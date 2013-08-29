package com.cantodo.content.agreement.action;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.base.frame.common.BaseAction;
import com.base.frame.model.DictBuss;
import com.base.frame.security.service.DictBussService;
import com.cantodo.content.agreement.service.AgreementService;
import com.cantodo.content.dto.Agreement;
import com.cantodo.content.member.action.MemberAction;

/**
 * @author tdy
 */
@Controller("agreementAction")
@Scope("prototype")
public class AgreementAction extends BaseAction
{

    /**
     * 
     */
    private static final long serialVersionUID = 2984477075531599967L;

    private Log logger = LogFactory.getLog(MemberAction.class);

    @Autowired
    private AgreementService agreementServiceImpl;
    
    @Autowired
    private DictBussService dictBussImplService;

    private Agreement agreement;

    private List<DictBuss> typelist;
    
    public Agreement getAgreement()
    {
        return agreement;
    }

    public void setAgreement(Agreement agreement)
    {
        this.agreement = agreement;
    }

    public List<DictBuss> getTypelist()
    {
        return typelist;
    }

    public void setTypelist(List<DictBuss> typelist)
    {
        this.typelist = typelist;
    }


    public String toLoadList()
    {
        
        typelist = dictBussImplService.listDictBuss(18);
        
        return SUCCESS;
    }

    @SuppressWarnings("unchecked")
    public String getAjaxData()
    {

        logger.debug("enter getAjaxData");

        response.setHeader("Cache-Control", "no-cache");

        String strpage = request.getParameter("page");

        String strrows = request.getParameter("rows");

        int rows = Integer.parseInt(strrows);

        int offset = (Integer.parseInt(strpage) - 1) * rows;
        String title = request.getParameter("title");
        String type = request.getParameter("type");
        String state = request.getParameter("state");
        title = StringUtils.isBlank(title) ? null : "%" + title + "%";
        type = ("").equals(type) ? null : type;
        state = ("").equals(state) ? null : state;

        Map conditionMap = new HashMap();
        conditionMap.put("title", title);
        conditionMap.put("type", type);
        conditionMap.put("state", state);
        
        conditionMap.put("offset", offset);
        conditionMap.put("rows", rows);

        String jsonData = agreementServiceImpl.getList(conditionMap);

        logger.debug("exit getAjaxData");

        return toJsonData(jsonData);
    }

    public String loadEdit()
    {

        logger.debug("enter  loadEdit");

        response.setHeader("Cache-Control", "no-cache");
        request.setAttribute("opt", "add");
        typelist = dictBussImplService.listDictBuss(18);

        logger.debug("exit  loadEdit");

        return SUCCESS;
    }
    
    
    public String getAgreeByType()
    {

        String type = request.getParameter("type");
        
        agreement = new Agreement();
        agreement.setCreateDate(new Date());
        agreement.setCode(UUID.randomUUID().toString());
        agreement.setType(NumberUtils.toInt(type,0));
        
        if("1".equals(type))
        {
            return "caigou";
        } 
        else if("2".equals(type))
        {
            return "jiameng";
        }
        else
        {
            return SUCCESS;
        }
        
    }


    public String saveOrUpdate()
    {
        logger.debug("enter saveOrUpdate");
        
        boolean flag = true;

        String opt = request.getParameter("opt");

        try
        {
            if (opt.equals("add"))
            {
                agreementServiceImpl.add(agreement);

            }
            if (opt.equals("edit"))
            {
                agreementServiceImpl.update(agreement);
            }
        }
        catch (RuntimeException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            flag = false;
        }

        logger.debug("exit saveOrUpdate");

        return result(flag);
    }

    @SuppressWarnings("unchecked")
    public String getInfoById()
    {

        logger.debug("enter getInfoById");

        String sid = request.getParameter("id");
        
        String type = request.getParameter("type");
        
        request.setAttribute("cooparatype", type);
        
        
        
        int id = Integer.parseInt(sid);
        String opt = request.getParameter("opt");
        request.setAttribute("opt",opt);
        try
        {
            agreement = agreementServiceImpl.getInfoById(id);

        }
        catch (Exception e)
        {
            logger.debug("getInfoById()", e);

        }
        
        if("print".equals(opt))
        {
        	return "printcaigou";
        }
 
        //≤…π∫∫œÕ¨
        if("1".equals(type))
        {
            return "viewcaigou";            	
        }
        return SUCCESS;

    }
    
    /**
     * [ºÚ“™√Ë ˆ]:<br/> [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String stateOpt()
    {

        String idarr = request.getParameter("ids");

        String statestr = request.getParameter("state");

        int state = NumberUtils.toInt(statestr, 0);

        agreementServiceImpl.stateOpt(idarr, state);

        return success();

    }
    
    
    /**
     * 
     * [ºÚ“™√Ë ˆ]:<br/>
     * [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String passAgree()
    {

        String id = request.getParameter("id");

        int res =agreementServiceImpl.passAgree(id);

        try
        {
            response.getWriter().println(res);
        }
        catch (IOException e)
        {
            logger.error("getResponse().getWriter().println error.", e);
        }
        
        return null;
    }
    
    /**
     * 
     * [ºÚ“™√Ë ˆ]:<br/>
     * [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String checkState()
    {

        String id = request.getParameter("id");

        int res =agreementServiceImpl.checkState(id);

        try
        {
            response.getWriter().println(res);
        }
        catch (IOException e)
        {
            logger.error("getResponse().getWriter().println error.", e);
        }
        
        return null;
    }
    
    


    /**
     * 
     * [ºÚ“™√Ë ˆ]:<br/>
     * [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String delete()
    {
        logger.debug("enter delete");

        String idarr = request.getParameter("ids");

        agreementServiceImpl.delete(idarr);

        logger.debug("exit delete");

        return success();
    }


}
