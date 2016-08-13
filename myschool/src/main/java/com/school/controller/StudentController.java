package com.school.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.school.po.Clazz;
import com.school.po.Evaluate;
import com.school.po.Score;
import com.school.po.Student;
import com.school.po.Teacher;
import com.school.po.UserAndRole;
import com.school.service.impl.ClazzServiceImpl;
import com.school.service.impl.StudentServiceImpl;
import com.school.util.PageBean;
import com.school.util.PaginationContext;
import com.school.vo.ScoreVo;


@Controller
public class StudentController {
	
	@Resource
	private StudentServiceImpl studentService ;
	@Resource
	private ClazzServiceImpl clazzService ;
	

	/**
	 * 确认删除/新增学生
	 * @param type 操作类型，若为0即新增学生，否则则为修改学生
	 * @param student 接受表单传过来的数据
	 * @param pageNow 分页的页数
	 * @return
	 */
	@RequestMapping("/affirmStudent")
	public String addStuent(@RequestParam("type") String type, Student student, 
			@RequestParam("classId") int pageNow ,
			Map<String, Object> map){
		if ("0".equals(type)){
			studentService.insert(student) ;
		}else{
			studentService.updateByPrimaryKey(student) ;
		}
		Map<String, Object> map1 = studentService.selectByClass(student.getClassId(),pageNow) ;
		map.put("StudentMap", map1) ;
		
		return "Students" ;
	}
	
	
	
	/**
	 * 根据班级查找学生
	 * @param classId
	 * @param pageNow
	 * @param map
	 * @return
	 */
	@RequestMapping("/selectStudentByClass")
	public ModelAndView selectStudentByClass(HttpServletRequest req, HttpServletResponse resp){
		ModelAndView mo = new ModelAndView();
		int classId = (int)req.getSession().getAttribute("classId");
		List<Student> list = studentService.selectByClass(classId);
		PageBean<Student> pb = new PageBean<Student>();
		pb.setBeanList(list);
		pb.setPageNum(PaginationContext.getPageNum());
		pb.setPageSize(PaginationContext.getPageSize());
		pb.setTr(studentService.countStuByCla(classId));
		pb.setUrl(req.getContextPath()+"/selectStudentByClass.action");
		mo.addObject("pb", pb);
		mo.setViewName("linsiyuan/Students");
		return mo ;
	}
	
	
	/**
	 * 更新/新增学生
	 * @param stuId 学生ID，若该ID存在则为新增学生，否则即为修改学生
	 * @param classId 学生所在班级
	 * @return
	 */
	@RequestMapping("/updateStudent")
	public String selectClass(HttpSession session,
			@RequestParam(value="stuId",required=false)String stuId,
			@RequestParam(value="classId",required=false) String classId,
			Map<String, Object> map){
		if(null==stuId){
			Student newStudent = new Student() ;
			newStudent.setClassId((int)session.getAttribute("classId"));
			map.put("student", newStudent) ;
		}else {
			Student student = studentService.selectByPrimaryKey(stuId) ;
			map.put("student", student) ;
		}
		return "linsiyuan/student" ;
	}
	
	
	/**
	 * 删除学生
	 * @param 删除学生的ID
	 * @return 数据库操作结果
	 */
	@RequestMapping("/deleteStudent")
	public String deleteStudent(String stuId){
		studentService.deleteByPrimaryKey(stuId) ;
		return "Students" ;
	}
	
	//跳转至添加成绩之前获取评价模板列表
	@RequestMapping("addScore")
	public String addScore(@RequestParam("stuId")String stuId,
			@RequestParam(value="score1" ,required=false) String score,
			@RequestParam(value="id" ,required=false) Integer  id,
			Map<String, Object> map){
		
		Student student = studentService.selectByPrimaryKey(stuId) ;
		List<Evaluate> evaList = clazzService.selectAllEvaluate() ;
		
		map.put("stuName", student.getStuName()) ;
		map.put("stuId", student.getStuId()) ;
		map.put("evaList", evaList) ;
		if(score!=null){
			map.put("score", score);
			map.put("id", id) ;
		}else {
			map.put("score", "") ;
			map.put("id", "") ;
		}
		return "linsiyuan/user/addScore" ;
	}
	//确认添加成绩
	@RequestMapping("affirmAddScore")
	public ModelAndView affirmAddScore(@RequestParam("stuId")String stuId,
			@RequestParam("type") String type ,
			@RequestParam(value="id",required=false) Integer id ,
			String score1,int evaId,
			HttpSession session){
		//模拟从session取得当前教师
		UserAndRole role = (UserAndRole) session.getAttribute("role");
		int subId = (int)session.getAttribute("subId");
		Score score = new Score() ;
		score.setSubId(subId);
		score.setTeaId(role.getU_id());
		score.setStuId(stuId);
		score.setEvaId(evaId);
		score.setScore(Double.parseDouble(score1));
		
		if ("0".equals(type)){
			studentService.addScore(score) ;
		}else {
			score.setId(id);
			studentService.updateScore(score) ;
		}
		ModelAndView mo = new ModelAndView();
		String msg = "操作成功";
		mo.addObject("msg", msg);
		mo.setViewName("user/msg");
		return mo ;
	}

	
	//任命学生作为班长
	@RequestMapping("addMonitor")
	public ModelAndView addMonitor(HttpServletRequest req, HttpServletResponse resp,
			@RequestParam("stuId") String stuId,
			@RequestParam("clazzId") String classId ,
			Map<String,Object> map){
		Clazz clazz = new Clazz() ;
		clazz.setClassId(Integer.parseInt(classId));
		clazz.setMomitorId(stuId);
		clazzService.updateByPrimaryKeySelective(clazz) ;
		return selectStudentByClass(req, resp) ;
	}
	
	//查看某一个学生的成绩
	@RequestMapping("/selectSubScore")
	public String selectSubScore(@RequestParam("stuId") String stuId,
			HttpSession session,
			Map<String,Object> map){
		int subId = 0;
		UserAndRole role = (UserAndRole) session.getAttribute("role");
		if(role.getRole_id() ==2){
			 subId = (int) session.getAttribute("subId");
		}
		//如果登录的是班主任角色，则将科目ID置为0，在查询时不限制查询科目
		if (3==role.getRole_id()){
			 subId = 0 ;
		}
		Map<String, Object> paraMap = new HashMap<String,Object>() ;
		map.put("stuId", stuId) ;
		map.put("subId", subId) ;
		List<ScoreVo> so = studentService.selectSubScore(paraMap) ;
		map.put("scoreList", so) ;
		return "linsiyuan/clazz/Score" ;
	}
	
	@RequestMapping("/findAllStu")
	public ModelAndView findAllStu(HttpServletRequest req, HttpServletResponse resp){
		ModelAndView mo = new ModelAndView();
		PageBean<Student> pb = new PageBean<Student>();
		List<Student> list = studentService.findAllStu();
		pb.setBeanList(list);
		pb.setPageNum(PaginationContext.getPageNum());
		pb.setPageSize(PaginationContext.getPageSize());
		pb.setTr(studentService.countAllStu());
		pb.setUrl(req.getContextPath()+"/findAllStu.action");
		mo.addObject("pb", pb);
		mo.setViewName("linsiyuan/Students");
		return mo;
	}
	
}
