package com.example.demo.dataProcessing;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.example.demo.models.Match;

public class MatchProcessor implements ItemProcessor<MatchInput, Match> {

	@Override
	public Match process(final MatchInput matchInput) throws Exception {

		Match match = new Match();
		match.setCity(matchInput.getCity());
		match.setId(Long.parseLong(matchInput.getId()));
		match.setMatchDate(LocalDate.parse(matchInput.getDate()));
		match.setVenue(matchInput.getVenue());
		match.setTeam1(matchInput.getTeam1());
		match.setTeam2(matchInput.getTeam2());
		match.setWinner(matchInput.getWinner());
		match.setManOfTheMatch(matchInput.getPlayer_of_match());
		match.setTossWinner(matchInput.getToss_winner());
		match.setDecision(matchInput.getToss_decision());
		match.setResult(matchInput.getResult());
		match.setResultMargin(matchInput.getResult_margin());
		match.setUmpire1(matchInput.getUmpire1());
		match.setUmpire2(matchInput.getUmpire2());
		
		System.out.println(match);
		return match;
		
		
	}

}