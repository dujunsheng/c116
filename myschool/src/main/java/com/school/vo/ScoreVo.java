package com.school.vo;

public class ScoreVo {
	private int id ;
	private String stuId ;
	private String stuName ;
	private String subName ;
	private String teaName ;
	private String evaName ;
	private double score ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public String getTeaName() {
		return teaName;
	}
	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}
	public String getEvaName() {
		return evaName;
	}
	public void setEvaName(String evaName) {
		this.evaName = evaName;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "ScoreVo [id=" + id + ", stuName=" + stuName + ", subName=" + subName + ", teaName=" + teaName
				+ ", evaName=" + evaName + ", score=" + score + "]";
	}
	
	
	
}
