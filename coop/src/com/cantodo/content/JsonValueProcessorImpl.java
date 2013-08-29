package com.cantodo.content;

import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class JsonValueProcessorImpl implements JsonValueProcessor
{

    @Override
    public Object processArrayValue(Object value, JsonConfig jsonConfig)
    {
        if (value == null)
        {
            return "";
        }
        return value;
    }

    @Override
    public Object processObjectValue(String key, Object value, JsonConfig jsonConfig)
    {
        if (key.equals("createDate"))
        {
            if (null == value)
            {
                return "";
            }
            String res = DateFormatUtils.format((Date) value, "yyyy-MM-dd");

            return res;
        }

        return value;
    }

}
