package com.base.frame.workflow.jbpm.handler;

import java.util.List;

import org.jbpm.graph.exe.ExecutionContext;
import org.jbpm.taskmgmt.def.AssignmentHandler;
import org.jbpm.taskmgmt.exe.Assignable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.base.frame.business.service.LeaveService;
import com.base.frame.common.BaseAutoWire;
import com.base.frame.model.Leave;


//@Component("orgAssignmentHandler")
public class OrgAssignmentHandler extends BaseAutoWire implements AssignmentHandler
{

    /**
     * [¼òÒªÃèÊö]:
     * @author tangdingyi
     */
    private static final long serialVersionUID = 7421474814558295343L;
    
    //@Autowired
    private LeaveService leaveService;
    
    private String roleName;
    

    @SuppressWarnings("unchecked")
    @Override
    public void assign(Assignable sssignable, ExecutionContext executionContext) throws Exception
    {
        
//        Integer leaveId = (Integer)executionContext.getContextInstance().getVariable("leave");
//        
//        Leave leave = leaveService.findLeave(leaveId);
//        
//        int orgId = leave.getCreator().getOrga().getId();
//        
//        List resList = leaveService.getUser(roleName, orgId);
//        
//        if(null == resList || resList.isEmpty())
//        {
//            
//        }
//        String [] pooledActors = (String [])resList.toArray(new String[resList.size()]);
//        
//        sssignable.setPooledActors(pooledActors);
        
        
    }

}
