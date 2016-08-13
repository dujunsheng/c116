/**
 * 
 */
package com.school.po;

import java.util.List;

/**
 * @author c116
 *
 */
public class Permission {

	private int id;
	private String permission;
	private int c_id;
	private int p_id;
	private String url;
	private List<Permission> son;
	private Permission parent;
	public int getId() {
		return id;
	}
	public String getPermission() {
		return permission;
	}
	public int getC_id() {
		return c_id;
	}
	public int getP_id() {
		return p_id;
	}
	public List<Permission> getSon() {
		return son;
	}
	public Permission getParent() {
		return parent;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public void setSon(List<Permission> son) {
		this.son = son;
	}
	public void setParent(Permission parent) {
		this.parent = parent;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
