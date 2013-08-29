package com.cantodo.content.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Agreement implements Serializable
{

    /**
     * [简要描述]:
     * 
     * @author tangdingyi
     */
    private static final long serialVersionUID = -394029920560868748L;

    private int id;

    // 合约号
    private String no;

    // 合约标题
    private String title;

    // 合约时间
    private Date createDate;

    // 合约类别
    private int type;

    // 合约状态
    private int state;

    // 乙方
    private int coopid;

    // 甲方
    private int jiafang;

    // 采购明细
    private List<AgreementItem> item;

    // 扩展信息
    private AgreementExt ext;
    
    // 合同生效时间
    private Date sxsj;
    
    //code
    private String code;

    // ------------页面显示熟悉----
    // 类型
    private String typename;

    // 甲方
    private String jfname;

    // 乙方
    private String coopname;


    public List<AgreementItem> getItem()
    {
        return item;
    }

    public void setItem(List<AgreementItem> item)
    {
        this.item = item;
    }

    public AgreementExt getExt()
    {
        return ext;
    }

    public void setExt(AgreementExt ext)
    {
        this.ext = ext;
    }

    public String getJfname()
    {
        return jfname;
    }

    public void setJfname(String jfname)
    {
        this.jfname = jfname;
    }

    public int getJiafang()
    {
        return jiafang;
    }

    public void setJiafang(int jiafang)
    {
        this.jiafang = jiafang;
    }

    public String getCoopname()
    {
        return coopname;
    }

    public void setCoopname(String coopname)
    {
        this.coopname = coopname;
    }

    public String getTypename()
    {
        return typename;
    }

    public void setTypename(String typename)
    {
        this.typename = typename;
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

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Date getCreateDate()
    {
        return createDate;
    }

    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }

    public int getType()
    {
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }

    public int getState()
    {
        return state;
    }

    public void setState(int state)
    {
        this.state = state;
    }

    public int getCoopid()
    {
        return coopid;
    }

    public void setCoopid(int coopid)
    {
        this.coopid = coopid;
    }

	public Date getSxsj() {
		return sxsj;
	}

	public void setSxsj(Date sxsj) {
		this.sxsj = sxsj;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
