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

import com.school.po.Permission;
import com.school.service.impl.PermissionService;
import com.school.vo.RoleAndPer;

/**
 * @author c116
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"/conf/applicationContext-dao.xml","/conf/applicationContext-service.xml"})
public class TestPermission {

	@Resource
	private PermissionService permissionService;
	
	/*@Test
	public void test(){
		List<Permission> perList = permissionService.findPer();
		System.out.println(perList);
	}*/
	
//	根据用户角色拿到用户的父类权限
	@Test
	public void test(){
		List<RoleAndPer> role = permissionService.findPreByRol_id(1);
		System.out.println(role);
	}
}
