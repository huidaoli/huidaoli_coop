package com.base.frame.security.action;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.base.frame.common.BaseAction;
import com.base.frame.common.MD5;
import com.base.frame.model.DictBuss;
import com.base.frame.model.UserInfo;
import com.base.frame.security.service.UserInfoService;
import com.cantodo.content.dto.Member;

/**
 * [ºÚ“™√Ë ˆ]:<br/> 
 * [œÍœ∏√Ë ˆ]:<br/>
 * 
 * @author tangdingyi
 * @version 1.0, Sep 9, 2011
 */
@Controller("userinfo")
@Scope("prototype")
public class UserInfoAction extends BaseAction
{

    /**
     * [ºÚ“™√Ë ˆ]:
     * @author tangdingyi
     */
    private static final long serialVersionUID = -4779117067450671709L;

    /**
     * 
     */

    private UserInfo user;

    private Log logger = LogFactory.getLog(UserInfoAction.class);

    @Autowired
    private UserInfoService userService;
    
    
    private List<DictBuss> listDictBuss;




    public List<DictBuss> getListDictBuss()
    {
        return listDictBuss;
    }


    public void setListDictBuss(List<DictBuss> listDictBuss)
    {
        this.listDictBuss = listDictBuss;
    }


    /**
     * 
     * [ºÚ“™√Ë ˆ]:<br/>
     * [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String saveUser()
    {

        String opt = request.getParameter("opt");
        
        String [] roleids = request.getParameterValues("role");
        
        //roleids = roleids+"";

        if (opt.equals("add"))
        {
            user.setCreateDate(new Date());
            if(userService.findUserInfoByName(user.getUsername()))
            {
            	try
                {
                    response.getWriter().println("{\"success\":false,\"mess\":2}");
                }
                catch (IOException e)
                {
                    logger.error("getResponse().getWriter().println error.", e);
                }
                
                return null;
            	
            }
            userService.addUserInfo(user,roleids);
            
        }
        if (opt.equals("edit"))
        {
            userService.updateUserInfo(user,roleids);
        }

       
        return success();
    }
    
    @SuppressWarnings("unchecked")
    public String resetUserPass()
    {
    	logger.debug("enter resetUserPass");

        String password = request.getParameter("respass");
        String strid = request.getParameter("id");
        int id = Integer.parseInt(strid);
        UserInfo user = userService.findUserInfo(id);
        user.setPassword(password);
        userService.updateUserInfo(user);
        
        logger.debug("exit resetUserPass");
        
        return success();
    }

    
    /**
     * 
     * [ºÚ“™√Ë ˆ]:<br/>
     * [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String getUserInfoList()
    {

        return SUCCESS;
    }

    /**
     * 
     * [ºÚ“™√Ë ˆ]:<br/>
     * [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String loadUser()
    {
        response.setHeader("Cache-Control", "no-cache");
        request.setAttribute("opt", "add");
        request.setAttribute("arrIds","''");
        listDictBuss = userService.listDictBuss(1);
        return SUCCESS;
    }

    /**
     * 
     * [ºÚ“™√Ë ˆ]:<br/>
     * [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String deleteUsers()
    {

        String idarr = request.getParameter("ids");
        
        userService.delUserInfo(idarr);
        
        return success();
    }
    
    
    /**
     * 
     * [ºÚ“™√Ë ˆ]:<br/>
     * [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    @SuppressWarnings("unchecked")
    public String loadUserInfoById()
    {

        String id = request.getParameter("id");

        String opt = request.getParameter("opt");

        this.user = userService.findUserInfo(Integer.parseInt(id));
        
        String arrIds = userService.roleIdsByUserId(user.getId());
        
        listDictBuss = userService.listDictBuss(1);
        
        request.setAttribute("arrIds",arrIds);
        
        request.setAttribute("opt", "edit");

        if (opt.equals("edit"))
        {
           
            return SUCCESS;
        }
        else
        {
            List roles = userService.getRolesByUserId(user.getId());
            
            request.setAttribute("orginfo", user.getOrga());
            
            request.setAttribute("roles", roles);
            
            return "view";
        }

    }

    
    /**
     * 
     * [ºÚ“™√Ë ˆ]:<br/>
     * [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String getUserAjaxData()
    {
        
        response.setHeader("Cache-Control", "no-cache");

        String strpage = request.getParameter("page");

        String strrows = request.getParameter("rows");

        int rows = Integer.parseInt(strrows);

        int offset = (Integer.parseInt(strpage) - 1) * rows;
        
        
        String name = request.getParameter("name");
        
        String jsonData = userService.searchUserInfos(name,offset, rows);

        return toJsonData(jsonData);
    }

    public UserInfo getUser()
    {
        return user;
    }

    public void setUser(UserInfo user)
    {
        this.user = user;
    }
    

}
