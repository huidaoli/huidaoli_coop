<#list field.items as item>
	 <input type="radio" name="props(${field.fieldName})" value="${item.value}" style="border:none"> 
	 ${item.label}
</#list>
