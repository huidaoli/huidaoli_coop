package com.base.frame.common;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.access.BeanFactoryLocator;
import org.springframework.beans.factory.access.BeanFactoryReference;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springmodules.workflow.jbpm31.JbpmFactoryLocator;

public class BaseAutoWire
{

    public BaseAutoWire()
    {
        ((AutowireCapableBeanFactory) retrieveBeanFactory()).autowireBeanProperties(this,
                AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, true);
    }

    protected BeanFactory retrieveBeanFactory()
    {
        BeanFactoryLocator factoryLocator = new JbpmFactoryLocator();
        BeanFactoryReference factory = factoryLocator.useBeanFactory(null);
        if (null == factory)
        {
            throw new IllegalArgumentException("no beanFactory found under key=" + null);
        }
        try
        {
            return factory.getFactory();
        }
        finally
        {
            factory.release();
        }

    }
}
