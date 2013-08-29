package com.cantodo.content.openclass.action;

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
import com.base.frame.common.MessTool;
import com.base.frame.model.DictBuss;
import com.base.frame.security.service.DictBussService;
import com.cantodo.content.dto.Member;
import com.cantodo.content.dto.OpenClass;
import com.cantodo.content.member.service.MemberService;
import com.cantodo.content.openclass.service.OpenClassService;

/**
 * 
 * @author tdy
 *
 */
@Controller("openClassAction")
@Scope("prototype")
public class OpenClassAction extends BaseAction
{

    
    /**
	 * 
	 */
	private static final long serialVersionUID = -6928972050105492749L;

	private Log logger = LogFactory.getLog(OpenClassAction.class);

    @Autowired
    private OpenClassService openClassServiceImpl;
    
    @Autowired 
    private DictBussService dictBussImplService;
    
    private OpenClass openClass;
    
    private List<DictBuss> listDictBuss;
    
    private List<DictBuss> listDictBussxu;
    
    @Autowired
    private MemberService memberServiceImpl;


    public List<DictBuss> getListDictBuss()
    {
        return listDictBuss;
    }


    public void setListDictBuss(List<DictBuss> listDictBuss)
    {
        this.listDictBuss = listDictBuss;
    }
    
    
    public String getClassInfoList()
    {
    	listDictBuss = dictBussImplService.listDictBuss(3);
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
        
        
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        name = StringUtils.isBlank(name)?null:"%"+name+"%";
        type = ("-1").equals(type)?null:type;
        
        Map conditionMap = new HashMap();
        conditionMap.put("cname", name);
        conditionMap.put("ctype", type);
        conditionMap.put("offset", offset);
        conditionMap.put("rows", rows);
        
        String jsonData = openClassServiceImpl.searchClassInfos(conditionMap);
        
  		
        logger.debug("exit getAjaxData");

        return toJsonData(jsonData);
    }
    
    public String loadOpenClass()
    {
    	logger.debug("enter loadOpenClass");

    	
    	response.setHeader("Cache-Control", "no-cache");
        request.setAttribute("opt", "add");
        String contcode = UUID.randomUUID().toString();
        openClass = new OpenClass();
        openClass.setContcode(contcode);
        openClass.setSumnum(30);
        listDictBuss = dictBussImplService.listDictBuss(3);
  		
        logger.debug("exit loadOpenClass");
        
    	return SUCCESS;
    }
    
    
    public String saveOpenClass()
    {
    	logger.debug("enter saveOpenClass");


        String opt = request.getParameter("opt");
        

        if (opt.equals("add"))
        {
        	openClassServiceImpl.addOpenClass(openClass);
            
        }
        if (opt.equals("edit"))
        {
        	openClassServiceImpl.updateOpenClass(openClass);
        }
  		
        logger.debug("exit saveOpenClass");
       
        return success();
    }
    
    @SuppressWarnings("unchecked")
    public String loadOpenClassInfoById()
    {
    	logger.debug("enter loadOpenClassInfoById");


        String id = request.getParameter("id");
        String opt = request.getParameter("opt");
        listDictBuss = dictBussImplService.listDictBuss(3);

        try {
			this.openClass = openClassServiceImpl.findOpenClass(Integer.parseInt(id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        request.setAttribute("opt", "edit");

        if (opt.equals("edit"))
        {
      		
            logger.debug("exit loadOpenClassInfoById");
            return SUCCESS;
        }
        else
        {
      		
            logger.debug("exit loadOpenClassInfoById");
            return "view";
        }

    }
    
    public String getMemByClassId()
    {
    	logger.debug("enter getMemByClassId");

    	
        response.setHeader("Cache-Control", "no-cache");
        
        String classid = request.getParameter("classid");
       
        listDictBussxu = dictBussImplService.listDictBuss(11);
        request.setAttribute("classid", classid);
        
  		
        logger.debug("exit getMemByClassId");
        
        return SUCCESS;
    }
    
    
//    @SuppressWarnings("unchecked")
//    public String checkState()
//    {
//       
//        return SUCCESS;
//    }
    
    @SuppressWarnings("unchecked")
    public String saveState()
    {
    	logger.debug("enter saveState");

    	
        String id = request.getParameter("id");
        String sclassid = request.getParameter("classid");
        int classid = NumberUtils.toInt(sclassid,0);
        String state = request.getParameter("state");
        
        //如果是审核通过，需检查本班人数
        String remark = request.getParameter("remark");
        Map conditionMap = new HashMap();
        conditionMap.put("state", state);
        conditionMap.put("remark", remark);
        conditionMap.put("memid", id);
        conditionMap.put("classid", classid);
        openClassServiceImpl.saveState(conditionMap);
        
  		
        logger.debug("exit saveState");
        
        return result(true, sclassid);
    }
    
    
    
    public String deleteOpenClasss()
    {

    	logger.debug("enter deleteOpenClasss");

        String idarr = request.getParameter("ids");
        
        openClassServiceImpl.deleteOpenClasss(idarr);
        
  		
        logger.debug("exit deleteOpenClasss");
        
        return success();
    }
    
    


	public OpenClass getOpenClass() {
		return openClass;
	}


	public void setOpenClass(OpenClass openClass) {
		this.openClass = openClass;
	}


    public List<DictBuss> getListDictBussxu()
    {
        return listDictBussxu;
    }


    public void setListDictBussxu(List<DictBuss> listDictBussxu)
    {
        this.listDictBussxu = listDictBussxu;
    }


}
