<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<s:if test="#session.member == null">
	<a href="register.html" target="_blank">注册加盟 </a> | 
    <a href="javascript:void(0)" onclick="tologin();">登录</a> | 
</s:if>
<s:else>
     欢迎您：<a href="myspace.html">${session.member.realName}</a> | 
    <a href="myspace.html">我的空间</a> | 
   <a href="javascript:void(0)" onclick="logout();">退出</a> | 
</s:else>

<a href="javascript:void(0)" onclick="internation();">国际站点</a>