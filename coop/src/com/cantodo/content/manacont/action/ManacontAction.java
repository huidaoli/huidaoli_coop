package com.cantodo.content.manacont.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.base.frame.common.BaseAction;
import com.cantodo.content.dto.Content;
import com.cantodo.content.manacont.service.ManacontService;

/**
 * @author tdy
 */
@Controller("manacontAction")
@Scope("prototype")
public class ManacontAction extends BaseAction
{

    /**
     * [¼òÒªÃèÊö]:
     * 
     * @author tangdingyi
     */
    private static final long serialVersionUID = -6554581830311410572L;

    private Log logger = LogFactory.getLog(ManacontAction.class);

    @Autowired
    private ManacontService manacontServiceImpl;

    private Content content;

    public String toManacont()
    {
        logger.debug("enter toLoadList");
        
        String sid = request.getParameter("id");
        
        int id = NumberUtils.toInt(sid,0);

        content =  manacontServiceImpl.getInfoById(id);

        logger.debug("exit toLoadList");

        return SUCCESS;
    }
    
    public String save()
    {
        logger.debug("enter toLoadList");
        
        manacontServiceImpl.update(content);

        logger.debug("exit toLoadList");

        return success();
    }
    
    public String update()
    {
        logger.debug("enter toLoadList");
        
        
        manacontServiceImpl.updateContent(content);

        logger.debug("exit toLoadList");

        return success();
    }

    public Content getContent()
    {
        return content;
    }

    public void setContent(Content content)
    {
        this.content = content;
    }

}
