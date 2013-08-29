package com.base.frame.business.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.base.frame.business.service.SysService;
import com.base.frame.common.BaseAction;
import com.base.frame.model.SysConfig;


@Controller("smAction")
@Scope("prototype")
public class SystemManageAction extends BaseAction
{

    /**
     * [¼òÒªÃèÊö]:
     * @author tangdingyi
     */
    private static final long serialVersionUID = -3117936463002637149L;
    
    @Autowired
    private SysService sysService;
    
    
    public String toSysConfing()
    {
        
        return SUCCESS;
    }
    
    public String getSysConfingData()
    {
        String jsonData = sysService.getJsonData();

        return toJsonData(jsonData);
    }
    
    public String saveConfing()
    {
       
        String jsonData = request.getParameter("jsonData");
        
        sysService.save(jsonData);
        
        return success();
    }

}
