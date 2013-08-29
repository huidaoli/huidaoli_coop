package com.base.frame.common;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.base.frame.model.UserInfo;
import com.base.frame.security.action.ModuleAction;
import com.opensymphony.xwork2.ActionSupport;

/**
 * [¼òÒªÃèÊö]:<br/> [ÏêÏ¸ÃèÊö]:<br/>
 * 
 * @author tangdingyi
 * @version 1.0, Sep 9, 2011
 */
public class BaseAction extends ActionSupport implements ServletContextAware, ServletResponseAware,
        ServletRequestAware, SessionAware
{

    private static final long serialVersionUID = 1L;

    protected ServletContext servletContext;

    protected HttpServletRequest request;

    protected HttpServletResponse response;

    protected HttpSession httpSession;

    protected Map<String, Object> session;
    
    private Log logger = LogFactory.getLog(BaseAction.class);

    
    /**
     * 
     * [¼òÒªÃèÊö]:<br/>
     * [ÏêÏ¸ÃèÊö]:<br/>
     * 
     * @author tangdingyi
     * @param context
     * @exception 
     * @see org.apache.struts2.util.ServletContextAware#setServletContext(javax.servlet.ServletContext)
     */
    @Override
    public void setServletContext(ServletContext context)
    {
        this.servletContext = context;
    }

    
    /**
     * 
     * [¼òÒªÃèÊö]:<br/>
     * [ÏêÏ¸ÃèÊö]:<br/>
     * 
     * @author tangdingyi
     * @param response
     * @exception 
     * @see org.apache.struts2.interceptor.ServletResponseAware#setServletResponse(javax.servlet.http.HttpServletResponse)
     */
    @Override
    public void setServletResponse(HttpServletResponse response)
    {
        this.response = response;
    }

    /**
     * 
     * [¼òÒªÃèÊö]:<br/>
     * [ÏêÏ¸ÃèÊö]:<br/>
     * 
     * @author tangdingyi
     * @param request
     * @exception 
     * @see org.apache.struts2.interceptor.ServletRequestAware#setServletRequest(javax.servlet.http.HttpServletRequest)
     */
    @Override
    public void setServletRequest(HttpServletRequest request)
    {
        this.request = request;
        this.httpSession = request.getSession();
    }

    /**
     * 
     * [¼òÒªÃèÊö]:<br/>
     * [ÏêÏ¸ÃèÊö]:<br/>
     * 
     * @author tangdingyi
     * @param session
     * @exception 
     * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
     */
    @Override
    public void setSession(Map<String, Object> session)
    {
        this.session = session;
    }

    
    /**
     * 
     * [¼òÒªÃèÊö]:<br/>
     * [ÏêÏ¸ÃèÊö]:<br/>
     * 
     * @author tangdingyi
     * @param request
     * @return
     */
    protected UserInfo currentUser(HttpServletRequest request)
    {
        return (UserInfo) request.getSession().getAttribute("user");
    }
    
    /**
     * 
     * [¼òÒªÃèÊö]:<br/>
     * [ÏêÏ¸ÃèÊö]:<br/>
     * 
     * @author tangdingyi
     * @param jsonData
     */
    protected String  toJsonData(String jsonData)
    {
        try
        {
            response.getWriter().println(jsonData);
        }
        catch (IOException e)
        {
            logger.error("getResponse().getWriter().println error.", e);
        }
        
        return null;
    }
    
    /**
     * 
     * [¼òÒªÃèÊö]:<br/>
     * [ÏêÏ¸ÃèÊö]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    protected String success()
    {
        try
        {
            response.getWriter().println("{\"success\":true}");
        }
        catch (IOException e)
        {
            logger.error("getResponse().getWriter().println error.", e);
        }
        
        return null;
    }
    
    protected String faild()
    {
        try
        {
            response.getWriter().println("{\"success\":false}");
        }
        catch (IOException e)
        {
            logger.error("getResponse().getWriter().println error.", e);
        }
        
        return null;
    }
    
    protected String result(boolean res)
    {
    	return result(res,"success");
    }
    
    protected String result(boolean res,String mess)
    {
        try
        {
            response.getWriter().println("{result:"+String.valueOf(res)+",mess:'"+mess+"'}");
        }
        catch (IOException e)
        {
            logger.error("getResponse().getWriter().println error.", e);
        }
        
        return null;
    }

}
