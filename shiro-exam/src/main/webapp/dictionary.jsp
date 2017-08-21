<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>

<script type="text/javascript" src="js/jquery.js" ></script>
<script type="text/javascript" src="js/bootstrap.js" ></script>
<script type="text/javascript" src="js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="js/jquery.ztree.exedit.js"></script>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css" type="text/css" media="screen" />
<link rel="stylesheet" href="css/public/main2.css" />
<link rel="stylesheet" href="css/register/register.css" />
<script type="text/javascript" src="js/sys/dictionary/dictionary.js"></script>
<script type="text/javascript" src="js/public/jquery.validate.js"></script>

<script type="text/javascript"
	src="controls/myPage/jquery.myPagination6.0.js"></script>
<script type="text/javascript" src="controls/myPage/msgbox.js"></script>
<link rel="stylesheet" href="controls/myPage/msgbox.css" />
<link rel="stylesheet" href="controls/myPage/page.css" />
<link rel="stylesheet" href="controls/myPage/pageStyle.css" />

<script type="text/javascript" src="js/public/main.js"></script>
<title>系统字典管理</title>
<style type="text/css">
.ztree li span.button.add {
	margin-left: 2px;
	margin-right: -1px;
	background-position: -144px 0;
	vertical-align: top;
	*vertical-align: middle
}
</style>
</head>
<body>
<!-- 
	<jsp:include page="/admin/home/header.jsp"/>
 -->
	<a href="javaScript:void(0)" id="sidebar_btn_show" class="">
		<i class="glyphicon glyphicon-forward"></i>
	</a>
	<a href="javaScript:void(0)" id="sidebar_btn_hide">
		<i class="glyphicon glyphicon-backward"></i>
	</a>

	<div class="html_middle">
	
	<div class="menu_modal">		
		<jsp:include page="/admin/home/menu.jsp" />
	</div>
	
	
	<div class="main_body">
	<div>
		<ol class="breadcrumb">
		  	<li class="active">系统管理</li>
		  	<li class="active">字典管理</li>		  	
		</ol>				
	</div>
	<div>
		<div class="user_left_tree_info">
 			<div class="user_left_tree_info_title">字典</div>
			<div class="hr"></div>
			<div class="padd" style="padding-bottom: 0px;">
				<div class="input-append row-fluid" style="margin-bottom: 0px;">
					<input id="search_condition" type="text" placeholder="请输入搜索条件"
						class="span8" style="font-size:12px;margin-left: 10px;" />
					<button type="button"
						onclick="search_ztree('treeDemo', 'search_condition')">搜索</button>
				</div>
			</div>			
			<div aria-multiselectable="true">
				<ul id="treeDemo" class="ztree"></ul>
			</div>
			<!-- <div style="height:300px">
			</div> -->
		</div>		
		<div class="floatL" style="width: 80%;">
			<div class="search_bar">
				<div class="input-group search_bar_input floatL">
				  	<span class="input-group-addon">字典名称</span>
				  	<input type="text" id="dic_name" class="form-control" placeholder="" >
				</div>
				<div class="input-group search_bar_input floatL">
				  	<span class="input-group-addon">字典编号</span>
				  	<input type="text" id="dic_id" class="form-control" placeholder="" aria-describedby>
				</div>
				
				<button class="btn btn-primary search_bar_button floatR" id="condition_sub">查询<span class=" glyphicon glyphicon-search span_icon"></span></button>
				
				<div class="clear"></div>
			</div>
			
								
			<div class="table_box outside_box">
				
				<div class="box_title word_center"><h3>字典管理</h3></div>
				<div class="hr" style=""></div>
				<div class="btn_box">			
					<div>
						<!-- <button class="btn btn-primary floatL" id="">导出 <span class=" glyphicon glyphicon-print span_icon"></span></button> -->
						<button class="btn btn-primary floatR" id="autoRefreshTree" style="display:none">自动刷新树</button>									
						<button class="btn btn-primary floatR" id="dictionary_delete">批量删除</button>
						<button class="btn btn-primary floatR modal_btn" id="dictionary_add" data-toggle="modal" data-target="#dictionary_add_modal">添加</button>
						<button type="button" class="hide" id="dictionary_change" data-toggle="modal" data-target="#dictionary_fix_modal">修 改</button>
						<input type="hidden" value="" id="bt_dictionaryId"> 
						<input type="hidden" value="" id="bt_dictionaryName"> 
						<input type="hidden" value="" id="bt_upDictionaryId"> 
						<input type="hidden" value="" id="bt_upDictionaryName"> 
						<input type="hidden" value="" id="table_row">	
						<input type="hidden" value="" id="leaf" />
					</div>
					<div class="clear"></div>
				</div>
				
				<div class="">
					<table class="table table-bordered  table-hover" id="dictionaryTable">
						<thead>
							<tr>
								<th><input type="checkbox" id="all" name="all" /></th>
								<th>序号</th>
								<th>字典名称</th>
								<th>字典编号</th>
								<th class='hide'>上级字典编号</th>
								<th class='hide'>上级字典名称</th>									
								<th>是否启用</th>
								<th>描述</th>	
								<th class='hide'>排序号</th>
								<th class='hide'>标志位</th>
								<th class='hide'>英文名字</th>																		
								<th>数据类型</th>
								<th class='hide'>备注1</th>
								<th class='hide'>备注2</th>									
								<th>操作</th>
							</tr>
						</thead>
						<tbody id="tabody"></tbody>
					</table>
					<div id="page"></div>
				</div>
				
				<!-- <nav class="word_center">
				  	<ul class="pagination">
					    <li>
					      	<a href="#" aria-label="Previous">
					        	<span aria-hidden="true">&laquo;</span>
					      	</a>
					    </li>
					    <li><a href="#">1</a></li>
					    <li><a href="#">2</a></li>
					    <li><a href="#">3</a></li>
					    <li><a href="#">4</a></li>
					    <li><a href="#">5</a></li>
					    <li>
					      	<a href="#" aria-label="Next">
					        	<span aria-hidden="true">&raquo;</span>
					      	</a>
					    </li>
				  	</ul>
				</nav> -->
			</div>
		</div>
		<div class="clear"></div>
	</div>
	</div>
	<div class="clear"></div>
	</div>
	
	<!--addModal-->
	<div class="modal fade" id="dictionary_add_modal">
		<div class="modal-dialog">
		    <div class="modal-content">
		      	<div class="modal-header word_center my_modal_title">
		        	<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        	<h4 class="modal-title">添加字典信息</h4>
		      	</div>
		        <form name="form1" id="form1" action="addDictionaryAction.action" type="post">
			      	<div class="modal-body" id="divFrame">
				        <div class="register_modal_body">
				      		<div class="input_info_group">
			      				<div class="group_left">上级字典</div>
			      				<div class="group_right">
			      					<input type="text" id="dap_add_name" class="form-control" readonly="readonly" value=""/> 
			      				</div>
			      				<div class="clear"></div>
				      		</div>
				      		<div class="input_info_group">
				      			<div class="group_left">上级字典编号</div>
				      			<div class="group_right">
				      				<input type="text" id="dap_add_id" class="form-control" readonly="readonly" value=""/> 
				      			</div>
				      			<div class="clear"></div>
				      		</div>				      		
				      		<div class="input_info_group">
				      			<div class="group_left">字典名称</div>
				      			<div class="group_right">
				      				<input type="text" id="dictionary_name" class="form-control" name="dictionary_name" /> 
				      			</div>
				      			<div class="clear"></div>
				      		</div>
				      		<div class="input_info_group">
				      			<div class="group_left">字典编号</div>
				      			<div class="group_right">
				      				<input type="text" id="dictionary_id" readonly="readonly" class="form-control" /> 
				      			</div>
				      			<div class="clear"></div>
				      		</div>
				      		<div class="input_info_group">
				      			<div class="group_left">是否启用</div>
				      			<div class="group_right">
				      				<input type="radio" name="dictionary_isUse" class="dictionary_isUse" checked="checked" value="启用"/>
				      				<label class="sex_label">是</label>
				      				<input type="radio" name="d
				      				ctionary_isUse" class="dictionary_isUse" value="禁用"/>
				      				<label class="sex_label">否</label>
				      			</div>
				      			<div class="clear"></div>
				      		</div>
				      		<div class="input_info_group">
				      			<div class="group_left">字典描述</div>
				      			<div class="group_right">
				      				<input type="text" id="dictionary_description" class="form-control" name="dictionary_description" />
				      			</div>
				      			<div class="clear"></div>
				      		</div>
				      		<div class="input_info_group">
				      			<div class="group_left">字典排序号</div>
				      			<div class="group_right">
				      				<input type="text" id="dictionary_sortNo" class="form-control" name="dictionary_sortNo"/> 
				      			</div>
				      			<div class="clear"></div>
				      		</div>
				      		<div class="input_info_group">
				      			<div class="group_left">字典标志位</div>
				      			<div class="group_right">
				      				<input type="text" id="dictionary_flag" class="form-control" name="dictionary_flag" /> 
				      			</div>
				      			<div class="clear"></div>
				      		</div>
				      		<div class="input_info_group">
				      			<div class="group_left">字典英文名字</div>
				      			<div class="group_right">
				      				<input type="text" id="dictionary_englishName" class="form-control" name="dictionary_englishName" /> 
				      			</div>
				      			<div class="clear"></div>
				      		</div>
				      		<div class="input_info_group">
				      			<div class="group_left">字典数据类型</div>
				      			<div class="group_right">
				      				<select class="form-control" id="dictionary_dataType">
										<option value="字符型">字符型</option>
										<option value="整型">整型</option>
										<option value="双精度浮点型">双精度浮点型</option>
										<option value="单精度浮点型">单精度浮点型</option>
										<option value="布尔型">布尔型</option>
				      				</select>
				      			</div>
				      			<div class="clear"></div>
				      		</div>
				      		<div class="input_info_group censor_modal_textarea">
			        			<div class="group_left">备注1</div>
			        			<div class="group_right modal_textarea_h" ><textarea class="form-control" id="dictionary_remark1"></textarea> </div>
			        			<div class="clear"></div>
			        		</div>
			        		<div class="input_info_group censor_modal_textarea">
			        			<div class="group_left">备注2</div>
			        			<div class="group_right modal_textarea_h" ><textarea class="form-control" id="dictionary_remark2"></textarea> </div>
			        			<div class="clear"></div>
			        		</div>
				      	</div>
					    <div class="modal-footer">
					    	<button type="button" style="display:none" class="btn btn-primary modal_btn submitToDB">提交数据到后台</button>
					      	<button type="reset" style="display:none" class="btn btn-primary modal_btn addFormReset">重置</button>
					      	<button type="submit" id="dictionary_add_save" class="btn btn-primary modal_btn">保存</button>
					        <button type="button" class="btn btn-default modal_btn" data-dismiss="modal">取消</button>		        
					    </div>
					 </div>
		        </form>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->


	<!--dictionary_fix_modal-->
	<div class="modal fade" id="dictionary_fix_modal">
		  <div class="modal-dialog">
			    <div class="modal-content">
			      	<div class="modal-header word_center my_modal_title">
			        	<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        	<h4 class="modal-title">修改字典信息</h4>
			      	</div>
			      	<form id="updateForm" name="updateForm" action="">
			      		<div class="modal-body" >
				        	<div class="register_modal_body">
				      			<div class="input_info_group">
				      				<div class="group_left">上级字典</div>
				      				<div class="group_right">
				      					<input type="text" id="upDicName" class="form-control" readonly="readonly" value=""/> 
				      				</div>
				      				<div class="clear"></div>
				      			</div>
					      		<div class="input_info_group">
					      			<div class="group_left">上级字典编号</div>
					      			<div class="group_right">
					      				<input type="text" id="upDicId" class="form-control" readonly="readonly" value=""/> 
					      			</div>
					      			<div class="clear"></div>
					      		</div>				      		
					      		<div class="input_info_group">
					      			<div class="group_left">字典名称</div>
					      			<div class="group_right">
					      				<input type="text" id="dict_name" name="dict_name" class="form-control" /> 
					      			</div>
					      			<div class="clear"></div>
					      		</div>
					      		<div class="input_info_group">
					      			<div class="group_left">字典编号</div>
					      			<div class="group_right">
					      				<input type="text" id="dict_id" readonly="readonly" class="form-control" /> 
					      			</div>
					      			<div class="clear"></div>
					      		</div>
					      		<div class="input_info_group">
					      			<div class="group_left">是否启用</div>
					      			<div class="group_right">
					      				<input type="radio" name="dic_isUse" class="dic_isUse" value="启用"/>
					      				<label class="sex_label">是</label>
					      				<input type="radio" name="dic_isUse" class="dic_isUse" value="禁用"/>
					      				<label class="sex_label">否</label>
					      			</div>
					      			<div class="clear"></div>
					      		</div>
					      		<div class="input_info_group">
					      			<div class="group_left">字典描述</div>
					      			<div class="group_right">
					      				<input type="text" id="dic_description" name="dic_description" class="form-control" />
					      			</div>
					      			<div class="clear"></div>
					      		</div>
					      		<div class="input_info_group">
					      			<div class="group_left">字典排序号</div>
					      			<div class="group_right">
					      				<input type="text" id="dic_sortNo" name="dic_sortNo" class="form-control" /> 
					      			</div>
					      			<div class="clear"></div>
					      		</div>
					      		<div class="input_info_group">
					      			<div class="group_left">字典标志位</div>
					      			<div class="group_right">
					      				<input type="text" id="dic_flag" name="dic_flag" class="form-control" /> 
					      			</div>
					      			<div class="clear"></div>
					      		</div>
					      		<div class="input_info_group">
					      			<div class="group_left">字典英文名字</div>
					      			<div class="group_right">
					      				<input type="text" id="dic_englishName" name="dic_englishName" class="form-control" /> 
					      			</div>
					      			<div class="clear"></div>
					      		</div>
					      		<div class="input_info_group">
					      			<div class="group_left">字典数据类型</div>
					      			<div class="group_right">
					      				<select class="form-control" id="dic_dataType">
											<option value="字符型">字符型</option>
											<option value="整型">整型</option>
											<option value="双精度浮点型">双精度浮点型</option>
											<option value="单精度浮点型">单精度浮点型</option>
											<option value="布尔型">布尔型</option>
					      				</select>
					      			</div>
					      			<div class="clear"></div>
					      		</div>
					      		<div class="input_info_group censor_modal_textarea">
				        			<div class="group_left">备注1</div>
				        			<div class="group_right modal_textarea_h"><textarea id="dic_remark1" class="form-control"></textarea> </div>
				        			<div class="clear"></div>
				        		</div>
				        		<div class="input_info_group censor_modal_textarea">
				        			<div class="group_left">备注2</div>
				        			<div class="group_right modal_textarea_h"><textarea id="dic_remark2" class="form-control"></textarea> </div>
				        			<div class="clear"></div>
				        		</div>
			     	 		</div>
				      	 	<div class="modal-footer">
				      	 		<button type="reset" style="display:none" class="btn btn-primary modal_btn updateFormReset">重置</button>
				      	 		<button type="button" style="display:none" class="btn btn-primary modal_btn updateToDB">提交数据到后台</button>
				      			<button type="submit" id="dictionary_update_save" class="btn btn-primary modal_btn">保存</button>
				        		<button type="button" class="btn btn-default modal_btn" data-dismiss="modal">取消</button>		        
				      	 	</div>
			     	 	</div>
			      	 </form>
	   	  		</div><!-- /.modal-content -->
	   	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	<!----------------------------------------------------------------------------------->
	<!-- 这是新加入的部门管理模块 上面的改善版 -->
	<!--------------------------------------------------------------------------------------->
	<script>

	/* validate */
	$(function(){
		$("#form1").validate({
			
            rules: { 
            	'dictionary_name':{required: true,}, //name
            	'dictionary_description':{required: true,}, //dictionary_description
            	'dictionary_sortNo':{required: true,}, //dictionary_sortNo
            	'dictionary_flag':{required: true,}, //dictionary_flag
            	//'dictionary_englishName':{required: true,}, //name
            },
            messages: {
                'dictionary_name':{required: '不能为空',}, //name
                'dictionary_description':{required: '不能为空',}, //dictionary_description
            	'dictionary_sortNo':{required: '不能为空',}, //dictionary_sortNo
            	'dictionary_flag':{required: '不能为空',}, //dictionary_flag
            	//'dictionary_englishName':{required: '不能为空',}, //name
            },
            errorClass: "error",
            success: 'valid',
            unhighlight: function (element, errorClass, validClass) { //验证通过
                $(element).tooltip('destroy').removeClass(errorClass);
            },
            errorPlacement: function (label, element) {
                $(element).tooltip('destroy'); /*必需*/
                $(element).attr('title', $(label).text()).attr("data-placement","right").tooltip('show');                
            },
            submitHandler: function (form) {
               $(".submitToDB").trigger("click");
            }
    	});
		
		$("#updateForm").validate({
            rules: { 
            	'dict_name':{required: true,}, //name
            	'dic_description':{required: true,}, //dic_description
            	'dic_sortNo':{required: true,}, //dic_sortNo
            	'dic_flag':{required: true,}, //dic_flag
            	//'dic_englishName':{required: true,}, //name
            },
            messages: {
                'dict_name':{required: '不能为空',}, //name
                'dic_description':{required: '不能为空',}, //dic_description
            	'dic_sortNo':{required: '不能为空',}, //dic_sortNo
            	'dic_flag':{required: '不能为空',}, //dic_flag
            	//'dic_englishName':{required: '不能为空',}, //name
            },
            errorClass: "error",
            success: 'valid',
            unhighlight: function (element, errorClass, validClass) { //验证通过
                $(element).tooltip('destroy').removeClass(errorClass);
            },
            errorPlacement: function (label, element) {
                $(element).tooltip('destroy'); /*必需*/
                $(element).attr('title', $(label).text()).attr("data-placement","right").tooltip('show');                
            },
            submitHandler: function (form) {
				$(".updateToDB").trigger("click");
            }
		});
	});
	
	var isAdd = false;		//全局变量，用于判断当前的操作是添加还是修改
	var isChange = false;	//全局变量，用于判断当前的操作是添加还是修改
	var alterRow;			//正在修改的表中的那一行的Id
	/**
	 * 删除单条字典信息
	 */
	function del_tr(id){
		if(confirm("确定删除该字典记录吗？")) {
			var tr = document.getElementById("tr_"+id);     //得到触发删除按钮的那一行
	    	var dictionaryIds = tr.cells[3].innerHTML;	//得到要删除的字典的编号
	    	
	    	console.log("dictionaryIds: " + dictionaryIds);
	    	
	   	
		}
	}

	/**
	 *修改字典数据
	 */
	function alt_tr(id) {
		isAdd = false;
		isChange = true;        //设置当前的操作是修改
		alterRow = "tr_" + id;  //修改的那一行的编号
		var tr = document.getElementById(alterRow); //得到修改的那一行
		setChangInfoModal(tr);						//在弹出框中显示要修改的字典的原始信息
	}
	/**
	 * 显示要修改的字典的原始信息
	 */
	function setChangInfoModal(tr) {
		//表的一列cells从0开始
		$("#upDicId").val(tr.cells[4].innerHTML);
		$("#upDicName").val(tr.cells[5].innerHTML);
		//设置启用和禁用
		if (tr.cells[6].innerHTML == "启用") {
			$(".dic_isUse:first").attr("checked", true);
		} else {
			$(".dic_isUse:last").attr("checked", true);
		}
		//填充要修改的字典的信息
		$("#dict_id").val(tr.cells[3].innerHTML);
		$("#dict_name").val(tr.cells[2].innerHTML);
		$("#dic_description").val(tr.cells[7].innerHTML);
		$("#dic_sortNo").val(tr.cells[8].innerHTML);
		$("#dic_flag").val(tr.cells[9].innerHTML);
		$("#dic_englishName").val(tr.cells[10].innerHTML);
		$("#dic_dataType").attr("value", tr.cells[11].innerHTML);
		$("#dic_remark1").val(tr.cells[12].innerHTML);
		$("#dic_remark2").val(tr.cells[13].innerHTML);

	}
	/**
	 *修改表显示的序号（注意：如果和复选框在同一列中的话，需要每个前面加上复选框）
	 */
	function alterNoOfTable() {
		//删除对应的行后，修改表的序号
		var len = $("#dictionaryTable tr").length;
		for (var i = 1; i < len; i++) {
			$("#dictionaryTable tr:eq(" + i + ") td:eq(1)").html(i);
		}
	}
	</script>
	
	
	<script type="text/javascript">
	
	/**  树的模糊查询，查询结果的高亮显示**/
	/**
     * 展开树
     * @param treeId  
     */
    function expand_ztree(treeId){
        var treeObj = $.fn.zTree.getZTreeObj(treeId);
        treeObj.expandAll(true);
    }
     
    /**
     * 收起树：只展开根节点下的一级节点
     * @param treeId
     */
    function close_ztree(treeId){
        var treeObj = $.fn.zTree.getZTreeObj(treeId);
        var nodes = treeObj.transformToArray(treeObj.getNodes());
        var nodeLength = nodes.length;
        for (var i = 0; i < nodeLength; i++) {
            if (nodes[i].dictionaryOptionId == '1') {
                //根节点：展开
                treeObj.expandNode(nodes[i], true, true, false);
            } else {
                //非根节点：收起
                treeObj.expandNode(nodes[i], false, true, false);
            }
        }
    }
    /**
     * 搜索树，高亮显示并展示【模糊匹配搜索条件的节点s】
     * @param treeId
     * @param searchConditionId 文本框的id
     */
    function search_ztree(treeId, searchConditionId){
    	
        searchByFlag_ztree(treeId, searchConditionId, "");
    }
     
    /**
     * 搜索树，高亮显示并展示【模糊匹配搜索条件的节点s】
     * @param treeId
     * @param searchConditionId     搜索条件Id
     * @param flag                  需要高亮显示的节点标识
     */
    function searchByFlag_ztree(treeId, searchConditionId, flag){
        //<1>.搜索条件
        var searchCondition = $("#" + searchConditionId).val();
        //<2>.得到模糊匹配搜索条件的节点数组集合
        var highlightNodes = new Array();
        if (searchCondition != "") {
            var treeObj = $.fn.zTree.getZTreeObj(treeId);
            highlightNodes = treeObj.getNodesByParamFuzzy("dictionaryOptionName", searchCondition, null);
        }
        //<3>.高亮显示并展示【指定节点s】
        highlightAndExpand_ztree(treeId, highlightNodes, flag);
    }
     
    /**
     * 高亮显示并展示【指定节点s】
     * @param treeId
     * @param highlightNodes 需要高亮显示的节点数组
     * @param flag           需要高亮显示的节点标识
     */
    function highlightAndExpand_ztree(treeId, highlightNodes, flag){
        var treeObj = $.fn.zTree.getZTreeObj(treeId);
        //<1>. 先把全部节点更新为普通样式
        var treeNodes = treeObj.transformToArray(treeObj.getNodes());
        for (var i = 0; i < treeNodes.length; i++) {
            treeNodes[i].highlight = false;
            treeObj.updateNode(treeNodes[i]);
        }
        //<2>.收起树, 只展开根节点下的一级节点
        close_ztree(treeId);
        //<3>.把指定节点的样式更新为高亮显示，并展开
        if (highlightNodes != null) {
            for (var i = 0; i < highlightNodes.length; i++) {
                if (flag != null && flag != "") {
                    if (highlightNodes[i].flag == flag) {
                        //高亮显示节点，并展开
                        highlightNodes[i].highlight = true;
                        treeObj.updateNode(highlightNodes[i]);
                        //高亮显示节点的父节点的父节点....直到根节点，并展示
                        var parentNode = highlightNodes[i].getParentNode();
                        var parentNodes = getParentNodes_ztree(treeId, parentNode);
                        treeObj.expandNode(parentNodes, true, false, true);
                        treeObj.expandNode(parentNode, true, false, true);
                    }
                } else {
                    //高亮显示节点，并展开
                    highlightNodes[i].highlight = true;
                    treeObj.updateNode(highlightNodes[i]);
                    //高亮显示节点的父节点的父节点....直到根节点，并展示
                    var parentNode = highlightNodes[i].getParentNode();
                    var parentNodes = getParentNodes_ztree(treeId, parentNode);
                    treeObj.expandNode(parentNodes, true, false, true);
                    treeObj.expandNode(parentNode, true, false, true);
                }
            }
        }
    }
    
    /**
     * 递归得到指定节点的父节点的父节点....直到根节点
     */
    function getParentNodes_ztree(treeId, node){
        if (node != null) {
            var parentNode = node.getParentNode();
            return getParentNodes_ztree(treeId, parentNode);
        } else {
            return node;
        }
    }
     
    /**
     * 设置树节点字体样式
     */
    function setFontCss_ztree(treeId, treeNode) {
        if (treeNode.dictionaryOptionId == 1) {
        	
            //根节点
            return {color:"#333", "font-weight":"bold"};
        } else if (treeNode.isParent == false){
            //叶子节点
            return (!!treeNode.highlight) ? {color:"#ff0000", "font-weight":"bold"} : {color:"#660099", "font-weight":"normal"};
        } else {
            //父节点
            return (!!treeNode.highlight) ? {color:"#ff0000", "font-weight":"bold"} : {color:"#333", "font-weight":"normal"};
        }
    }
    </script>	
   <!--  
    <jsp:include page="/admin/home/footer.jsp"></jsp:include>
    --> 
</body>
</html>
