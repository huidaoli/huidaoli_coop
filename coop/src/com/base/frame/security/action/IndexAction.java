package com.base.frame.security.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.base.frame.common.BaseAction;
import com.base.frame.common.SystemException;
import com.base.frame.model.ACL;
import com.base.frame.model.LoginMess;
import com.base.frame.model.Module;
import com.base.frame.model.UserInfo;
import com.base.frame.security.service.AclService;
import com.base.frame.security.service.LoginMessService;
import com.base.frame.security.service.ModuleService;
import com.base.frame.security.service.UserInfoService;

@Controller("index")
@Scope("prototype")
public class IndexAction extends BaseAction
{
    /**
     * [ºÚ“™√Ë ˆ]:
     * 
     * @author tangdingyi
     */
    private static final long serialVersionUID = 937985788654525018L;

    private Log logger = LogFactory.getLog(IndexAction.class);

    @Autowired
    private UserInfoService userService;

    @Autowired
    private AclService aclService;

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private LoginMessService loginMessService;

    /**
     * [ºÚ“™√Ë ˆ]:<br/> [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String login()
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String code = request.getParameter("code");

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password) || StringUtils.isEmpty(code))
        {
            return null;
        }
        String sessCode = (String) request.getSession().getAttribute("GLY_VERIRY_CODE");

        String res = "1";

        if (!code.equals(sessCode))
        {
            res = "2";
        }

        UserInfo user = null;

        try
        {
            user = userService.login(username, password);

        }
        catch (SystemException e)
        {
            res = "3";
        }

        request.getSession().setAttribute("user", user);

        try
        {

            response.getWriter().println("{\"res\":" + res + "}");
        }
        catch (IOException e)
        {
            logger.error("getResponse().getWriter().println error.", e);

        }

        return null;
    }

    /**
     * [ºÚ“™√Ë ˆ]:<br/> [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String loginOut()
    {
        request.getSession().removeAttribute("user");
        request.getSession().removeAttribute("aclMap");
        request.getSession().invalidate();

        return success();
    }

    /**
     * [ºÚ“™√Ë ˆ]:<br/> [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String toLogin()
    {

        return SUCCESS;
    }

    private String getRemoteAddr(HttpServletRequest request)
    {
        String address = request.getHeader("X-Forwarded-For");
        if (address != null && address.length() > 0 && !"unknown".equalsIgnoreCase(address))
        {
            return address;
        }
        address = request.getHeader("X-Real-IP");
        if (address != null && address.length() > 0 && !"unknown".equalsIgnoreCase(address))
        {
            return address;
        }
        return request.getRemoteAddr();
    }

    /**
     * [ºÚ“™√Ë ˆ]:<br/> [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String index()
    {
        UserInfo user = currentUser(request);

        LoginMess loginMess = loginMessService.findLoginMess(user.getUsername());

        // ªÒµ√remoteAddr µÿ÷∑
        // ”√nginx¥˙¿Ì∫Û£¨remoteAddr «ªÒµ√nginxµƒµÿ÷∑°£
        String remoteAddr = getRemoteAddr(request);

        if (null == loginMess)
        {
            loginMess = new LoginMess();
            loginMess.setPreLoginDate(new Date());
            loginMess.setPreLoginIp(remoteAddr);
            loginMess.setUsername(user.getUsername());
            loginMessService.addLoginMess(loginMess);
            request.setAttribute("preLoginDate", "");
            request.setAttribute("preLoginIp", "");
            request.setAttribute("loginIp", remoteAddr);
            request.setAttribute("loginDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        }
        else
        {
            // Date date = loginMess.getPreLoginDate();
            // String dates = new SimpleDateFormat("yyyy-MM-dd
            // HH:mm:ss").format(date);
            request.setAttribute("preLoginDate",
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(loginMess.getPreLoginDate()));
            request.setAttribute("preLoginIp", loginMess.getPreLoginIp());
            request.setAttribute("loginIp", remoteAddr);
            request.setAttribute("loginDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

            loginMess.setPreLoginDate(new Date());
            loginMess.setPreLoginIp(remoteAddr);
            loginMess.setUsername(user.getUsername());
            loginMessService.updateLoginMess(loginMess);
        }

        if (user != null)
        {
            Map<Integer, ACL> aclMap = aclService.getAclMap(user.getId());

            request.getSession().setAttribute("aclMap", aclMap);

            List<Module> menuLists = aclService.searchModulesData(1, aclMap);

            List<Module> actions = moduleService.getAllActions();

            request.setAttribute("menuLists", menuLists);

            request.setAttribute("actions", actions);

        }

        return SUCCESS;
    }

    /**
     * [ºÚ“™√Ë ˆ]:<br/> [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String getUrl()
    {
        String mid = request.getParameter("mid");

        Module m = moduleService.findModule(Integer.parseInt(mid));

        String url = m.getUrl();

        try
        {
            response.getWriter().println(url);
        }
        catch (IOException e)
        {
            logger.error("getResponse().getWriter().println error.", e);

        }

        return null;
    }

    /**
     * [ºÚ“™√Ë ˆ]:<br/> [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    @SuppressWarnings("unchecked")
    public String getMenus()
    {

        UserInfo user = currentUser(request);

        String mid = request.getParameter("mid");

        if (user != null)
        {

            Map<Integer, ACL> aclMap = (Map<Integer, ACL>) request.getSession().getAttribute("aclMap");

            String treeData = aclService.searchModules(aclMap, Integer.parseInt(mid));

            try
            {
                // response.setCharacterEncoding("UTF-8");
                response.getWriter().println(treeData);
            }
            catch (IOException e)
            {
                logger.error("getResponse().getWriter().println error.", e);

            }

        }

        return null;
    }

    public String welcome()
    {
        response.setHeader("Cache-Control", "no-cache");

        Map<Integer, ACL> map = (Map<Integer, ACL>) request.getSession().getAttribute("aclMap");

        return SUCCESS;
    }
}
