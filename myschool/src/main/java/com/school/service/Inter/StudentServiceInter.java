package com.school.service.Inter;

import java.util.List;
import java.util.Map;

import com.school.po.Score;
import com.school.po.Student;
import com.school.service.base.BaseService;
import com.school.vo.ScoreVo;

public interface StudentServiceInter extends BaseService<Student>{
	
	int insert(List<Student> stuList) ;
	
	int insert(Student t);
	
	int deleteByPrimaryKey(String stuId) ;
	
	Student selectByPrimaryKey(String id);
	
	int updateByPrimaryKey(Student student);

	Map<String, Object> selectByClass(int classId, int pageNow) ;

	int addScore(Score score);
	
	List<ScoreVo>  selectSubScore(Map<String,Object> paraMap) ;
	
	int updateScore(Score score) ;
}
