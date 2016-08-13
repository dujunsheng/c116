/**
 * 
 */
package com.school.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.school.po.Teacher;
import com.school.service.impl.TeacherService;
import com.school.util.GetUrl;
import com.school.util.PageBean;
import com.school.util.PaginationContext;
import com.school.vo.TeaAndSub;

/**
 * @author c116
 *
 */
@Controller
public class TeacherController {

	@Resource
	private TeacherService teacherService;
	
//	添加老师
	@RequestMapping("/insertTeacher")
	public ModelAndView insertTeacher(HttpServletRequest req, HttpServletResponse resp, Teacher teacher){
		int result = teacherService.insertSelective(teacher);
		if(result == 1){
			return findAllTeacher(req, resp);
		}else{
			ModelAndView modelAndView = new ModelAndView();
			String msg = "添加老师失败";
			String title = "测试";
			modelAndView.addObject("msg", msg);
			modelAndView.addObject("title", title);
			modelAndView.setViewName("/user/msg");
			return modelAndView;
		}
	}
	
//	查询所有老师
	@RequestMapping("/findTeacher")
	public ModelAndView findAllTeacher(HttpServletRequest req, HttpServletResponse resp){
		PageBean<Teacher> pb = new PageBean<Teacher>();
		ModelAndView modelAndView = new ModelAndView();
		List<Teacher> result = teacherService.findAll();
		pb.setBeanList(result);
		pb.setPageNum(PaginationContext.getPageNum());
		pb.setPageSize(PaginationContext.getPageSize());
		pb.setTr(teacherService.countAll());
		pb.setUrl(req.getContextPath()+"/findTeacher.action");
		modelAndView.addObject("pb", pb);
		modelAndView.setViewName("user/jsps/teaList");
		return modelAndView;
	}

	
//	修改教师的职称
	@RequestMapping("/findTeacherRank")
	public ModelAndView findTeacherRank(HttpServletRequest req, HttpServletResponse resp){
		PageBean<Teacher> pb = new PageBean<Teacher>();
		ModelAndView modelAndView = new ModelAndView();
		List<Teacher> result = teacherService.findAll();
		pb.setBeanList(result);
		pb.setPageNum(PaginationContext.getPageNum());
		pb.setPageSize(PaginationContext.getPageSize());
		pb.setTr(teacherService.countAll());
		pb.setUrl(req.getContextPath()+"/findTeacher.action");
		modelAndView.addObject("pb", pb);
		modelAndView.setViewName("user/jsps/teaRank");
		return modelAndView;
	}
	
//	删除老师
	@RequestMapping("/deleteTeacher")
	public ModelAndView deleteTeacher(HttpServletRequest req, HttpServletResponse resp, String teaId){
		int result = teacherService.deleteByPrimaryKey(teaId);
		if(result == 1){
			return findAllTeacher(req, resp);
		}else{
			ModelAndView modelAndView = new ModelAndView();
			String msg = "删除老师失败";
			String title = "测试";
			modelAndView.addObject("msg", msg);
			modelAndView.addObject("title", title);
			modelAndView.setViewName("/user/msg");
			return modelAndView;
		}
	}

//	更改老师信息
	@RequestMapping("/updateTeacher")
	public ModelAndView updateTeacher(HttpServletRequest req, HttpServletResponse resp, Teacher teacher){
		int result = teacherService.updateByPrimaryKeySelective(teacher);
		if(result == 1){
			return findAllTeacher(req, resp);
		}else{
			ModelAndView modelAndView = new ModelAndView();
			String msg = "修改老师失败";
			String title = "测试";
			modelAndView.addObject("msg", msg);
			modelAndView.addObject("title", title);
			modelAndView.setViewName("/user/msg");
			return modelAndView;
		}
	}
	
//	多条件查询老师
	
	
//	查询老师并且查询老师所教的科目
	@RequestMapping("/findTeaAndSub")
	public String findTeaAndSub(HttpServletRequest req, HttpServletResponse resp, String teaId){
		TeaAndSub teaAndSub = teacherService.selectTeaAndSub(teaId);
		return null;
		
	}

//	查询老师并且查询所教的班级
	@RequestMapping("/findTeaAndCla")
	public String findTeaAndCla(String id){
		return null;
	}
	
//	查询老师并且查询老师所教的学生及他们的成绩评价
	
//	查询老师并且查询一周的课程
	
//	按科目查询老师
}
