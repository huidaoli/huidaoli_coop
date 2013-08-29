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
import com.cantodo.content.dto.MemProject;
import com.cantodo.content.dto.Member;
import com.cantodo.content.dto.Project;
import com.cantodo.content.dto.RandDResult;
import com.cantodo.content.dto.RandDSys;
import com.cantodo.content.dto.Scrollinfo;
import com.cantodo.content.front.tool.PageUtil;
import com.cantodo.content.manacont.service.ManacontService;
import com.cantodo.content.member.service.MemberService;
import com.cantodo.content.project.service.ProjectService;
import com.cantodo.content.randdresult.service.RandDResultService;
import com.cantodo.content.randdsys.service.RandDSysService;
import com.cantodo.content.scrollinfo.service.ScrollinfoService;

/**
 * @author tdy 项目专区
 */
@Controller("projectAreaAction")
@Scope("prototype")
public class ProjectAreaAction extends BaseAction
{

    /**
     * 
     */
    private static final long serialVersionUID = 1073898189563129791L;

    private Log logger = LogFactory.getLog(ProjectAreaAction.class);

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
     * @return
     */
    public String toProjectArea()
    {

        logger.debug("enter toProjectArea");

        content = manacontServiceImpl.getInfoById(7);
        
        List<Ads> list1 = adsServiceImpl.getAllInfo2(1);
    	
    	List<Ads> list2 = adsServiceImpl.getAllInfo2(2);
    	
    	request.setAttribute("list1", list1);
    	
    	request.setAttribute("list2", list2);

        logger.debug("exit toProjectArea");

        return SUCCESS;
    }

}
