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
  </head>
  
  <body>
	<p align="center">部门管理</p>
		<form action="<c:url value='/insertDepartment.action'/>">
			<table width="95%" align="center" cellpadding="0" cellspacing="0">
					<tr align="center">
						<td>名字</td>
						<td><input type="text" name="teaName"></td>
					</tr>
					<tr align="center">	
						<td></td>
						<td><input type="text" name="depName"></td>
					</tr>
					<tr align="center">
						<td align="center">
							<input type="submit" value="提交"/>
							<input type="reset" value="重置"/>				
						</td>
					</tr>
			</table>
		</form>
	
  </body>
 
</html>