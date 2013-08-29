<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<script>
		$(function(){
			$('#tty').datagrid({
				title:'待审批',
				iconCls:'icon-search',
				idField:'id', 
				treeField:'code',
				nowrap: false,
				striped: true,
				singleSelect:true,
				url:'buse/approvingList.action',
				fitColumns:true,
				
							
				columns:[[
				    {title:'标题',field:'title',width:100},
				    {title:'请假类型',field:'leaveType',width:100},
				    {title:'开始时间',field:'startTime',width:100},
				    {title:'结束时间',field:'endTime',width:100},
				    {title:'请假天数',field:'days',width:100},
				    {title:'状态',field:'status',width:60},
					{title:'创建时间',field:'createTime',width:100},
					{field:'opt',title:'操作',width:120,align:'center', 
						formatter:function(value,rec){
						    //alert(rec.id);
							return "<span style='padding-right:10px;'><img src='../themes/icons/ok.png'\ title='审批' style='cursor:pointer;border:1px solid #7eabcd;' onclick='subInput("+rec.id+")' ></span>"+
							       "<span style='padding-right:10px;'><img src='../themes/icons/view.gif'\ title='查看' style='cursor:pointer'onclick='getLeaveById2(\"view\","+rec.id+")' ></span>"+
						           "<span style='padding-right:10px;'><img src='../themes/icons/tree_file.gif'\ title='审批历史' style='cursor:pointer;' onclick='showDestory("+rec.id+")'></span>"+
						           "<span style='padding-right:10px;'><img src='../themes/icons/valid.png'\ title='当前流程' style='cursor:pointer'onclick='showProcessImage2("+rec.workflow+","+rec.id+")' ></span>";
						
						}
						
					}
					
					
				]],
				pagination:true,
				rownumbers:true,
				toolbar:"#tb"
			});
			
		});
		
		
		function loadLeave(tit,url,opt){
			
			var $div = $('<div id="dlg" class="easyui-dialog" style="width:500px;height:480px;padding:5px 5px" closed="true">');
			
			var options = {
	                title: tit,
					modal: true,
					shadow: false,
					closed: false,
					href:url,
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
								saveLeave('buse/saveLeave.action?opt='+opt);
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
			
			$div.dialog(options);
           
		}
		
		function saveLeave(url){
			$('#fm').form('submit',{
				url: url,
				onSubmit: function(){
					return $(this).form('validate');
				},
				success: function(result){
					var result = eval('('+result+')');
					if (result.success){
						//$('#dlg').dialog('close');		// close the dialog
						tAlert('信息','保存成功');
						$('#dlg').dialog('close');
						$('#tty').datagrid('reload');	// reload the Leave data
						
					} else {
						tAlert('信息','保存失败')
					}
				}
			});
		}
		
	    function tAlert(title,msg)
		{
		     $.messager.alert(title,msg);
		}
		
		function getLeaveById(opt)
		{
		     //var selected = $('#tty').datagrid('getSelected');
		     var rows = $('#tty').datagrid('getSelections');
		     if(rows.length!=1)
		     {
		          tAlert('信息','请选择一条数据');
		     }
		     else{
		         var strinfo = opt=='edit'?'修改用户':'查看用户';
		         loadLeave(strinfo,'buse/loadLeaveById.action?opt='+opt+'&id='+ rows[0].id ,opt);
		        
		     }
		}
		
		
		function subInput(leaveId)
		{
		    $('<div id="dlg2" class="easyui-dialog" style="width:450px;height:400px;padding:10px 20px" closed="true">').dialog({
	                title: "选择步骤提交",
					modal: true,
					shadow: false,
					closed: false,
					href:'buse/submitInput.action?type=approve&leaveId='+leaveId,
					onClose:function(){
					    //close方法触发的onClose事件,去调用destory方法
					    $('#dlg2').dialog('destroy')
					},
					buttons:[{
							text:'确定',
							iconCls:'icon-ok',
							handler:function(){
								save('buse/approveData.action',leaveId);
							}
						},{
							text:'关闭',
							handler:function(){
							    //调用dialog的close方法
							    $('#dlg2').dialog('close');
							}
						}]
	         }
		   
		   );
		}
		
		function save(url,id)
		{
		
		  // var input = $("input:radio:checked");
		 
		   var rad = $("input[name='transitionName']:checked").val();
		   
		   var comment = $('#comment_id').val();
		   
		   $.post(url,{transistionName:rad,leaveId:id,commentVal:comment},function(result){
							if (result.success){
							    $.messager.alert('信息','保存成功');
							    $('#dlg2').dialog('close');
								$('#tty').datagrid('reload');	// reload the Leave data
							} else {
								tAlert('信息','删除失败');
							}
			},'json');
		}
		
		function getLeaveById2(opt,id)
		{
		     clearSelections();
		     //window.event.cancelBubble = true;
	         var strinfo = opt=='edit'?'修改请假申请':'查看请假申请'
	         loadLeave(strinfo,'buse/loadLeaveById.action?opt='+opt+'&id='+id,opt);
		     
		}
		
		function deleteLeave(){
		
		    var rows = $('#tty').datagrid('getSelections');
		     if(rows.length==0){
		          tAlert('信息','请选择数据');
		     }else{
		        
		        var idarr = [];
		        for(var i=0;i<rows.length;i++)
		        {
		             idarr.push(rows[i].id);
		        }
		        var res = '['+idarr.join(",")+']';
		        $.messager.confirm('信息','确认删除',function(r){
					if (r){
						$.post('buse/deleteLeaves.action',{ids:res},function(result){
							if (result.success){
								$('#tty').datagrid('reload');	// reload the Leave data
							} else {
								tAlert('信息','删除失败');
							}
						},'json');
					}
				});
		        
		     }
		}
		
	    function clearSelections(){
			$('#tty').datagrid('clearSelections');
		}
		
		
		function queryinfo()
		{
		
		    var query={title:$('#no_titleid').val()}; 
		    
		    //把查询条件赋值给datagrid内部变量
			$("#tty").datagrid('options').queryParams=query;
			
			//重新加载
			$("#tty").datagrid('load');
		 
		}
	
		
	</script>


		<table id="tty"></table>
	
	<div id="tb" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			
			标题: <input type="text" name="no_title" id="no_titleid">
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="queryinfo()">查询</a>
			
		</div>
		<div>
			
			
		</div>
	</div>
