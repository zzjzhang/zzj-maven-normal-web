package com.bet.cn.bean;

public class CornerObj implements Comparable<CornerObj> {

	private String team;
	private Integer avgSelf;
	private Integer avgOpposite;

	@Override
	public int compareTo(CornerObj o) {
		return this.avgSelf.compareTo(o.avgSelf);
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public Integer getAvgSelf() {
		return avgSelf;
	}

	public void setAvgSelf(Integer avgSelf) {
		this.avgSelf = avgSelf;
	}

	public Integer getAvgOpposite() {
		return avgOpposite;
	}

	public void setAvgOpposite(Integer avgOpposite) {
		this.avgOpposite = avgOpposite;
	}


}