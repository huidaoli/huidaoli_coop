package com.cantodo.content.bussdict.action;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.base.frame.common.BaseAction;
import com.base.frame.model.DictBuss;
import com.cantodo.content.bussdict.service.BussdictService;

/**
 * @author tdy
 */
@Controller("bussdictAction")
@Scope("prototype")
public class BussdictAction extends BaseAction
{

    /**
     * [¼òÒªÃèÊö]:
     * 
     * @author tangdingyi
     */
    private static final long serialVersionUID = -7001674431027239274L;

    /**
     * [¼òÒªÃèÊö]:
     * 
     * @author tangdingyi
     */

    private Log logger = LogFactory.getLog(BussdictAction.class);

    @Autowired
    private BussdictService bussdictServiceImpl;

    private DictBuss dictBuss;

    private List<DictBuss> listDB;

    public List<DictBuss> getListDB()
    {
        return listDB;
    }

    public void setListDB(List<DictBuss> listDB)
    {
        this.listDB = listDB;
    }

    public DictBuss getDictBuss()
    {
        return dictBuss;
    }

    public void setDictBuss(DictBuss dictBuss)
    {
        this.dictBuss = dictBuss;
    }

    public String toLoadList()
    {
        logger.debug("enter toLoadList");

        logger.debug("exit toLoadList");

        return SUCCESS;
    }

    @SuppressWarnings("unchecked")
    public String getAjaxData()
    {
        logger.debug("enter getAjaxData");

        response.setHeader("Cache-Control", "no-cache");

        String jsonData = bussdictServiceImpl.getList(null, "");

        logger.debug("exit getAjaxData");

        return toJsonData(jsonData);
    }

    public String save()
    {
        logger.debug("enter toLoadList");

        String jsonData = request.getParameter("jsonData");

        bussdictServiceImpl.save(jsonData);

        logger.debug("exit toLoadList");

        return success();
    }

    public String getInfoById()
    {
        
        int defaultindex = 15;
        String id = request.getParameter("id");
        
        if("17".equals(id))
        {
            defaultindex = 50;
        }
        
        request.setAttribute("id", id);

        int type = NumberUtils.toInt(id, 0);

        listDB = bussdictServiceImpl.listDictBuss(type);

        int len = listDB.size();

        if (listDB.size() < defaultindex)
        {
            for (int i = 0; i < (defaultindex - len); i++)
            {
                listDB.add(new DictBuss());
            }
        }

        return SUCCESS;
    }

    public String saveCont()
    {
        String[] ids = request.getParameterValues("id");
        String[] dictIds = request.getParameterValues("dictId");
        String[] dictNames = request.getParameterValues("dictName");
        String typeid = request.getParameter("typeid");
        bussdictServiceImpl.savecont(ids, dictIds, dictNames, typeid);
        return success();
    }
}
