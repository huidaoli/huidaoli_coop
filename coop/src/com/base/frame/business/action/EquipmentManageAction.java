package com.base.frame.business.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.base.frame.business.service.EquipmentService;
import com.base.frame.common.BaseAction;
import com.base.frame.model.EqumentDetail;

@Controller("equipmentAction")
@Scope("prototype")
public class EquipmentManageAction extends BaseAction
{

    /**
     * [¼òÒªÃèÊö]:
     * 
     * @author tangdingyi
     */
    private static final long serialVersionUID = 6361859425061094473L;
    
    
    private EqumentDetail equmentDetail;
    
    
    @Autowired
    private EquipmentService equipmentService;
    
    
   
    public EqumentDetail getEqumentDetail()
    {
        return equmentDetail;
    }

    public void setEqumentDetail(EqumentDetail equmentDetail)
    {
        this.equmentDetail = equmentDetail;
    }

    /**
     * 
     * [¼òÒªÃèÊö]:<br/>
     * [ÏêÏ¸ÃèÊö]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String toAddEquInfo()
    {
        return SUCCESS;
    }

    /**
     * 
     * [¼òÒªÃèÊö]:<br/>
     * [ÏêÏ¸ÃèÊö]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String equmentAcount()
    {
        return SUCCESS;
    }

    /**
     * 
     * [¼òÒªÃèÊö]:<br/>
     * [ÏêÏ¸ÃèÊö]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String equmentLog()
    {
        return SUCCESS;
    }
    
    public String getEqumentDetailInfo()
    {
        
        String id = request.getParameter("id");
        
        //System.out.println(id);
        
        
        return SUCCESS;
    }
    
    
    /**
     * 
     * [¼òÒªÃèÊö]:<br/>
     * [ÏêÏ¸ÃèÊö]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String getEquipmentTreeData()
    {

        response.setHeader("Cache-Control", "no-cache");

        String treeData = equipmentService.getEquipmentTreeData(1);

        return toJsonData(treeData);

    }

   

}
