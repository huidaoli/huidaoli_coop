<#list form.fields as field>
		<tr>
		
			<td nowrap="nowrap">${field.fieldLabel}</td>			
			<td><#include "${field.fieldInput.template}"></td>
		
		</tr>
	
</#list>
    
	
