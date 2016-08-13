/**
 * 
 */
package com.school.mapper;


import java.util.List;

import com.school.dao.base.BaseDao;
import com.school.po.Subject;
import com.school.vo.TeaAndSub;

/**
 * @author c116
 *
 */
public interface SubjectMapper extends BaseDao<Subject>{

	Subject selectByPrimaryKey(int id);
	
	List<Subject> findAll();
	
	Subject selectBySubName(String sub_name);
	
	int deleteByPrimaryKey(int id);
	
	int insertSubject(String subName);
	
	TeaAndSub selectSubAndTea(int id);
}
