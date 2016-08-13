<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="affirmAddClazz.action" method="POST">
		
		年级：<input type="text" name="grade">
		班级：<input type="text" name="clazz">
		班主任：<select name="headTeaId">
				<c:forEach items="${teaList }" var="teacher">
					<option value=${teacher.teaId }>${teacher.teaName }</option><br>
				</c:forEach>
			</select>
		<input type="submit" value="确定">
	</form>
</body>
</html>