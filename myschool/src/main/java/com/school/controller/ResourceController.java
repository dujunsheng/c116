package com.school.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.school.po.Resource;
import com.school.service.impl.ResourceService;
import com.school.util.DateFormatUtil;
import com.school.util.DateUtil;
import com.school.util.FileFormatUtil;
import com.school.util.FileUtil;
import com.school.vo.ResourceVo;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/resource")
public class ResourceController {

    @javax.annotation.Resource
    private ResourceService rs;
    
    /*
     * 多文件上传，无法设置标题
     */
    @RequestMapping(value= {"/uploads.action"/*"/img/uploads.action","/video/uploads.action","/file/uploads.action"*/})
    public String toUploads() {
	return "uploads";
    }
    
    /*
     * 跳转到班级资源页
     */
    @RequestMapping(value="/classresource/goto.action",method=RequestMethod.GET)
    public String toClassResource() {
	return "class_resource";
    }
    
    /*
     * 跳转到校园资源页
     */
    @RequestMapping(value="/campusresource/goto.action",method=RequestMethod.GET)
    public String toCampusResource() {
	return "campus_resource";
    }

    /*
     * get请求,获取相册,默认按时间
     */
    @RequestMapping(value = "/img/get.action",method=RequestMethod.GET)
    public String getImgByTime(
	    @RequestParam(value = "time", required = true) String time,
	    Map<String, Object> map) {
	map.put("time", time);
	map.put("type", 1);
	List<Resource> resources = rs.getResourcesByTime(map);
	map.put("resources", resources);
	return "pic";
    }

    /*
     * 以GET请求加restfulurl获取班级相册资源 class_id为0时获得的是校内的相册，而不是班级的
     */
    // @ResponseBody
    @RequestMapping(value = "/img/{class_id}/get.action", method = RequestMethod.GET)
    public String getClassImages(@PathVariable(value = "class_id") int id,
	    Map<String, Object> map) {
	map.put("type", 1);
	map.put("class_id", id);
	List<Resource> resources = rs.getResources(map);
	// return JSONArray.fromObject(resources).toString();
	map.put("resources", resources);
	return "pic";
    }

    /*
     * 获取视频资源，需要classid
     */
    @RequestMapping(value = "/vedio/{class_id}/get.action", method = RequestMethod.GET)
    public String getClassVideo(@PathVariable("class_id") int id,
	    Map<String, Object> map) {
	map.put("class_id", id);
	map.put("type", 2);
	List<Resource> resources = rs.getResources(map);
	map.put("resources", resources);
	return "video";
    }

    /*
     * 获取文件
     */
    @RequestMapping(value = "/file/{class_id}/get.action")
    public String getClassFile(@PathVariable("class_id") int id,
	    Map<String, Object> map) {
	map.put("class_id", id);
	map.put("type", 3);
	List<Resource> resources = rs.getResources(map);
	map.put("resources", resources);
	return "file";
    }
    
    /*
     * 获取校内文件
     */
    @RequestMapping("/file/campus/get.action")
    public String getCampusFile(Map<String,Object> map) {
	List<Resource> resources = null;
	map.put("class_id", 0);
	map.put("type", 3);
	resources = rs.getResources(map);
	map.put("resources", resources);
	return "campusfile";
    }
    
    /*
     *  获取校内视频
     */
    @RequestMapping("/video/campus/get.action")
    public String getCampusVideo(Map<String,Object> map) {
	List<Resource> resources = null;
	map.put("class_id", 0);
	map.put("type", 2);
	resources = rs.getResources(map);
	map.put("resources", resources);
	return "campusvideo";
    }
    
    /*
     *获取校内相片
     */
    @RequestMapping("/img/campus/get.action")
    public String getCampusImg(Map<String,Object> map) {
	List<Resource> resources = null;
	map.put("class_id", 0);
	map.put("type", 2);
	resources = rs.getResources(map);
	map.put("resources", resources);
	return "campusimg";
    }

    /*
     * 以GET方法跳转到相册上传页面
     */
    @RequestMapping(value = "/img/upload.action", method = RequestMethod.GET)
    public String toUploadImg(Map<String, Object> map) {
	map.put("resourceType", 1);
	return "upload";
    }

    /*
     * 以GET方法跳转到视频上传页面
     */
    @RequestMapping(value = "/video/upload.action", method = RequestMethod.GET)
    public String toUploadVideo(Map<String, Object> map) {
	map.put("resourceType", 2);
	return "upload";
    }

    /*
     * 以GET方法跳到上传文件页面
     */
    @RequestMapping(value = "/file/upload.action", method = RequestMethod.GET)
    public String toUploadFile(Map<String, Object> map) {
	map.put("resourceType", 3);
	return "upload";
    }

