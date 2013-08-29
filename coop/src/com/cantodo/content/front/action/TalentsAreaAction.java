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
import com.base.frame.common.MessTool;
import com.base.frame.model.DictBuss;
import com.base.frame.security.service.DictBussService;
import com.cantodo.content.ads.service.AdsService;
import com.cantodo.content.dto.Ads;
import com.cantodo.content.dto.Content;
import com.cantodo.content.dto.MemClass;
import com.cantodo.content.dto.Member;
import com.cantodo.content.dto.OpenClass;
import com.cantodo.content.dto.Scrollinfo;
import com.cantodo.content.dto.TrainingResult;
import com.cantodo.content.dto.TrainingSys;
import com.cantodo.content.front.tool.PageUtil;
import com.cantodo.content.manacont.service.ManacontService;
import com.cantodo.content.member.service.MemberService;
import com.cantodo.content.openclass.service.OpenClassService;
import com.cantodo.content.scrollinfo.service.ScrollinfoService;
import com.cantodo.content.trainingresult.service.TrainingResultService;
import com.cantodo.content.trainingsys.service.TrainingSysService;

/**
 * @author tdy 人才专区
 */
@Controller("talentsAreaAction")
@Scope("prototype")
public class TalentsAreaAction extends BaseAction
{

    /**
     * [简要描述]:
     * 
     * @author tangdingyi
     */
    private static final long serialVersionUID = -8368416338781531792L;
    
    private Log logger = LogFactory.getLog(TalentsAreaAction.class);

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
    
    
    public String toTalentArea()
    {

        logger.debug("enter toTalentArea");
        
        List<Ads> list1 = adsServiceImpl.getAllInfo2(1);
    	
    	List<Ads> list2 = adsServiceImpl.getAllInfo2(2);
    	
    	request.setAttribute("list1", list1);
    	
    	request.setAttribute("list2", list2);

        content = manacontServiceImpl.getInfoById(8);

        logger.debug("exit toTalentArea");
        
        return SUCCESS;
    }

    
}
