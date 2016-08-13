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
			<table width="95%" align="center" cellpadding="0" cellspacing="0">
				<tr bgcolor="#efeae5">
					<td>教师id</td>
					<td>名字</td>
					<td>等级</td>
					<td>操作</td>
				</tr>
			<c:forEach items="${pb.beanList }" var="teacher" varStatus="status">	
				<form action="<c:url value='/updateTeacher.action?teaId=${teacher.teaId }'/>">
					<table width="95%" align="center" cellpadding="0" cellspacing="0">
						<tr>
						<td><input type="text" value="${teacher.teaId }" name="teaId"></td>
						<td>${teacher.teaName }</td>
						<td>
							<select name="rank">
								<option selected="true" value="0"> </option>
								<option value="0">普通教师</option>
								<option value="1">特级教师</option>
								<option value="2">高级教师</option>
							</select>
						</td>
						<td><input type="submit"></td>
						</tr>
					</table>
				</form>
				</c:forEach>
			</table>
  </body>
 
</html>