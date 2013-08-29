<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>用户</title>
    <link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../themes/content.css">
		<script type="text/javascript" src="../jquery.js"></script>
		<script type="text/javascript" src="../jquery-migrate.js"></script>
		<script type="text/javascript" src="../jquery.easyui.min.js"></script>
		<script type="text/javascript" src="../locale/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript" src="../page/upload/gener.js"></script>
		<script src="../js/jquery.Jcrop.js" type="text/javascript"></script>
    <link rel="stylesheet" href="../themes/jquery.Jcrop.css" type="text/css" />
		<link rel="shortcut icon" href="../fckeditor.gif" type="image/x-icon" />
	<script type="text/javascript">
			function FCKeditor_OnComplete(editorInstance) {
				window.status = "";
			}
		$(function(){
			$('#tt').datagrid({
				title:'业务字典',
				iconCls:'icon-search',
				idField:'id', 
				treeField:'code',
				nowrap: false,
				striped: true,
				singleSelect:true,
				url:'bussdict/getAjaxData.action',
				fitColumns:true,
				onDblClickRow:onClickRow,
				columns:[[
				    {title:'类型',field:'0',width:20},
				    {title:'类型描述',field:'1',width:100, editor:{type:'text',options:{required:true}}},
					{field:'opt',title:'内容维护',width:20,align:'center', 
						formatter:function(value,rec){
						    //alert(rec[0]);
							return "<span style='padding-right:10px;'><img src='../themes/icons/pencil.png'\ title='修改' style='cursor:pointer;border:1px solid #7eabcd;' onclick='getInfoById2(\"edit\","+rec[0]+")'></span>";
						}
						
					}
				]]
				
			});
			
		});
		
		function getInfoById2(opt,id)
		{
	         var strinfo = opt=='edit'?'修改':'查看'
	         loadEdit(strinfo,'bussdict/getInfoById.action?opt='+opt+'&id='+id,opt);
		     
		}
		
		function loadEdit(tit,url,opt){
			var $div = $('<div id="dlg" class="easyui-dialog" style="width:700px;height:450px;padding:10px 20px" closed="true">');
			var options = {
	                title: tit,
					modal: true,
					shadow: false,
					href:url,
					closed: false,
					maximizable:true,
					onClose:function(){
					    //close方法触发的onClose事件,去调用destory方法
					    $('#dlg').dialog('destroy')
					}
	         }
			if(opt=='edit' || opt=='add')
			{
				settings = {
				    buttons:[{
							text:'保存',
							iconCls:'icon-ok',
							handler:function(){
								saveOrUpdate('bussdict/saveCont.action?opt='+opt);
							}
						},{
							text:'关闭',
							handler:function(){
							    //调用dialog的close方法
							    $('#dlg').dialog('close');
							}
						}]
				}
			    $.extend(options,settings); 
			}
			
			$div.dialog(options)
       
		}
		
		function saveOrUpdate(url)
		{
		     var flag = true;
		     var s = $("input[name='dictId']");
		     $("input[name='dictName']").each(function(i){
			    if($.trim($(this).val())=='' && $.trim($(s.get(i)).val())!='')
			    {
			       tAlert('提示信息','第'+(i+1)+'行有空值');
			       flag = false;
			       return flag;
			    }
			    if($.trim($(this).val())!='' && $.trim($(s.get(i)).val())=='')
			    {
			       tAlert('提示信息','第'+(i+1)+'行有空值');
			       flag = false;
			       return flag;
			    }
			 });
			 if(flag)
			 {
				    $('#fm').form('submit',{
					url: url,
					success: function(result){
						  var result = eval('('+result+')');
							if (result.success){
								tAlert('信息','保存成功');
							} else {
								tAlert('信息','保存失败')
							}
						}
				   });
			 
			 }
			 
		}
		
	    var editIndex = undefined;
		function endEditing(){
			if (editIndex == undefined){
			    return true
			}
			if ($('#tt').datagrid('validateRow', editIndex)){
				//var ed = $('#tt').datagrid('getEditor', {index:editIndex,field:0});
				//var productname = $(ed.target).combobox('getText');
				//$('#tt').datagrid('getRows')[editIndex][1] = productname;
				$('#tt').datagrid('endEdit', editIndex);
				editIndex = undefined;
				return true;
			} else {
				return false;
			}
		}
		function onClickRow(index){
			if (editIndex != index){
				if (endEditing()){
					$('#tt').datagrid('selectRow', index)
							.datagrid('beginEdit', index);
					editIndex = index;
				} else {
					$('#tt').datagrid('selectRow', editIndex);
				}
			}
		}
		
		/**增加一行**/
		function append(){
			if (endEditing()){
				$('#tt').datagrid('appendRow',{status:'P'});
				editIndex = $('#tt').datagrid('getRows').length-1;
				$('#tt').datagrid('selectRow', editIndex)
						.datagrid('beginEdit', editIndex);
			}
		}
		
		/**同意接收**/
		function accept(){
			if (endEditing()){
				$('#tt').datagrid('acceptChanges');
			}
		}
		
		function getChanges(){
			var rows = $('#tt').datagrid('getChanges');
			var s,arr=[],str;
			if(rows && rows.length)
			{
			    //alert('');
				for(var i=0;i<rows.length;i++)
				{
				   s = "{"+"dictType:"+rows[i][0]+",descript:'"+rows[i][1]+"'}";
			   
			       arr.push(s);
				}
				str = "["+arr.join(",")+"]";
				
				$.post('bussdict/save.action',{jsonData:str},function(result){
					if (result.success){
						tAlert('信息','保持成功');
					} else {
						tAlert('信息','删除失败');
					}
				},'json');
			}	
		}
		
		function tAlert(title,msg)
		{
		     $.messager.alert(title,msg);
		}
	
		
		
		
	</script>
</head>
<body>


		<table id="tt"></table>
		
	<!--  div id="tb" style="height:auto">
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="accept()">保存</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="getChanges()">GetChanges</a>
	</div>
	-->
	
</body>
</html>