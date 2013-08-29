package com.base.frame.security.action;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.base.frame.common.BaseAction;

@Controller("timeOut")
@Scope("prototype")
public class TimeOutAction  extends BaseAction
{

    private Log logger = LogFactory.getLog(TimeOutAction.class);
    /**
     * [¼òÒªÃèÊö]:
     * @author tangdingyi
     */
    private static final long serialVersionUID = -2626588203663939532L;
    
    public String timeOut()
    {
        logger.debug("Enter timeOut()");
        /**
        try
        {
            StringBuffer sb = new StringBuffer();
            sb.append("<script type=\"text/javascript\">");
            sb.append("window.top.location = \"toLogin.action\";");
            sb.append("</script>");
            response.getWriter().println(sb.toString());
        }
        catch (IOException e)
        {
            logger.error("getResponse().getWriter().println error.", e);

        }
         return null;
         */
        
        return SUCCESS;
        
       
    }

}
