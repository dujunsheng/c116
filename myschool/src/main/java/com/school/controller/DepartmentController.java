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

import com.school.po.Department;
import com.school.service.impl.DepartmentService;
import com.school.util.CommonUtils;
import com.school.util.PageBean;
import com.school.util.PaginationContext;
import com.school.vo.DepAndEmp;

/**
 * @author c116
 *
 */
@Controller
public class DepartmentController {
	
	@Resource
	private DepartmentService departmentService;
	
	private int getPc(HttpServletRequest req){
		int pc = 1;
		String param = req.getParameter("pc");
		if(param != null && !param.trim().isEmpty()){
			try{
				pc = Integer.valueOf(param);
			}catch(RuntimeException e){
				
			}
		}
		return pc;
	}
	
	private String getUrl(HttpServletRequest req){
		String url = req.getRequestURI() + "?" + req.getQueryString();
		int index = url.lastIndexOf("&pageNum=");
		if(index != -1){
			url = url.substring(0, index);
		}
		return url;
	}
	
	
//	添加部门
	@RequestMapping("/insertDepartment")
	public ModelAndView insertDepartmrnt(HttpServletRequest req, HttpServletResponse resp, String depName){
		ModelAndView modelAndView = new ModelAndView();
//		要先查询是否存在这部门名字
		int isExist = departmentService.exist(depName);
		if(isExist == 0 ){
			Department department = CommonUtils.toBean(req.getParameterMap(), Department.class);
			int result = departmentService.insertSelective(department);
				return findAllDepartment(req, resp);
		}else{
			String msg = "添加部门失败";
			String title = "测试";
			modelAndView.addObject("msg", msg);
			modelAndView.addObject("title", title);
			modelAndView.setViewName("user/msg");
			return modelAndView;	
			}
	}

//	查询所有部门
	@RequestMapping("/findAllDepartment")
	public ModelAndView findAllDepartment(HttpServletRequest req, HttpServletResponse resp){
		ModelAndView modelAndView = new ModelAndView();
		PageBean<Department> pb = departmentService.findAll();
		pb.setUrl(req.getContextPath()+"/findAllDepartment.action");
		pb.setPageNum(PaginationContext.getPageNum());
		pb.setPageSize(PaginationContext.getPageSize());
		modelAndView.addObject("pb", pb);
		modelAndView.setViewName("user/jsps/depList");
		return modelAndView;
		
	}
	
//	删除部门
	@RequestMapping("/deleteDepartment")
	public ModelAndView deleteDepartment(HttpServletRequest req, HttpServletResponse resp, String depId){
		ModelAndView modelAndView = new ModelAndView();
		int result = departmentService.deleteByPrimaryKey(depId);
		if(result ==1){
			return findAllDepartment(req, resp);
		}else{
			String msg = "删除部门失败";
			String title = "测试";
			modelAndView.addObject("msg", msg);
			modelAndView.addObject("title", title);
			modelAndView.setViewName("user/jsps/msg");
			return modelAndView;
		}
	}
	
//	根据主键修改部门名字
	@RequestMapping("/updateDepartment")
	public ModelAndView updateDepartment(HttpServletRequest req, HttpServletResponse resp, Department department){
		ModelAndView modelAndView = new ModelAndView();
		int result = departmentService.updateByPrimaryKeySelective(department);
		if(result ==1){
			return findAllDepartment(req, resp);
		}else{
			String msg = "修改部门失败";
			String title = "测试";
			modelAndView.addObject("msg", msg);
			modelAndView.addObject("title", title);
			modelAndView.setViewName("user/jsps/msg");
			return modelAndView;
		}
	}
	
//	查询部门及其所有人
	@RequestMapping("/findDepartmentTotal")
	public ModelAndView findDepartmentTotal(HttpServletRequest req, HttpServletResponse resp){
		ModelAndView modelAndView = new ModelAndView();
		PageBean<DepAndEmp> pb = new PageBean<DepAndEmp>();
		List<DepAndEmp> list = departmentService.findTotal();
		pb.setBeanList(list);
		pb.setPageNum(PaginationContext.getPageNum());
		pb.setPageSize(PaginationContext.getPageSize());
		pb.setUrl(getUrl(req));
		modelAndView.addObject("pb", pb);
		modelAndView.setViewName("user/jsps/page");
		return modelAndView;
	}
//	查看该部门所发的通知
	

}
