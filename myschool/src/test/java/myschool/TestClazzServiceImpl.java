/**
 * 
 */
package myschool;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.school.po.Evaluate;
import com.school.service.impl.ClazzServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"/conf/applicationContext-dao.xml",
"/conf/applicationContext-service.xml",
"/conf/springmvc.xml"})
public class TestClazzServiceImpl {

	@Resource
	private ClazzServiceImpl clazzServiceImpl;
	
	
	
//	测试提交成绩
	/*@Test
	public void affirmScore(Map<String, Object> paraMap){
		
	}*/
	
//	查询该老师所教的该班级的科目的成绩是否被提交
	/*@Test
	public void testScoreIsAffirm(){}*/
	
//	查询评价模板
/*	@Test
	public void testEvaluate(){
		List<Evaluate> list = clazzServiceImpl.selectAllEvaluate();
		System.out.println(list);
	}*/
	
//	查询班主任所担任班级的ID
	
}
