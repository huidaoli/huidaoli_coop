package com.base.frame.common;

import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.base.frame.dao.FormManager;
import com.base.frame.model.FlowForm;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Component
public class DynaFormFunction
{

    private static FormManager formManager;

    @Autowired
    public void setFormManager(FormManager formManager)
    {
        DynaFormFunction.formManager = formManager;
    }

    private static Configuration cfg = FreemarkerUtil.getConfiguration();

    public static String form(int workflowId)
    {
        try
        {
            FlowForm form = formManager.findForm(workflowId);
            if (null == form)
            {
                return null;
            }

            Template template = cfg.getTemplate(form.getTemplate());

            // 最终输出的位置
            Writer out = new StringWriter();

            Map<String, FlowForm> rootMap = new HashMap<String, FlowForm>();
            
            rootMap.put("form", form);

            template.process(rootMap, out);

            return out.toString();

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

}
