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
	<p align="center">我的信息</p>
	
		<c:if test="${ sessionSopr.role.role_id == 2} ">
			<table width="95%" align="center" cellpadding="0" cellspacing="0" style="line-height:50px;">
				<tr align="center">
					<td>教师id</td>
					<td>${teacher.teaId }</td>
				</tr>	
				<tr align="center">
					<td>名称</td>
					<td>${teacher.teaName }</td>
				</tr>
				<tr align="center">
					<td>性别</td>
					<td>${teacher.sex }</td>
				</tr>
				<tr align="center">
					<td>出生日期</td>
					<td>${teacher.birth }</td>
				</tr>
				<tr align="center">
					<td>入职时间</td>
					<td>${teacher.hiredate }</td>
				</tr>
				<tr align="center">
					<td>薪水</td>
					<td>${teacher.salary }</td>
				</tr>
				<tr align="center">
					<td>地址</td>
					<td>${teacher.adress }</td>
				</tr>
				<tr align="center">
					<td>电话号码</td>
					<td>${teacher.phone }</td>
				</tr>
				<tr align="center">
					<td>教师等级</td>
					<td>${teacher.rank }</td>
				</tr>
			</table>  
		</c:if>
		<c:if test="${sessionSope.role.role_id == 4}">
			<table width="95%" align="center" cellpadding="0" cellspacing="0">
					<tr align="center">
						<td>学号</td>
						<td>${student.stuId }</td>
					</tr>	
					<tr align="center">
						<td>姓名</td>
						<td>${student.stuName }</td>
					</tr>	
					<tr align="center">
						<td>性别</td>
						<td>${student.sex }</td>
					</tr>
					<tr align="center">
						<td>生日</td>
						<td>${student.birth }</td>
					</tr>		
					<tr align="center">
						<td>入学时间</td>
						<td>student.admissionDate</td>
					</tr>	
					<tr align="center">
						<td>班级号</td>
						<td>${student.classId }</td>
					</tr>	
					<tr align="center">
						<td>父亲姓名</td>
						<td>${student.fatherName }</td>
					</tr>	
					<tr align="center">
						<td>母亲姓名</td>
						<td>${student.motherName }</td>
					</tr>	
					<tr align="center">
						<td>手机号</td>
						<td>${student.parentsPhone }</td>
					</tr>	
					<tr align="center">
						<td>地址</td>
						<td>${studnet.adress }</td>
					</tr>	
						
			</table>
		</c:if>
		<c:if test="${sessionScope.role.role_id == 5 }">
			<table width="95%" align="center" cellpadding="0" cellspacing="0">
				<tr align="center">
					<td>员工号</td>
					<td>${employee.empId }</td>
				</tr>
				<tr align="center">
					<td>姓名</td>
					<td>${employee.empName }</td>
				</tr>
				<tr align="center">
					<td>性别</td>
					<td>${employee.sex }</td>
				</tr>
				<tr align="center">
					<td>生日</td>
					<td>${employee.birth }</td>
				</tr>
				<tr align="center">
					<td>入职时间</td>
					<td>${employee.hiredate }</td>
				</tr>
				<tr align="center">
					<td>薪水</td>
					<td>${employee.salary }</td>
				</tr>
				<tr align="center">
					<td>地址</td>
					<td>${employee.adress }</td>
				</tr>
				<tr align="center">
					<td>电话</td>
					<td>${employee.phone }</td>
				</tr>
				<tr align="center"> 
					<td>部门号</td>
					<td>${employee.depId }</td>
				</tr>
			</table>
		</c:if>
  </body>
 
</html>