    /**
     * 资源上传
     * 
     * @param file
     * @param request
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = { "/img/upload.action", "/video/upload.action",
	    "/file/upload.action" }, method = RequestMethod.POST)
    public String uploadImg(@RequestParam("file") CommonsMultipartFile[] files,
	    Resource resource, HttpServletRequest request) throws IOException {
	Map<String, String> msg = new HashMap<String, String>();

//	User u = (User)request.getSession().getAttribute("user");
//	String u_id = u.getuId();
//	通过u_id查user得到class_id即可的值当前用户是那个班的class_id
//	设置班级id int class_id = 1 TODO
	int class_id = 1;// TODO 前端传值，从session中获取
	String u_id = "1";// TODO
	resource.setUser_id(u_id);
	resource.setClass_id(class_id);
	ResourceVo rv;

	for (CommonsMultipartFile file : files) {
	    if (file.isEmpty()) {
		continue;
	    }
	    // 判断文件格式是否正确
	    if (!FileFormatUtil.isValidFile(file.getOriginalFilename())) {
		msg.put("msg", "invalid_file");
		return JSONObject.fromObject(msg).toString();
	    }

	    // 1.将客户端的文件上传到服务器，存储
	    // 文件上传，路径存放在webapps下的upload目录下
	    rv = FileUtil.upload(file, request);

	    if (rv == null) {
		msg.put("msg", "fail");
		return JSONObject.fromObject(msg).toString();// 判断文件上传是否成功
	    }

	    // 设置资源信息
	    if (resource.getTitle() == null || "".equals(resource.getTitle())) {
		resource.setTitle(file.getOriginalFilename());
	    }
	    resource.setType(rv.getType());
	    resource.setRelative_path(rv.getRelative_path());// 设置相对路径，存放到数据库中
	    resource.setThumb_path(rv.getRelativeThumbPath());// 缩略图的相对路径
	    resource.setTime(DateFormatUtil.formatDateToDay(new Date()));// 设置上传时间
	    // 3调用service上传文件,添加纪录到数据库
	    int result = rs.upload(resource);
	    if (result != 0) {
		msg.put("msg", "success");
	    } else {
		msg.put("msg", "fail");
	    }
	}
	return JSONObject.fromObject(msg).toString();
    }

    @RequestMapping("/{resource_id}/download.action")
    public void downLoad(@PathVariable("resource_id") int id,
	    HttpServletRequest request, HttpServletResponse response)
	    throws IOException {
	Resource resource = rs.selectByPrimaryKey(id);
	String path = null;
	if (resource == null) {
	    return;
	}
	path = request.getSession().getServletContext().getRealPath("/upload");
	// 设置文件形式
	response.setContentType("multipart/form-data");
	// 设置头信息
	response.setHeader("Content-Disposition",
		"attachment;fileName=" + resource.getTitle()
			+ resource.getRelative_path().substring(
				resource.getRelative_path().lastIndexOf(".")));
	ServletOutputStream out = null;// 输出文件流
	File file = new File(path + resource.getRelative_path());
	FileInputStream in = new FileInputStream(file);
	// 通过response获取输出文件流
	out = response.getOutputStream();
	int b = 0;
	byte[] buffer = new byte[1024];
	while (b != -1) {
	    b = in.read(buffer);
	    out.write(buffer, 0, b);
	}
	in.close();
	out.flush();
	out.close();
    }

    /*
     * get请求删除资源
     */
    @RequestMapping(value = "/{resource_id}/delete.action", method = RequestMethod.GET)
    public String deleteResource(@PathVariable("resource_id") int resource_id,
	    HttpServletRequest request) {
	Resource resource = rs.selectByPrimaryKey(resource_id);// 从数据库查找该资源
	if (resource != null) {
	    //1.删除数据库记录
	    rs.delete(resource_id);
	    // 2.删除服务器上的对应资源
	    String contextPath = request.getSession().getServletContext()
		    .getRealPath("upload");
	    ResourceVo rv = new ResourceVo();
	    rv.setAbsolutePath(contextPath + resource.getRelative_path());// 获取资源在服务器的位置
	    rv.setThumb_path(
		    contextPath + "/thumb/" + resource.getRelative_path()); // 获取对应缩略图的资源路径
	    FileUtil.delete(rv);// 执行删除
	} else {
	    // 返回错误界面
	}
	return "redirect:/jsp/resource.jsp";
    }

    /*
     * 获取这两天的资源
     */
    @RequestMapping(value = { "/vedio/lastest.action" })
    public String getLastestResource(Map<String, Object> map) {
	String today = DateFormatUtil.formatDateToDay(new Date());
	String before = DateFormatUtil
		.formatDateToDay(DateUtil.getLasetestDate(2));// 获取两天前日期
	map.put("beforeday", before);
	map.put("today", today);
	map.put("type", 2);
	List<Resource> resources = this.rs.getLastestResources(map);
	map.put("resources", resources);
	return "video";
    }

}