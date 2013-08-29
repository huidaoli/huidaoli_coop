package com.cantodo.content.trainingsys.service.impl;

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
import com.cantodo.content.dto.Atta;
import com.cantodo.content.dto.Divproper;
import com.cantodo.content.dto.TrainingSys;
import com.cantodo.content.persistence.AttaMapper;
import com.cantodo.content.persistence.DivproperMapper;
import com.cantodo.content.persistence.TrainingSysMapper;
import com.cantodo.content.trainingsys.service.TrainingSysService;

@Service("trainingSysServiceImpl")
public class TrainingSysServiceImpl implements TrainingSysService
{

    private Log logger = LogFactory.getLog(TrainingSysServiceImpl.class);

    @Autowired
    private DictBussManager dictBussManager;

    @Autowired
    private TrainingSysMapper trainingSysMapper;
    
    @Autowired
    private DivproperMapper divproperMapper;
    
    
    @Autowired
    private AttaMapper attaMapper;


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
							List<DictBuss> listDictBuss = listDictBuss(10);
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
		List<TrainingSys> list = null;
		int total = 0;
		try {
			list = trainingSysMapper.getAllInfo(param);
			total = trainingSysMapper.getCounts(param);
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

    public void add(TrainingSys trainingSys)
    {
    	logger.debug("enter add");

    	trainingSysMapper.insert(trainingSys);
  		
        logger.debug("exit add");
    }
    
   

    public void update(TrainingSys trainingSys)
    {
    	logger.debug("enter update");

    	trainingSysMapper.update(trainingSys);
  		
        logger.debug("exit update");
    }

    public TrainingSys getInfoById(int id)
    {
    	logger.debug("enter getInfoById");
    	
    	TrainingSys r =trainingSysMapper.getInfoById(id);
  		
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
        	trainingSysMapper.delete(id);
        }
  		
        logger.debug("exit delete");
    }
    
    public List<TrainingSys> getAllInfo(Map pata)
    {
    	logger.debug("enter about");
    	
    	 List<TrainingSys> r =  trainingSysMapper.getAllInfo(pata);
  		
        logger.debug("exit about");
    	return r;
    }
    
    public List<Map> getImgsById(int id)
    {
    	logger.debug("enter getImgsById");
    	
    	List<Map> lm = trainingSysMapper.getImgsById(id);
  		
        logger.debug("exit getImgsById");
    	return lm;
    }
    
    public int getCounts2()
    {
    	logger.debug("enter getCounts2");
    	
    	int r =  trainingSysMapper.getCounts2();
  		
        logger.debug("exit getCounts2");
    	return r;
    }
    
    public void insert(Divproper divproper)
    {
    	logger.debug("enter insert");

        divproperMapper.insert(divproper);
  		
        logger.debug("exit insert");
    }
    
    public List<Divproper> getDivInfo(String id)
    {
    	logger.debug("enter getDivInfo");
    	
    	 List<Divproper>  ld = divproperMapper.getDivInfo(id);
  		
        logger.debug("exit getDivInfo");
        return ld;
    }
    
    public List<Atta> getAttaByImgId(String imgid)
    {
    	logger.debug("enter getAttaByImgId");
    	
    	 List<Atta> la = attaMapper.getAttaByImgId(imgid);
  		
        logger.debug("exit getAttaByImgId");
        return la;
    }
    
    public void deleteImg(String imgid)
    {
    	logger.debug("enter deleteImg");

        divproperMapper.delete(imgid);
  		
        logger.debug("exit deleteImg");
    }


}
