package com.school.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.school.mapper.ScoreMapper;
import com.school.mapper.StudentMapper;
import com.school.po.Score;
import com.school.po.Student;
import com.school.service.Inter.StudentServiceInter;
import com.school.service.base.impl.BaseServiceImpl;
import com.school.util.PaginationContext;
import com.school.vo.ScoreVo;

@Service("StudentService")
public class StudentServiceImpl extends BaseServiceImpl<Student> implements StudentServiceInter {

	@Resource
	private StudentMapper stuMapper ;
	@Resource
	private ScoreMapper scoreMapper ;
	
	//获取某个学生某一个科目的成绩
	public List<ScoreVo> selectSubScore(Map<String, Object> paraMap) {

		return scoreMapper.selectScore(paraMap) ;
	}
	
	//将Ecxel获取的学生数组存入数据库
	public int insert(List<Student> stuList){
		return stuMapper.insertStudentList(stuList) ;
	}
	
	//通过班级ID查找学生
	public List<Student> selectByClass(int classId) {
		PageHelper.startPage(PaginationContext.getPageNum(), 
				 PaginationContext.getPageSize());
		return stuMapper.selectByClass(classId);
	}
	
//	通过班级id计算人数
	public int countStuByCla(int classId){
		return stuMapper.countStuByCla(classId);
	}

//	获取整个学校的学生
	public List<Student>findAllStu(){
		PageHelper.startPage(PaginationContext.getPageNum(), 
				 PaginationContext.getPageSize());
		return stuMapper.findAllStu();
	}
	
//	获取整个学校的人数
	public int countAllStu(){
		return stuMapper.countAllStu();
	}
	
	@Override
	public Student selectByPrimaryKey(String stuId) {
		Student student = stuMapper.selectByPrimaryKey(stuId) ;
		return student;
	}
	
	@Override
	public int updateByPrimaryKey(Student student){
		return stuMapper.updateByPrimaryKey(student) ;
 	}
	
	@Override
	public int insert(Student student){
		return stuMapper.insert(student) ;
	}
	

	@Override
	public int deleteByPrimaryKey(String stuId) {
		
		return stuMapper.deleteByPrimaryKey(stuId);
	}
	
	@Override
	public int addScore(Score score){
		return scoreMapper.insert(score) ;
	}
	
	@Override
	public int updateScore(Score score){
		return scoreMapper.updateByPrimaryKey(score) ;
	}

	@Override
	public Map<String, Object> selectByClass(int classId, int pageNow) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
