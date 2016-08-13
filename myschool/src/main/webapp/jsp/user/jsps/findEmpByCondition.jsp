<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>组合查询员工</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	table {
		color: #404040;
		font-size: 10pt;
	}
</style>
  </head>
  
  <body>
  <form action="<c:url value='/findEmpByCondition.action'/>" method="get">
	<table align="center">
	<tr>
		<td>姓名：</td>
		<td><input type="text" name="empName"/></td>
	</tr>
	<tr>
		<td>性别：</td>
		<td><input type="text" name="sex"/></td>
	</tr>
	<tr>
		<td>薪水范围：</td>
		<td><input type="text" name="min"/> —— <input type="text" name="mix"/></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>
			<input type="submit" value="搜　　索"/>&nbsp;
			<input type="reset" value="重新填写"/>
		</td>
	</tr>
</table>
	</form>
  </body>
</html>
