<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="selectStudentByClass.action?classId=1&pageNow=1">获取班级学生</a><br>

<!-- 老师通过查找班级学生可以修改该学生的基本信息 -->
<a href="updateStudent.action?stuId=12">修改学生</a><br><br>

<a href="updateStudent.action">添加学生</a><br><br>

<a href="selectClazz.action?teaId=1">班级管理</a>

<a href="addClazz.action">新增班级</a>

<a href="selectAllClazz.action">科任老师查看所教班级</a>

<a href="selectHeadClazz.action?pageNow=1">班主任查看班级</a>

<a href="selectHeadScore.action?teaId=6">班主任查看成绩</a>

    <form action="importStudent.action" method="post" enctype="multipart/form-data"  >  
            <label for="file">File</label>  
            <input id="file" type="file" name="file" />  
            <p><button type="submit">Read</button></p>    
    </form>

</body>
</html>