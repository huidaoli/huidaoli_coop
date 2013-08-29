package com.cantodo.content.member.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.base.frame.common.BaseAction;
import com.base.frame.common.MD5;
import com.base.frame.model.DictBuss;
import com.base.frame.security.service.DictBussService;
import com.cantodo.content.dto.Member;
import com.cantodo.content.front.tool.CharacterUtils;
import com.cantodo.content.member.service.MemberService;

/**
 * @author tdy
 */
@Controller("memberAction")
@Scope("prototype")
public class MemberAction extends BaseAction
{

    /**
     * 
     */
    private static final long serialVersionUID = 2984477075531599967L;

    private Log logger = LogFactory.getLog(MemberAction.class);

    @Autowired
    private MemberService memberServiceImpl;

    @Autowired
    private DictBussService dictBussImplService;

    private Member member;

    public Member getMember()
    {
        return member;
    }

    public void setMember(Member member)
    {
        this.member = member;
    }

    private List<DictBuss> listDictBuss;

    private List<DictBuss> listDictBusstype;

    public List<DictBuss> getListDictBusstype()
    {
        return listDictBusstype;
    }

    public void setListDictBusstype(List<DictBuss> listDictBusstype)
    {
        this.listDictBusstype = listDictBusstype;
    }

    public String toLoadList()
    {
        listDictBuss = dictBussImplService.listDictBuss(11);
        return SUCCESS;
    }
    
    public String selectmember()
    {
        listDictBuss = dictBussImplService.listDictBuss(11);
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

        String username = request.getParameter("username");
        String companyname = request.getParameter("companyname");
        String realname = request.getParameter("realname");
        String state = request.getParameter("state");
        String xuyu = request.getParameter("xuyu");
        username = StringUtils.isBlank(username) ? null : "%" + username + "%";
        companyname = StringUtils.isBlank(companyname) ? null : "%" + companyname + "%";
        realname = StringUtils.isBlank(realname) ? null : "%" + realname + "%";
        state = ("").equals(state) ? null : state;
        xuyu = StringUtils.isBlank(xuyu) ? null : "%" + xuyu + "%";

        Map conditionMap = new HashMap();
        conditionMap.put("username", username);
        conditionMap.put("companyname", companyname);
        conditionMap.put("realname", realname);
        conditionMap.put("state", state);

        conditionMap.put("offset", offset);
        conditionMap.put("rows", rows);

        String jsonData = memberServiceImpl.getList(conditionMap);

        logger.debug("exit getAjaxData");

        return toJsonData(jsonData);
    }

    public String loadEdit()
    {

        logger.debug("enter  loadEdit");

        response.setHeader("Cache-Control", "no-cache");
        request.setAttribute("opt", "add");
        String contcode = UUID.randomUUID().toString();

        listDictBuss = dictBussImplService.listDictBuss(10);

        logger.debug("exit  loadEdit");

        return SUCCESS;
    }

    @SuppressWarnings("unchecked")
    public String resetPass()
    {
        logger.debug("enter resetPass");

        String password = request.getParameter("respass");
        String strid = request.getParameter("id");
        int id = Integer.parseInt(strid);
        Member m = memberServiceImpl.getInfoById(id);
        String pass = MD5.MD5Encode(m.getUserName() + password);
        Map conditionMap = new HashMap();
        conditionMap.put("id", id);
        conditionMap.put("password", pass);
        memberServiceImpl.resetPass(conditionMap);

        logger.debug("exit resetPass");

        return success();
    }

    public String saveOrUpdate()
    {
        logger.debug("enter saveOrUpdate");

        String opt = request.getParameter("opt");

        if (opt.equals("add"))
        {
            memberServiceImpl.add(member);

        }
        if (opt.equals("edit"))
        {
            memberServiceImpl.update(member);
        }

        logger.debug("exit saveOrUpdate");

        return success();
    }

    @SuppressWarnings("unchecked")
    public String getInfoById()
    {

        logger.debug("enter getInfoById");

        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        String opt = request.getParameter("opt");
        listDictBuss = dictBussImplService.listDictBuss(1);
        listDictBusstype = dictBussImplService.listDictBuss(16);

        try
        {
            member = memberServiceImpl.getInfoById(id);

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

    public String generPass()
    {

        logger.debug("enter generPass");

        String pass = CharacterUtils.getRandomString(8);

        try
        {
            response.getWriter().println("{res:true,mess:'" + pass + "'}");
        }
        catch (IOException e)
        {
            logger.error("getResponse().getWriter().println error.", e);
        }

        logger.debug("exit generPass");

        return null;
    }

    @SuppressWarnings("unchecked")
    public String lockorunlock()
    {
        logger.debug("enter lockorunlock");

        response.setHeader("Cache-Control", "no-cache");
        String idarr = request.getParameter("id");
        String type = request.getParameter("type");

        Map conditionMap = new HashMap();
        conditionMap.put("id", Integer.parseInt(idarr));
        if (type.equals("lock"))
        {

            conditionMap.put("state", 0);

        }
        if (type.equals("unlock"))

        {
            conditionMap.put("state", 1);
        }

        memberServiceImpl.lockorunlock(conditionMap);

        logger.debug("exit lockorunlock");

        return success();
    }

    public String delete()
    {
        logger.debug("enter delete");

        String idarr = request.getParameter("ids");

        memberServiceImpl.delete(idarr);

        logger.debug("exit delete");

        return success();
    }

    public String stateOpt()
    {

        String idarr = request.getParameter("ids");

        String statestr = request.getParameter("state");

        int state = NumberUtils.toInt(statestr, 0);

        memberServiceImpl.stateOpt(idarr, state);

        return success();

    }
    
    public String saveFphone()
    {

        String id = request.getParameter("id");

        String fphone = request.getParameter("fphone");

        int iid = NumberUtils.toInt(id, 0);

        memberServiceImpl.saveFphone(iid, fphone);

        return success();

    }

    public List<DictBuss> getListDictBuss()
    {
        return listDictBuss;
    }

    public void setListDictBuss(List<DictBuss> listDictBuss)
    {
        this.listDictBuss = listDictBuss;
    }

}
