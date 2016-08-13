/**
 * 
 */
package myschool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.school.po.Clazz;
import com.school.po.Evaluate;
import com.school.po.Student;
import com.school.service.impl.ClazzServiceImpl;
import com.school.vo.ScoreVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"/conf/applicationContext-dao.xml",
"/conf/applicationContext-service.xml",
"/conf/springmvc.xml"})
public class TestClazzServiceImpl {

	@Resource
	private ClazzServiceImpl clazzServiceImpl;

	
//	测试提交成绩*
	/*@Test
	public void affirmScore(Map<String, Object> paraMap){
		
	}*/
	
//	查询该老师所教的该班级的科目的成绩是否被提交*
	/*@Test
	public void testScoreIsAffirm(){}*/
	
//	查询评价模板*
/*	@Test
	public void testEvaluate(){
		List<Evaluate> list = clazzServiceImpl.selectAllEvaluate();
		System.out.println(list);
	}*/
	
//	查询班主任所担任班级的ID*
	/*@Test
	public void testSelecthHeadTeaClazz(){
		int a = clazzServiceImpl.selecthHeadTeaClazz("00000001");
		System.out.println(a);
	}*/
	
//	新增班级*
/*	@Test
	public void testInsert(){
		Clazz c = new  Clazz();
		c.setClazz(1);
		c.setGrade(1);
		c.setHeadTeaId("12345678");
		c.setMomitorId(null);
		int a = clazzServiceImpl.insert(c);
		System.out.println(a);
	}
	*/
//	根据班级 、学生号、 科目号查询学生所有成绩*
	@Test
	public void testSelectScore(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("stuId", "10000001");
		List<ScoreVo> list = clazzServiceImpl.selectScore(map);
		System.out.println(list);
	}
	
//	将Excel表读取出来的学生成绩批量导入到数据库中*
//	@Test
/*	public void testImportStu(){
		
	}
	*/
}
