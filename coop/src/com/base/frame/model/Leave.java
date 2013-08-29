package com.base.frame.model;

import java.util.Date;

/**
 * @author Administrator
 * @hibernate.class table="T_Leave"
 */
public class Leave
{

    public static final String STATUS_NEW = "新建";
    
    public static final String STATUS_MODIFY = "退回修改";

    public static final String STATUS_FINISH = "完成";
    
    public static final String STATUS_SUBMIT = "提交";

    private int id;

    private String title;

    private int leaveType;

    private Date startTime;

    private Date endTime;
    
    private String days;

    private String description;

    private Date createTime;

    private String status;

    private long processInstanceId;

    private Workflow workflow;

    private UserInfo creator;

    public Workflow getWorkflow()
    {
        return workflow;
    }

    public void setWorkflow(Workflow workflow)
    {
        this.workflow = workflow;
    }

    public UserInfo getCreator()
    {
        return creator;
    }

    public void setCreator(UserInfo creator)
    {
        this.creator = creator;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getLeaveType()
    {
        return leaveType;
    }

    public void setLeaveType(int leaveType)
    {
        this.leaveType = leaveType;
    }

    public Date getStartTime()
    {
        return startTime;
    }

    public void setStartTime(Date startTime)
    {
        this.startTime = startTime;
    }

    public Date getEndTime()
    {
        return endTime;
    }

    public void setEndTime(Date endTime)
    {
        this.endTime = endTime;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public long getProcessInstanceId()
    {
        return processInstanceId;
    }

    public void setProcessInstanceId(long processInstanceId)
    {
        this.processInstanceId = processInstanceId;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDays()
    {
        return days;
    }

    public void setDays(String days)
    {
        this.days = days;
    }
}
