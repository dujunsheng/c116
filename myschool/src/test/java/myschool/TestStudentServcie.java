package myschool;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.school.po.Student;
import com.school.service.impl.StudentServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"/conf/applicationContext-dao.xml",
"/conf/applicationContext-service.xml",
"/conf/springmvc.xml"})
public class TestStudentServcie {

	@Resource
	public StudentServiceImpl a;
	
//	添加学生
/*	@Test
	public void insert(){
		Student s1 = new Student();
		Student s2 = new Student();
		s1.setStuId("10000002");
		s1.setAdmissionDate(null);
		s1.setAdress(null);
		s1.setBirth(null);
		s1.setClassId(1);
		s1.setFatherName(null);
		s1.setMotherName(null);
		s1.setParentsPhone(null);
		s1.setSex("F");
		s1.setStuName("小丽");	
		s2.setStuId("10000003");
		s2.setAdmissionDate(null);
		s2.setAdress(null);
		s2.setBirth(null);
		s2.setClassId(1);
		s2.setFatherName(null);
		s2.setMotherName(null);
		s2.setParentsPhone(null);
		s2.setSex("F");
		s2.setStuName("小丽");
		List<Student> stuList = new ArrayList<Student>();
		stuList.add(s1);
		stuList.add(s2);
		int result = a.insert(stuList);
		System.out.println(result);
	}*/
	
////	通过班级查询那学生
//	@Test
//	public void testselectByPage
}
