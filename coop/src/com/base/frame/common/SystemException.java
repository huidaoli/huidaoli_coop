package com.base.frame.common;

/**
 * 
 * [ºÚ“™√Ë ˆ]:<br/>
 * [œÍœ∏√Ë ˆ]:<br/>
 *
 * @author tangdingyi
 * @version 1.0, Sep 28, 2011
 */
public class SystemException extends RuntimeException
{
    /**
     * [ºÚ“™√Ë ˆ]:
     * 
     * @author tangdingyi
     */
    private static final long serialVersionUID = -5588528781009409579L;

    private String key;

    private Object[] values;

    public SystemException()
    {
        super();
    }

    public SystemException(String message, Throwable throwable)
    {
        super(message, throwable);
    }

    public SystemException(String message)
    {
        super(message);
    }

    public SystemException(Throwable throwable)
    {
        super(throwable);
    }

    public SystemException(String key, String message)
    {
        super(message);
        this.key = key;
    }

    public SystemException(String key, Object value, String message)
    {
        super(message);
        this.key = key;
        this.values = new Object[] {value};
    }

    public SystemException(String key, Object[] values, String message)
    {
        super(message);
        this.key = key;
        this.values = values;
    }

    public String getKey()
    {
        return key;
    }

    public Object[] getValues()
    {
        return values;
    }

}
