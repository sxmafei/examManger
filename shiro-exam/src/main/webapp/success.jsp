<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主菜单</title>
</head>
<body>



<!-- 001 系统管理权限 -->
<shiro:hasPermission name="systemmanager:dictionary or systemmanager:function
 or systemmanager:role or systemmanager:user">

	<a href="/shiro-exam/sysmanager.jsp">系统管理</a><hr>
	
</shiro:hasPermission>

<!--002 题库管理权限  -->
<shiro:hasPermission name="question:create">

	<a href="/shiro-exam/qBankManager">题库管理</a><hr>
	
</shiro:hasPermission>

<!-- 003 录入外来单位信息 -->
<shiro:hasPermission name="003">
	<a href="/shiro-exam/qBankManager">录入外来单位信息</a><hr>
</shiro:hasPermission>

<!-- 004 培训档案管理 -->
<shiro:hasPermission name="004">
	<a href="/shiro-exam/qBankManager">查询培训档案</a><hr>
</shiro:hasPermission>

<!-- 005 考试权限 -->
<shiro:hasPermission name="005">
	<a href="#">考试</a><hr>
</shiro:hasPermission>


<a href="#">培训资料</a>


<ul>
		<c:forEach items="${funInfo}" var="fun">
			<c:if test="${empty fun.parentid}">
				<li>${fun.name}
					<ul>
					<c:forEach items="${funInfo}" var="temp">
						<c:if test="${temp.parentid==fun.permissionid and temp.type=='menu'}">
							<label>${temp.name}</label>
							<c:if test="${temp.status=='true'}">
								已启用
							</c:if >
							<c:if test="${temp.status=='false'}" >
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

</body>
</html>