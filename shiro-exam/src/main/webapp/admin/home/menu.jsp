<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC >
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>menu</title>
    <!-- <script type="text/javascript" src="js/jquery.js" ></script>
	<script type="text/javascript" src="js/bootstrap.js" ></script>
	<link rel="stylesheet" href="css/bootstrap.css" /> -->
	<link rel="stylesheet" href="css/home/menu.css" />
	<!-- <link rel="stylesheet" href="css/public/main2.css" /> -->
	<script type="text/javascript" src="js/home/menu.js" ></script>

  </head>
  
  <body>
	<ul>
			<!-- <li class="menuLevel_one">
				<a href="javaScript:void(0)">接收验收资料<i class="glyphicon glyphicon-plus floatR"></i></a>
				<ul class="menuLevel_two">
					<li><a href="html/register/register.html"   id="">登记验收资料</a></li>
					<li><a href="html/register/register.html"   id="">确定负责部门</a></li>
					<li><a href="html/register/logging_data.html"   id="">领取验收资料</a></li>
					<li><a href="html/register/logging_data.html"   id="">审查验收资料</a></li>
					<li><a href="html/register/inspection.html"   id="">企业现场考察</a></li>
				</ul>
			</li>
			<li  class="menuLevel_one">
				<a href="javaScript:void(0)">验收会前准备<i class="glyphicon glyphicon-plus floatR"></i></a>
				<ul class="menuLevel_two">
					<li><a href=""   id="">待验收项目管理</a></li>
					<li><a href=""   id="">验收会议管理</a></li>
					<li><a href=""   id="">验收资料编制</a></li>
					<li><a href=""   id="">编制验收会议</a></li>
					<li><a href=""   id="">通知相关人员</a></li>
				</ul>
			</li>
			<li  class="menuLevel_one">
				<a href="javaScript:void(0)">验收会议管理</a>							
			</li>
			<li  class="menuLevel_one">
				<a href="javaScript:void(0)">验收后管理<i class="glyphicon glyphicon-plus floatR"></i></a>
				<ul class="menuLevel_two">
					<li><a href="html/accepted/aduit_porject_data.html"   id="">审核完善资料</a></li>
					<li><a href="html/accepted/porject_data_perfect.html"   id="">完善项目验收资料</a></li>
					<li><a href="html/accepted/send_card_info.html"   id="">验收证书发放</a></li>							
				</ul>
			</li>
			<li  class="menuLevel_one">
				<a href="javaScript:void(0)">专家管理</a>
			</li>
			<li  class="menuLevel_one">
				<a href="html/user_manage/user_manage.html"   id="">用户管理</a>
			</li> -->
			
			<li class="menuLevel_one">
				<ul class="menuLevel_two">
			<c:forEach var="userPrivilege" varStatus="status" items="${session.menuUrl}">
				<c:if test="${userPrivilege.menuClass=='1'}">
					</ul>
					</li>
					<li class="menuLevel_one">
						<a href="javaScript:void(0)">${userPrivilege.moduleName }<i class="glyphicon glyphicon-plus floatR"></i></a>
						<ul class="menuLevel_two">
				</c:if>	
				<c:if test="${userPrivilege.menuClass=='2' }">
					<li><a href="${userPrivilege.moduleURL }" >${userPrivilege.moduleName }</a></li>
				</c:if>
					
			</c:forEach>
				</ul>
				</li>
			
		</ul>
  </body>
</html>
