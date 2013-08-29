package com.cantodo.content.persistence;

import java.util.Map;

import com.cantodo.content.dto.Content;

/**
 * @author tdy
 */
public interface ContentMapper
{

    Content getInfoById(int id);
    
    Content getInfoByTypeCoop(Map map);

    void insert(Content content);

    void update(Content content);
    
    void updateContent(Content content);

    void delete(int id);

}
