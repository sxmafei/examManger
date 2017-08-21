<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>新建角色</h1>

<form action="rolefun" method="post">
	角色id:<input type="text" name="role.roleid"><br>
	角色名:<input type="text" name="role.rolename"><br>
	是否启用<select name="role.rolestatus">
				<option value="true">是</option>
				<option value="false">否</option>
			</select><br>
	描述:<input type="text" name="role.description"><br>
	注意：<input type="text" name="role.remark"><br>
	<ul>
		<c:forEach items="${funInfo}" var="fun">
			<c:if test="${empty fun.upfunction}">
				<li>${fun.functionname}
					<ul>
					<c:forEach items="${funInfo}" var="temp">
						<c:if test="${temp.upfunction==fun.functionid}">
							<label><input type="checkbox" name="role.functionid" 
							value="${temp.functionid}">${temp.functionname}</label>
							<br>
						</c:if>
					</c:forEach>
					</ul>
				 </li>
			</c:if>
		</c:forEach>
	</ul>
	
	<input type="submit" value="提交">
</form>

<div >



</div>
</body>
</html>