package com.cantodo.content.dto;

import java.io.Serializable;
import java.util.Date;

public class AgreementItem implements Serializable
{

    /**
     * [��Ҫ����]:
     * 
     * @author tangdingyi
     */
    private static final long serialVersionUID = -1387278414533068848L;

    // id
    private int id;
    
    //pcode
    private String pcode;
    
    //
    private String proid;

    // Ʒ��
    private String proname;

    // ���
    private String guige;

    // ����
    private String candi;

    // ����
    private String shuliang;

    // ����
    private String danjia;

    // С��
    private String xiaoji;

    // ��������
    private Date jhsj;

    // ������ַ
    private String jhdd;

    // ������ϵ��
    private String jflxr;

    // ��ϵ�绰
    private String lxdh;

    // ��ע
    private String bz;

    public String getProid()
    {
        return proid;
    }

    public void setProid(String proid)
    {
        this.proid = proid;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }


    public String getProname()
    {
        return proname;
    }

    public void setProname(String proname)
    {
        this.proname = proname;
    }

    public String getGuige()
    {
        return guige;
    }

    public void setGuige(String guige)
    {
        this.guige = guige;
    }

    public String getCandi()
    {
        return candi;
    }

    public void setCandi(String candi)
    {
        this.candi = candi;
    }

    public String getShuliang()
    {
        return shuliang;
    }

    public void setShuliang(String shuliang)
    {
        this.shuliang = shuliang;
    }

    public String getDanjia()
    {
        return danjia;
    }

    public void setDanjia(String danjia)
    {
        this.danjia = danjia;
    }

    public String getXiaoji()
    {
        return xiaoji;
    }

    public void setXiaoji(String xiaoji)
    {
        this.xiaoji = xiaoji;
    }

    public Date getJhsj()
    {
        return jhsj;
    }

    public void setJhsj(Date jhsj)
    {
        this.jhsj = jhsj;
    }

    public String getJhdd()
    {
        return jhdd;
    }

    public void setJhdd(String jhdd)
    {
        this.jhdd = jhdd;
    }

    public String getJflxr()
    {
        return jflxr;
    }

    public void setJflxr(String jflxr)
    {
        this.jflxr = jflxr;
    }

    public String getLxdh()
    {
        return lxdh;
    }

    public void setLxdh(String lxdh)
    {
        this.lxdh = lxdh;
    }

    public String getBz()
    {
        return bz;
    }

    public void setBz(String bz)
    {
        this.bz = bz;
    }

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}


}
