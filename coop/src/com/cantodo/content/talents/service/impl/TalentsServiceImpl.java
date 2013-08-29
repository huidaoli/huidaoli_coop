package com.cantodo.content.talents.service.impl;

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

import com.base.frame.dao.DictBussManager;
import com.base.frame.model.DictBuss;
import com.cantodo.content.dto.Talents;
import com.cantodo.content.persistence.TalentsMapper;
import com.cantodo.content.talents.service.TalentsService;

@Service("talentsServiceImpl")
public class TalentsServiceImpl implements TalentsService
{

    private Log logger = LogFactory.getLog(TalentsServiceImpl.class);

    @Autowired
    private DictBussManager dictBussManager;

    @Autowired
    private TalentsMapper talentsMapper;


    private List<DictBuss> listDictBuss(int type)
    {
        return dictBussManager.listDictBuss(type);
    }


    @Override
    @SuppressWarnings("unchecked")
    public String getList(Map param)
    {
    	logger.debug("enter getList");

    	JsonConfig jsonConfig = new JsonConfig();

		// 处理属性为Date类型
		jsonConfig.registerJsonValueProcessor(Date.class,
				new JsonValueProcessor() {
					public Object processArrayValue(Object value,
							JsonConfig jsonConfig) {
						if (value == null) {
							return "";
						}
						return value;
					}

					public Object processObjectValue(String key, Object value,
							JsonConfig jsonConfig) {

						if (key.equals("createDate")) {
							if (null == value) {
								return "";
							}
							String res = DateFormatUtils.format((Date) value,
									"yyyy-MM-dd");

							return res;
						}

						return value;

					}

				});

		jsonConfig.registerJsonValueProcessor(int.class,
				new JsonValueProcessor() {
					public Object processArrayValue(Object value,
							JsonConfig jsonConfig) {
						if (value == null) {
							return "";
						}
						return value;
					}

					public Object processObjectValue(String key, Object value,
							JsonConfig jsonConfig) {

						if (key.equals("type")) {
							if (null == value) {
								return "";
							}
							String res = "";
							List<DictBuss> listDictBuss = listDictBuss(8);
							for (DictBuss db : listDictBuss) {
								if (db.getDictId() == Integer.parseInt(value
										.toString())) {
									return db.getDictName();
								}
							}

							return res;
						}

						return value;

					}

				});
		Map result = new HashMap();
		List<Talents> list = null;
		int total = 0;
		try {
			list = talentsMapper.getAllInfo(param);
			total = talentsMapper.getCounts(param);
		} catch (RuntimeException e1) {
			logger.debug("",e1);
		}
		//System.out.println(list.size());

		result.put("total", total);
		result.put("rows", list);

		String s = "";
		try {
			s = JSONObject.fromObject(result, jsonConfig).toString();
		} catch (DataAccessException e) {
			logger.error("JSONObject.fromObject(result,jsonConfig).toString()",
					e);
		}
  		
        logger.debug("exit getList");
		return s;

    }
    
    public 	 List<Talents> getAllList(Map param)
    {
    	logger.debug("enter getAllList");
    	
    	 List<Talents> r =  talentsMapper.getAllInfo(param);
  		
        logger.debug("exit getAllList");
    	return r;
    }

    public void add(Talents talents)
    {
    	logger.debug("enter add");

        talentsMapper.insert(talents);
  		
        logger.debug("exit add");
    }
    
   

    public void update(Talents talents)
    {
    	logger.debug("enter update");

        talentsMapper.update(talents);
  		
        logger.debug("exit update");
    }

    public Talents getInfoById(int id)
    {
    	logger.debug("enter getInfoById");
    	
    	Talents r=  talentsMapper.getInfoById(id);
  		
        logger.debug("exit getInfoById");
        return r;
    }

    public void delete(String strids)
    {
    	logger.debug("enter delete");

        JSONArray jsonArray = JSONArray.fromObject(strids);

        int[] ids = (int[]) JSONArray.toArray(jsonArray, int.class);

        for (int id : ids)
        {
            talentsMapper.delete(id);
        }
  		
        logger.debug("exit delete");
    }
    
    public int getCounts2()
  	{
    	logger.debug("enter getCounts2");
    	
    	int r =  talentsMapper.getCounts2();
  		
        logger.debug("exit getCounts2");
  		return r;
  	}
    
    public List<Talents> getAllInfo(Map pata)
    {
    	logger.debug("enter getAllInfo");
    	
    	List<Talents> t = talentsMapper.getAllInfo(pata);
  		
        logger.debug("exit getAllInfo");
    	return t;
    }


}
