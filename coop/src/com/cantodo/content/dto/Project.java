package com.cantodo.content.dto;

import java.io.Serializable;
import java.util.Date;

public class Project implements Serializable
{

    /**
     * [简要描述]:
     * 
     * @author tangdingyi
     */
    private static final long serialVersionUID = 1302302269714051322L;

    private int id;
    
    //项目编号
    private String no;

    //名称
    private String name;

    //类别
    private int type;

    //技术方向
    private int itfx;

    //应用行业方向
    private int yyfx;

    //工期
    private int longday;

    //开始时间
    private Date startTime;

    //结束时间
    private Date endTime;

    //团队人数
    private int groupper;

    //项目规模
    private String ry;

    //投资规模
    private String touzif;

    //发包方
    private String fbf;

    //承包方
    private String cbf;

    //项目经理
    private String pm;

    //项目描述
    private String desctio;
    
    private String contcode;
    
    
    private String ctype;

    public String getCtype()
    {
        return ctype;
    }

    public void setCtype(String ctype)
    {
        this.ctype = ctype;
    }

    public String getContcode()
    {
        return contcode;
    }

    public void setContcode(String contcode)
    {
        this.contcode = contcode;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getNo()
    {
        return no;
    }

    public void setNo(String no)
    {
        this.no = no;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getType()
    {
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }

    public int getItfx()
    {
        return itfx;
    }

    public void setItfx(int itfx)
    {
        this.itfx = itfx;
    }

    public int getYyfx()
    {
        return yyfx;
    }

    public void setYyfx(int yyfx)
    {
        this.yyfx = yyfx;
    }

    public int getLongday()
    {
        return longday;
    }

    public void setLongday(int longday)
    {
        this.longday = longday;
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

    public int getGroupper()
    {
        return groupper;
    }

    public void setGroupper(int groupper)
    {
        this.groupper = groupper;
    }

    public String getRy()
    {
        return ry;
    }

    public void setRy(String ry)
    {
        this.ry = ry;
    }

    public String getTouzif()
    {
        return touzif;
    }

    public void setTouzif(String touzif)
    {
        this.touzif = touzif;
    }

    public String getFbf()
    {
        return fbf;
    }

    public void setFbf(String fbf)
    {
        this.fbf = fbf;
    }

    public String getCbf()
    {
        return cbf;
    }

    public void setCbf(String cbf)
    {
        this.cbf = cbf;
    }

    public String getPm()
    {
        return pm;
    }

    public void setPm(String pm)
    {
        this.pm = pm;
    }

    public String getDesctio()
    {
        return desctio;
    }

    public void setDesctio(String desctio)
    {
        this.desctio = desctio;
    }

}
