/**
 * 
 */
package com.school.vo;

import java.util.List;

import com.school.po.Department;
import com.school.po.Employee;

/**
 * @author c116
 *
 */
public class DepAndEmp {
	private String depId;
	private String depName;
	private Employee employee;
	private Department department ;
	private List<Employee> employeeList;
	
	public Department getDepartment() {
		return department;
	}
	public List<Employee> getEmployeeList() {
		return employeeList;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	public String getDepId() {
		return depId;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepId(String depId) {
		this.depId = depId;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
