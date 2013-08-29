<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<script language="javascript">
function   DeleteRow(){//删除行 //index插入的位置 
  var obj = document.getElementById('mytab11'); 
   if(obj.rows.length>1) {  
       obj.deleteRow(obj.rows.length-1);  
   } 
  }  
  function   InsertRow(){  
    var obj = document.getElementById('mytab11'); 
    if(obj.rows.length==5)
    {
       tAlert('信息','最多上传5个文件');
       return;
    }
    var  oTr=obj.insertRow(obj.rows.length);  
    var  oTd  ;
    var idtem ='temp'+obj.rows.length;
    //for (j=0;j<obj.rows(0).cells.length;j++)  {  
     oTd=oTr.insertCell(0);  
     oTd.innerHTML='<a>附件上传:</a>';
     oTd=oTr.insertCell(1);  
     oTd.innerHTML='<input type="file" id='+idtem+' name="attafile">';
  }  

</script>
<form id="fmatta" method="post" enctype="multipart/form-data">
<input onclick="InsertRow()" type="button" value="新增"
			ID="Button2" NAME="Button2">
			<INPUT onclick="DeleteRow()" type="button" value="删除"
			ID="Button1" NAME="Button1">
	<table width="100%" id="mytab11" border="1" class="t1">
		<tr>
			<td nowrap="nowrap">
				附件上传:
			</td>
			<td>
				<input type="file" name="attafile">
			</td>

		</tr>
	</table>
	
	<div id="viewupload"></div>
</form>


