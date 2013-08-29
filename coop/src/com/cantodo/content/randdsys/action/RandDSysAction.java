package com.cantodo.content.randdsys.action;

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
import com.cantodo.content.dto.RandDSys;
import com.cantodo.content.randdsys.service.RandDSysService;
import com.cantodo.content.trainingsys.service.Tool;

/**
 * @author tdy
 */
@Controller("randdsysAction")
@Scope("prototype")
public class RandDSysAction extends BaseAction
{

    /**
     * 
     */
    private static final long serialVersionUID = -6928972050105492749L;

    private Log logger = LogFactory.getLog(RandDSysAction.class);

    @Autowired
    private RandDSysService randDSysServiceImpl;

    @Autowired
    private DictBussService dictBussImplService;

    private RandDSys randDSys;

    private List<DictBuss> listDictBuss;
    
    

  
   

    public RandDSys getRandDSys()
    {
        return randDSys;
    }

    public void setRandDSys(RandDSys randDSys)
    {
        this.randDSys = randDSys;
    }

    public String toLoadList()
    {
    	listDictBuss = dictBussImplService.listDictBuss(13);
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

		Map conditionMap = new HashMap();
		conditionMap.put("cname", name);
		conditionMap.put("ctype", type);
		conditionMap.put("offset", offset);
		conditionMap.put("rows", rows);

		String jsonData = randDSysServiceImpl.getList(conditionMap);
		
  		
        logger.debug("exit getAjaxData");

		return toJsonData(jsonData);
    }

    public String loadEdit()
    {
    	
    	logger.debug("enter loadEdit");

        response.setHeader("Cache-Control", "no-cache");
        request.setAttribute("opt", "add");
        String contcode = UUID.randomUUID().toString();
        randDSys = new RandDSys();
        randDSys.setContcode(contcode);
        randDSys.setCreateDate(new Date());
        listDictBuss = dictBussImplService.listDictBuss(13);
        
  		
        logger.debug("exit loadEdit");
        return SUCCESS;
    }

    public String saveOrUpdate()
    {
    	logger.debug("enter saveOrUpdate");

        String opt = request.getParameter("opt");

        if (opt.equals("add"))
        {
            randDSysServiceImpl.add(randDSys);

        }
        if (opt.equals("edit"))
        {
            randDSysServiceImpl.update(randDSys);
        }
        
  		
        logger.debug("exit saveOrUpdate");

        return success();
    }

    @SuppressWarnings("unchecked")
    public String getInfoById()
    {
    	logger.debug("enter getInfoById");

        String id = request.getParameter("id");
        String opt = request.getParameter("opt");
        listDictBuss = dictBussImplService.listDictBuss(13);

        try
        {
            randDSys = randDSysServiceImpl.getInfoById(Integer.parseInt(id));
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
    
    
    @SuppressWarnings("unchecked")
    public String getImgsById()
    {
    	logger.debug("enter getImgsById");

        String id = request.getParameter("id");
        List<Map> list = null;
        
        try
        {
        	list = randDSysServiceImpl.getImgsById(Integer.parseInt(id));


            if (!(null == list || list.size() == 0))
            {
                Map smap = list.get(0);

                String imgid = (String) smap.get("attaid");

                String imgName = (String) smap.get("newname");

                int width = (Integer) smap.get("width");

                int height = (Integer) smap.get("height");
                
                List divlist = randDSysServiceImpl.getDivInfo(imgid);

                String div = Tool.createTable(imgName, new int[] {width, height},divlist,2);

                request.setAttribute("divs", div);
            }

        }
        catch (Exception e)
        {
            logger.debug("getInfoById()", e);

        }
        
        request.setAttribute("list", list);
  		
        logger.debug("exit getImgsById");

        return SUCCESS;

    }

    public String delete()
    {
    	logger.debug("enter delete");

        String idarr = request.getParameter("ids");

        randDSysServiceImpl.delete(idarr);
        
  		
        logger.debug("exit delete");

        return success();
    }

   

	public List<DictBuss> getListDictBuss() {
		return listDictBuss;
	}

	public void setListDictBuss(List<DictBuss> listDictBuss) {
		this.listDictBuss = listDictBuss;
	}


}
