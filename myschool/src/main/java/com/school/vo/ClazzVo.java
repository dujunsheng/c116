package com.school.vo;

public class ClazzVo {

	private int classId ;
	private int clazz ;
	private int grade ;
	private String headTeaName ;
	private String monitorName ;
	private int sum ;
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public int getClazz() {
		return clazz;
	}
	public void setClazz(int clazz) {
		this.clazz = clazz;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getHeadTeaName() {
		return headTeaName;
	}
	public void setHeadTeaName(String headTeaName) {
		this.headTeaName = headTeaName;
	}
	public String getMonitorName() {
		return monitorName;
	}
	public void setMonitorName(String monitorName) {
		this.monitorName = monitorName;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	@Override
	public String toString() {
		return "ClazzVo [classId=" + classId + ", clazz=" + clazz + ", grade=" + grade + ", headTeaName=" + headTeaName
				+ ", monitorName=" + monitorName + ", sum=" + sum + "]";
	}
	
	
}
