<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<script language="javascript">
	$(function(){
	
	     var opt = '${opt}';
	     var s = $("input[name='id']");
	     var cc = $("input[name='dictId']");
	     $("input[name='dictName']").each(function(i){
		    if($(this).val()=='')
		    {
		       $(s.get(i)).val('');
		       $(cc.get(i)).val('');
		    }
		 });
	
	})
    
</script>
<form id="fm" method="post">
	<table width="100%" id="mytab" border="1" class="t1">
		<tr>
			<td width="100">
				类型序号
			</td>
			<td>
			    类型名称<input type="hidden" name="typeid" value="${id}">
			</td>
			
		</tr>
		<s:iterator value="listDB" var="dictBuss">
			<tr>
				<td nowrap="nowrap" width="100">
				    <input type="hidden" name="id" value="<s:property value="#dictBuss.id" />">
					<input name="dictId" style="width:220px;" type="text" value="<s:property value="#dictBuss.dictId" />">
				</td>
				<td>
				    <input name="dictName" style="width:220px;" type="text" value="<s:property value="#dictBuss.dictName" />">
				</td>
				
			</tr>
		 </s:iterator>
		
		
		
	</table>
</form>
