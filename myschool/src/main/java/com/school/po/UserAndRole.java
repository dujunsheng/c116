/**
 * 
 */
package com.school.po;

/**
 * @author c116
 *
 */
public class UserAndRole {

	private String u_id;
	private String u_pw;
	private int role_id;
	private String role;
	public String getU_id() {
		return u_id;
	}
	public String getU_pw() {
		return u_pw;
	}
	public int getRole_id() {
		return role_id;
	}
	public String getRole() {
		return role;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
