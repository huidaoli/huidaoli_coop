package com.cantodo.content.dto;

import java.io.Serializable;
import java.util.Date;

public class MemClass implements Serializable
{

    /**
     * [¼òÒªÃèÊö]:
     * 
     * @author tangdingyi
     */
    private static final long serialVersionUID = -7052271013061340882L;

    private int memid;

    private int classid;

    private int state;
    
    private String remark;

    public int getMemid()
    {
        return memid;
    }

    public void setMemid(int memid)
    {
        this.memid = memid;
    }

    public int getClassid()
    {
        return classid;
    }

    public void setClassid(int classid)
    {
        this.classid = classid;
    }

    public int getState()
    {
        return state;
    }

    public void setState(int state)
    {
        this.state = state;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

}
