/**
 * 
 */
package com.school.vo;

import java.util.List;

import com.school.po.Subject;
import com.school.po.Teacher;

/**
 * @author c116
 *
 */
public class TeaAndSub {
	private String teaId;
	private int subId;
	private Teacher teacher;
	private Subject subject;
	private List<Teacher> list;
	public String getTeaId() {
		return teaId;
	}
	public int getSubId() {
		return subId;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setTeaId(String teaId) {
		this.teaId = teaId;
	}
	public void setSubId(int subId) {
		this.subId = subId;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public List<Teacher> getList() {
		return list;
	}
	public void setList(List<Teacher> list) {
		this.list = list;
	}
	
	
}
