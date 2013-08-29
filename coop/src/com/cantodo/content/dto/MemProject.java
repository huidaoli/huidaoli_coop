package com.cantodo.content.dto;

import java.io.Serializable;

public class MemProject implements Serializable
{

    /**
	 * 
	 */
	private static final long serialVersionUID = -5486610403236975381L;

	/**
     * [¼òÒªÃèÊö]:
     * 
     * @author tangdingyi
     */

    private int memid;

    private int projectid;

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


    public int getProjectid() {
		return projectid;
	}

	public void setProjectid(int projectid) {
		this.projectid = projectid;
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
