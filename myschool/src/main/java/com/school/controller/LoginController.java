/**
 * 
 */
package com.school.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.school.mapper.EmployeeMapper;
import com.school.po.Clazz;
import com.school.po.Employee;
import com.school.po.Teacher;
import com.school.po.User;
import com.school.po.UserAndRole;
import com.school.service.impl.ClazzServiceImpl;
import com.school.service.impl.EmployeeServcie;
import com.school.service.impl.TeacherService;
import com.school.service.impl.UserService;
import com.school.vo.UserPW;

/**
 * @author c116
 *
 */
@Controller
public class LoginController {

	@Resource
	private UserService userService;
	@Resource
	private TeacherService teacherService;
	@Resource
	private EmployeeServcie employeeService;
	@Resource
	private ClazzServiceImpl clazzServiceImpl;
	

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest req, HttpServletResponse resp, UserAndRole userAndRole)throws Exception{
		User user  = new User();
		user.setuId(userAndRole.getU_id());
		user.setuPw(userAndRole.getU_pw());
		ModelAndView modelAndView = new ModelAndView();
//		先查询用户判断用户id密码是否正确
		User result = userService.selectByUidAndUpw(user);
		if(result != null){
//			存在该用户，判断用户的权限是否正确
			UserAndRole role = userService.findRole(userAndRole);
				if(role != null){
					role.setU_id(userAndRole.getU_id());
					role.setU_pw(userAndRole.getU_pw());
					
//					该用户权限不为空，获取该用户所有权限
					
					req.getSession().setAttribute("role", role);
					if( role.getRole_id() == 1){
						int classId = 1;
						req.getSession().setAttribute("classId", classId);
					}else if(role.getRole_id() == 2){
						Teacher teacher = teacherService.selectByPrimaryKey(role.getU_id());
						req.getSession().setAttribute("subId", teacher.getSubId());
					}else if(role.getRole_id() == 3){
						Teacher teacher = teacherService.selectByPrimaryKey(role.getU_id());
						int id = clazzServiceImpl.selecthHeadTeaClazz(role.getU_id());
						Clazz clazz = clazzServiceImpl.findClass(id);
						clazz.setClassId(id);
						req.getSession().setAttribute("subId", teacher.getSubId());
						req.getSession().setAttribute("classId", id);
					}
					else {
						Employee employee = employeeService.selectByPrimaryKey(role.getU_id());
						modelAndView.addObject("employee", employee);
					}
					modelAndView.addObject("role", role);
					modelAndView.setViewName("/user/jsps/main");
					return modelAndView;
				}else{
					String msg = "你没有该权限";
					modelAndView.addObject("msg", msg);
					String title = "测试登陆功能";
					modelAndView.addObject("title", title);
					modelAndView.setViewName("/user/msg");
					return modelAndView;
				}
		}
			String msg = "登陆失败";
			String title = "测试登陆功能";
			modelAndView.addObject("msg", msg);
			modelAndView.addObject("title", title);
			modelAndView.setViewName("/user/msg");
			return modelAndView;	
	}
	
	@RequestMapping("/findMe")
	public ModelAndView findMe(HttpServletRequest req, HttpServletResponse resp){
		ModelAndView modelAndView = new ModelAndView();
		UserAndRole role = (UserAndRole) req.getSession().getAttribute("role");
		if( role.getRole_id() == 1){
			String msg = "admin";
			int classId = 1;
			modelAndView.addObject("msg", msg);
			modelAndView.setViewName("/user/msg");
			return modelAndView;
		}else if(role.getRole_id() == 2){
			Teacher teacher = teacherService.selectByPrimaryKey(role.getU_id());
			req.getSession().setAttribute("subId", teacher.getSubId());
			modelAndView.addObject("teacher", teacher);
		}else if(role.getRole_id() == 3){
			Teacher teacher = teacherService.selectByPrimaryKey(role.getU_id());
			int id = clazzServiceImpl.selecthHeadTeaClazz(role.getU_id());
			Clazz clazz = clazzServiceImpl.findClass(id);
			clazz.setClassId(id);
			modelAndView.addObject("teacher", teacher);
			modelAndView.addObject("class", clazz);
		}
		else {
			Employee employee = employeeService.selectByPrimaryKey(role.getU_id());
			modelAndView.addObject("employee", employee);
		}
		modelAndView.setViewName("user/jsps/myInf");
		return modelAndView;
	}
	
//	退出
	@RequestMapping("/quit")
	public String quit(HttpServletRequest req, HttpServletResponse resp){
		req.getSession().invalidate();
		return "/user/jsps/login";
	}
	
//	修改密码
	@RequestMapping("/editPw")
	public ModelAndView editPw(HttpServletRequest req, HttpServletResponse resp, UserPW userPw){
		ModelAndView modelAndView = new ModelAndView();
		UserAndRole role = (UserAndRole) req.getSession().getAttribute("role");
		String pw = userPw.getUserOpw();
		User user = new User();
		user.setuPw(userPw.getUserNpw());
		if(pw.equals(role.getU_pw())){
			userService.updateByPrimaryKey(user);
			String msg = "成功修改密码";
			modelAndView.addObject("msg", msg);
			modelAndView.setViewName("user/jsps/msg");
			return modelAndView;
		}else{
			String msg = "修改密码失败";
			modelAndView.addObject("msg", msg);
			modelAndView.setViewName("user/jsps/msg");
			return modelAndView;
		}
	}
}
