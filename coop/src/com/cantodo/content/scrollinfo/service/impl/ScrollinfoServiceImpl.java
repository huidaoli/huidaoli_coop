package com.cantodo.content.scrollinfo.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.frame.model.DictBuss;
import com.cantodo.content.dto.Scrollinfo;
import com.cantodo.content.persistence.AttaMapper;
import com.cantodo.content.persistence.ScrollinfoMapper;
import com.cantodo.content.scrollinfo.service.ScrollinfoService;

@Service("scrollinfoServiceImpl")
public class ScrollinfoServiceImpl implements ScrollinfoService
{

    private Log logger = LogFactory.getLog(ScrollinfoServiceImpl.class);


    @Autowired
    private ScrollinfoMapper scrollinfoMapper;
    
    @Autowired
    private AttaMapper attaMapper;
    
    
    


    @Override
    @SuppressWarnings("unchecked")
    public String getList(Map param, String type)
    {
    	logger.debug("enter getList");


        JsonConfig jsonConfig = new JsonConfig();

        // 处理属性为Date类型
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonValueProcessor()
        {
            public Object processArrayValue(Object value, JsonConfig jsonConfig)
            {
                if (value == null)
                {
                    return "";
                }
                return value;
            }

            public Object processObjectValue(String key, Object value, JsonConfig jsonConfig)
            {

                if (key.equals("createDate"))
                {
                    if (null == value)
                    {
                        return "";
                    }
                    String res = DateFormatUtils.format((Date) value, "yyyy-MM-dd");

                    return res;
                }

                return value;

            }

        });

        Map result = new HashMap();
        List<Scrollinfo> list = null;
        int total = 0;
        try
        {
            list = scrollinfoMapper.getAllInfo(param);
            total = scrollinfoMapper.getCounts(param);
        }
        catch (RuntimeException e1)
        {
            logger.debug("", e1);
        }
       // System.out.println(list.size());

        result.put("total", total);
        result.put("rows", list);

        String s = "";
        try
        {
            s = JSONObject.fromObject(result, jsonConfig).toString();
        }
        catch (DataAccessException e)
        {
            logger.error("JSONObject.fromObject(result,jsonConfig).toString()", e);
        }
        
  		
        logger.debug("exit getList");
        return s;

    }

    public void add(Scrollinfo scrollinfo)
    {
    	logger.debug("enter add");


        try
        {
            scrollinfoMapper.insert(scrollinfo);
        }
        catch (RuntimeException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
  		
        logger.debug("exit add");
    }

    @Transactional
    public void update(Scrollinfo scrollinfo)
    {
    	logger.debug("enter update");

        attaMapper.deleteContent(scrollinfo.getContcode());
        scrollinfoMapper.update(scrollinfo);
  		
        logger.debug("exit update");
    }

    public Scrollinfo getInfoById(Map map)
    {
    	logger.debug("enter getInfoById");
    	
    	Scrollinfo s = scrollinfoMapper.getInfoById(map);
  		
        logger.debug("exit getInfoById");
        return s;
    }

    public void delete(String strids)
    {
    	logger.debug("enter delete");

        JSONArray jsonArray = JSONArray.fromObject(strids);

        int[] ids = (int[]) JSONArray.toArray(jsonArray, int.class);

        for (int id : ids)
        {
            scrollinfoMapper.delete(id);
        }
  		
        logger.debug("exit delete");
    }

    public List<Scrollinfo> getAllInfo(Map pata)
    {
    	logger.debug("enter getAllInfo");
    	
    	 List<Scrollinfo> ls = scrollinfoMapper.getAllInfo(pata);
  		
        logger.debug("exit getAllInfo");
        return ls;
    }


    // )
    public int getCounts2(String cctype)
    {
    	logger.debug("enter getCounts2");
    	
    	int s= scrollinfoMapper.getCounts2(cctype);
  		
        logger.debug("exit getCounts2");
        return s;
    }

    @Override
    public int getCounts3(String name)
    {
    	logger.debug("enter getCounts3");

        int res = 0;
        try
        {
            res = scrollinfoMapper.getCounts3(name);
        }
        catch (RuntimeException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
  		
        logger.debug("exit getCounts3");
        return res;
    }

    @Override
    public List<Scrollinfo> getAllInfoSearch(String type)
    {
    	logger.debug("enter getAllInfoSearch");
    	
    	 List<Scrollinfo> ls = scrollinfoMapper.getAllInfoSearch(type);
  		
        logger.debug("exit getAllInfoSearch");
        return ls;
    }


}
