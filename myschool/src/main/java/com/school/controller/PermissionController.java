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

import com.school.po.UserAndRole;
import com.school.service.impl.PermissionService;
import com.school.vo.RoleAndPer;

/**
 * @author c116
 *
 */
@Controller
public class PermissionController {

	@Resource
	private PermissionService psermissionService;
	/*http://localhost:8080/myschool/findPrePermission.action*/
//	根据该用户的角色id查询父类功能
	@RequestMapping("/findPrePermission")
	public ModelAndView findPrePermission(HttpServletRequest req, HttpServletResponse resp){
		UserAndRole role = (UserAndRole) req.getSession().getAttribute("role");
		List<RoleAndPer> rolAndPers = psermissionService.findPreByRol_id(Integer.valueOf(role.getRole_id()));
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("rolAndPers", rolAndPers);
		modelAndView.setViewName("/user/jsps/left");
		return modelAndView;
	}
}
