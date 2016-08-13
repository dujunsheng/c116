package com.school.mapper;

import com.school.po.Employee;
import com.school.po.EmployeeExample;
import com.school.vo.DepAndEmp;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {
    int countByExample(EmployeeExample example);

    int deleteByExample(EmployeeExample example);

    int deleteByPrimaryKey(String empId);

    int insert(Employee record);

    int insertSelective(Employee record);

    List<Employee> selectByExample(EmployeeExample example);

    Employee selectByPrimaryKey(String empId);

    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
    
    List<Employee> findAll();
    
    DepAndEmp findEmpAndDep(String empId);
    
    int countAll();
    
    int countByDepId(int id);
    
    List<Employee> findByDepId(int id);
}