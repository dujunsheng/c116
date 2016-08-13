<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  <body>
	<div class="main">
	<h1 class="title" align="center">欢迎来到XXX学校管理系统</h1>
	  <div align="center">
	    <div class="login1">
	      <div class="login2">
            <div class="loginTopDiv">
              <span class="loginTop">用户登录</span>
              <br>
              <br>
            </div>
              <form target="_top" action="<c:url value='/login.action'/>" method="post" id="loginForm">
                <input type="hidden" name="method" value="login" />
                <input type="radio" value="1" name="role_id"/>管理员
               	<input type="radio" value="2" name="role_id"/>教师
               	<input type="radio" value="3" name="role_id"/>班主任
               	<input type="radio" value="4" name="role_id"/>学生
               	<input type="radio" value="5" name="role_id">领导
                  <table>
                    <tr>
                      <td width="50"></td>
                      <td><label class="error" id="msg">${msg }</label></td>
                    </tr>
                    <tr>
                      <td width="50">用户id</td>
                      <td><input class="input" type="text" name="u_id" id="loginname"/></td>
                    </tr>
                    <tr>
                      <td height="20">&nbsp;</td>
                      <td><label id="loginnameError" class="error"></label></td>
                    </tr>
                    <tr>
                      <td>密　码</td>
                      <td><input class="input" type="password" name="u_pw" id="loginpass"/></td>
                    </tr>
                    <tr>
                      <td height="20">&nbsp;</td>
                      <td><label id="loginpassError" class="error"></label></td>
                    </tr>
                    <tr>
                      <td align="left">
                        <input type="submit" id="submit" value="登录"/>
                      </td>
                      <td align="right">
                      	<a href="<c:url value='/'/>">返回首页</a>
                      </td>
                    </tr>	
                 </table>
              </form>
            </div>
          </div>
        </div>
      </div>
  </body>
</html>