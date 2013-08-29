<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
	<script type="text/javascript">
		function FCKeditor_OnComplete(editorInstance) {
				window.status = "";
		}
		$(function(){
			$('#tt').datagrid({
				title:'行业资讯',
				iconCls:'icon-search',
				idField:'id', 
				treeField:'code',
				nowrap: false,
				striped: true,
				url:'getAjaxDataNews.action',
				fitColumns:true,
				frozenColumns:[[
				    {field:'ck',checkbox:true}
	                
				]],
				//rowStyler: function(index,row){
				//	if (row.zhiding == 1){
				//		return 'background-color:#FF0000;font-weight:bold;';
				//	}
				//},
				columns:[[
				    {title:'标题',field:'name',width:100,},
				    {title:'分类',field:'typename',width:100},
				    {title:'创建时间',field:'createDate',width:100},
				    {title:'发布者',field:'coopname',width:100},
					{field:'opt',title:'操作',width:80,align:'center', 
						formatter:function(value,rec){
						    //alert(rec.id);
							return "<span style='padding-right:10px;'><img src='themes/icons/pencil.png'\ title='修改' style='cursor:pointer;border:1px solid #7eabcd;' onclick='getNewsInfoById2(\"edit\","+rec.id+")'></span>"+
							       "<span><img src='themes/icons/view.gif'\ title='查看' style='cursor:pointer'onclick='getNewsInfoById2(\"view\","+rec.id+")' ></span>";
						}
						
					}
					
					
				]],
				pagination:true,
				rownumbers:true,
				toolbar:"#tb"
			});
			
			initbuttons();
			
		});
		
     
		function loadNewsInfo(tit,url,opt){
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
								saveNews('saveNews.action?opt='+opt);
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
            //1.2.4版本后，使用href:url,会调用2次后台，规避方法使用refresh方法
            //$div.dialog('refresh',url);
		}
		
		function saveNews(url){
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
						$('#tt').datagrid('reload');	// reload the News data
						
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
		
		function getNewsInfoById(opt)
		{
		     //var selected = $('#tt').datagrid('getSelected');
		     var rows = $('#tt').datagrid('getSelections');
		     if(rows.length!=1)
		     {
		          tAlert('信息','请选择一条数据');
		     }
		     else{
		         var strinfo = opt=='edit'?'修改行业资讯':'查看行业资讯';
		         loadNewsInfo(strinfo,'loadNewsInfoById.action?opt='+opt+'&id='+ rows[0].id ,opt);
		        
		     }
		}
		
		
		function getNewsInfoById2(opt,id)
		{
		     clearSelections();
		     //window.event.cancelBubble = true;
	         var strinfo = opt=='edit'?'修改行业资讯':'查看行业资讯'
	         loadNewsInfo(strinfo,'loadNewsInfoById.action?opt='+opt+'&id='+id,opt);
		     
		}
		
		function deleteNews(){
		
		    var rows = $('#tt').datagrid('getSelections');
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
						$.post('deleteNews.action',{ids:res},function(result){
							if (result.success){
								$('#tt').datagrid('reload');	// reload the News data
							} else {
								tAlert('信息','删除失败');
							}
						},'json');
					}
				});
		        
		     }
		}
		
	    function clearSelections(){
			$('#tt').datagrid('clearSelections');
		}
		
		
		function queryinfo()
		{
		
		    var typeval = $('#news_type').val();
		    var state = $('#state_id').val();
		    var query={name:$('#nameid').val(),type:typeval,state:state}; 
		    
		    //把查询条件赋值给datagrid内部变量
			$("#tt").datagrid('options').queryParams=query;
			
			//重新加载
			$("#tt").datagrid('load');
		 
		}
		
		
		
		function initbuttons(){
	      var arr =["icon-search","icon-add","icon-edit","icon-view","icon-remove"]
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
			
			标题: <input name="news.name" id="nameid">
			分类: <s:select list="listDictBuss" headerKey="-1" headerValue="--请选择--" listKey="dictId" listValue="dictName" name="news.type"></s:select>
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="queryinfo()">查询</a>
			<br><br>
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="loadNewsInfo('新闻资讯','loadNews.action','add')">新增</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="getNewsInfoById('edit')">修改</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-view" plain="true" onclick="getNewsInfoById('view')">查看</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteNews()">删除</a>
			
		</div>
		<div>
	</div>
</div>
	