package com.example.demo.dataProcessing;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.example.demo.models.Match;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	final String fieldNames[] = new String[] { "id", "city", "date", "player_of_match", "venue",
            "neutral_venue", "team1", "team2", "toss_winner", "toss_decision", "winner", "result", "result_margin",
            "eliminator", "method", "umpire1", "umpire2" };


	@Bean
	public FlatFileItemReader<MatchInput> reader() {
		return new FlatFileItemReaderBuilder<MatchInput>().name("MatchItemReader")
				.resource(new ClassPathResource("ipl-matches.csv")).linesToSkip(1).delimited().names(fieldNames)
				.fieldSetMapper(new BeanWrapperFieldSetMapper<MatchInput>() {
					{
						setTargetType(MatchInput.class);
					}
				}).build();
	}

	@Bean
	public MatchProcessor processor() {
		return new MatchProcessor();
	}

	@Bean
	public JdbcBatchItemWriter<Match> writer(DataSource dataSource) {
		return new JdbcBatchItemWriterBuilder<Match>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO matches (id,city,team1,team2,winner,venue,umpire1,umpire2,man_of_the_match,toss_winner,decision,result,match_date, result_margin)"
						+ " VALUES (:id,:city,:team1,:team2,:winner,:venue,:umpire1,:umpire2,:manOfTheMatch,:tossWinner,:decision,:result,:matchDate,:resultMargin)")
				.dataSource(dataSource).build();
	}

	@Bean
	public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
		return jobBuilderFactory.get("importUserJob").incrementer(new RunIdIncrementer()).listener(listener).flow(step1)
				.end().build();
	}

	@Bean
	public Step step1(JdbcBatchItemWriter<Match> writer) {
		return stepBuilderFactory.get("step1").<MatchInput, Match>chunk(10).reader(reader()).processor(processor())
				.writer(writer).build();
	}

}

//"id", "city", "date", "player_of_match", "venue", "neutral_venue",
//"team1", "team2", "toss_winner", "toss_decision", "winner", "result", "result_margin", "eliminator",
//"method", "umpire1", "umpire2"

