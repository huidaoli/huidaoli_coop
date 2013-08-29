package com.base.frame.model;

import java.util.Date;

/**
 * 
 * [ºÚ“™√Ë ˆ]:<br/>
 * [œÍœ∏√Ë ˆ]:<br/>
 *
 * @author tangdingyi
 * @version 1.0, Nov 4, 2011
 */
public class AppInfo
{

    private int id;

    private Date approveTime;

    private UserInfo approver;

    private String mess;
    
    private String aggType;

    private Leave leave;

    public String getMess()
    {
        return mess;
    }

    public void setMess(String mess)
    {
        this.mess = mess;
    }

    public Leave getLeave()
    {
        return leave;
    }

    public void setLeave(Leave leave)
    {
        this.leave = leave;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Date getApproveTime()
    {
        return approveTime;
    }

    public void setApproveTime(Date approveTime)
    {
        this.approveTime = approveTime;
    }

    public UserInfo getApprover()
    {
        return approver;
    }

    public void setApprover(UserInfo approver)
    {
        this.approver = approver;
    }

    public String getAggType()
    {
        return aggType;
    }

    public void setAggType(String aggType)
    {
        this.aggType = aggType;
    }

}
