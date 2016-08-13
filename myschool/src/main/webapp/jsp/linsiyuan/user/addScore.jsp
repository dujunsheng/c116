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
	<form action="affirmAddScore.action?stuId=${stuId }" method="POST">
		学生：${stuName }<br>
		评价：<select name="evaId">
			<c:forEach items="${evaList }" var="evaluate">
			<option value="${evaluate.evaId }">${evaluate.evaluate }</option><br>
			</c:forEach>
			</select><br>
		评分：<input type="text" name="score1" value="${score==''?'':score }"><br>
			<input type="hidden" name="type" value="${score==''?0:1 }">
			<c:if test="${id!='' }">
				<input type="hidden" name=id value="${id }" />
			</c:if>
			<input type="hidden" name="id" value="${id }">
			<input type="submit" value="确定">
			<input type="reset" value="重置">
	</form>
</body>
</html>