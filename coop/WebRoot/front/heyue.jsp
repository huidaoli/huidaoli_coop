<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@page import="com.base.frame.business.Init"%>
<script type="text/javascript">
		$(function(){
			$('#tt').datagrid({
				title:'合约信息',
				iconCls:'icon-search',
				idField:'id', 
				treeField:'code',
				nowrap: false,
				striped: true,
				url:'getAgreementAjaxData.action?coopid=${memid}',
				fitColumns:true,
				frozenColumns:[[
				    {field:'ck',checkbox:true}
	                
				]],
							
				columns:[[
				    {title:'合约编号',field:'no',width:40},
				    {title:'合约类型',field:'typename',width:30},
				    {title:'甲方',field:'jiafang',width:100,
				           formatter:function(value,rec){
							if(value==0)
							{
							  return "<%=Init.getMap().get("jiafang")%>";
							}
						}},
				    {title:'创建日期',field:'createDate',width:40},
				    {title:'生效日期',field:'sxsj',width:40,
				        formatter:function(value,rec){
							if(value=='')
							{
							  return "未生效";
							}
							return value;
						}},
				    {title:'状态',field:'state',width:30,
				        formatter:function(value,rec){
							if(value==0)
							{
							  return "待审核";
							}
							if(value==1)
							{
							  return "审核通过";
							}
							if(value==2)
							{
							  return "审核不通过";
							}
						}},
					{field:'opt',title:'操作',width:80,align:'center', 
						formatter:function(value,rec){
						    var html = ''
						    html += "<span style='padding-right:10px;'><img src='themes/icons/view.gif'\ title='查看' style='cursor:pointer'onclick='getInfoById2(\"view\","+rec.id+","+rec.type+")' ></span>";
						    html += "<span style='padding-right:10px;'><img src='themes/icons/print.png'\ title='打印预览' style='cursor:pointer'onclick='printhy(\"print\","+rec.id+","+rec.type+")' ></span>";
						    html += "<span style='padding-right:10px;'><img src='themes/icons/tree_file.gif'\ title='合同文件管理' style='cursor:pointer'onclick=\"clearSelections();getUploadView('"+rec.code+"','view','coop')\" ></span>";
							return html;     
						}
						
					}
				]],
				pagination:true,
				rownumbers:true,
				toolbar:"#tb"
			});
			
			
			initbuttons();
			
		});
		
		function passAgree(id,type)
		{
		    clearSelections();
		    $.get("agreement/passAgree.action", {id: id},
				  function(data){
				    if(data==1)
				    { 
				       $('#tt').datagrid('reload');
				    }
				    else
				    {
				       tAlert('信息','审核通过的才能生效');
				    }
				  }
			);
		}
		
				
		function loadEdit(tit,url,opt){
			var $div = $('<div id="dlg" class="easyui-dialog" style="width:800px;height:450px;padding:10px 20px" closed="true">');
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
								saveOrUpdate('agreement/saveOrUpdate.action?opt='+opt,opt);
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
			//$(".panel-tool-max").click();
            //1.2.4版本后，使用href:url,会调用2次后台，规避方法使用refresh方法
            //$div.dialog('refresh',url);
		}
		
		
		function saveOrUpdate(url,opt){
		    var index = 0;
		    if(opt=='add')
		    {
		      index = getSelectedTabs();
		    }
		    if(opt=='edit')
		    { 
		      var cooparatype =$('#cooparatype').val();
		      //采购合同
		      if(cooparatype==1)
		      {
		          //用form0表单
		          index =0;
		      }
		    }
		    
			$('#fm'+index).form('submit',{
				url: url,
				onSubmit: function(){
				    if(index==0)
				    {
				       return checkform1();
				    }
					
				},
				success: function(result){
					var result = eval('('+result+')');
					if (result.result){
						//$('#dlg').dialog('close');		// close the dialog
						tAlert('信息','保存成功');
						$('#dlg').dialog('close');
						$('#tt').datagrid('reload');	// reload the project data
						
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
		
		function getInfoById(opt)
		{
		     //var selected = $('#tt').datagrid('getSelected');
		     var rows = $('#tt').datagrid('getSelections');
		     if(rows.length!=1)
		     {
		          tAlert('信息','请选择一条数据');
		     }
		     else{
		         var strinfo = opt=='edit'?'修改合约信息':'查看合约信息';
		         loadEdit(strinfo,'getAgreementInfoById.action?opt='+opt+'&id='+ rows[0].id ,opt);
		        
		     }
		}
		
		
		function printhy(opt,id,type)
		{
		     clearSelections();
		     window.open('getAgreementInfoById.action?opt='+opt+'&id='+id+"&type="+type, "_blank", '');
		}
		
		function getInfoById2(opt,id,type)
		{
		
		     clearSelections();
		     //window.event.cancelBubble = true;
	         var strinfo = opt=='edit'?'修改合约信息':'查看合约信息'
		     loadEdit(strinfo,'getAgreementInfoById.action?opt='+opt+'&id='+id+"&type="+type,opt);
		}
		
		
	    function clearSelections(){
			$('#tt').datagrid('clearSelections');
		}
		
		
		function queryinfo()
		{
		    var title = $('#title').val();
		    var type = $('#agreement_type').val();
		    var state = $('#state_id').val();
		    var query={title:title,type:type,state:state}; 
		    
		    //把查询条件赋值给datagrid内部变量
			$("#tt").datagrid('options').queryParams=query;
			//重新加载
			$("#tt").datagrid('load');
		 
		}
		
		function getSelectedTabs()
		{
		  var tab = $('#tabeid').tabs('getSelected'); 
		  var index = $('#tabeid').tabs('getTabIndex',tab); 
		  return index;
		}
		
		
		
		function stateOpt(id,state){
		
		     var rows = $('#tt').datagrid('getSelections');
		     if(rows.length==0 && id==''){
		          tAlert('信息','请选择数据');
		     }else{
		        
		        var idarr = [];
		        
		        if(id=='')
		        {
		           for(var i=0;i<rows.length;i++)
			        {
			             idarr.push(rows[i].id);
			        }
		        }
		        else
		        {
		           idarr.push(id);
		        }
		        var res = '['+idarr.join(",")+']';
		        var info = state==1?"审核通过":"审核不通过";
		        $.messager.confirm('信息','确认'+info,function(r){
					if (r){
						$.post('agreement/stateOpt.action',{ids:res,state:state},function(result){
							if (result.success){
								$('#tt').datagrid('reload');	// reload the  data
							} else {
								tAlert('信息',info+'操作失败');
							}
						},'json');
					}
				});
		        
		     }
		}
		
		function initbuttons(){
	      var arr =["icon-search"]
	      $('.easyui-linkbutton').each(function(i){
	           $(this).linkbutton({  
			     iconCls: arr[i],
			     plain:true 
			  });  
	      })
	    }
	</script>
    <table id="tt"></table>
	<div id="tb" style="padding:5px;height:auto"> 
		<div style="margin-bottom:5px">
			
			标题: <input name="agreement.title" id="title">
			类型: <s:select list="typelist" headerKey="" headerValue="--全部--" listKey="dictId" listValue="dictName" name="agreement.type" ></s:select>
			状态：<select id="state_id" name="state_name">
			        <option value="">--请选择--</option>
			        <option value="0">待审核</option>
			        <option value="1">审核通过</option>
			        <option value="2">审核不通过</option>
			      </select>
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="queryinfo()">查询</a>
			<br><br>
		</div>
	</div>
	
	
	