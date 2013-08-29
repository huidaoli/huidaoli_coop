<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<script language="javascript">
    var opt = '${opt}';
</script>
<div class="easyui-tabs" id="tabeid">
    <s:iterator value="typelist" var="x">
	   <div title="<s:property value="#x.dictName" escape="false" />" 
	   data-options="href:'getAgreeByType.action?type=<s:property value="#x.dictId"/>',
	                  tools:[{
							iconCls:'icon-mini-refresh',
							handler:function(){
							   var tab = $('#tabeid').tabs('getSelected');
							   tab.panel('refresh', this.herf);
							}
					  }]" style="padding:10px"></div>
	</s:iterator>
</div>

<script language="javascript">

</script>
