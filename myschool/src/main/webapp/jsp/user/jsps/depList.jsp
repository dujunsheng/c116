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
	<p align="center">部门管理</p>
	
<c:choose>
		<c:when test="${empty pb.beanList }">
			<table width="95%" align="center" cellpadding="0" cellspacing="0" style="line-height:50px;">
				<tr>
					<td>
						<span class="spanEmpty">没有部门</span>
					</td>
				</tr>
			</table>  
		</c:when>
		<c:otherwise>
		<div  align="center">所有部门</div>
			<table width="95%" align="center" cellpadding="0" cellspacing="0">
				<tr bgcolor="#efeae5">
					<td>部门id</td>
					<td>部门名称</td>
					<td>操作</td>
					<td>操作</td>
					<td>操作</td>
				</tr>	
	
				<c:forEach items="${pb.beanList }" var="department" varStatus="status">
					<tr>
						<td>${department.depId }</td>	
						<td><input type="text" value="${department.depName }" name="depName"/></td>
						<td>
							<a href="<c:url value='/updateDepartment.action?depName=<% request.getParameter("depName"); %>&depId=${department.depId }'/>" >修改部门名字</a>
						</td>
						<td>
							<a href="<c:url value='/deleteDepartment.action?depId=${department.depId }'/>">删除该部门</a>
						</td>
						<td>
							<a href="<c:url value='/findEmpByDepId.action?depId=${department.depId }'/>">查看部门成员</a>
						</td>
	
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