/**
 * 
 */
package com.school.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.school.mapper.UserMapper;
import com.school.po.User;
import com.school.po.UserAndRole;
import com.school.service.base.impl.BaseServiceImpl;

/**
 * @author c116
 *
 */
@Service("UserServcie")
public class UserService extends BaseServiceImpl<User> {

	@Resource
	private UserMapper userMapper;
	
	public User selectByUidAndUpw(User user)throws Exception{
		return userMapper.selectByUidAndUpw(user);
	}
	
//	查询用户的id与权限是否对应
	public UserAndRole findRole(UserAndRole userAndRole){
		return userMapper.findRole(userAndRole);
	}
	
}
