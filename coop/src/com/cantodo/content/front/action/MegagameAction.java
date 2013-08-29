package com.cantodo.content.front.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.base.frame.common.BaseAction;
import com.cantodo.content.ads.service.AdsService;
import com.cantodo.content.dto.Ads;
import com.cantodo.content.dto.Content;
import com.cantodo.content.manacont.service.ManacontService;

/**
 * 
 * @author tdy
 * 大赛赛场
 */
@Controller("megagameAction")
@Scope("prototype")
public class MegagameAction extends BaseAction
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7091757674706665888L;
	
    private Log logger = LogFactory.getLog(MegagameAction.class);
    
    @Autowired
    private ManacontService manacontServiceImpl;
    
    private Content content;
    
    @Autowired
    private AdsService adsServiceImpl;
    
    public Content getContent()
    {
        return content;
    }


    public void setContent(Content content)
    {
        this.content = content;
    }
    
    


	/**
	 * 
	 * @return
	 */
	public String toMegagame()
	{
		
    	logger.debug("enter toMegagame");
    	
    	content = manacontServiceImpl.getInfoById(2);
    	
        List<Ads> list1 = adsServiceImpl.getAllInfo2(1);
    	
    	List<Ads> list2 = adsServiceImpl.getAllInfo2(2);
    	
    	request.setAttribute("list1", list1);
    	
    	request.setAttribute("list2", list2);
  		
        logger.debug("exit toMegagame");
		
		return SUCCESS;
	}


    


}
