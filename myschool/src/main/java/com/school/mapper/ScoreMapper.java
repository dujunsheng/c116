package com.school.mapper;

import com.school.po.Score;
import com.school.po.ScoreExample;
import com.school.vo.ScoreVo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ScoreMapper {
    int countByExample(ScoreExample example);

    int deleteByExample(ScoreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Score record);

    int insertSelective(Score record);

    List<Score> selectByExample(ScoreExample example);

    Score selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Score record, @Param("example") ScoreExample example);

    int updateByExample(@Param("record") Score record, @Param("example") ScoreExample example);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);
    
//    score（林思远）

    //将Excel表读取出来的学生成绩批量导入到数据库中
    int importScore(List<Score> scoreList) ;
    
    List<ScoreVo> selectScore(Map<String,Object> paraMap) ;
}