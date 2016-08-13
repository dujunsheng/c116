<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${clazzList }" var="clazz">
		${clazz.grade}级${clazz.clazz}班
		<a href="selectStudentByClass.action?classId=${clazz.classId }&pageNow=1">查看该班级学生</a>
		<a href="selectScoreByClazz.action?clazzId=${clazz.classId }">查看该班级本科目成绩</a>
		<a href="selectScoreByClazz.action?clazzId=${clazz.classId }">查看该班级所有科目成绩</a>
		 	
    <form action="importScore.action" method="post" enctype="multipart/form-data"  >  
            <label for="file">上传成绩</label>  
            <input id="file" type="file" name="file" />  
            <p><button type="submit">上传</button></p>    
    </form>
		
		<br>
	</c:forEach>
</body>
</html>