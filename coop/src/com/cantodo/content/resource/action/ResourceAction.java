package com.cantodo.content.resource.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.base.frame.common.BaseAction;
import com.base.frame.model.DictBuss;
import com.base.frame.security.service.DictBussService;
import com.cantodo.content.dto.Resource;
import com.cantodo.content.resource.service.ResourceService;

/**
 * @author tdy
 */
@Controller("resourceAction")
@Scope("prototype")
public class ResourceAction extends BaseAction
{


    /**
     * [¼òÒªÃèÊö]:
     * @author tangdingyi
     */
    private static final long serialVersionUID = -6554581830311410572L;

    private Log logger = LogFactory.getLog(ResourceAction.class);

    @Autowired
    private ResourceService resourceServiceImpl;

    @Autowired
    private DictBussService dictBussImplService;

    private Resource resource;

    private List<DictBuss> listDictBuss;

  
   


    public Resource getResource()
    {
        return resource;
    }

    public void setResource(Resource resource)
    {
        this.resource = resource;
    }

    public String toLoadList()
    {
    	logger.debug("enter toLoadList");

        String type = request.getParameter("type");
        if("1".equals(type))
        {
            listDictBuss = dictBussImplService.listDictBuss(15);
        }
        if("2".equals(type))
        {
            listDictBuss = dictBussImplService.listDictBuss(16);
        }
        if("3".equals(type))
        {
            listDictBuss = dictBussImplService.listDictBuss(17);
        }
        if("4".equals(type))
        {
            listDictBuss = dictBussImplService.listDictBuss(18);
        }
        
        request.setAttribute("cctype", type);
        
  		
        logger.debug("exit toLoadList");
    	
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
		name = StringUtils.isBlank(name) ? null : "%"+name+"%";
		type = ("-1").equals(type) ? null : type;
		
		String cctype = request.getParameter("cctype");

		Map conditionMap = new HashMap();
		conditionMap.put("cname", name);
		conditionMap.put("ctype", type);
		conditionMap.put("cctype", cctype);
		conditionMap.put("offset", offset);
		conditionMap.put("rows", rows);

		String jsonData = resourceServiceImpl.getList(conditionMap,cctype);
		
  		
        logger.debug("exit getAjaxData");

		return toJsonData(jsonData);
    }

    public String loadEdit()
    {
    	
    	logger.debug("enter loadEdit");

        response.setHeader("Cache-Control", "no-cache");
        String cctype = request.getParameter("cctype");
        request.setAttribute("opt", "add");
        String contcode = UUID.randomUUID().toString();
        resource = new Resource();
        resource.setContcode(contcode);
        resource.setCreateDate(new Date());
        resource.setCtype(cctype);
        if("1".equals(cctype))
        {
            listDictBuss = dictBussImplService.listDictBuss(15);
        }
        if("2".equals(cctype))
        {
            listDictBuss = dictBussImplService.listDictBuss(16);
        }
        if("3".equals(cctype))
        {
            listDictBuss = dictBussImplService.listDictBuss(17);
        }
        if("4".equals(cctype))
        {
            listDictBuss = dictBussImplService.listDictBuss(18);
        }
        
  		
        logger.debug("exit loadEdit");
        return SUCCESS;
    }

    public String saveOrUpdate()
    {
    	logger.debug("===============enter saveOrUpdate===================");

        String opt = request.getParameter("opt"); 

        if (opt.equals("add"))
        {
        	resourceServiceImpl.add(resource);

        }
        if (opt.equals("edit"))
        {
        	resourceServiceImpl.update(resource);
        }
        
  		
        logger.debug("================exit saveOrUpdate===================");

        return success();
    }

    @SuppressWarnings("unchecked")
    public String getInfoById()
    {
    	logger.debug("enter getInfoById");

        String id = request.getParameter("id");
        String cctype = request.getParameter("cctype");
        String opt = request.getParameter("opt");
        if("1".equals(cctype))
        {
            listDictBuss = dictBussImplService.listDictBuss(15);
        }
        if("2".equals(cctype))
        {
            listDictBuss = dictBussImplService.listDictBuss(16);
        }
        if("3".equals(cctype))
        {
            listDictBuss = dictBussImplService.listDictBuss(17);
        }
        if("4".equals(cctype))
        {
            listDictBuss = dictBussImplService.listDictBuss(18);
        }

        try
        {
            Map conditionMap = new HashMap();
            conditionMap.put("id", id);
            conditionMap.put("cctype", cctype);
            resource = resourceServiceImpl.getInfoById(conditionMap);
        }
        catch (Exception e)
        {
            logger.debug("getInfoById()", e);

        }

        request.setAttribute("opt", "edit");

        if (opt.equals("edit"))
        {
      		
            logger.debug("exit getInfoById");
            return SUCCESS;
        }
        else
        {
      		
            logger.debug("exit getInfoById");
            return "view";
        }

    }
    
    

    public String delete()
    {

        String idarr = request.getParameter("ids");

        resourceServiceImpl.delete(idarr);

        return success();
    }

   

	public List<DictBuss> getListDictBuss() {
		return listDictBuss;
	}

	public void setListDictBuss(List<DictBuss> listDictBuss) {
		this.listDictBuss = listDictBuss;
	}



}
