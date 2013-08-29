package com.cantodo.content.dto;

import java.io.Serializable;
import java.util.List;

public class ProductShop implements Serializable
{
    /**
     * [¼òÒªÃèÊö]:
     * @author tangdingyi
     */
    private static final long serialVersionUID = 1807499788616381894L;

    private int catid;

    private String goodssn;

    private String goodsname;

    private String brandid;

    private String providername;

    private String goodsnumber;

    private String goodsweight;

    private String marketprice;

    private String shopprice;

    private String goodsbrief;

    private String goodsdesc;

    private String goodsthumb;

    private String goodsimg;

    private String originalimg;

    private String goodstype;
    
    private String addtime;
    
    private List<ProPic> imglist;

    public String getAddtime()
    {
        return addtime;
    }

    public void setAddtime(String addtime)
    {
        this.addtime = addtime;
    }

    public List<ProPic> getImglist()
    {
        return imglist;
    }

    public void setImglist(List<ProPic> imglist)
    {
        this.imglist = imglist;
    }

    public int getCatid()
    {
        return catid;
    }

    public void setCatid(int catid)
    {
        this.catid = catid;
    }

    public String getGoodssn()
    {
        return goodssn;
    }

    public void setGoodssn(String goodssn)
    {
        this.goodssn = goodssn;
    }

    public String getGoodsname()
    {
        return goodsname;
    }

    public void setGoodsname(String goodsname)
    {
        this.goodsname = goodsname;
    }

    public String getBrandid()
    {
        return brandid;
    }

    public void setBrandid(String brandid)
    {
        this.brandid = brandid;
    }

    public String getProvidername()
    {
        return providername;
    }

    public void setProvidername(String providername)
    {
        this.providername = providername;
    }

    public String getGoodsnumber()
    {
        return goodsnumber;
    }

    public void setGoodsnumber(String goodsnumber)
    {
        this.goodsnumber = goodsnumber;
    }

    public String getGoodsweight()
    {
        return goodsweight;
    }

    public void setGoodsweight(String goodsweight)
    {
        this.goodsweight = goodsweight;
    }

    public String getMarketprice()
    {
        return marketprice;
    }

    public void setMarketprice(String marketprice)
    {
        this.marketprice = marketprice;
    }

    public String getShopprice()
    {
        return shopprice;
    }

    public void setShopprice(String shopprice)
    {
        this.shopprice = shopprice;
    }

    public String getGoodsbrief()
    {
        return goodsbrief;
    }

    public void setGoodsbrief(String goodsbrief)
    {
        this.goodsbrief = goodsbrief;
    }

    public String getGoodsdesc()
    {
        return goodsdesc;
    }

    public void setGoodsdesc(String goodsdesc)
    {
        this.goodsdesc = goodsdesc;
    }

    public String getGoodsthumb()
    {
        return goodsthumb;
    }

    public void setGoodsthumb(String goodsthumb)
    {
        this.goodsthumb = goodsthumb;
    }

    public String getGoodsimg()
    {
        return goodsimg;
    }

    public void setGoodsimg(String goodsimg)
    {
        this.goodsimg = goodsimg;
    }

    public String getOriginalimg()
    {
        return originalimg;
    }

    public void setOriginalimg(String originalimg)
    {
        this.originalimg = originalimg;
    }

    public String getGoodstype()
    {
        return goodstype;
    }

    public void setGoodstype(String goodstype)
    {
        this.goodstype = goodstype;
    }

}
