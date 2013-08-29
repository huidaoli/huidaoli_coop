<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript">

    jQuery(function($){

      $('#target').Jcrop({
        onChange:   showCoords,
        onSelect:   showCoords,
        onRelease:  clearCoords
      });

    });
    
     function showCoords(c)
    {
      $('#x1').val(c.x);
      $('#y1').val(c.y);
      $('#x2').val(c.x2);
      $('#y2').val(c.y2);
      $('#w').val(c.w);
      $('#h').val(c.h);
    };
    
     function clearCoords()
    {
      $('#coords input').val('');
    };
    
    </script>
	
<form id="eidtimg" method="post" enctype="multipart/form-data">

    
	<s:iterator value="#request.list" var="x" status="sta">
	
    <table width="100%" id="mytab" border="1" class="t1">
		<tr>
			<td>
				<img id='target' src='../attach/file/<s:property value="#x.newname" escape="false" />' />
			</td>
			<td>
			<table>
			  <tr>
			  <td>
			   标题:<input type="text" name="divproper.title" class="easyui-validatebox" required="true"><input type="hidden" id="imgid" name="divproper.imgid" value='<s:property value="#x.attaid" escape="false" />'>
		      <br> 
		      <input type="hidden" name="divproper.sequ" value="1">
			  </td>
			  </tr>
			    <tr>
			  <td>
			    <div id="coords">    
			      <input type="hidden"  id="x1" name="divproper.x1" style="width:30px;"/>
			      <input type="hidden"  id="y1" name="divproper.y1" style="width:30px;"/>
			      <input type="hidden"  id="x2" name="divproper.x2" style="width:30px;"/>
			      <input type="hidden"  id="y2" name="divproper.y2" style="width:30px;"/>
			      <input type="hidden"  id="w" name="divproper.w" style="width:30px;"/>
			      <input type="hidden"  id="h" name="divproper.h" style="width:30px;"/>
			     </div>
			  附件：<input type="file" name="attafile">
			  </td>
			  </tr>
			</table>
			   
			   
			</td>
			
		</tr>
	</table>
	</s:iterator>
	
	
</form>
<br>
<br>
<s:if test="#request.divs !=null">
<h3>预览图</h3>
</s:if>
${divs}
