<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

	<script type="text/javascript">
	    
	    var values = eval('${result}');
	    //alert(values.length);
		$(function(){
		    //var temp = 0;
		    $('#loading').html("<img src='../themes/icons/loading.gif'/>loading...");
			$('#tt2').tree({
				checkbox: true,
				url: 'contents/getModuleTreeData.action',
			    onLoadSuccess:function()
				{
				
				   var node;
				   for(var i=0;i<values.length;i++)
				   {
				   
				      node = $('#tt2').tree('find', values[i]);
				      if(node!=null)
				      {
				         $('#tt2').tree('check', node.target);
				      }
				   }
				   
				   //if((temp++)==1){
				   $('#loading').remove();
				   //}
				   
				   
				}
				
			});
		});
		
	</script>

	
<fieldset style="">
				<legend>
					<s:text name="cms.module.info.me"/>
					
				</legend>
    <div id="loading"></div>
	<ul id="tt2"></ul>
</fieldset>
