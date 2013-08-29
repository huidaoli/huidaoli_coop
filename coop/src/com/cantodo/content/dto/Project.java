package com.cantodo.content.dto;

import java.io.Serializable;
import java.util.Date;

public class Project implements Serializable
{

    /**
     * [��Ҫ����]:
     * 
     * @author tangdingyi
     */
    private static final long serialVersionUID = 1302302269714051322L;

    private int id;
    
    //��Ŀ���
    private String no;

    //����
    private String name;

    //���
    private int type;

    //��������
    private int itfx;

    //Ӧ����ҵ����
    private int yyfx;

    //����
    private int longday;

    //��ʼʱ��
    private Date startTime;

    //����ʱ��
    private Date endTime;

    //�Ŷ�����
    private int groupper;

    //��Ŀ��ģ
    private String ry;

    //Ͷ�ʹ�ģ
    private String touzif;

    //������
    private String fbf;

    //�а���
    private String cbf;

    //��Ŀ����
    private String pm;

    //��Ŀ����
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
