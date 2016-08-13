<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table>
    <tr style="color:blue">
	    <th width="50">学号</th> 
	    <th width="100">姓名</th>
	    <th width="100">性别</th>
	    <th width="100">生日</th>
	    <th width="100">入学日期</th>
	    <th width="100">父亲</th>
	    <th width="100">母亲</th>
	    <th width="100">监护人电话</th>
	    <th width="100">地址</th>
	    <th width="100">操作</th>
    </tr>
    <tr>
	<c:forEach items="${pb.beanList }" var="student">
	    <th width="50">${student.stuId }</th> 
	    <th width="80">${student.stuName }</th>
	    <th width="100">${student.sex }</th>
	    <th width="100">${student.birth }</th>
	    <th width="100">${student.admissionDate }</th>
	    <th width="100">${student.fatherName }</th>
	    <th width="100">${student.motherName }</th>
	    <th width="100">${student.parentsPhone }</th>
	    <th width="100">${student.adress }</th>
	    <th><a href="selectSubScore.action?stuId=${student.stuId }">查看成绩</a>
	    	<a href="addScore.action?stuId=${student.stuId }&clazzId=${student.classId}">新增成绩</a>
	    	<a href="addMonitor.action?stuId=${student.stuId }&clazzId=${student.classId}">任为班长</a><br><br><br>
	    </th>
	    <tr>
	</c:forEach>
    </tr>
	
	</table>
	<c:if test="${!empty pb.beanList}">
		<div style="float:left; width: 100%; text-align: center;">
			<hr/>
			<br/>
			<%@include file="/jsp/user/jsps/pager.jsp" %>
		</div>
	</c:if>
</body>
</html>