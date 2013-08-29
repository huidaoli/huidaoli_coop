package com.cantodo.content.practiceresult.service.impl;

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
import com.cantodo.content.dto.PracticeResult;
import com.cantodo.content.persistence.PracticeResultMapper;
import com.cantodo.content.practiceresult.service.PracticeResultService;

@Service("practiceResultServiceImpl")
public class PracticeResultServiceImpl implements PracticeResultService
{

    private Log logger = LogFactory.getLog(PracticeResultServiceImpl.class);

    @Autowired
    private DictBussManager dictBussManager;

    @Autowired
    private PracticeResultMapper practiceResultMapper;


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
							List<DictBuss> listDictBuss = listDictBuss(24);
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
		List<PracticeResult> list = null;
		int total = 0;
		try {
			list = practiceResultMapper.getAllInfo(param);
			total = practiceResultMapper.getCounts(param);
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

    public void add(PracticeResult practiceResult)
    {
    	logger.debug("enter add");

    	practiceResultMapper.insert(practiceResult);
  		
        logger.debug("exit add");
    }
    
   

    public void update(PracticeResult practiceResult)
    {
    	logger.debug("enter update");

    	practiceResultMapper.update(practiceResult);
  		
        logger.debug("exit update");
    }

    public PracticeResult getInfoById(int id)
    {
    	logger.debug("enter getInfoById");
    	
    	PracticeResult r = practiceResultMapper.getInfoById(id);
  		
        logger.debug("exit getInfoById");
        return  r;
    }

    public void delete(String strids)
    {
    	logger.debug("enter delete");

        JSONArray jsonArray = JSONArray.fromObject(strids);

        int[] ids = (int[]) JSONArray.toArray(jsonArray, int.class);

        for (int id : ids)
        {
        	practiceResultMapper.delete(id);
        }
  		
        logger.debug("exit delete");
    }
    
    public List<PracticeResult> getAllInfo(Map pata)
    {
    	logger.debug("enter getAllInfo");
    	
    	List<PracticeResult>  r = practiceResultMapper.getAllInfo(pata);
  		
        logger.debug("exit getAllInfo");
    	return r;
    }
    
   
    
    public int getCounts2()
    {
    	logger.debug("enter getCounts2");
    	
    	int r = practiceResultMapper.getCounts2();
  		
        logger.debug("exit getCounts2");
    	return r;
    }




}
