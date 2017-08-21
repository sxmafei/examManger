<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1>系统管理</h1>

<!-- 有字典管理权限 -->
<shiro:hasPermission name="systemmanager:dictionary">
	<a href="#">字典管理</a><hr>
</shiro:hasPermission>

<shiro:hasPermission name="systemmanager:function">
	<a href="/shiro-exam/rolefunselectFun">权限管理</a><hr>
</shiro:hasPermission>

<shiro:hasPermission name="systemmanager:role">
	<a href="/shiro-exam/rolemanager.jsp">角色管理</a><hr>
</shiro:hasPermission>

<shiro:hasPermission name="systemmanager:user">
	<a href="/shiro-exam/rolefunselectFun">用户管理</a><hr>
</shiro:hasPermission>

</body>
</html>