package com.cantodo.content.manacont.service;

import com.cantodo.content.dto.Content;

public interface ManacontService
{

    @SuppressWarnings("unchecked")
    Content getInfoById(int id);

    void insert(Content content);

    void update(Content content);

    void delete(int id);

    void updateContent(Content content);

}
