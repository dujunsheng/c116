package com.school.mapper;

import com.school.dao.base.BaseDao;
import com.school.po.Department;
import com.school.po.DepartmentExample;
import com.school.vo.DepAndEmp;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DepartmentMapper extends BaseDao<Department>{
    int countByExample(DepartmentExample example);

    int deleteByExample(DepartmentExample example);

    int deleteByPrimaryKey(Integer depId);

    int insert(Department record);

    int insertSelective(Department record);

    List<Department> selectByExample(DepartmentExample example);

    Department selectByPrimaryKey(Integer depId);

    int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByExample(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
    
    //应用于分页查询所有
    List<Department> findAll();
    
//    分页查询所有部门和旗下所有人
    List<DepAndEmp> findTotal();
    
//	统计部门数目
    int count();
    
//    查询该部门是否存在
    int exist(String depName);
}