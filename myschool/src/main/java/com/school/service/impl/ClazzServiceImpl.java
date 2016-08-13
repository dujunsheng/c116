package com.school.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.school.mapper.ClassMapper;
import com.school.mapper.EvaluateMapper;
import com.school.mapper.ScoreMapper;
import com.school.mapper.SubjectMapper;
import com.school.mapper.Teacher_classMapper;
import com.school.po.Clazz;
import com.school.po.Evaluate;
import com.school.po.Score;
import com.school.po.Subject;
import com.school.service.Inter.ClassServiceInter;
import com.school.vo.ClazzVo;
import com.school.vo.ScoreVo;

@Service("ClassService")
public class ClazzServiceImpl implements ClassServiceInter {

	@Resource
	private ClassMapper classmapper ;
	
	@Resource
	private EvaluateMapper evaMapper ;
	
	@Resource 
	private ScoreMapper scoreMapper ;
	
	@Resource
	private SubjectMapper subMapper ;
	@Resource
	private Teacher_classMapper tcMapper ;
	
	//提交成绩
	@Override
	public int affirmScore(Map<String, Object> paraMap){
		return tcMapper.affirmScore(paraMap) ;
	}
	
	//查询该老师所教的该班级的科目的成绩是否被提交
	@Override
	public int scoreIsAffirm(Map<String, Object> paraMap){
		return tcMapper.scoreIsAffirm(paraMap) ;
	}
	
	//查询评价模板列表
	@Override
	public List<Evaluate> selectAllEvaluate(){
		return evaMapper.selectAll() ;
	}
	
	//查看班主任所担任的班级ID
	public int selecthHeadTeaClazz(String teaId) {
		return classmapper.selecthHeadTeaClazz(teaId) ;
	}
	
	//新增班级
	@Override
	public int insert(Clazz t) {
		return classmapper.insert(t) ;
	}
	
	@Override
	public List<ClazzVo> selectAllClazz(){
		return classmapper.selectAll() ;
	}

	@Override
	public int insertSelective(Clazz t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Clazz selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Clazz> selectByParameters(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Clazz t) {
		return classmapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int updateByPrimaryKey(Clazz t) {
		return classmapper.updateByPrimaryKey(t);
	}

	public List<Clazz> selectByTeacher(Integer teaId){
		return classmapper.selectByTeacher(teaId) ;
	}

	//根据班级查看学生所有成绩
	@Override
	public List<ScoreVo> selectScore(Map<String,Object> paraMap) {
		return scoreMapper.selectScore(paraMap) ;
	}
	
	//导入该班级学生成绩
	@Override
	public int importScore(List<Score> scoreList){
		return scoreMapper.importScore(scoreList) ;
	}

	@Override
	public List<Subject> subList() {
		return subMapper.findAll() ;
	}

	/* (non-Javadoc)
	 * @see com.school.service.base.BaseService#selectAll(int, int)
	 */
	@Override
	public List<Clazz> selectAll(int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.school.service.base.BaseService#deleteByPrimaryKey(java.lang.String)
	 */
	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
