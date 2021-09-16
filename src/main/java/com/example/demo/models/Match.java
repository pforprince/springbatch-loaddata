package com.example.demo.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="matches")
public class Match {

	@Id
	long id;
	
	String city;
	String team1;
	String team2;
	String winner;
	String venue;
	String umpire1;
	String umpire2;
	String manOfTheMatch;
	String tossWinner;
	String decision;
	String result;
	LocalDate matchDate;
	String resultMargin;
	
	
	@Override
	public String toString() {
		return "Match [id=" + id + ", city=" + city + ", team1=" + team1 + ", team2=" + team2 + ", winner=" + winner
				+ ", venue=" + venue + ", umpire1=" + umpire1 + ", umpire2=" + umpire2 + ", manOfTheMatch="
				+ manOfTheMatch + ", tossWinner=" + tossWinner + ", decision=" + decision + ", result=" + result
				+ ", matchDate=" + matchDate + ", resultMargin=" + resultMargin + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTeam1() {
		return team1;
	}
	public void setTeam1(String team1) {
		this.team1 = team1;
	}
	public String getTeam2() {
		return team2;
	}
	public void setTeam2(String team2) {
		this.team2 = team2;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getUmpire1() {
		return umpire1;
	}
	public void setUmpire1(String umpire1) {
		this.umpire1 = umpire1;
	}
	
	public String getUmpire2() {
		return umpire2;
	}
	public void setUmpire2(String umpire2) {
		this.umpire2 = umpire2;
	}
	public String getManOfTheMatch() {
		return manOfTheMatch;
	}
	public void setManOfTheMatch(String manOfTheMatch) {
		this.manOfTheMatch = manOfTheMatch;
	}
	public String getTossWinner() {
		return tossWinner;
	}
	public void setTossWinner(String tossWinner) {
		this.tossWinner = tossWinner;
	}
	public String getDecision() {
		return decision;
	}
	public void setDecision(String decision) {
		this.decision = decision;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public LocalDate getMatchDate() {
		return matchDate;
	}
	public void setMatchDate(LocalDate matchDate) {
		this.matchDate = matchDate;
	}
	public String getResultMargin() {
		return resultMargin;
	}
	public void setResultMargin(String resultMargin) {
		this.resultMargin = resultMargin;
	}
	
}



// "id",
// "city",
// "team1",
// "team2",
//" winner",
// "venue",
// "umpire1",
// "umpire2",
// "manOfTheMatch",
// "tossWinner",
// "decision",
// "result",
// "matchDate",
// "resultMargin"




//id,city,team1,team2,winner,venue,umpire1,umpire2,man_of_the_match,toss_winner,decision,result,match_date, result_margin
