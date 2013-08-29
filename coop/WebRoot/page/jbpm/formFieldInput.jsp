<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<script>
 $(function(){
    $("tr:odd").addClass("a1");
    $('#tid').hide();
 })

 function changeVal(obj)
 {
     if(obj.value==2 || obj.value==3 || obj.value==4)
     {
         createTable();
     }
 }
 

 
function saveKv(action)
{
   //alert();
  
   var jsonData = $('#tt12').datagrid("getChanges");
   //alert(jsonData.length)
   var arr = [];
   for(var obj in jsonData)
   {
       var values = jsonData[obj];
       var r = "";
       for(var key in values)
       {
          if(key=='key')
          {
             r+="{value:'"+ values[key]+"'";
          }
          if(key=='value')
          {
             r+=",label:'"+ values[key]+"'}";
          }
          
       }
       if(r!="")
       {
          arr.push(r);
       }
      
       
   }
   //alert(arr);
   
   $('#jsondata_Id').val('['+arr.join(",")+']');
   
   tAlert('信息','保存成功');
   
   $('#dlg21').dialog('close');
   
   // var formField =  $('#formField_id').val();
   /**
   $.post('jbpm/savaKeyValue.action',{jsonData:'['+arr.join(",")+']'},function(result){
		if (result.success){
			$('#tt').datagrid('reload');	// reload the user data
		} else {
			tAlert('信息','删除失败');
		}
   },'json')
   **/
	
}
</script>
<form id="fm" method="post">
    <input type="hidden" name="jsondata" id="jsondata_Id"/>
    <input type="hidden" name="formField.id" value="<s:property value="formField.id" default="0"/>" id="formField_id"/>
    <input type="hidden" name="formId" value="${formId}" id="formId"/>
	<table width="100%" id="mytab" border="1" class="t1">
		<tr>
			<td nowrap="nowrap" width="100">
				标签:
			</td>
			<td>
				<input type="text" name="formField.fieldLabel" value="<s:property value="formField.fieldLabel"/>" class="easyui-validatebox" required="true" >
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap" width="100">
				名称:
			</td>
			<td>
				<input type="text" name="formField.fieldName" value="<s:property value="workflow.name"/>" class="easyui-validatebox" required="true" >
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap" width="100">
				类型:
			</td>
			<td>
				 <s:select list="listFieldType" headerKey="-1" headerValue="==请选择==" listKey="id" listValue="name" name="formField.fieldInput.id"></s:select>
			</td>
			
		</tr>
		<tr>
			<td nowrap="nowrap" width="100">
				输入形式:
			</td>
			<td>
				 <s:select list="listFieldInput" headerKey="-1" headerValue="==请选择==" listKey="id" listValue="name" name="formField.fieldType.id" onchange="changeVal(this)"></s:select>
			</td>
			
		</tr>
	</table>
</form>