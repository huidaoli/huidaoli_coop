package com.cantodo.content.openclass.service.impl;

import java.text.SimpleDateFormat;
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
import com.cantodo.content.dto.OpenClass;
import com.cantodo.content.openclass.service.OpenClassService;
import com.cantodo.content.persistence.MemClassMapper;
import com.cantodo.content.persistence.OpenClassMapper;

@Service("openClassServiceImpl")
public class OpenClassServiceImpl implements OpenClassService {

	private Log logger = LogFactory.getLog(OpenClassServiceImpl.class);

	@Autowired
	private DictBussManager dictBussManager;

	@Autowired
	private OpenClassMapper openClassMapper;
	
	@Autowired
	private MemClassMapper memClassMapper;

	private List<DictBuss> listDictBuss(int type) {
		return dictBussManager.listDictBuss(type);
	}

	@Override
	@SuppressWarnings("unchecked")
	public String searchClassInfos(Map param) {
    	logger.debug("enter searchClassInfos");

		JsonConfig jsonConfig = new JsonConfig();
		// jsonConfig.setJsonPropertyFilter(new PropertyFilter() {
		// public boolean apply(Object source, String name, Object value) {
		// //忽略Organization属性
		// if (value != null &&
		// Organization.class.isAssignableFrom(value.getClass())) {
		// return true;
		// }
		// return false;
		// }
		// });

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
							SimpleDateFormat sdf = new SimpleDateFormat(
									"yyyy-MM-dd");
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

						if (key.equals("classType")) {
							if (null == value) {
								return "";
							}
							String res = "";
							List<DictBuss> listDictBuss = listDictBuss(3);
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
		List<OpenClass> openlist = null;
		int total = 0;
		try {
			openlist = openClassMapper.getAllOpenClass(param);
			total = openClassMapper.getCounts(param);
		} catch (RuntimeException e1) {
			e1.printStackTrace();
		}
		//System.out.println(openlist.size());

		result.put("total", total);
		result.put("rows", openlist);

		String s = "";
		try {
			s = JSONObject.fromObject(result, jsonConfig).toString();
		} catch (DataAccessException e) {
			logger.error("JSONObject.fromObject(result,jsonConfig).toString()",
					e);
		}
		
  		
        logger.debug("exit searchClassInfos");
		return s;

	}
	
	@SuppressWarnings("unchecked")
    public  List<OpenClass> getAllList(Map param)
    {
    	logger.debug("enter getAllList");
    	
    	List<OpenClass>  r = openClassMapper.getAllOpenClass(param);
  		
        logger.debug("exit getAllList");
		return r;
	}
	
	@SuppressWarnings("unchecked")
    public List<Map<String,Object>> getClassList(Map conditionMap)
	{
    	logger.debug("enter getClassList");

	    List<Map<String,Object>> list = openClassMapper.getClassList(conditionMap);
	    Date createDate = null;
	    long hascount = 0;
	    long sumnum = 0;
	    long today = new Date().getTime();
	    for(Map<String,Object> map : list) 
	    {
	        createDate = (Date)map.get("createDate");
	        hascount = (Long)map.get("hascount");
	        sumnum = (Integer)map.get("sumnum");
            if(createDate.getTime() > today)
            {
                map.put("flag", "0");
            }
            else
            {
                map.put("flag", "1");
            }
            if(hascount>=sumnum)
            {
                map.put("flag2", "0");
            }
            else
            {
                map.put("flag2", "1");
            }
            
           
	    }
	    
  		
        logger.debug("exit getClassList");
	    return list;
	}

	public void addOpenClass(OpenClass openClass) {
    	logger.debug("enter addOpenClass");

		openClassMapper.insert(openClass);
		
  		
        logger.debug("exit addOpenClass");
	}

	public void updateOpenClass(OpenClass openClass) {
		
    	logger.debug("enter updateOpenClass");

		openClassMapper.update(openClass);
  		
        logger.debug("exit updateOpenClass");
	}
	
	public OpenClass findOpenClass(int id)
	{
    	logger.debug("enter findOpenClass");
    	
    	OpenClass r=  openClassMapper.getOpenClassById(id);
  		
        logger.debug("exit findOpenClass");
	    return r;
	}
	
	public void deleteOpenClasss(String strids)
	{
    	logger.debug("enter deleteOpenClasss");

		 JSONArray jsonArray = JSONArray.fromObject(strids);

	        int[] ids = (int[]) JSONArray.toArray(jsonArray, int.class);

	        for (int id : ids)
	        {
	        	openClassMapper.delete(id);
	        }
	  		
	        logger.debug("exit deleteOpenClasss");
	}
	
	public int getCounts2()
	{
    	logger.debug("enter getCounts2");
    	
    	int r = openClassMapper.getCounts2();
  		
        logger.debug("exit getCounts2");
	    return r;
	}
	
	public  void saveState(Map para)
	{
    	logger.debug("enter saveState");

	    memClassMapper.saveState(para);	    
  		
        logger.debug("exit saveState");
	}
	
	public  List<OpenClass> getAllInfo(Map pata)
	{
    	logger.debug("enter getAllInfo");
    	
    	 List<OpenClass>  r =  openClassMapper.getAllOpenClass(pata);
  		
        logger.debug("exit getAllInfo");
        
		return r;
		
	}
	
//	public static void main(String[] args)
//    {
//        String date = "2012-12-15";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        try
//        {
//            Date d =  sdf.parse(date);
//            if(d.getTime()< new Date().getTime())
//            {
//                System.out.println("dddddddddddddd");
//            }
//        }
//        catch (ParseException e)
//        {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }

}
