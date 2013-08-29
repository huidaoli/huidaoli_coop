package com.base.frame.common;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

public class FreemarkerUtil
{
    private static Configuration cfg = new Configuration();
    static
    {

        // ��ʲô�ط�����freemarkerģ���ļ�
        cfg.setTemplateLoader(new ClassTemplateLoader(DynaFormFunction.class, "templates"));

        // �����쳣������
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);

    }

    public static Configuration getConfiguration()
    {
        return cfg;
    }
}
