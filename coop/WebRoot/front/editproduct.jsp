<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<script type="text/javascript" src="front/plugins/cityselect/js/jquery.cityselect.js"></script>
<script>

function addtd()
{
  var s =$("#filegroup span").size();
  if(s==8)
  {
      tAlert("信息","最多支持8张");
      return;
  }
  $('#filegroup').append("<span><input name='productimg' type='file'><a href='#' onclick='deltd(this,\"\");'>删除</a><br></span>");
  $("input[name='productimg']").validatebox({
       required: true
   });
}
var arrdeleids=[];
function deltd(obj,id)
{
   //方法一
   //var d = document.getElementById("filegroup");
   //var oChild=d.children[0];
   //d.removeChild(oChild);
   
   //方法二
   //var s = $("#filegroup").children("span").get(0);
   //$(s).remove();
   
   //方法三
   //var s =$("#filegroup span").size();
   //if(s==1)
   //{
   //  return;
   //}
   //$("#filegroup").children("span:last-child").remove();
   
   var s =$("#filegroup span").size();
   if(s==1)
   {
     tAlert("信息","必须保留一张图片");
     return;
   }
   if(id!='')
   {
     arrdeleids.push(id);
   }
   
   $(obj).parent().remove();
   
   
}
$(function(){
	$('#sort').validatebox({
        required: true
    });
    $('#sort').validatebox({
        required: true
    });
	
});

 
</script>
<form id="fm" method="post" enctype="multipart/form-data">
    <input type="hidden" name="product.id" value="<s:property value="product.id" default="0"/>" />
    <input type="hidden" name="product.code" value="<s:property value="product.code"/>" />
    <input type="hidden" name="product.coopid" value="${strmemid}" />
	<table width="100%" id="mytab" border="1" class="t1">
		<tr>
			<td  width="100">
				产品名称:<font color="red">*</font>
			</td>
			<td>
			   <input name="product.name" style="width:200px;" type="text" class="easyui-validatebox" required="true" value="<s:property value="product.name"/>">
			</td>
			
		</tr>
		<tr>
			<td  width="100">
				产品热词:
			</td>
			<td>
			<s:iterator value="hotword" var="x">
			<input type="checkbox" name="product.hotword" value="<s:property value="#x.dictName" escape="false"/>"><s:property value="#x.dictName" escape="false" />
			</s:iterator>
			<script>
			  var arrs = '<s:property value="product.hotword" escape="false" />';
			  if(arrs!='')
			  {
			     var arr = arrs.split(",");
			     $("input[name='product.hotword']").each(function(i){
			         if(inArr($(this).val(),arr))
			         {
			             $(this).attr("checked","checked");
			         }
			         
			     })
			  }
			  function inArr(ele,arr)
			  {
			       for(var i in arr)
			       {
			           //alert(ele+"=="+arr[i]+"ddd"+(ele==$.trim(arr[i])))
			           if(ele==$.trim(arr[i]))
			           {
			              return true;
			           }
			       }
			       return false;
				
			  }
			</script>
			</td>
		</tr>
		<tr>
			<td  width="100">
				产品分类:<font color="red">*</font>
			</td>
			<td>
			   <s:select list="prodcutsort" headerKey="" headerValue="请选择" listKey="dictId" listValue="dictName" name="product.sort" id="sort"></s:select>
			</td>
		</tr>
		<tr>
			<td  width="100">
				产地:<font color="red">*</font>
			</td>
			<td>
			  <div id="city1">
			 	<select class="prov" id="prov"></select> 
			   	<select class="city" id="city" disabled="disabled"></select>
			    <select class="dist" id="dist" disabled="disabled"></select>
			   </div>
			   <input type="hidden" name="product.proarea" id="proarea" value="<s:property value="product.proarea"/>">
			<script>
			    var val = $('#proarea').val();
			    var arr = val.split(" ");
			    //alert(arr[0] + arr[0] + arr[2]);
				$("#city1").citySelect({
					nodata:"none",
					prov:arr[0], 
			    	city:arr[1],
					dist:arr[2],
					required:false
				});
			
			</script>
			  
			</td>
		</tr>
		<tr>
			<td  width="100">
				重量:
			</td>
			<td>
			   <input name="product.weight" style="width:200px;" type="text" class="easyui-numberbox" required="true" 
			   data-options="precision:1" value="<s:property value="product.weight"/>">千克
			</td>
		</tr>
		<tr>
			<td  width="100">
				市场价格:
			</td>
			<td>
			   <input name="product.markingprice" style="width:200px;" type="text" class="easyui-numberbox" 
			      required="true" data-options="precision:2" value="<s:property value="product.markingprice"/>">元
			</td>
		</tr>
		
		<tr>
			<td  width="100">
				平台价格:
			</td>
			<td>
			   <input name="product.ourprice" style="width:200px;" type="text" class="easyui-numberbox"  required="true" 
			     data-options="precision:2" value="<s:property value="product.ourprice"/>">元
			</td>
		</tr>
		
		<tr>
			<td  width="100">
				类型图:<font color="red">*</font>
			</td>
			<td>
			   <input type="hidden" name="product.typeimg" value="<s:property value="product.typeimg"/>" />
			   <s:if test="product.typeimg!=null">
			     <input name="typeimg"  type="file" class="easyui-validatebox">
			     <span id="img"><img src='attach/productpic/<s:property value="product.typeimg"/>'></span>
			   </s:if>
			   <s:else>
			      <input name="typeimg"  type="file" class="easyui-validatebox" required="true">
			   </s:else>
			   
			</td>
		</tr>
		<tr>
			<td  width="100">
				产品图:<font color="red">*</font>
			</td>
			<td>
			   <input type="hidden" name="product.tempdeleids" id="tempdeleids" />
			   <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addtd();">新增</a>
			   <br>
			   
			  
			   <div id="filegroup">
			   <s:if test="#request.pplist==null">
			       <span><input name="productimg"  type="file" class="easyui-validatebox" required="true"><br></span>
			   </s:if>
			   <s:else>
				   <s:iterator value="#request.pplist" var="x" >
				      <span>
				       <img src="attach/productpic/<s:property value="#x.scaledpath"/>"><a href="#" onclick="deltd(this,'<s:property value="#x.id"/>')">删除</a><br>
				      </span>
				   </s:iterator>
			   </s:else>
			   </div>
			   <font color="red"></font>
			</td>
		</tr>
		<!-- 
		<tr>
			<td  width="100">
				产品商城地址:
			</td>
			<td>
			   <input name="product.mallurl" style="width:200px;" type="text"  value="<s:property value="product.mallurl"/>">
			</td>
		</tr>
		 -->
		<tr>
			<td  width="100">
				规格信息:
			</td>
			<td>
			<input name="product.specinfo" style="width:200px;" type="text" class="easyui-validatebox" required="true" value="<s:property value="product.specinfo" escape="false"/>">
			</td>
		</tr>
		<tr>
			<td  width="100">
				功效信息:
			</td>
			<td>
			   <FCK:editor instanceName="product.efficacyinfo" height="200" toolbarSet="Basic">
				<jsp:attribute name="value">
				<s:property value="product.efficacyinfo" escape="false"/>
				</jsp:attribute>
			</FCK:editor>
			</td>
		</tr>
		<tr>
			<td  width="100">
				其他备注:
			</td>
			<td>
			    <FCK:editor instanceName="product.remark" height="200" toolbarSet="Basic">
				<jsp:attribute name="value">
				<s:property value="product.remark" escape="false"/>
				</jsp:attribute>
			</FCK:editor>
			</td>
		</tr>
	</table>
</form>