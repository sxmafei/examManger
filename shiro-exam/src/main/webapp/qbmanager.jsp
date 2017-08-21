<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css"> 
<script type="text/javascript">  
function altRows(id){  
    if(document.getElementsByTagName){    
          
        var table = document.getElementById(id);    
        var rows = table.getElementsByTagName("tr");   
           
        for(i = 0; i < rows.length; i++){            
            if(i % 2 == 0){  
                rows[i].className = "evenrowcolor";  
            }else{  
                rows[i].className = "oddrowcolor";  
            }        
        }  
    }  
}  
  
window.onload=function(){  
    altRows('alternatecolor');  
}  
</script>  
  
  
<!-- CSS goes in the document HEAD or added to your external stylesheet -->  
<style type="text/css">  
table.altrowstable {  
    font-family: verdana,arial,sans-serif;  
    font-size:11px;  
    color:#333333;  
    border-width: 1px;  
    border-color: #a9c6c9;  
    border-collapse: collapse;  
}  
table.altrowstable th {  
    border-width: 1px;  
    padding: 8px;  
    border-style: solid;  
    border-color: #a9c6c9;  
}  
table.altrowstable td {  
    border-width: 1px;  
    padding: 8px;  
    border-style: solid;  
    border-color: #a9c6c9;  
}  
.oddrowcolor{  
    background-color:#d4e3e5;  
}  
.evenrowcolor{  
    background-color:#c3dde0;  
}  
</style> 

<script>
$(function() {
    $('#myModal').modal({
        keyboard: true
    })
});
</script>
</head>
<body>

<h1>题库管理</h1>
<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#exampleModal">新建题库</button>
<table class="altrowstable" id="alternatecolor">
<tr><th>题库编号</th><th>题库名</th><th>所属部门</th><th>创建人</th><th>创建时间</th><th>描述</th></tr>
<c:forEach items="${QBs}" var="qb">
	<tr><td>${qb.questionbankid}</td><td>${qb.questionbankname}</td><td>${qb.departmentName}</td>
	<td>${qb.name}</td><td>${qb.createtime}</td><td>${qb.description}</td></tr>
</c:forEach>
</table>

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">  
    <div class="modal-dialog" role="document">  
        <div class="modal-content">  
            <div class="modal-header">  
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span  
                        aria-hidden="true">×</span></button>  
                <h4 class="modal-title" id="exampleModalLabel">New message</h4>  
            </div>  
            <div class="modal-body">  
                <s:form  action="insertQb" method="post" >  
                    <div class="form-group">  
                        <label for="recipient-name" class="control-label">题库id:</label>  
                        <input type="text" class="form-control" id="recipient-name" name="questionBank.questionbankid">  
                    </div>  
                    <div class="form-group">  
                        <label for="message-text" class="control-label">题库名:</label>  
                        <textarea class="form-control" id="message-text" name="questionBank.questionbankname"></textarea>  
                    </div>  
                      <div class="form-group">  
                        <label for="message-text" class="control-label">所属部门:</label>  
                        <select class="form-control" id="message-text" name="questionBank.departmentid">
                        	<c:forEach items="${depart}" var="dep">
                        		<option  value="${dep.departmentid}">${dep.departmentname}</option>
                        	</c:forEach>
                        </select>  
                    </div>  
                     <div class="form-group">  
                        <label for="message-text" class="control-label">创建人:</label>  
                        <textarea class="form-control" id="message-text"  name="questionBank.employeeid"readonly="readonly">${userInfo.employeeid}</textarea>  
                    </div>  
                           <div class="form-group">  
                        <label for="message-text" class="control-label">描述：</label>  
                        <textarea class="form-control" id="message-text" name="questionBank.description"></textarea>  
                    </div> 
                         <div class="modal-footer">  
		               		<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			               <s:submit type="submit" class="btn btn-primary" value="提交"> </s:submit>
		            </div>  
		      
                </s:form>  
           
            </div>  
            
        </div>  
    </div>  
</div>  
<script src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>  
<script src="http://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>  
<script>  
$('#myModal').modal(options)  
    $('#exampleModal').on('show.bs.modal', function (event) {  
        var button = $(event.relatedTarget) // 触发事件的按钮  
        var recipient = button.data('whatever') // 解析出data-whatever内容  
        var modal = $(this)  
        modal.find('.modal-title').text('Message To ' + recipient)  
        modal.find('.modal-body input').val(recipient)  
    })  
</script>  
</body>
</html>