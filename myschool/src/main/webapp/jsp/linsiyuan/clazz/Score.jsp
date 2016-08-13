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
	<table>
		<tr>
			<th>学号</th>	
			<th>姓名</th>	
			<th>科目</th>	
			<th>教师名字</th>	
			<th>评价</th>
			<th>分数</th>	

		</tr><br>
		
		<c:forEach items="${scoreList }" var="scoreVo">
		<tr>
			<th>${scoreVo.stuId}</th>	
			<th>${scoreVo.stuName }</th>	
			<th>${scoreVo.subName }</th>	
			<th>${scoreVo.teaName }</th>	
			<th>${scoreVo.evaName }</th>
			<th>${scoreVo.score }</th>	
			<c:if test="${scoreIsAffirm==0}">
			<th><a href="addScore.action?score=${scoreVo.score }&id=${scoreVo.id}&stuId=${scoreVo.stuId}&clazzId=${clazzId}">修改</a></th>
			</c:if>
		</tr><br>
		</c:forEach>
	</table>
	
	<c:if test="${sessionScope.role.role_id==3 && scoreIsAffirm==0 }">
		<a href="affirmScore.action?clazzId=${clazzId }">提交成绩</a>
	</c:if>
	
	<c:if test="${sessionScope.role_id==2 }">
		<form action="selectHeadScore.action">
			<select name="subId">
			<c:forEach items="${subList }" var="sub">
				<option value="${sub.subId }">${sub.subName }</option>
			</c:forEach>
			</select>
			<input type="submit" value="查看该科目成绩">
		</form>
	</c:if>
</body>
</html>