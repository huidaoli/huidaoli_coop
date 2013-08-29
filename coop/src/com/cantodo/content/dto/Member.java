package com.cantodo.content.dto;

import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 2351180554448022316L;

    // �û�id
    private int id;

    // �û�code
    private String code;

    // �ֻ�����ΪuerName
    private String userName;

    private String password;

    // ��ʵ����
    private String realName;

    // ��������
    private int cooptype;

    // ���ú���
    private String mphone;

    //400�绰
    private String fphone;
    
    // ����
    private String email;

    // ��ַ
    private String address;
    
    //����
    private String area;

    // �Ա�
    private int sex;
    
    //��˾��λ����
    private String companyname;

    //��������
    private Date createDate;

    //��ע
    private String remark;
    
    //Ʒ��LOGO
    private String logo;

    // �û�״̬
    private int state;

    // �Ƿ����step��Ϣ
    private int flag;

    public String getFphone()
    {
        return fphone;
    }

    public void setFphone(String fphone)
    {
        this.fphone = fphone;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public int getFlag()
    {
        return flag;
    }

    public void setFlag(int flag)
    {
        this.flag = flag;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
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

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getRealName()
    {
        return realName;
    }

    public void setRealName(String realName)
    {
        this.realName = realName;
    }

    public int getSex()
    {
        return sex;
    }

    public void setSex(int sex)
    {
        this.sex = sex;
    }

    public Date getCreateDate()
    {
        return createDate;
    }

    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }

    public String getMphone()
    {
        return mphone;
    }

    public void setMphone(String mphone)
    {
        this.mphone = mphone;
    }

    public int getCooptype()
    {
        return cooptype;
    }

    public void setCooptype(int cooptype)
    {
        this.cooptype = cooptype;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getCompanyname()
    {
        return companyname;
    }

    public void setCompanyname(String companyname)
    {
        this.companyname = companyname;
    }

    public String getArea()
    {
        return area;
    }

    public void setArea(String area)
    {
        this.area = area;
    }

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

}
