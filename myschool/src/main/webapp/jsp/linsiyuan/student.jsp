<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<from:form action="affirmStudent.action?type=${student.stuName==null?0:1 }" method="POST" modelAttribute="student">
	学号：<from:input path="stuId"/><br>
	姓名：<from:input path="stuName"/><br>
	性别：<from:input path="sex"/><br>
	生日：<from:input path="birth"/><br>
	入学日期：<from:input path="admissionDate"/><br>
	<from:hidden path="classId"/>
	父亲：<from:input path="fatherName"/><br>
	母亲：<from:input path="motherName"/><br>
	监护人号码：<from:input path="parentsPhone"/><br>
	家庭住址：<from:input path="adress"/><br>

	<input type="submit" value="确认">
	<input type="reset" value="重置">
</from:form>
</body>
</html>