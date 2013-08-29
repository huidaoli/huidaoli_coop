package com.base.frame.business.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import net.sf.json.util.PropertyFilter;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.graph.exe.Token;
import org.jbpm.taskmgmt.exe.TaskInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sun.font.EAttribute;

import com.base.frame.business.service.LeaveService;
import com.base.frame.dao.DictBussManager;
import com.base.frame.dao.LeaveManager;
import com.base.frame.model.AppInfo;
import com.base.frame.model.DictBuss;
import com.base.frame.model.Leave;
import com.base.frame.model.UserInfo;
import com.base.frame.model.Workflow;
import com.base.frame.system.PagerModel;

@Service
public class LeaveImplService implements LeaveService
{

    private Log logger = LogFactory.getLog(LeaveImplService.class);

    @Autowired
    private LeaveManager leaveManager;

    @Autowired
    private DictBussManager dictBussManager;

    @Override
    @Transactional
    public void addApproveInfo(AppInfo approveInfo, int leaveId, int approverId, boolean back, String transistionName)
    {
        leaveManager.addApproveInfo(approveInfo, leaveId, approverId, back);

        if (!back && StringUtils.isNotBlank(transistionName))
        {
            leaveManager.submitToWorkflow(approverId, leaveId, transistionName);
        }
    }

    @Override
    @Transactional
    public void addLeave(Leave leave, int workflowId, int userId)
    {
        AppInfo appInfo = new AppInfo();

        appInfo.setApproveTime(new Date());

        appInfo.setAggType(Leave.STATUS_SUBMIT);

        leaveManager.addLeave(leave, workflowId, userId, appInfo);

    }

    @Override
    @Transactional
    public void delLeave(int leaveId)
    {

        leaveManager.delLeave(leaveId);
        leaveManager.delAppInfoByLeaveId(leaveId);

    }

    @Override
    public Leave findLeave(int leaveId)
    {
        return leaveManager.findLeave(leaveId);
    }

    @Override
    public List searchApproveInfos(int leaveId)
    {
        return leaveManager.searchApproveInfos(leaveId);
    }

    @Override
    public String searchApprovedLeaves(Object param, int offset, int pagesize, int userId)
    {
        PagerModel pm = leaveManager.searchApprovedLeaves(param, offset, pagesize, userId);

        return getJsonData(pm.getDatas(), pm.getTotal());
    }

    @Override
    public String searchApprovingLeaves(Object param, int offset, int pagesize, int userId)
    {
        PagerModel pm = leaveManager.searchApprovingLeaves(param, userId, offset, pagesize);

        return getJsonData(pm.getDatas(), pm.getTotal());

    }

    @Override
    public PagerModel searchMyLeaves(int userId)
    {
        return null;
    }

    @Override
    public List searchNextSteps(int leaveId, int userId)
    {
        return leaveManager.searchNextSteps(leaveId, userId);
    }

    @Override
    @Transactional
    public void submitToWorkflow(int userId, int leaveId, String transistionName)
    {

        leaveManager.submitToWorkflow(userId, leaveId, transistionName);

    }

    @Override
    @Transactional
    public void updateLeave(Leave leave, int workflowId, int userId)
    {
        leaveManager.updateLeave(leave, workflowId, userId);

    }

    @Override
    @SuppressWarnings("unchecked")
    public String searchLeaves(Object param, int offset, int pagesize, int userId, String type)
    {

        PagerModel pm = leaveManager.searchLeaves(param, offset, pagesize, userId, type);

        return getJsonData(pm.getDatas(), pm.getTotal());

    }

    /**
     * [简要描述]:<br/> [详细描述]:<br/>
     * 
     * @author tangdingyi
     * @param datas
     * @param totals
     * @return
     */
    private String getJsonData(List<Leave> datas, int totals)
    {
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setJsonPropertyFilter(new PropertyFilter()
        {
            public boolean apply(Object source, String name, Object value)
            {
                // 忽略Workflow属性
                // if (value != null &&
                // Workflow.class.isAssignableFrom(value.getClass()))
                // {
                // return true;
                // }
                // 忽略UserInfo属性
                if (value != null && UserInfo.class.isAssignableFrom(value.getClass()))
                {
                    return true;
                }

                return false;
            }
        });

        jsonConfig.registerJsonValueProcessor(Workflow.class, new JsonValueProcessor()
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

                if (key.equals("workflow"))
                {
                    return ((Workflow) value).getId();
                }
                return value;

            }

        });

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

                if (key.equals("startTime") || key.equals("endTime") || key.equals("createTime"))
                {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
                    if (null == value)
                    {
                        return "";
                    }
                    String res = "";
                    try
                    {
                        Date d = sdf.parse(value.toString());
                        res = DateFormatUtils.format(d, "yyyy-MM-dd HH:mm:ss");
                    }
                    catch (ParseException e)
                    {
                        logger.error("ParseException", e);
                    }

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

                if (key.equals("leaveType"))
                {
                    if (null == value)
                    {
                        return "";
                    }
                    String res = "";
                    List<DictBuss> listDictBuss = dictBussManager.listDictBuss(3);
                    if (Integer.parseInt(value.toString()) == 10000)
                    {
                        return "异常打卡";
                    }
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
        result.put("total", totals);
        result.put("rows", datas);
        String s = "";
        try
        {
            s = JSONObject.fromObject(result, jsonConfig).toString();
        }
        catch (DataAccessException e)
        {
            logger.error("JSONObject.fromObject(result,jsonConfig).toString()", e);
        }

        return s;
    }

    @Override
    public List getUser(String roleName, int orgId)
    {
        return leaveManager.getUser(roleName, orgId);
    }

    @Override
    public TaskInstance loadTaskInstance(int taskInstanceId)
    {
        return leaveManager.loadTaskInstance(taskInstanceId);
    }

    @Override
    public Token loadToken(int tokenInstanceId)
    {
        return leaveManager.loadToken(tokenInstanceId);
    }

    @Override
    public ProcessInstance loadProcessInstance(int leaveId)
    {
        return leaveManager.loadProcessInstance(leaveId);
    }

}
