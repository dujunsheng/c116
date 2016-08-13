/**
 * 
 */
package com.school.mapper;

import java.util.List;

import com.school.po.Permission;
import com.school.vo.RoleAndPer;

/**
 * @author c116
 *
 */
public interface PermissionMapper {

	List<Permission> findPer();
	
	List<Permission> findSon(int p_id);
	
	Permission findPerById(int id);
	
	Permission findSonById(int id);
	
	List<RoleAndPer> findPreByRol_id(int id);
}
