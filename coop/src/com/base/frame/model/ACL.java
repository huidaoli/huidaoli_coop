package com.base.frame.model;

/**
 * [ºÚ“™√Ë ˆ]:<br/> [œÍœ∏√Ë ˆ]:<br/>
 * 
 * @author tangdingyi
 * @version 1.0, Sep 27, 2011
 */
public class ACL
{

    public static final String TYPE_ROLE = "Role";

    public static final String TYPE_USER = "User";

    private int id;

    private String principalType;

    private int principalId;

    private int moduleId;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getPrincipalType()
    {
        return principalType;
    }

    public void setPrincipalType(String principalType)
    {
        this.principalType = principalType;
    }

    public int getPrincipalId()
    {
        return principalId;
    }

    public void setPrincipalId(int principalId)
    {
        this.principalId = principalId;
    }

    public int getModuleId()
    {
        return moduleId;
    }

    public void setModuleId(int moduleId)
    {
        this.moduleId = moduleId;
    }

}
