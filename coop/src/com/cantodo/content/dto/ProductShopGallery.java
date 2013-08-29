package com.cantodo.content.dto;

import java.io.Serializable;

public class ProductShopGallery implements Serializable
{
    /**
     * [¼òÒªÃèÊö]:
     * 
     * @author tangdingyi
     */
    private static final long serialVersionUID = -8239970240982870340L;

    private int goodsid;

    private String imgurl;

    private String imgdesc;

    private String thumburl;

    private String imgoriginal;

    public int getGoodsid()
    {
        return goodsid;
    }

    public void setGoodsid(int goodsid)
    {
        this.goodsid = goodsid;
    }

    public String getImgurl()
    {
        return imgurl;
    }

    public void setImgurl(String imgurl)
    {
        this.imgurl = imgurl;
    }

    public String getImgdesc()
    {
        return imgdesc;
    }

    public void setImgdesc(String imgdesc)
    {
        this.imgdesc = imgdesc;
    }

    public String getThumburl()
    {
        return thumburl;
    }

    public void setThumburl(String thumburl)
    {
        this.thumburl = thumburl;
    }

    public String getImgoriginal()
    {
        return imgoriginal;
    }

    public void setImgoriginal(String imgoriginal)
    {
        this.imgoriginal = imgoriginal;
    }
}
