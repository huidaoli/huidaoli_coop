package com.cantodo.content.project.service.impl;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.base.frame.common.MessTool;
import com.base.frame.common.SystemException;
import com.base.frame.dao.DictBussManager;
import com.base.frame.model.DictBuss;
import com.cantodo.content.dto.Project;
import com.cantodo.content.persistence.MemProjectMapper;
import com.cantodo.content.persistence.ProjectMapper;
import com.cantodo.content.project.service.ExcelReader;
import com.cantodo.content.project.service.ProjectService;

@Service("projectServiceImpl")
public class ProjectServiceImpl implements ProjectService
{

    private Log logger = LogFactory.getLog(ProjectServiceImpl.class);

    @Autowired
    private DictBussManager dictBussManager;

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private MemProjectMapper memProjectMapper;

    @Autowired
    private ExcelReader excelReader;

    private List<DictBuss> listDictBuss(int type)
    {
        return dictBussManager.listDictBuss(type);
    }

    private static Map<String, String> titleMap = new HashMap<String, String>();
    {
        titleMap.put("项目编号", "项目编号");
        titleMap.put("项目名称", "项目名称");
        titleMap.put("项目类别", "项目类别");
        titleMap.put("技术方向", "技术方向");
        titleMap.put("应用行业", "应用行业");
        titleMap.put("项目工期", "项目工期");
        titleMap.put("开始时间", "开始时间");
        titleMap.put("结束时间", "结束时间");
        titleMap.put("团队人数", "团队人数");
        titleMap.put("项目规模", "项目规模");
        titleMap.put("投资规模", "投资规模");
        titleMap.put("发包方", "发包方");
        titleMap.put("承包方", "承包方");
        titleMap.put("项目经理", "项目经理");
        titleMap.put("项目描述", "项目描述");

    }

    @Override
    @SuppressWarnings("unchecked")
    public String getList(Map param)
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

                if (key.equals("startTime"))
                {
                    if (null == value)
                    {
                        return "";
                    }
                    String res = DateFormatUtils.format((Date) value, "yyyy-MM-dd");

                    return res;
                }
                if (key.equals("endTime"))
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

