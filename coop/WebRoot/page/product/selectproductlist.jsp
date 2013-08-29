<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
	<script type="text/javascript">
	
	    function selectRow2(id,name,guige,prodarea)
		{
		
		   var proid = $("input[name='agreement.item["+cache.id+"].proid']");  
		   var proname = $("input[name='agreement.item["+cache.id+"].proname']");
		   var guige2 = $("input[name='agreement.item["+cache.id+"].guige']");
		   var candi = $("input[name='agreement.item["+cache.id+"].candi']");
		   proid[0].value=id;
		   proname[0].value=name;
		   guige2[0].value=guige;
		   candi[0].value=prodarea;
		   
		   $('#dlghzf2').dialog('close');
		}
		
		$(function(){
			$('#ttddg').datagrid({
				title:'产品列表',
				iconCls:'icon-search',
				idField:'id', 
				treeField:'code',
				nowrap: false,
				striped: true,
				url:'../product/getProductList.action?memid=${memid}',
				fitColumns:true,
				frozenColumns:[[
				    {field:'ck',formatter:function(value,rec){
				             return "<input type='radio' name='ccc2' onclick=\"selectRow2('"+rec.id+"','"+rec.name+"','"+rec.specinfo+"','"+rec.proarea+"')\">";
						}
					}
	                
	                
				]],
							
				columns:[[
				    {title:'名称',field:'name',width:150},
				    {title:'分类',field:'sortname',width:80},
				    {title:'产地',field:'proarea',width:150}
					
				]],
				pagination:true,
				rownumbers:true,
				toolbar:"#tb232"
			});
			
			
		});
		
		
		function queryinfo2()
		{
		
		    var productsort = $('#product_sort').val();
		    var linestate = $('#linestate').val();
		    var state = $('#state').val();
		    var sync = $('#sync').val();
		      
		    var query={name:$('#nameid').val(),sort:productsort,linestate:linestate,state:state,sync:sync}; 
		    
		    //把查询条件赋值给datagrid内部变量
			$("#ttddg").datagrid('options').queryParams=query;
			
			//重新加载
			$("#ttddg").datagrid('load');
		 
		}
		
	
		
	</script>
	<table id="ttddg"></table>
	
	<div id="tb232" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			
			产品名称: <input name="product.name" id="nameid">
			产品分类: <s:select list="prodcutsort" headerKey="-1" headerValue="--全部--" listKey="dictId" listValue="dictName" name="product.sort" ></s:select>
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="queryinfo2()">查询</a>
			<br><br>
		</div>
		<div>
			
			
		</div>
	</div>
	
