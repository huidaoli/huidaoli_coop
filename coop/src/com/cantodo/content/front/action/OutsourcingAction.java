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
import com.cantodo.content.dto.Resource;
import com.cantodo.content.front.tool.PageUtil;
import com.cantodo.content.resource.service.ResourceService;

/**
 * @author tdy 外包市场
 */
@Controller("outsourcingAction")
@Scope("prototype")
public class OutsourcingAction extends BaseAction
{

    /**
     * 
     */
    private static final long serialVersionUID = 4842643897615385181L;

    private Log logger = LogFactory.getLog(OutsourcingAction.class);

    @Autowired
    private ResourceService resourceServiceImpl;

    @Autowired
    private DictBussService dictBussImplService;

    private List<DictBuss> listDictBuss;
    
    @Autowired
    private AdsService adsServiceImpl;

    public List<DictBuss> getListDictBuss()
    {
        return listDictBuss;
    }

    public void setListDictBuss(List<DictBuss> listDictBuss)
    {
        this.listDictBuss = listDictBuss;
    }

    /**
     * @return
     */
    public String toOutsourcing()
    {

        logger.debug("enter toOutsourcing");
        
        List<Ads> list1 = adsServiceImpl.getAllInfo2(1);
    	
    	List<Ads> list2 = adsServiceImpl.getAllInfo2(2);
    	
    	request.setAttribute("list1", list1);
    	
    	request.setAttribute("list2", list2);

        logger.debug("exit toOutsourcing");

        return SUCCESS;
    }

    public String tobussres()
    {

        logger.debug("enter toOutsourcing");

        response.setHeader("Cache-Control", "no-cache");

        String cctype = "1";

        int pages = NumberUtils.toInt(request.getParameter("pages"), 1);

        int count = resourceServiceImpl.getCounts2(cctype);

        Map<String, Object> res = PageUtil.processPage(pages, count, 10, 5, "2");

        Map conditionMap = new HashMap();
        conditionMap.put("cname", null);
        conditionMap.put("ctype", null);
        conditionMap.put("cctype", cctype);
        conditionMap.put("offset", res.get("recordbegin"));
        conditionMap.put("rows", res.get("pagesize"));

        listDictBuss = dictBussImplService.listDictBuss(15);

        List<Resource> list = resourceServiceImpl.getAllInfo(conditionMap);

        request.setAttribute("list", list);

        request.setAttribute("pageHtml", res.get("pageHtml"));

        logger.debug("exit toOutsourcing");

        return SUCCESS;
    }

}
