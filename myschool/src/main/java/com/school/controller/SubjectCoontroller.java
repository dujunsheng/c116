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

import com.school.po.Subject;
import com.school.service.impl.SubjectServcie;
import com.school.util.PageBean;
import com.school.vo.TeaAndSub;

import net.sf.json.JSONArray;

/**
 * @author c116
 *
 */
@Controller
public class SubjectCoontroller {

	@Resource
	private SubjectServcie subjectServcie;
	
	@RequestMapping("/selectAllSubject")
	public String selectAllSubject(HttpServletRequest req, HttpServletResponse resp){
		return null;
	}
	
	@RequestMapping("/selectSubAndTea")
	public String selectSubAndTea(int subId){
		TeaAndSub list = subjectServcie.selectSubAndTea(subId);
		return JSONArray.fromObject(list).toString();
	}
	
	@RequestMapping("/insertSubject")
	public ModelAndView insertSubject(String subName){
		Subject subject = new Subject();
		subject.setSubName(subName);
		int result = subjectServcie.insert(subject);
		ModelAndView modelAndView = new ModelAndView();
		if(result == 1){
			String msg = "成功";
			String title = "添加科目";
			modelAndView.addObject("msg", msg);
			modelAndView.addObject("title", title);
			modelAndView.setViewName("/user/msg");
			return modelAndView;
		}else{
			String msg = "失败";
			String title = "添加科目";
			modelAndView.addObject("msg", msg);
			modelAndView.addObject("title", title);
			modelAndView.setViewName("/user/msg");
			return modelAndView;
		}
	}
}
