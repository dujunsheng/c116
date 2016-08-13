/**
 * 
 */
package com.school.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.school.mapper.PermissionMapper;
import com.school.po.Permission;
import com.school.vo.RoleAndPer;

/**
 * @author c116
 *
 */
@Service("PermissionService")
public class PermissionService{

	@Resource
	private PermissionMapper permissionMapper;
	
//	查询所有父类功能
	public List<Permission> findPer(){
		return permissionMapper.findPer();
	}
	
//	查询所有子类功能
	public List<Permission> findSon(int p_id){
		return permissionMapper.findSon(p_id);
	}
	
//	根据id查询父类功能
	public Permission findPerById(int id){
		return permissionMapper.findPerById(id);
	}
	
//	根据id查询子类功能
	public Permission findSonById(int id){
		return permissionMapper.findSonById(id);
	}
	
//	根据角色的id查询该角色所拥有的父类的功能
	public List<RoleAndPer> findPreByRol_id(int id){
		return permissionMapper.findPreByRol_id(id);
	}
}
