package com.school.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.school.po.Clazz;
import com.school.po.Score;
import com.school.po.Student;
import com.school.po.Subject;
import com.school.po.Teacher;
import com.school.service.impl.ClazzServiceImpl;
import com.school.service.impl.StudentServiceImpl;
import com.school.util.ExcelUtil;
import com.school.vo.ClazzVo;
import com.school.vo.ScoreVo;

@Controller
public class clazzControl {
	
	@Resource
	private ClazzServiceImpl clazzService ;
	@Resource
	private StudentServiceImpl studentSerivce ;
	
	//按照老师Id查看所教的班级
	@RequestMapping("selectClazz")
	public String selectClazz(String teaId,
			Map<String,Object> map){
		
		List<Clazz> clazzList = clazzService.selectByTeacher(Integer.parseInt(teaId)) ;
		map.put("clazzList", clazzList) ;
		return "clazz/ClazzManage" ;
	}
	
	//班主任查看担任的班级学生
	@RequestMapping("selectHeadClazz")
	public String selectHeadClazz(@RequestParam("pageNow") int pageNow ,
			HttpSession session,
			Map<String,Object> map){
		int clazzId = clazzService.selecthHeadTeaClazz(1+"") ;  //模拟班主任id
		Map<String, Object> map1 = studentSerivce.selectByClass(clazzId, pageNow) ;
		map.put("StudentMap", map1) ;
		return "Students" ;
	}
	
	//查询出所有老师以便添加班级
	@RequestMapping("addClazz")
	public String addClazz(Map<String, Object> map){
		//模拟查询老师
		Teacher tea1 = new Teacher() ;
		tea1.setTeaId("1"); tea1.setTeaName("老师1");
		Teacher tea2 = new Teacher() ;
		tea2.setTeaId("2");	tea2.setTeaName("老师2");	
		Teacher tea3 = new Teacher() ;
		tea3.setTeaId("3"); tea3.setTeaName("老师3");
		List<Object> list = new ArrayList<Object>() ;
		list.add(tea1);
		list.add(tea2) ;
		list.add(tea3) ;
		
		
		map.put("teaList", list) ;
		return "clazz/addClazz" ;
	}
	//确认添加班级
	@RequestMapping("affirmAddClazz")
	public String affrimClazz(Clazz clazz){
		clazzService.insert(clazz) ;
		return "" ;
	}
	
	//上传学生
	@RequestMapping("importStudent")
	public String importStudent(@RequestParam MultipartFile file){
		List<Student> studentList = new ArrayList<Student>() ; 
		Map<Integer, String> map = new HashMap<Integer, String>() ;
		map.put(1, "stuId") ;
		map.put(2, "stuName") ;
		map.put(3, "sex") ;
		map.put(4, "birth") ;
		map.put(5, "admissionDate") ;
		map.put(6, "classId") ;
		map.put(7, "fatherName") ;
		map.put(8, "motherName") ;
		map.put(9, "parentsPhone") ;
		map.put(10, "adress") ;
		
		ExcelUtil excelUtil = new ExcelUtil() ;
		try {
			studentList = excelUtil.readReport(file.getInputStream(), Student.class, map) ;
		} catch (Exception e) {
			e.printStackTrace();
		}

		studentSerivce.insert(studentList) ;
		
		return "Students" ;
	}
	
	//查看该班级某一科目的学生成绩   selectScoreByClazz
	@RequestMapping("selectScoreByClazz")
	public String selectScoreByClass(@RequestParam(value="clazzId") String clazzId,
		Map<String, Object> map,HttpSession session){
		
		//模拟从session取出用户类型和用户id,还要根据角色id查询
		session.setAttribute("role",3);
		session.setAttribute("teaId","6");
		session.setAttribute("subId", 1);
		int subId = (int) session.getAttribute("subId") ;
		
		Map<String, Object> paraMap = new HashMap<String, Object>() ;
		paraMap.put("subId", subId) ;
		paraMap.put("clazzId", clazzId) ;
		List<ScoreVo> scoreList = clazzService.selectScore(paraMap) ;
		
		//查看该班级这一成绩是否已经被提交
		String teaId = (String) session.getAttribute("teaId") ;
		Map<String, Object> paraMap1 = new HashMap<String, Object>() ;
		paraMap1.put("clazzId", clazzId) ;
		paraMap1.put("teaId", teaId) ;
		int scoreIsAffirm = clazzService.scoreIsAffirm(paraMap1) ;
		
		map.put("clazzId", clazzId) ;
		map.put("scoreIsAffirm", scoreIsAffirm) ;
		map.put("scoreList", scoreList) ;
		return "clazz/Score" ;
	}
	
	//通过Excel上传班级的科目成绩
	@RequestMapping("importScore")
	public String importScore(@RequestParam MultipartFile file){
		List<Score> scoreList = new ArrayList<Score>() ; 
		Map<Integer, String> map = new HashMap<Integer, String>() ;
		
		map.put(1, "stuId") ;
		map.put(2, "subId") ;
		map.put(3, "teaId") ;
		map.put(4, "evaId") ;
		map.put(5, "score") ;
		
		ExcelUtil excelUtil = new ExcelUtil() ;
		try {
			scoreList = excelUtil.readReport(file.getInputStream(), Score.class, map) ;
		} catch (Exception e) {
			e.printStackTrace();
		}

		clazzService.importScore(scoreList) ;
		
		return "forward:selectScoreByClazz.action?clazzId=1" ;
	}
	
	//查看所有班级
	@RequestMapping("selectAllClazz")
	public String selectAllClazz(Map<String, Object> map){
		List<ClazzVo> clazzList = clazzService.selectAllClazz() ;
		map.put("clazzList", clazzList) ;
		return "clazz/allClazz" ;
	}
	
	//班主任查看班级成绩
	@RequestMapping("selectHeadScore")
	public String selectHeadScore(Map<String, Object> map,@RequestParam(value="subId",required=false) String subId,
			HttpSession session){
		//模拟取出老师所教科目		
		if(subId==null){
			subId = "2" ;
		}
		//模拟从session取出用户类型和用户id
		session.setAttribute("role",2);
		session.setAttribute("teaId", "1");
		String teaId = (String) session.getAttribute("teaId") ;
		//确定该班主任所担任的班级ID
		int	clazzId = clazzService.selecthHeadTeaClazz(teaId) ;
		
		Map<String, Object> paraMap = new HashMap<String, Object>() ;
		paraMap.put("subId", subId) ;
		paraMap.put("clazzId", clazzId) ;
		List<ScoreVo> so = studentSerivce.selectSubScore(paraMap) ;
		List<Subject> subList =  clazzService.subList();
		map.put("scoreList", so) ;
		map.put("subList",subList);
		map.put("clazzId", clazzId) ;
		return "clazz/Score" ;
	}
	
	//提交成绩
	@RequestMapping("affirmScore")
	public String affirmScore(@RequestParam("clazzId") String clazzId,HttpSession session){
		//模拟从session取出用户类型和用户id
		session.setAttribute("teaId","6");
		String teaId = (String) session.getAttribute("teaId") ;
		
		Map<String, Object> paraMap1 = new HashMap<String, Object>() ;
		paraMap1.put("clazzId", clazzId) ;
		paraMap1.put("teaId", teaId) ;
		clazzService.affirmScore(paraMap1) ;
		
		return "redirect:/selectScoreByClazz.action?clazzId="+clazzId ;
	}
	
}
