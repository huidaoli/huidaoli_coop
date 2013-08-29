package com.cantodo.content.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Product implements Serializable
{

    /**
     * [��Ҫ����]:
     * @author tangdingyi
     */
    private static final long serialVersionUID = -6233545957174727924L;

    //��Ʒid
    private int id;
    
    //��Ʒcode
    private String code;

    // ��Ʒ����
    private String name;
    
    // ��Ʒ�ȴ�
    private String hotword;
    
    //��Ʒ����
    private int sort;

    // ����
    private String proarea;

    // ״̬
    private int state;
    
    //�ϼ�,�¼�
    private int linestate;
    
    //�Ƿ�ͬ�� 0δͬ��,1ͬ��
    private int sync;

    // �����Ϣ
    private String specinfo;

    // ��Ч��Ϣ
    private String efficacyinfo;

    // ����
    private String remark;

    // ��������
    private Date createDate;
    
    //����ͼ--��ҳҳ��չʾ
    private String typeimg;
    
    //�̳�url
    private String mallurl;

    // ��Ʒ����������
    private int coopid;
    
    //�г��۸�
    private double markingprice ;
    
    //����۸�
    private double ourprice ;
    
    //��Ʒ����
    private double weight;
    
    
    //---------------------------------------------
    //sorname
    private String sortname;
    
    private String coopname;
    
    private String tempdeleids;
    
    private List<ProPic> imglist;


    public List<ProPic> getImglist()
    {
        return imglist;
    }

    public void setImglist(List<ProPic> imglist)
    {
        this.imglist = imglist;
    }

    public String getTempdeleids()
    {
        return tempdeleids;
    }

    public void setTempdeleids(String tempdeleids)
    {
        this.tempdeleids = tempdeleids;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getSort()
    {
        return sort;
    }

    public void setSort(int sort)
    {
        this.sort = sort;
    }

    public String getProarea()
    {
        return proarea;
    }

    public void setProarea(String proarea)
    {
        this.proarea = proarea;
    }

    public int getState()
    {
        return state;
    }

    public void setState(int state)
    {
        this.state = state;
    }

    public int getLinestate()
    {
        return linestate;
    }

    public void setLinestate(int linestate)
    {
        this.linestate = linestate;
    }

    public String getSpecinfo()
    {
        return specinfo;
    }

    public void setSpecinfo(String specinfo)
    {
        this.specinfo = specinfo;
    }

    public String getEfficacyinfo()
    {
        return efficacyinfo;
    }

    public void setEfficacyinfo(String efficacyinfo)
    {
        this.efficacyinfo = efficacyinfo;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public Date getCreateDate()
    {
        return createDate;
    }

    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }

    public String getTypeimg()
    {
        return typeimg;
    }

    public void setTypeimg(String typeimg)
    {
        this.typeimg = typeimg;
    }

    public int getCoopid()
    {
        return coopid;
    }

    public void setCoopid(int coopid)
    {
        this.coopid = coopid;
    }

    public String getHotword()
    {
        return hotword;
    }

    public void setHotword(String hotword)
    {
        this.hotword = hotword;
    }

    public String getMallurl()
    {
        return mallurl;
    }

    public void setMallurl(String mallurl)
    {
        this.mallurl = mallurl;
    }

	public String getSortname() {
		return sortname;
	}

	public void setSortname(String sortname) {
		this.sortname = sortname;
	}

    public String getCoopname()
    {
        return coopname;
    }

    public void setCoopname(String coopname)
    {
        this.coopname = coopname;
    }

    public int getSync()
    {
        return sync;
    }

    public void setSync(int sync)
    {
        this.sync = sync;
    }

    public double getMarkingprice()
    {
        return markingprice;
    }

    public void setMarkingprice(double markingprice)
    {
        this.markingprice = markingprice;
    }

    public double getOurprice()
    {
        return ourprice;
    }

    public void setOurprice(double ourprice)
    {
        this.ourprice = ourprice;
    }

    public double getWeight()
    {
        return weight;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

}
