package com.cantodo.content.manacont.service.impl;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cantodo.content.dto.Content;
import com.cantodo.content.manacont.service.ManacontService;
import com.cantodo.content.persistence.ContentMapper;

@Service("manacontServiceImpl")
public class ManacontServiceImpl implements ManacontService
{

    private Log logger = LogFactory.getLog(ManacontServiceImpl.class);

    @Autowired
    private ContentMapper contentMapper;

    public Content getInfoById(int id)
    {
        logger.debug("enter getInfoById");

        Content r = contentMapper.getInfoById(id);

        logger.debug("exit getInfoById");
        return r;
    }

    @Override
    public void delete(int id)
    {
        contentMapper.delete(id);

    }

    @Override
    public void insert(Content content)
    {
        contentMapper.insert(content);

    }

    @Override
    public void update(Content content)
    {
        contentMapper.update(content);

    }

    @Override
    public void updateContent(Content content)
    {
        try
        {
            contentMapper.updateContent(content);
        }
        catch (RuntimeException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }


}
