package com.school.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.school.mapper.ResourceMapper;
import com.school.po.Resource;

@Service("ResourceService")
public class ResourceService {

    @javax.annotation.Resource
    private ResourceMapper resourceMapper;

    /**
     * 上传资源
     * 
     * @param resource
     * @return
     * @throws IOException
     */
    public int upload(Resource resource) throws IOException {
	return resourceMapper.insertSelective(resource);
    }

    /**
     * 删除资源
     * @param resource
     * @return
     */
    public int delete(int id) {
	return resourceMapper.deleteByPrimaryKey(id);
    }

    /*
     * 按id查找资源
     */
    public Resource selectByPrimaryKey(int id) {
	return resourceMapper.selectByPrimaryKey(id);
    }
    
    /**
     * 查看资源 分页？？？
     *TODO
     * @return
     */
    public List<Resource> getResources(Map<String, Object> param ) {
	// 先从数据库中查询对应的表段记录
	// 从服务器拿资源
	// 直接调用下面方法没有参数条件就是查询全部
	// 是否考虑分页 TODO
	return resourceMapper.selectByParameters(param);
    }

    /*
     * 获取最近两天的新上传的资源，标记为new
     */
    public List<Resource> getLastestResources(Map<String, Object> params) {
	return  resourceMapper.getLastestResource(params);
    }

    /*
     * 根据时间查找
     */
    public List<Resource> getResourcesByTime(Map<String, Object> params) {
	return  resourceMapper.selectByParameters(params);
    }
    
    /*
     * 查看某班班级资源，如果classId为0则查看的是校内资源
     */
    public List<Resource> getResourcesByClass(int classId,Map<String, Object> params) {
	// 依然调用selectselective
	return resourceMapper.selectByParameters(params);
    }

    /*
     * 按分类查找资源，1图片相册2视频3普通文件
     */
    public List<Resource> getResourcesByType(int typeId,Map<String,Object> params) {
	// 依然调用selectselective
	return resourceMapper.selectByParameters(params);
    }
}
