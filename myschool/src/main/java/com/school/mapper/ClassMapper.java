package com.school.mapper;

import com.school.po.Clazz;
import com.school.vo.ClazzVo;
import com.school.po.ClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassMapper {
    int countByExample(ClassExample example);

    int deleteByExample(ClassExample example);

    int deleteByPrimaryKey(Integer classId);

    int insert(Clazz record);

    int insertSelective(Clazz record);

    List<Clazz> selectByExample(ClassExample example);

    Clazz selectByPrimaryKey(Integer classId);

    int updateByExampleSelective(@Param("record") Clazz record, @Param("example") ClassExample example);

    int updateByExample(@Param("record") Clazz record, @Param("example") ClassExample example);

    int updateByPrimaryKeySelective(Clazz record);

    int updateByPrimaryKey(Clazz record);
    
    
//  class（林思远）  
    
    List<ClazzVo> selectAll() ;
    
    List<Clazz> selectByTeacher(Integer teaId) ;
    
    int selecthHeadTeaClazz(String teaId) ;
}