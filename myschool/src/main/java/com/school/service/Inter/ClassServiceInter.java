package com.school.service.Inter;

import java.util.List;
import java.util.Map;

import com.school.po.Clazz;
import com.school.po.Evaluate;
import com.school.po.Score;
import com.school.po.Subject;
import com.school.service.base.BaseService;
import com.school.vo.ClazzVo;
import com.school.vo.ScoreVo;

public interface ClassServiceInter extends BaseService<Clazz>{
	
	public List<Evaluate> selectAllEvaluate() ;
	public List<Clazz> selectByTeacher(Integer teaId);
	
	public List<ClazzVo> selectAllClazz() ;
	
	public List<ScoreVo> selectScore(Map<String,Object> paraMap) ;
	
	public int importScore(List<Score> scoreList) ;
	
	public int selecthHeadTeaClazz(String teaId) ;
	
	public List<Subject> subList() ;
	
	public int scoreIsAffirm(Map<String, Object> paraMap) ;
	
	int affirmScore(Map<String,Object> paraMap) ;
}
