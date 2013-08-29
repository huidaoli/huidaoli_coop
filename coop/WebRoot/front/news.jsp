<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<div class="home_service clearfix">
	<div class="s_title s_color_2">
		<div class="st_in">
			<h2>
				最新行业资讯
			</h2>
			<!-- 
									<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
										codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0">
										<param name="quality" value="high" />
										<embed src="front/swf/1.swf" quality="high"
											pluginspage="http://www.macromedia.com/go/getflashplayer"
											type="application/x-shockwave-flash" width="460" height="270"></embed>
									</object>
									 -->
		</div>
	</div>
	<div style="width: 90%">
		<!-- ==== WIDGET [begin] ==== -->
		<aside class="widget">
		<h3 class="widget-title">
			<a href="more_1.html" target="_blank">更多</a>
		</h3>
		<div class="recent_comments">
			<s:iterator value="listNews" var="x">
				<div class="post_comm">
					[
					<s:iterator value="listDictBuss1" var="y">
						<s:if test="#y.dictId == #x.type">
							<s:property value="#y.dictName" />
						</s:if>
					</s:iterator>
					]
					<span style="padding-left: 20px;" /> <a
						href="javascript:void('0');"
						onclick="showMessage('<s:property value="#x.id" escape="false"/>','1');">
							<s:property value="#x.name" escape="false" /> </a>
						<div style="float: right">
							<s:date name="#x.createDate" format="yyyy-MM-dd" />
						</div>
				</div>
				<div class="clear"></div>
			</s:iterator>
		</div>
		<div class="clear"></div>
		</aside>
		<div class="clear"></div>
		<!-- ==== WIDGET [end] ==== -->
	</div>

</div>

<div class="home_service clearfix">
	<div class="s_title s_color_2">
		<div class="st_in">
			<h2>
				最新业务公告
			</h2>
			<!--
									<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
										codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0">
										<param name="quality" value="high" />
										<embed src="front/swf/2.swf" quality="high"
											pluginspage="http://www.macromedia.com/go/getflashplayer"
											type="application/x-shockwave-flash" width="460" height="270"></embed>
									</object>
								  -->
		</div>
	</div>
	<div style="width: 90%">
		<!-- ==== WIDGET [begin] ==== -->
		<aside class="widget">
		<h3 class="widget-title">
			<a href="more_2.html" target="_blank">更多</a>
		</h3>
		<div class="recent_comments">
			<s:iterator value="listProjectNews" var="x">
				<div class="post_comm">
					[
					<s:iterator value="listDictBuss2" var="y">
						<s:if test="#y.dictId == #x.type">
							<s:property value="#y.dictName" />
						</s:if>
					</s:iterator>
					]
					<span style="padding-left: 20px;" /> <a
						href="javascript:void('0');"
						onclick="showMessage('<s:property value="#x.id" escape="false"/>','2');">
							<s:property value="#x.name" escape="false" /> </a>
						<div style="float: right">
							<s:date name="#x.createDate" format="yyyy-MM-dd" />
						</div>
				</div>
				<div class="clear"></div>
			</s:iterator>
		</div>
		<div class="clear"></div>
		</aside>
		<div class="clear"></div>
	</div>

</div>
<div class="clear"></div>