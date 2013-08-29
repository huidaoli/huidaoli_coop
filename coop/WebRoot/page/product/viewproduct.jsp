<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<script>
</script>
<form id="fm" method="post" enctype="multipart/form-data">
    <input type="hidden" name="product.id" value="<s:property value="product.id" default="0"/>" />
    <input type="hidden" name="product.code" value="<s:property value="product.code"/>" />
    <input type="hidden" name="product.coopid" value="${strmemid}" />
	<table width="100%" id="mytab" border="1" class="t1">
		<tr>
			<td  width="100">
				产品名称:
			</td>
			<td>
			  <s:property value="product.name"/>
			</td>
			
		</tr>
		<tr>
			<td  width="100">
				产品热词:
			</td>
			<td>
			   <s:property value="product.hotword" escape="false" />
			</td>
		</tr>
		<tr>
			<td  width="100">
				产品分类:
			</td>
			<td>
			 <s:iterator value="prodcutsort" var="x">
					<s:if test="#x.dictId == product.sort">
					  <s:property value="#x.dictName"/> 
					</s:if>
			</s:iterator>
			</td>
		</tr>
		<tr>
			<td  width="100">
				产地:
			</td>
			<td>
			 <s:property value="product.proarea"/>
			</td>
		</tr>
		<tr>
			<td  width="100">
				类型图:
			</td>
			<td>
			  <img src='../attach/productpic/<s:property value="product.typeimg"/>'>
			</td>
		</tr>
		<tr>
			<td  width="100">
				产品图:
			</td>
			<td>
			   <s:iterator value="#request.pplist" var="x" >
			      <span>
			       <img src="../attach/productpic/<s:property value="#x.scaledpath"/>"><br>
			      </span>
			   </s:iterator>
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
			 <s:property value="product.specinfo" escape="false"/>
			</td>
		</tr>
		<tr>
			<td  width="100">
				功效信息:
			</td>
			<td>
			  <s:property value="product.efficacyinfo" escape="false"/>
			</td>
		</tr>
		<tr>
			<td  width="100">
				其他备注:
			</td>
			<td>
			  <s:property value="product.remark" escape="false"/>
			</td>
		</tr>
	</table>
</form>