package com.cantodo.content.front.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.base.frame.common.BaseAction;
import com.base.frame.model.DictBuss;
import com.base.frame.security.service.DictBussService;
import com.cantodo.content.ads.service.AdsService;
import com.cantodo.content.dto.Ads;
import com.cantodo.content.dto.Content;
import com.cantodo.content.dto.Information;
import com.cantodo.content.front.tool.PageUtil;
import com.cantodo.content.information.service.InformationService;
import com.cantodo.content.manacont.service.ManacontService;

/**
 * @author tdy ��̬԰��
 */
@Controller("gardensAction")
@Scope("prototype")
public class GardensAction extends BaseAction
{

    /**
     * 
     */
    private static final long serialVersionUID = 349892292577852567L;

    private Log logger = LogFactory.getLog(GardensAction.class);
    @Autowired
    private ManacontService manacontServiceImpl;
    
    @Autowired
    private AdsService adsServiceImpl;
    
    private Content content;
    
    public Content getContent()
    {
        return content;
    }


    public void setContent(Content content)
    {
        this.content = content;
    }

    /**
     * @return
     */
    public String toGraden()
    {

        logger.debug("enter toGraden");
        
        content = manacontServiceImpl.getInfoById(3);
        
        List<Ads> list1 = adsServiceImpl.getAllInfo2(1);
    	
    	List<Ads> list2 = adsServiceImpl.getAllInfo2(2);
    	
    	request.setAttribute("list1", list1);
    	
    	request.setAttribute("list2", list2);

        logger.debug("exit toGraden");
        return SUCCESS;
    }

}
