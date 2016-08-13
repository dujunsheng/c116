/**
 * 
 */
package com.school.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.school.mapper.EmployeeMapper;
import com.school.po.Employee;
import com.school.po.EmployeeExample;
import com.school.service.base.BaseService;
import com.school.util.PaginationContext;
import com.school.vo.DepAndEmp;

/**
 * @author c116
 *
 */
@Service("EmployeeServcie")
public class EmployeeServcie implements BaseService<Employee>{

	@Resource
	private EmployeeMapper employeeMapper;
	
	/* (non-Javadoc)
	 * @see com.school.service.base.BaseService#insert(java.lang.Object)
	 */
	@Override
	public int insert(Employee t) {
		// TODO Auto-generated method stub
		return employeeMapper.insert(t);
	}

	/* (non-Javadoc)
	 * @see com.school.service.base.BaseService#insertSelective(java.lang.Object)
	 */
	@Override
	public int insertSelective(Employee t) {
		return employeeMapper.insertSelective(t);
	}

	/* (non-Javadoc)
	 * @see com.school.service.base.BaseService#selectByPrimaryKey(java.lang.String)
	 */
	@Override
	public Employee selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return employeeMapper.selectByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see com.school.service.base.BaseService#selectByParameters(java.util.Map)
	 */
	@Override
	public List<Employee> selectByParameters(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.school.service.base.BaseService#updateByPrimaryKeySelective(java.lang.Object)
	 */
	@Override
	public int updateByPrimaryKeySelective(Employee t) {
		// TODO Auto-generated method stub
		return employeeMapper.updateByPrimaryKeySelective(t);
	}

	/* (non-Javadoc)
	 * @see com.school.service.base.BaseService#updateByPrimaryKey(java.lang.Object)
	 */
	@Override
	public int updateByPrimaryKey(Employee t) {
		// TODO Auto-generated method stub
		return employeeMapper.updateByPrimaryKey(t);
	}

	/* (non-Javadoc)
	 * @see com.school.service.base.BaseService#selectAll(int, int)
	 */
	@Override
	public List<Employee> selectAll(int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.school.service.base.BaseService#deleteByPrimaryKey(java.lang.String)
	 */
	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return employeeMapper.deleteByPrimaryKey(id);
	}
	
	public List<Employee> findAll(){
		PageHelper.startPage(PaginationContext.getPageNum(), 
				 PaginationContext.getPageSize());
		return employeeMapper.findAll();
	}
	
	public DepAndEmp findEmpAndDep(String id){
		return employeeMapper.findEmpAndDep(id);
	}
	
	public List<Employee> findByExamplie(EmployeeExample example){
		return employeeMapper.selectByExample(example);
	}
	
	public int countAll(){
		return employeeMapper.countAll();
	}
	
	public int countByDepId(int id){
		return employeeMapper.countByDepId(id);
	}
	
	public List<Employee> findByDepId(int id){
		PageHelper.startPage(PaginationContext.getPageNum(), 
				 PaginationContext.getPageSize());
		return employeeMapper.findByDepId(id);
	}
}
