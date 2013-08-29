package com.cantodo.content.upload.service;

import java.util.List;

import com.cantodo.content.dto.FileUpload;

public interface UploadService
{

    void add(String path, List<FileUpload> list);

    void addPicture(String path, List<FileUpload> list);

    String add2(String path, List<FileUpload> list);

    List getAttaById(String ids);

    void deleAtta(String id);

}
