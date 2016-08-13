package com.school.mapper;

import java.util.List;
import java.util.Map;

import com.school.po.Resource;

public interface ResourceMapper/* extends BaseDao<Resource>*/{
    int insertSelective(Resource resource);
    /*
     * 通过主键删除
     */
    int deleteByPrimaryKey(int id);
    /*
     * 通过主键查找
     */
    Resource selectByPrimaryKey(int id);
    
    /*
     * 条件查找
     */
    List<Resource> selectByParameters(Map<String,Object> params);
    
    /*
     * 获取两天之内资源
     */
    List<Resource> getLastestResource(Map<String,Object> params);
    
//    List<Resource> selectAll();
	
}
