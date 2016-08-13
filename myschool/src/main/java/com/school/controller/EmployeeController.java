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
import com.school.po.DepartmentExample;
import com.school.po.Employee;
import com.school.po.EmployeeExample;
import com.school.service.impl.DepartmentService;
import com.school.service.impl.EmployeeServcie;
import com.school.util.GetUrl;
import com.school.util.PageBean;
import com.school.util.PaginationContext;
import com.school.vo.DepAndEmp;

/**
 * @author c116
 *
 */
@Controller
public class EmployeeController {

	@Resource
	private EmployeeServcie employeeServcie;
	
	@Resource
	private DepartmentService departmentService;
	
	
	
//	查询所有员工
	@RequestMapping("/findAllEmployee")
	public ModelAndView findAllEmployee(HttpServletRequest req, HttpServletResponse resp){
		PageBean<Employee> pb = new PageBean<Employee>();
		ModelAndView modelAndView = new ModelAndView();
		List<Employee> result = employeeServcie.findAll();
		pb.setPageNum(PaginationContext.getPageNum());
		pb.setPageSize(PaginationContext.getPageSize());
		pb.setBeanList(result);
		pb.setUrl(GetUrl.getUrl(req));
		pb.setTr(employeeServcie.countAll());
		modelAndView.addObject("pb", pb);
		modelAndView.setViewName("/user/jsps/employeeList");
		return modelAndView;
	}
	
//	添加员工
	@RequestMapping("/insertEmployee")
	public ModelAndView insertEmployee(HttpServletRequest req, HttpServletResponse resp, Employee employee, String depName){
		DepartmentExample departmentExample = new DepartmentExample();
		DepartmentExample.Criteria criteria = departmentExample.createCriteria();
		criteria.andDepNameEqualTo(depName);
		List<Department> department = departmentService.selectByDepartmentExample(departmentExample);
		if(department.size() > 0){	
			employee.setDepId(department.get(0).getDepId());
			int result = employeeServcie.insertSelective(employee);
			if(result ==1){
				return findAllEmployee(req, resp);
			}else{
				ModelAndView modelAndView = new ModelAndView();
				String msg = "添加员工失败";
				String title = "测试";
				modelAndView.addObject("msg", msg);
				modelAndView.addObject("title", title);
				modelAndView.setViewName("/user/msg");
				return modelAndView;
			}
		}else{
			ModelAndView modelAndView = new ModelAndView();
			String msg = "没有该部门";
			String title = "测试";
			modelAndView.addObject("msg", msg);
			modelAndView.addObject("title", title);
			modelAndView.setViewName("/user/msg");
			return modelAndView;
		}
	}

//	删除员工
	@RequestMapping("/deleteEmployee")
	public ModelAndView deleteEmployee(HttpServletRequest req, HttpServletResponse resp, String empId){
		int result = employeeServcie.deleteByPrimaryKey(empId);
		if(result == 1){
			ModelAndView modelAndView = new ModelAndView();
			String msg = "删除员工成功";
			String title = "测试";
			modelAndView.addObject("msg", msg);
			modelAndView.addObject("title", title);
			modelAndView.setViewName("/user/msg");
			return modelAndView;
		}else{
			ModelAndView modelAndView = new ModelAndView();
			String msg = "删除员工失败";
			String title = "测试";
			modelAndView.addObject("msg", msg);
			modelAndView.addObject("title", title);
			modelAndView.setViewName("/user/msg");
			return modelAndView;
		}
	}
	
//	更改员工信息
	@RequestMapping("/updateEmployee")
	public ModelAndView updateEmployee(HttpServletRequest  req, HttpServletResponse resp, Employee employee){
		int result = employeeServcie.updateByPrimaryKeySelective(employee);
		if(result == 1){
			ModelAndView modelAndView = new ModelAndView();
			String msg = "更改信息成功";
			String title = "测试";
			modelAndView.addObject("msg", msg);
			modelAndView.addObject("title", title);
			modelAndView.setViewName("/user/msg");
			return modelAndView;
		}else{
			ModelAndView modelAndView = new ModelAndView();
			String msg = "更改信息失败";
			String title = "测试";
			modelAndView.addObject("msg", msg);
			modelAndView.addObject("title", title);
			modelAndView.setViewName("/user/msg");
			return modelAndView;
		}
	}
	
//	查询员工所在部门
	@RequestMapping("/findEmpAndDep")
	public ModelAndView findEmpAndDep(HttpServletRequest req, HttpServletResponse resp, String emp_id){
		DepAndEmp depAndEmp = employeeServcie.findEmpAndDep(emp_id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("depAndEmp", depAndEmp);
		modelAndView.setViewName("/user/page");
		return modelAndView;
	}
		
	
//	多条件查询员工信息
	@RequestMapping("/findEmpByCondition")
	public ModelAndView findEmpByCondition(HttpServletRequest req, HttpServletResponse resp, Employee employee
			, String min, String max){
		ModelAndView modelAndView = new ModelAndView();
		EmployeeExample example = new EmployeeExample();
//		构造条件（姓名模糊查询，性别查询， 薪水范围查询）
		EmployeeExample.Criteria criteril = example.createCriteria();
		if(employee != null){
			if(employee.getEmpName() !=null && employee.getEmpName() != " ")
				{criteril.andEmpNameLike("%"+employee.getEmpName()+"%");}
			if(employee.getSex() != null && employee.getSex() != ""){
				criteril.andSexEqualTo(employee.getSex());
			}
		}
		if(min != null && max != null ){
			criteril.andSalaryBetween(Integer.valueOf(min), Integer.valueOf(max));
		}
		List<Employee> list = employeeServcie.findByExamplie(example);

			modelAndView.addObject("list", list);
			modelAndView.setViewName("user/jsps/empConditionList");
			return modelAndView;
		
	}
	
//	通过部门id查询
	@RequestMapping("/findEmpByDepId")
	public ModelAndView findEmpByDepId(HttpServletRequest req, HttpServletResponse resp, String depId){
		ModelAndView modelAndView = new ModelAndView();
		PageBean<Employee> pb = new PageBean<Employee>();
		List<Employee> list = employeeServcie.findByDepId(Integer.valueOf(depId));
		pb.setBeanList(list);
		pb.setPageNum(PaginationContext.getPageNum());
		pb.setPageSize(PaginationContext.getPageSize());
		pb.setUrl(req.getContextPath()+"/findEmpByDepId.action");
		pb.setTr(employeeServcie.countByDepId(Integer.valueOf(depId)));
		modelAndView.addObject("pb", pb);
		modelAndView.setViewName("user/jsps/employeeList");
		return modelAndView;
	}
	
//	通过id查询员工的基本信息
	@RequestMapping("/findEmpByEmpId")
	public ModelAndView findEmpByEmpId(HttpServletRequest req, HttpServletResponse resp, String empId){
		ModelAndView modelAndView = new ModelAndView();
		Employee emp = employeeServcie.selectByPrimaryKey(empId);
		modelAndView.addObject("emp", emp);
		modelAndView.setViewName("/user/jsps/emp");
		return modelAndView;
	}
}
