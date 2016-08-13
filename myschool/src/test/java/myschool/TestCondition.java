/**
 * 
 */
package myschool;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.school.po.Employee;
import com.school.po.EmployeeExample;
import com.school.service.impl.EmployeeServcie;

/**
 * @author c116
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"/conf/applicationContext-dao.xml",
"/conf/applicationContext-service.xml",
"/conf/springmvc.xml"	})	
public class TestCondition {

	@Resource
	private EmployeeServcie em;
	
	@Test
	public void test(){
		EmployeeExample a = new EmployeeExample();
		EmployeeExample.Criteria c = a.createCriteria();
		c.andEmpNameLike("%李%");
		List<Employee> abc = em.findByExamplie(a);
		System.out.println(abc);
	}
}
