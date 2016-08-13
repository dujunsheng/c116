<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>员工</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<script src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsp/css/book/goodDesc.css'/>">
  </head>
  
  <body>
  <div>
    <div class="divBookDesc" align="center">
	    <ul>
	    	<li>员工号：${emp.empId }</li>
	    	<li>姓    	名：${emp.empName }</li>
	    	<li>性	别: ${emp.sex } </li>
	    	<li>生	日：${emp.birth }</li>
	    	<li>入职时间：${emp.hiredate }</li>
	    	<li>地	址：${emp.adress }</li>
	    	<li>手机号：${emp.phone }</li>
	    	<li>薪	水：${emp.salary }</li>
	    	<li>部门号：${emp.depId }</li>
	    </ul>
		<hr class="hr1"/>
	</div>
	<div>
		<a href="<c:url value=''/>">返回主页</a>
	</div>
  </div>
  </body>
</html>