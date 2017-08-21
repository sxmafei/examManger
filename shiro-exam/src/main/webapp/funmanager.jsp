<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>权限管理</h1>
<form action="rolefunupdateFun" method="post">
	<ul>
		<c:forEach items="${funInfo}" var="fun">
			<c:if test="${empty fun.upfunction}">
				<li>${fun.functionname}
					<ul>
					<c:forEach items="${funInfo}" var="temp">
						<c:if test="${temp.upfunction==fun.functionid}">
							<label>${temp.functionname}</label>
							<c:if test="${temp.functionstatus=='true'}">
								已启用
							</c:if >
							<c:if test="${temp.functionstatus=='false'}" >
								未启用
							</c:if>
							<br>
						</c:if>
					</c:forEach>
					</ul>
				 </li>
			</c:if>
		</c:forEach>
	</ul>
	
	<select name="function.functionid" >
		<c:forEach items="${funInfo}" var="fun">
			<c:if test="${not empty fun.parentid}">
				<option value="${fun.permissionid}">${fun.name}</option>
			</c:if>
		</c:forEach>
	</select>
	
	<select name="function.functionstatus">
		<option value="true">是</option>
		<option value="false">否</option>
	</select>
	<input type="submit" value="提交">
</form>
</body>
</html>