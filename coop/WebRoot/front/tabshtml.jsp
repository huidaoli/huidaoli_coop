<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<aside class="widget">
	<div class="recent_comments">
	 <table>
	    <tr>
		    <td style="text-align: center;" width="20%">图片</td>
		    <td style="text-align: center;" width="20%">类别</td>
		    <td style="text-align: center;" width="20%">名称</td>
		    <td style="text-align: center;" width="20%">地区</td>
		    <td style="text-align: center;" width="20%">联系方式</td>
	    </tr>
	    <s:if test="cooperationList.size()==0">
	     <tr><td colspan="5">暂无数据</td></tr>
	    </s:if>
	    <s:else>
	      <s:iterator value="cooperationList" var="x" >
			<tr>
			   <td style="vertical-align: middle;">
			   <a href="<s:property value="#x.id"/>" target="_blank">
			     <img alt="logo" src="attach/productpic/<s:property value="#x.logo" escape="false"/>"  onerror="javascript:this.src='front/images/default.png'"/></a>
			   </td>
			   <td style="vertical-align: middle;">
			     <a href="<s:property value="#x.id"/>"  target="_blank">
			      <s:iterator value="listDictBusstype" var="y">
						<s:if test="#y.dictId == #x.cooptype">
						  <s:property value="#y.dictName"/> 
						</s:if>
				  </s:iterator>
			     </a>
			    </td>
			   <td style="vertical-align: middle;"><a href="<s:property value="#x.id"/>" target="_blank"><s:property value="#x.companyname" escape="false"/></a></td>
			   <td style="vertical-align: middle;"><a href="<s:property value="#x.id"/>" target="_blank"><s:property value="#x.area" escape="false"/></a></td> 
			   <td style="vertical-align: middle;"><a href="<s:property value="#x.id"/>" target="_blank"><s:property value="#x.fphone" escape="false"/></a></td>
			</tr>
		</s:iterator>
	    </s:else>
		
	</table>
	
	</div>
</aside>
<div id="smk_pagination" class="all_transition_05">
	${pageHtml}
</div>
<div style="width:100px;float:right"><a class="smk_button green" href="register.html" target="_blank">在线加盟</a></div>
<script>
function goPage2(pages)
{
   $('#tab1').load("showtabs.html?type=${type}&page="+pages);
}

function gotourl(obj,id)
{
    //alert($(obj).find("a").click());
}
</script>

<!-- 
<div class="post_comm">
			<a href="#"><img alt="" src="front/images/assets/75-1.jpg" /> </a>
			<p>
				<a href="#"> <strong class="comment-author">类别</strong>:农场主 <strong
					class="comment-author">名称</strong>:<s:property value="#x.name" escape="false"/><strong
					class="comment-author">地区</strong>:<s:property value="#x.address" escape="false"/> <strong
					class="comment-author">联系方式</strong>:<s:property value="#x.phone" escape="false"/> </a>
			</p>
		</div>
		<div class="clear"></div>
 -->