<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsp/css/pager.css'/>" />
	<script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
	<style type="text/css">
		li {float: left; width: 240px; list-style:none;height: 319px; line-height: 18px; position: relative; border-bottom: solid 1px #e5e5e5; }
		li div {margin-bottom:1px;margin-left: 10px;}
	</style>
  </head>
  
  <body>
	<p align="center">教师列表</p>
	
<c:choose>
		<c:when test="${empty pb.beanList }">
			<table width="95%" align="center" cellpadding="0" cellspacing="0" style="line-height:50px;">
				<tr>
					<td>
						<span class="spanEmpty">没有老师</span>
					</td>
				</tr>
			</table>  
		</c:when>
		<c:otherwise>
			<table width="95%" align="center" cellpadding="0" cellspacing="0">
				<tr bgcolor="#efeae5">
					<td>教师id</td>
					<td>名称</td>
					<td>性别</td>
					<td>出生日期</td>
					<td>入职时间</td>
					<td>薪水</td>
					<td>地址</td>
					<td>电话号码</td>
					<td>教师等级</td>
					<td>操作</td>
				</tr>	
	
				<c:forEach items="${pb.beanList }" var="teacher" varStatus="status">
					<tr>
						<td>${teacher.teaId }</td>
						<td>${teacher.teaName }</td>
						<td>${teacher.sex }</td>
						<td>${teacher.birth }</td>
						<td>${teacher.hiredate }</td>
						<td>${teacher.salary }</td>
						<td>${teacher.adress }</td>
						<td>${teacher.phone }</td>
						<td>${teacher.rank }</td>
						<td><a></a></td>
					</tr>
				</c:forEach>
	
			</table>
	
		</c:otherwise>
	</c:choose>
	<c:if test="${!empty pb.beanList}">
		<div style="float:left; width: 100%; text-align: center;">
			<hr/>
			<br/>
			<%@include file="/jsp/user/jsps/pager.jsp" %>
		</div>
	</c:if>
  </body>
 
</html>