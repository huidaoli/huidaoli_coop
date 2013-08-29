package com.cantodo.content.practiceresult.action;

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
import com.cantodo.content.dto.PracticeResult;
import com.cantodo.content.practiceresult.service.PracticeResultService;

/**
 * @author tdy
 */
@Controller("practiceResultAction")
@Scope("prototype")
public class PracticeResultAction extends BaseAction
{

    /**
     * [¼òÒªÃèÊö]:
     * @author tangdingyi
     */

    /**
	 * 
	 */

	/**
     * [¼òÒªÃèÊö]:
     * @author tangdingyi
     */
    private static final long serialVersionUID = 205269063032101058L;

    /**
     * 
     */

    private Log logger = LogFactory.getLog(PracticeResultAction.class);

    @Autowired
    private PracticeResultService practiceResultServiceImpl;

    @Autowired
    private DictBussService dictBussImplService;

    private PracticeResult practiceResult;

    private List<DictBuss> listDictBuss;

    public PracticeResult getPracticeResult()
    {
        return practiceResult;
    }

    public void setPracticeResult(PracticeResult practiceResult)
    {
        this.practiceResult = practiceResult;
    }

    public String toLoadList()
    {
    	listDictBuss = dictBussImplService.listDictBuss(24);
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

		String jsonData = practiceResultServiceImpl.getList(conditionMap);
		
  		
        logger.debug("exit getAjaxData");

		return toJsonData(jsonData);
    }

    public String loadEdit()
    {
    	logger.debug("enter loadEdit");

        response.setHeader("Cache-Control", "no-cache");
        request.setAttribute("opt", "add");
        String contcode = UUID.randomUUID().toString();
        practiceResult = new PracticeResult();
        practiceResult.setContcode(contcode);
        practiceResult.setCreateDate(new Date());
        listDictBuss = dictBussImplService.listDictBuss(24);
        
  		
        logger.debug("exit loadEdit");
        return SUCCESS;
    }

    public String saveOrUpdate()
    {
    	logger.debug("enter saveOrUpdate");

        String opt = request.getParameter("opt");

        if (opt.equals("add"))
        {
            practiceResultServiceImpl.add(practiceResult);

        }
        if (opt.equals("edit"))
        {
            practiceResultServiceImpl.update(practiceResult);
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
        listDictBuss = dictBussImplService.listDictBuss(24);

        try
        {
            practiceResult = practiceResultServiceImpl.getInfoById(Integer.parseInt(id));
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
    	logger.debug("enter delete");

        String idarr = request.getParameter("ids");

        practiceResultServiceImpl.delete(idarr);
        
  		
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
