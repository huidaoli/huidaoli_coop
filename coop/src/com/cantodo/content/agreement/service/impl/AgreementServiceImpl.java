package com.cantodo.content.agreement.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cantodo.content.agreement.service.AgreementService;
import com.cantodo.content.dto.Agreement;
import com.cantodo.content.dto.AgreementExt;
import com.cantodo.content.dto.AgreementItem;
import com.cantodo.content.persistence.AgreementMapper;

@Service("agreementServiceImpl")
public class AgreementServiceImpl implements AgreementService
{

    private Log logger = LogFactory.getLog(AgreementServiceImpl.class);

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    
    
    @Autowired
    private AgreementMapper agreementMapper;

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public void add(Agreement agreement)
    {
        agreement.setCreateDate(new Date());

        // 插入合同主表
        agreementMapper.insertAgreement(agreement);

        // 插入合同分配明细表
        List<AgreementItem> ailist = getListItem(agreement);
        agreementMapper.insertAItem(ailist);

        // 插入合同扩展表
        List<String[]> list = getListExt(agreement);
        agreementMapper.insertAExt(list);

    }

    @Override
    @Transactional
    public void delete(String sids)
    {
        JSONArray jsonArray = JSONArray.fromObject(sids);

        int[] ids = (int[]) JSONArray.toArray(jsonArray, int.class);
        Agreement agreement = null;
        for (int id : ids)
        {
            agreement = agreementMapper.getInfoById(id);
            agreementMapper.delete(id);
            agreementMapper.deleteAItem(agreement.getCode());
            agreementMapper.deleteAExt(agreement.getCode());
        }

    }

    @Override
    public List<Agreement> getAllInfo(Map pata)
    {
        return agreementMapper.getAllInfo(pata);
    }

    @Override
    public int getCounts2()
    {
        return agreementMapper.getCounts2();
    }

    @Override
    public Agreement getInfoById(int id)
    {

        // 读合同主表
        Agreement agreement = agreementMapper.getInfoById(id);
        List<Map<String, String>> extlist = agreementMapper.getExtInfoById(agreement.getCode());
        Map<String, String> res = new HashMap<String, String>();
        String key = null;
        String value = null;
        String[] ress = null;

        // 读合同扩展表
        // ======================对象转换1===================
        for (Map<String, String> map : extlist)
        {
            ress = new String[2];
            for (Map.Entry<String, String> entry : map.entrySet())
            {

                key = entry.getKey();
                value = entry.getValue();
                if ("name".equals(key))
                {
                    ress[0] = value;
                }
                if ("value".equals(key))
                {
                    ress[1] = value;
                }

            }
            res.put(ress[0], ress[1]);

        }
        AgreementExt ext = new AgreementExt();
        try
        {
            BeanUtils.populate(ext, res);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        // =====================对象转换2=================
        List<Map<String, String>> itemlist = agreementMapper.getItemListById(agreement.getCode());
        List<AgreementItem> itelist = new ArrayList<AgreementItem>();
        AgreementItem item = new AgreementItem();
        for (Map<String, String> map : itemlist)
        {
            try
            {
                BeanUtils.populate(item, map);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            itelist.add(item);
        }
        int size = itelist.size();
        if (size < 10)
        {
            for (int i = 0; i < 10 - size; i++)
            {
                itelist.add(new AgreementItem());
            }
        }
        agreement.setExt(ext);
        agreement.setItem(itelist);
        return agreement;
    }

    @Override
    public String getList(Map param)
    {
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

                if (key.equals("createDate") || key.equals("sxsj"))
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
        List<Agreement> openlist = null;
        int total = 0;
        try
        {
            openlist = agreementMapper.getAllInfo(param);
            total = agreementMapper.getCounts(param);
        }
        catch (RuntimeException e1)
        {
            e1.printStackTrace();
        }
        result.put("total", total);
        result.put("rows", openlist);

        String s = "";
        try
        {
            s = JSONObject.fromObject(result, jsonConfig).toString();
        }
        catch (DataAccessException e)
        {
            logger.error("JSONObject.fromObject(result,jsonConfig).toString()", e);
        }

        logger.debug("exit searchNewsInfo");

        return s;
    }

    @SuppressWarnings("unchecked")
	@Override
	/**
	 * 该方法用到批量执行update语句,所以不用spring的事务,改成手工事务
	 */
    public void update(Agreement agreement)
    {
        
        SqlSession session = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, true);
        try
        {
            AgreementMapper AgreementMapper2 = session.getMapper(AgreementMapper.class);
            
            AgreementMapper2.update(agreement);
            
            
            //更新合同明细表--先删后增
            AgreementMapper2.deleteAItem(agreement.getCode());
            List<AgreementItem> ailist = getListItem(agreement);
            AgreementMapper2.insertAItem(ailist);
            
            
            List<String[]> list = getListExt(agreement);
            Map param = new HashMap();
            for(String [] str : list)
            {
                param.put("value", str[2]);
                param.put("code", str[0]);
                param.put("name", str[1]);
                AgreementMapper2.updateAExt(param);
            }
            session.commit();
        }
        catch (RuntimeException e)
        {
            e.printStackTrace();
            session.rollback();
            throw e;
        }
        finally
        {
            session.close();
        }
    }
    
    
    
    @SuppressWarnings("unchecked")
	private List<String[]> getListExt(Agreement agreement)
    {
    	List<String[]> list = new ArrayList<String[]>();
        AgreementExt ext = agreement.getExt();
        Map map = null;
        try
        {
            map = BeanUtils.describe(ext);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        Iterator it = map.entrySet().iterator();
        Map.Entry entry = null;
        String key, value = null;
        while (it.hasNext())
        {

            entry = (Map.Entry) it.next();
            key = (String) entry.getKey();
            if ("class".equals(key))
            {
                continue;
            }
            value = (String) entry.getValue();
            value = null == value ? "" : value;
            list.add(new String[] {agreement.getCode(), key, value});
        }
        return list;
    }
	
	
	@SuppressWarnings("unchecked")
	private List<AgreementItem> getListItem(Agreement agreement)
	{
		List<AgreementItem> ailist = agreement.getItem();
		Iterator iter = ailist.iterator();
		AgreementItem ai = null;
		while (iter.hasNext()) {
			ai = (AgreementItem) iter.next();
			if (StringUtils.isEmpty(ai.getProname()) || StringUtils.isEmpty(ai.getJhdd())) {
				iter.remove();
			}
		}
		return ailist;
	}

    @Override
    public void stateOpt(String idarr, int state)
    {
        JSONArray jsonArray = JSONArray.fromObject(idarr);

        int[] ids = (int[]) JSONArray.toArray(jsonArray, int.class);

        Map cmap = new HashMap();

        // for 赋值给map时，无需new HashMap，因为map后覆盖前的
        for (int id : ids)
        {

            cmap.put("id", id);
            cmap.put("state", state);
            agreementMapper.stateOpt(cmap);
        }

    }

    @Override
    public int passAgree(String id)
    {
        
        int res = 0;
        if(agreementMapper.getstate(NumberUtils.toInt(id,0))!=1)
        {
            return 0;
        }
        else
        {
            Map cmap = new HashMap();
            cmap.put("id", id);
            cmap.put("sxsj", new Date());
            agreementMapper.passAgree(cmap);
            
            return 1;
        }
       
    }

    @Override
    public int checkState(String id)
    {
        return agreementMapper.getstate(NumberUtils.toInt(id,0));
    }


}
