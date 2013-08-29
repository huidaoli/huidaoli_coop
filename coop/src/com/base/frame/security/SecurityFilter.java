package com.base.frame.security;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.base.frame.model.UserInfo;

public class SecurityFilter implements Filter
{

    /**
     * ����Ҫ���˵�·������
     */
    private String[] excludeActions = null;
    
    /**
     * ����Ҫ���˵�·��
     */
    private String[] excludePath = null;
    
    /**
     * ��Ҫ���˵�����
     */
    private String[] filterType = null;
    
    @Override
    public void destroy()
    {
        // TODO Auto-generated method stub

    }
    
    private int getCharCount(String str)
    {
    	
    	int count = 0;
    	
    	if(StringUtils.isBlank(str))
    	{
    		return count;
    	}
    	else
    	{
    		int len = str.length();
    		for(int i=0;i<len;i++)
    		{
    			if(str.charAt(i)=='/')
    			{
    				count++;
    			}
    			
    		}
    	}
    	return count;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException,
            ServletException
    {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        String contextPath = httpRequest.getContextPath();
        String requestAction = httpRequest.getRequestURI().substring(contextPath.length());
        
        //��Ҫ���˵����;�Ҫ����
        boolean isFilter = false;
        for (String filterTypeStr : filterType)
        {
            if (requestAction.endsWith(filterTypeStr))
            {
                isFilter = true;
                break;
            }
            
        }
        
        if (!isFilter)
        {
            filterChain.doFilter(request, response);
            return; 
        }
        
        // ����ǲ���Ҫ���˵�·���򲻹���
        for (String excludePathStr : excludePath)
        {
            if (requestAction.equals(excludePathStr))
            {
                filterChain.doFilter(request, response);
                return;
            }
        }
        
        //�����action��β
        if(requestAction.endsWith(".action"))
        {
        	//���ֻ��һ��/
        	if(1==getCharCount(requestAction))
        	{
        		 filterChain.doFilter(request, response);
                 return;
        	}
        }
        
        // ����ǲ���Ҫ���˵�action�򲻹���
        for (String excludeAction : excludeActions)
        {
            if (requestAction.startsWith(excludeAction))
            {
                filterChain.doFilter(request, response);
                return;
            }
        }
        
        UserInfo user =  (UserInfo)httpRequest.getSession().getAttribute("user");
        
        if(null == user)
        {
            //httpResponse.sendRedirect("/platform"+contextPath + "/sysadmin/timeOut.action");
        	httpResponse.sendRedirect(contextPath + "/sysadmin/timeOut.action");
            return;
        }
        
        filterChain.doFilter(request, response);

    }

    @SuppressWarnings("unchecked")
    @Override
    public void init(FilterConfig config) throws ServletException
    {
        Enumeration en = config.getInitParameterNames();
        String value = null;
        while (en.hasMoreElements()) {
            String property = (String) en.nextElement();
            value = (String)config.getInitParameter(property);
            if(property.equals("excludeActions"))
            {
                excludeActions = value.split("\\,");
                for (int i = 0; i < excludeActions.length; i++)
                {
                    excludeActions[i] = excludeActions[i].substring(StringUtils.indexOf(excludeActions[i], '/'));
                }
            }
            if(property.equals("excludePath"))
            {
                excludePath = value.split("\\,");
                for (int i = 0, len = excludePath.length; i < len; i++)
                {
                    excludePath[i] = excludePath[i].substring(StringUtils.indexOf(excludePath[i], '/'));
                }
                
            }
            if(property.equals("filterType"))
            {
                filterType = value.split("\\,");
                for (int i = 0, len = filterType.length; i < len; i++)
                {
                    filterType[i] = filterType[i].substring(StringUtils.indexOf(filterType[i], '.') + 1);
                }
            }
            
        }

    }

}

