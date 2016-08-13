/**
 * 
 */
package com.school.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.school.mapper.SubjectMapper;
import com.school.po.Subject;
import com.school.service.base.BaseService;
import com.school.vo.TeaAndSub;

/**
 * @author c116
 *
 */
@Service("SubjectService")
public class SubjectServcie implements BaseService<Subject>{

	/* (non-Javadoc)
	 * @see com.school.service.base.BaseService#insert(java.lang.Object)
	 */
	@Override
	public int insert(Subject t) {
		// TODO Auto-generated method stub
		return subjectMapper.insertSubject(t.getSubName());
	}

	/* (non-Javadoc)
	 * @see com.school.service.base.BaseService#insertSelective(java.lang.Object)
	 */
	@Override
	public int insertSelective(Subject t) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.school.service.base.BaseService#selectByPrimaryKey(java.lang.String)
	 */
	@Override
	public Subject selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return subjectMapper.selectByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see com.school.service.base.BaseService#selectByParameters(java.util.Map)
	 */
	@Override
	public List<Subject> selectByParameters(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.school.service.base.BaseService#updateByPrimaryKeySelective(java.lang.Object)
	 */
	@Override
	public int updateByPrimaryKeySelective(Subject t) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.school.service.base.BaseService#updateByPrimaryKey(java.lang.Object)
	 */
	@Override
	public int updateByPrimaryKey(Subject t) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.school.service.base.BaseService#selectAll(int, int)
	 */
	@Override
	public List<Subject> selectAll(int offset, int limit) {
		// TODO Auto-generated method stub
		return subjectMapper.findAll();
	}

	/* (non-Javadoc)
	 * @see com.school.service.base.BaseService#deleteByPrimaryKey(java.lang.String)
	 */
	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return subjectMapper.deleteByPrimaryKey(id);
	}

	@Resource
	private SubjectMapper subjectMapper;
	
	public TeaAndSub selectSubAndTea(int id){
		return subjectMapper.selectSubAndTea(id);
	}
}
