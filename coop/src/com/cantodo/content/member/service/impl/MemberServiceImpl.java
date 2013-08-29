package com.cantodo.content.member.service.impl;

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

import com.base.frame.common.MD5;
import com.cantodo.content.dto.Content;
import com.cantodo.content.dto.Cooperation;
import com.cantodo.content.dto.Member;
import com.cantodo.content.member.service.MemberService;
import com.cantodo.content.persistence.ContentMapper;
import com.cantodo.content.persistence.MemberMapper;

@Service("memberServiceImpl")
public class MemberServiceImpl implements MemberService
{

    private Log logger = LogFactory.getLog(MemberServiceImpl.class);

    @Autowired
    private MemberMapper memberMapper;
    
    
    @Autowired
    private ContentMapper contentMapper;
    

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

                if (key.equals("createDate") || key.equals("brithday") || key.equals("bysj"))
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
        List<Member> list = null;
        int total = 0;
        try
        {
            list = memberMapper.getAllInfo(param);
            total = memberMapper.getCounts(param);
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

    public boolean add(Member member)
    {

    	logger.debug("enter add");

        boolean flag = true;
        
        member.setPassword(MD5.MD5Encode(member.getUserName()+member.getPassword()));

        try
        {
            memberMapper.insert(member);
        }
        catch (RuntimeException e)
        {
            logger.debug("add(Member member)", e);
            flag = false;
        }
        
  		
        logger.debug("exit add");

        return flag;
    }

    public void update(Member member)
    {
    	logger.debug("enter update");

        memberMapper.update(member);
  		
        logger.debug("exit update");
    }

    public Member getInfoById(int id)
    {
    	logger.debug("enter getInfoById");
    	
    	Member me = memberMapper.getInfoById(id);
    	
        logger.debug("exit getInfoById");

        return me;
        
        
    }

    public boolean checkUserName(String userName)
    {
    	logger.debug("enter checkUserName");

        int res = memberMapper.getMemberCountByUserName(userName);

        //如果没有 返回true
        if (0 == res)
        {
      		
            logger.debug("exit checkUserName");
            return true;
        }

        //如果有返回false
        logger.debug("exit checkUserName");
        return false;
    }
    
    public boolean checkEmail(String userName)
    {
        logger.debug("enter checkEmail");

        int res = memberMapper.getMemberCountByUserName(userName);

        //如果没有 返回true
        if (0 == res)
        {
            
            logger.debug("exit checkEmail");
            return true;
        }

        //如果有返回false
        logger.debug("exit checkEmail");
        return false;
    }
    
    public Member checkMem(String username,String password) 
    {
    	logger.debug("enter checkMem");

        Map<String,String> conMap = new HashMap<String,String> ();
        
        conMap.put("username", username);
        
        conMap.put("password", MD5.MD5Encode(username+password));
        
        Member member = null;
        try
        {
            member = memberMapper.getMem(conMap);
        }
        catch (RuntimeException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
      		
            logger.error("checkMem",e);
        }
        
  		
        logger.debug("exit checkMem");
        
        return member;

    }

    public void delete(String strids)
    {
    	
    	logger.debug("enter delete");

        JSONArray jsonArray = JSONArray.fromObject(strids);

        int[] ids = (int[]) JSONArray.toArray(jsonArray, int.class);

        for (int id : ids)
        {
            memberMapper.delete(id);
        }
  		
        logger.debug("exit delete");
    }
    
    
    @Transactional
    public Member signup(Member member)
    {
    	logger.debug("enter signup");
        
        add(member);
        
        Member m =  memberMapper.getMemberByUserName(member.getUserName());
        
        Content con = null;

        for(int i=0;i<2;i++)
        {
            con = new Content();
            con.setContent("");
            con.setCreatedate(new Date());
            con.setTypeid(i);
            con.setCoopid(m.getId());
            contentMapper.insert(con);
        }
        
        
  		
        logger.debug("exit signup");
        
        return m;
    }
    
    public List<Map<String,String>> getClassInfo(int memid)
    {
    	logger.debug("enter getClassInfo");
    	
    	 List<Map<String,String>> res  = memberMapper.getClassInfoList(memid);
  		
        logger.debug("exit getClassInfo");
        
    	return res;
    }
    
    public List<Map<String,String>> getProjectInfoList(int memid)
    {
    	logger.debug("enter getProjectInfoList");
  		
    	List<Map<String,String>> res =  memberMapper.getProjectInfoList(memid);
    	
        logger.debug("exit getProjectInfoList");
        
    	return res;
    }
    
    public void lockorunlock(Map param)
    {
    	logger.debug("enter lockorunlock");

        memberMapper.lockorunlock(param);
  		
        logger.debug("exit lockorunlock");
    }
    
    public void resetPass(Map param)
    {
        memberMapper.resetPass(param);
    }
    
    public List<Member> getMemByClassId(int classid)
    {
    	logger.debug("enter getMemByClassId");
    	
    	 List<Member> res = memberMapper.getMemByClassId(classid);
  		
        logger.debug("exit getMemByClassId");
        
        return res;
    }
    
    public List<Member> getMemByProjectId(int projectid)
    {
    	logger.debug("enter getMemByProjectId");
    	
    	List<Member> res = memberMapper.getMemByProjectId(projectid);
  		
        logger.debug("exit getMemByProjectId");
        
        return res;
    }
    

    @Override
    @Transactional
    public Member updateStep(Member member)
    {
        memberMapper.updateStep(member);
        Member m = memberMapper.getInfoById(member.getId());
        
        return m;
        
    }

    @Override
    public void stateOpt(String idarr, int state)
    {
        JSONArray jsonArray = JSONArray.fromObject(idarr);

        int[] ids = (int[]) JSONArray.toArray(jsonArray, int.class);
        
        Map cmap = new HashMap();
        
        for (int id : ids)
        {
            cmap.put("id", id);
            cmap.put("state", state);
            memberMapper.stateOpt(cmap);
        }
        
    }

    @Override
    public void saveFphone(int iid, String fphone)
    {
        Map cmap = new HashMap();
        cmap.put("id", iid);
        cmap.put("fphone", fphone);
        memberMapper.saveFphone(cmap);
        
    }

    @Override
    public Content getInfoByTypeCoop(Map map)
    {
        Content c = null;
        try
        {
            c = contentMapper.getInfoByTypeCoop(map);
        }
        catch (RuntimeException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public List<Cooperation> getAllCooperation(Map conditionMap2)
    {
        // TODO Auto-generated method stub
        return memberMapper.getAllCooperation(conditionMap2);
    }

    @Override
    public int getCounts(Map conditionMap)
    {
        return memberMapper.getCountsByCoonType(conditionMap);
    }

	@Override
	public int checkIsFinish(int id) {
		return memberMapper.getIsFinish(id);
		
		
	}
    
    

}
