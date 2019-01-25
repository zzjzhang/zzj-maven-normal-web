package com.bet.cn.bean;

public class Game implements Comparable<Game> {

	private String teams;
	private String scores;
	private String time;
	private String rates;

	
	@Override
	public int compareTo(Game o) {
		Integer intValue1 = Integer.valueOf(this.time.split(":")[0]);
		Integer intValue2 = Integer.valueOf(o.getTime().split(":")[0]);
		return intValue1.compareTo(intValue2);
	}

	public String getTeams() {
		return teams;
	}
	public void setTeams(String teams) {
		this.teams = teams;
	}
	public String getScores() {
		return scores;
	}
	public void setScores(String scores) {
		this.scores = scores;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getRates() {
		return rates;
	}
	public void setRates(String rates) {
		this.rates = rates;
	}

}