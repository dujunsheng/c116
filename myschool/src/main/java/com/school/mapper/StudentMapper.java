package com.school.mapper;

import com.school.po.Student;
import com.school.po.StudentExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
    int countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(String stuId);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(String stuId);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
    
    
    //将从Excel表中读取出来的数据存入到数据库中
    int insertStudentList(List<Student> list) ;
    
    //通过班级查找学生
    List<Student> selectByClass(int classId) ;
    
//    查询该班级有多少人
    int countStuByCla(int classId);
    
    int countByExample();

   List<Student> selectByPage(Map<String, Integer> map);
   
//   查询所有学生
   List<Student> findAllStu();
   
//   统计学生人数
   int countAllStu();
}