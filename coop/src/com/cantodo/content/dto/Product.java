package com.cantodo.content.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Product implements Serializable
{

    /**
     * [简要描述]:
     * @author tangdingyi
     */
    private static final long serialVersionUID = -6233545957174727924L;

    //产品id
    private int id;
    
    //产品code
    private String code;

    // 产品名称
    private String name;
    
    // 产品热词
    private String hotword;
    
    //产品分类
    private int sort;

    // 产地
    private String proarea;

    // 状态
    private int state;
    
    //上架,下架
    private int linestate;
    
    //是否同步 0未同步,1同步
    private int sync;

    // 规格信息
    private String specinfo;

    // 功效信息
    private String efficacyinfo;

    // 描述
    private String remark;

    // 发布日期
    private Date createDate;
    
    //类型图--首页页面展示
    private String typeimg;
    
    //商城url
    private String mallurl;

    // 产品所属合作者
    private int coopid;
    
    //市场价格
    private double markingprice ;
    
    //本店价格
    private double ourprice ;
    
    //商品重量
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