        jsonConfig.registerJsonValueProcessor(int.class, new JsonValueProcessor()
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

                if (key.equals("type"))
                {
                    if (null == value)
                    {
                        return "";
                    }
                    String res = "";
                    List<DictBuss> listDictBuss = listDictBuss(7);
                    for (DictBuss db : listDictBuss)
                    {
                        if (db.getDictId() == Integer.parseInt(value.toString()))
                        {
                            return db.getDictName();
                        }
                    }

                    return res;
                }
                if (key.equals("itfx"))
                {
                    if (null == value)
                    {
                        return "";
                    }
                    String res = "";
                    List<DictBuss> listDictBuss = listDictBuss(5);
                    for (DictBuss db : listDictBuss)
                    {
                        if (db.getDictId() == Integer.parseInt(value.toString()))
                        {
                            return db.getDictName();
                        }
                    }

                    return res;
                }
                if (key.equals("yyfx"))
                {
                    if (null == value)
                    {
                        return "";
                    }
                    String res = "";
                    List<DictBuss> listDictBuss = listDictBuss(6);
                    for (DictBuss db : listDictBuss)
                    {
                        if (db.getDictId() == Integer.parseInt(value.toString()))
                        {
                            return db.getDictName();
                        }
                    }

                    return res;
                }

                return value;

            }

        });
        Map result = new HashMap();
        List<Project> list = null;
        int total = 0;
        try
        {
            list = projectMapper.getAllProject(param);
            String s = (String) param.get("qno");
           // System.out.println(s);
            total = projectMapper.getCounts(param);
        }
        catch (RuntimeException e1)
        {
            logger.debug("RuntimeException", e1);
        }

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

    public void add(Project project)
    {
    	logger.debug("enter add");

        if (checkProjectNo(project.getNo()))
        {
            projectMapper.insert(project);
        }
        else
        {
            //String ms = MessTool.getMessage("message010").replace("{0}", project.getNo());
            throw new SystemException("message010",MessTool.getMessage("message010"));
        }
  		
        logger.debug("exit add");

    }

    public void addBatch(Map<String, List<Map<String, String>>> projects)
    {
    	logger.debug("enter addBatch");

        try
        {
            projectMapper.addBatch(projects);
        }
        catch (RuntimeException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
  		
        logger.debug("exit addBatch");
    }

    public void update(Project project)
    {
    	logger.debug("enter update");

        projectMapper.update(project);
  		
        logger.debug("exit update");
    }

    public Project getInfoById(int id)
    {
    	logger.debug("enter about");
    	
    	Project r =  projectMapper.getProjectById(id);
  		
        logger.debug("exit about");
        return r;
    }

    public void delete(String strids)
    {
    	logger.debug("enter  delete");

        JSONArray jsonArray = JSONArray.fromObject(strids);

        int[] ids = (int[]) JSONArray.toArray(jsonArray, int.class);

        for (int id : ids)
        {
            projectMapper.delete(id);
        }
        
  		
        logger.debug("exit  delete");
    }

    public int getCounts2(String ctype)
    {
    	logger.debug("enter getCounts2");
    	
    	int r = projectMapper.getCounts2(ctype);
  		
        logger.debug("exit getCounts2");
        return r;
    }

    @Override
    public void readExcel(File file,String type)
    {
    	logger.debug("enter readExcel");

        String[] titles = null;
        try
        {
            titles = excelReader.readExcelTitle(file);
        }
        catch (Exception e)
        {
            throw new SystemException("error001", MessTool.getMessage("error001"));
        }
        for (String title : titles)
        {
            if (null == titleMap.get(title))
            {
                throw new SystemException("error001", MessTool.getMessage("error001"));
            }
        }

        Map<String, List<Map<String, String>>> contents = excelReader.readExcelContent(file,type);
        List<Map<String, String>> list = contents.get("res");
        
        
        for(Map<String,String> map : list)
        {
            if(!checkProjectNo(map.get("no")))
            {
                
                throw new SystemException("message010",MessTool.getMessage("message010"));
            }
            if(!checkTime(map.get("startTime"),map.get("endTime")))
            {
                
                throw new SystemException("message011",MessTool.getMessage("message011"));
            }
            
             
            
        }

        addBatch(contents);
        
  		
        logger.debug("exit readExcel");
    }
    
//    public static void main(String[] args)
//    {
//        checkTime("2012-03-23","2012-03-24");
//    }
    
    private boolean checkTime(String s,String e)
    {
    	
    	logger.debug("enter checkTime");

        if(StringUtils.isBlank(s) || StringUtils.isBlank(e))
        {
            return true;
        }
        else
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date sd = null;
            Date ed = null;
            try
            {
                sd = sdf.parse(s);
                ed = sdf.parse(e);
            }
            catch (ParseException e1)
            {
                e1.printStackTrace();
            }
             
            if(sd.getTime()<ed.getTime())
            {
          		
                logger.debug("exit checkTime");
                return true;
            }
      		
            logger.debug("exit checkTime");
            return false;
        }
    }

    public List<Map<String, Object>> getProjectList(Map conditionMap)
    {
    	logger.debug("enter getProjectList");

        List<Map<String, Object>> list = projectMapper.getProjectList(conditionMap);

        Date startTime = null;
        long hascount = 0;
        int groupper = 0;
        long today = new Date().getTime();
        for (Map<String, Object> map : list)
        {
            startTime = (Date) map.get("startTime");
            hascount = (Long) map.get("hascount");
            groupper = (Integer) map.get("groupper");
            if (startTime.getTime() > today)
            {
                map.put("flag", "0");
            }
            else
            {
                map.put("flag", "1");
            }
            if (hascount >= groupper)
            {
                map.put("flag2", "0");
            }
            else
            {
                map.put("flag2", "1");
            }
        }
        
  		
        logger.debug("exit getProjectList");
        return list;

    }

    public void saveState(Map para)
    {
    	logger.debug("enter saveState");

        memProjectMapper.saveState(para);
  		
        logger.debug("exit saveState");
    }

    public boolean checkProjectNo(String no)
    {
    	logger.debug("enter checkProjectNo");

        if(StringUtils.isBlank(no))
        {
            return false;
        }
        long res = projectMapper.checkProjectNo(no);

        if (0 == res)
        {
      		
            logger.debug("exit checkProjectNo");
            return true;
        }
        else
        {
      		
            logger.debug("exit checkProjectNo");
            return false;
        }
    }

}
