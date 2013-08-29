<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<script language="javascript">
    var opt = '${opt}';
    if(opt=='add')
    {
      $('#longday').val('');
	  $('#groupper').val('');
    }
    
    function parseDate(s)
    {
       return $.fn.datebox.defaults.parser(s).getTime();
    }
    
    //自定义校验规则，param 是传入的参数数组 如：validType:'length[1,3]'
    //本规则不需要传入参数所以无需param
    $.extend($.fn.validatebox.defaults.rules, {
		equals: {
		    validator: function(value){
		      var qstartTime = $('#starttimeid').datebox('getValue');
		      return  parseDate(value)>parseDate(qstartTime);
		   },
		message: '项目结束时间不能小于等于项目开始时间'
		}
	});
	
	$(function(){
	
	
	});
	
	$('#longday').keyup( function() {
	  countss();
	});
	
	$('#groupper').keyup( function() {
	  countss();
	});
	
	function countss()
	{
	   var day = $('#longday').val();
	   var gouer = $('#groupper').val();
	   if(day=='' || gouer=='')
	   {
	      return;
	   }
	   else
	   {
	       day = parseInt(day,10);
	       gouer = parseInt(gouer,10);
	       var res = (day*gouer/21).toFixed(2);
	       $('#ry').numberbox('setValue',res);
	       var res2 = (res*0.4).toFixed(2);
	       $('#touzif').numberbox('setValue',res2);
	       
	   }
	}
	
	
	
	
</script>
<form id="fm" method="post">
    <input type="hidden" name="project.id" value="<s:property value="project.id" default="0"/>" />
    <input type="hidden" name="project.ctype" value="<s:property value="project.ctype"/>" />
    <input type="hidden" id="contcodeid" name="project.contcode" value="<s:property value="project.contcode"/>" />
	<table width="100%" id="mytab" border="1" class="t1">
		<tr>
			<td  width="100">
				项目编号:
			</td>
			<td>
			   <input name="project.no" type="text" class="easyui-validatebox" required="true" value="<s:property value="project.no"/>">
			</td>
			<td >
				项目名称:
			</td>
			<td>
			   <input name="project.name" type="text" class="easyui-validatebox" required="true" value="<s:property value="project.name"/>">
			</td>
			
		</tr>
		<tr>
			<td >
				项目类别:
			</td>
			<td>
			    <s:select list="listDictBusstype" headerKey="" headerValue="==请选择==" listKey="dictId" listValue="dictName" name="project.type" id="typeid1"></s:select>
			</td>
			<td >
				技术方向:
			</td>
			<td>
			    <s:select list="listDictBussitfx" headerKey="" headerValue="==请选择==" listKey="dictId" listValue="dictName" name="project.itfx" id="typeid2"></s:select>
			</td>
			
		</tr>
		<tr>
			<td >
				应用行业:
			</td>
			<td>
			    <s:select list="listDictBussyyfx" headerKey="" headerValue="==请选择==" listKey="dictId" listValue="dictName" name="project.yyfx" id="typeid3"></s:select>
			</td>
			<td >
				项目工期:
			</td>
			<td>
				<input name="project.longday" id="longday" type="text" class="easyui-numberbox" maxlength="5" required="true" value="<s:property value="project.longday"/>"> (工作日)
			</td>
			
		</tr>
		<tr>
		     <td >
				开始时间:
			</td>
			<td>
				<input name="project.startTime" type="text" id="starttimeid" class="easyui-datebox" required="required" value="<s:date name="project.startTime" format="yyyy-MM-dd" />">
			</td>
			 <td >
				结束时间:
			</td>
			<td>
				<input name="project.endTime" type="text" class="easyui-datebox" data-options="required:true,validType:'equals'" value="<s:date name="project.endTime" format="yyyy-MM-dd" />">
			</td>
		</tr>
		<tr>
			<td >
				团队人数:
			</td>
			<td>
			   	<input name="project.groupper" type="text" id="groupper" class="easyui-numberbox" maxlength="3" required="true" value="<s:property value="project.groupper"/>">
			</td>
			<td >
				项目规模:
			</td>
			<td>
				<input name="project.ry" type="text" id="ry" class="easyui-numberbox"  data-options="min:0,max:200000,precision:2,required:true" value="<s:property value="project.ry"/>"> (人月)
			</td>
			
		</tr>
		<tr>
			<td >
				投资规模:
			</td>
			<td>
			   	<input name="project.touzif" id="touzif" type="text" class="easyui-numberbox" data-options="min:0,max:200000,precision:2,required:true"  value="<s:property value="project.touzif"/>"> (万元)
			</td>
			<td >
				发包方:
			</td>
			<td>
				<input name="project.fbf" type="text"   value="<s:property value="project.fbf"/>">
			</td>
			
		</tr>
		<tr>
			<td >
				承包方:
			</td>
			<td>
			   	<input name="project.cbf" type="text"  value="<s:property value="project.cbf"/>">
			</td>
			<td >
				项目经理:
			</td>
			<td>
				<input name="project.pm" type="text"  value="<s:property value="project.pm"/>">
			</td>
			
		</tr>
		<tr>
			<td >
				附件:
			</td>
			<td colspan="3">
				<img src='../themes/icons/view.gif' title='附件' style='cursor:pointer'onclick="getUpload()" />
			</td>
			
		</tr>
		
		<tr >
			<td  style="height:400px;">
				项目简介:
			</td>
			<td colspan="3">
			<FCK:editor instanceName="project.desctio" height="400">
				<jsp:attribute name="value">
				<s:property value="project.desctio" escape="false"/>
				</jsp:attribute>
			</FCK:editor>
			
			</td>
			
		</tr>
	</table>
</form>
<script language="javascript">
    $('#typeid1').validatebox({
        required: true
    });
    
    $('#typeid2').validatebox({
        required: true
    });
    
    $('#typeid3').validatebox({
        required: true
    });
</script>

	