package com.base.frame.model;

/**
 * 
 * [ºÚ“™√Ë ˆ]:<br/>
 * [œÍœ∏√Ë ˆ]:<br/>
 *
 * @author tangdingyi
 * @version 1.0, Sep 24, 2011
 */
public class DictBuss
{

    private int id;

    private int dictId;

    private String dictName;

    private int dictType;
    
    private String descript;

    public String getDescript()
    {
        return descript;
    }

    public void setDescript(String descript)
    {
        this.descript = descript;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getDictId()
    {
        return dictId;
    }

    public void setDictId(int dictId)
    {
        this.dictId = dictId;
    }

    public String getDictName()
    {
        return dictName;
    }

    public void setDictName(String dictName)
    {
        this.dictName = dictName;
    }

    public int getDictType()
    {
        return dictType;
    }

    public void setDictType(int dictType)
    {
        this.dictType = dictType;
    }
}
