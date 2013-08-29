package com.cantodo.content.upload.service.impl;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cantodo.content.dto.FileUpload;
import com.cantodo.content.persistence.AttaMapper;
import com.cantodo.content.upload.service.UploadService;

/**
 * [简要描述]:<br/> [详细描述]:<br/>
 * 
 * @author tangdingyi
 * @version 1.0, Oct 26, 2011
 */
@Service("uploadServiceImpl")
public class UploadServiceImpl implements UploadService
{

    private Log logger = LogFactory.getLog(UploadServiceImpl.class);

    @Autowired
    private AttaMapper attaMapper;

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public void add(String path, List<FileUpload> list)
    {

    	logger.debug("enter add");

        File[] uploadFiles = null;
        String[] fileNames = null;
        Map mapPara = null;
        String attid = null;
        String filename = null;
        int width = 0;
        int height = 0;
        for (FileUpload fileUpload : list)
        {

            uploadFiles = fileUpload.getUploadFiles();
            fileNames = fileUpload.getFileNames();
            for (int i = 0; i < uploadFiles.length; i++)
            {
                mapPara = new HashMap();

                File uploadFile = uploadFiles[i];
                
                //文件大小为0，不考虑
                if (!uploadFile.exists())
                {
                    continue;
                }
                // 如果文件夹不存在，创建文件夹,将文件保存到目录
                File dir = new File(path);
                if (!dir.exists())
                {
                    dir.mkdirs();
                }

                String ext = fileNames[i].substring(fileNames[i].indexOf("."), fileNames[i].length());// 获取文件扩展名
                
               
                ext = ext.toLowerCase();

                attid = UUID.randomUUID().toString();

                filename = attid + ext;

                File file = new File(path + File.separator + filename);
                
                
                byte[] data = new byte[8192];
                int byteRead = -1;
                try
                {
                    FileInputStream in = new FileInputStream(uploadFile);
                    FileOutputStream out = new FileOutputStream(file);
                    while ((byteRead = in.read(data)) != -1)
                    {
                        out.write(data, 0, byteRead);
                        out.flush();
                    }
                    out.close();
                    in.close();
                }
                catch (Exception e)
                {
                    logger.error("", e);
                }
                // ============对图片的处理=========
                int[] rs = getSize(file);
                if (null != rs)
                {
                    width = rs[0];
                    height = rs[1];
                }
                // ===============================
                mapPara.put("attaid", attid);
                mapPara.put("attaname", fileNames[i]);
                mapPara.put("newname", filename);
                mapPara.put("contcode", fileUpload.getContcode());
                mapPara.put("width", width);
                mapPara.put("height", height);
                attaMapper.insert(mapPara);

            }
        }
        
  		
        logger.debug("exit add");

    }
    
    
    
    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public void addPicture(String path, List<FileUpload> list)
    {
    	logger.debug("enter addPicture");

        File[] uploadFiles = null;
        String[] fileNames = null;
        Map mapPara = null;
        String attid = null;
        String filename = null;
        int width = 0;
        int height = 0;
        for (FileUpload fileUpload : list)
        {

            uploadFiles = fileUpload.getUploadFiles();
            fileNames = fileUpload.getFileNames();
            for (int i = 0; i < uploadFiles.length; i++)
            {
                mapPara = new HashMap();

                File uploadFile = uploadFiles[i];
                
                //文件大小为0，不考虑
                if (!uploadFile.exists())
                {
                    continue;
                }
                // 如果文件夹不存在，创建文件夹,将文件保存到目录
                File dir = new File(path);
                if (!dir.exists())
                {
                    dir.mkdirs();
                }

                String ext = fileNames[i].substring(fileNames[i].indexOf("."), fileNames[i].length());// 获取文件扩展名
                
               
                ext = ext.toLowerCase();

                attid = UUID.randomUUID().toString();

                filename = attid + ext;

                File file = new File(path + File.separator + filename);
                
                
                byte[] data = new byte[8192];
                int byteRead = -1;
                try
                {
                    FileInputStream in = new FileInputStream(uploadFile);
                    FileOutputStream out = new FileOutputStream(file);
                    while ((byteRead = in.read(data)) != -1)
                    {
                        out.write(data, 0, byteRead);
                        out.flush();
                    }
                    out.close();
                    in.close();
                }
                catch (Exception e)
                {
                    logger.error("", e);
                }
                // ============对图片的处理=========
                int[] rs = getSize(file);
                if (null != rs)
                {
                    width = rs[0];
                    height = rs[1];
                }
                // ===============================
                mapPara.put("attaid", attid);
                mapPara.put("attaname", fileNames[i]);
                mapPara.put("newname", filename);
                mapPara.put("contcode", fileUpload.getContcode());
                mapPara.put("width", width);
                mapPara.put("height", height);
                attaMapper.insert(mapPara);

            }
        }
        
  		
        logger.debug("exit addPicture");

    }
    
    
    @SuppressWarnings("unchecked")
    @Transactional
    public String add2(String path, List<FileUpload> list)
    {
    	logger.debug("enter add2");


        File[] uploadFiles = null;
        String[] fileNames = null;
        Map mapPara = null;
        String attid = null;
        String filename = null;
        int width = 0;
        int height = 0;
        for (FileUpload fileUpload : list)
        {

            uploadFiles = fileUpload.getUploadFiles();
            fileNames = fileUpload.getFileNames();
            for (int i = 0; i < uploadFiles.length; i++)
            {
                mapPara = new HashMap();

                File uploadFile = uploadFiles[i];
                
                //文件大小为0，不考虑
                if (!uploadFile.exists())
                {
                    continue;
                }
                // 如果文件夹不存在，创建文件夹,将文件保存到目录
                File dir = new File(path);
                if (!dir.exists())
                {
                    dir.mkdirs();
                }

                String ext = fileNames[i].substring(fileNames[i].indexOf("."), fileNames[i].length());// 获取文件扩展名
                
               
                ext = ext.toLowerCase();

                attid = UUID.randomUUID().toString();

                filename = attid + ext;

                File file = new File(path + File.separator + filename);
                
                
                byte[] data = new byte[8192];
                int byteRead = -1;
                try
                {
                    FileInputStream in = new FileInputStream(uploadFile);
                    FileOutputStream out = new FileOutputStream(file);
                    while ((byteRead = in.read(data)) != -1)
                    {
                        out.write(data, 0, byteRead);
                        out.flush();
                    }
                    out.close();
                    in.close();
                }
                catch (Exception e)
                {
                    //logger.error("", e);
                }
                // ============对图片的处理=========
                int[] rs = getSize(file);
                if (null != rs)
                {
                    width = rs[0];
                    height = rs[1];
                }
                // ===============================
                mapPara.put("attaid", attid);
                mapPara.put("attaname", fileNames[i]);
                mapPara.put("newname", filename);
                mapPara.put("contcode", fileUpload.getContcode());
                mapPara.put("width", width);
                mapPara.put("height", height);
                attaMapper.insert(mapPara);

            }
        }
  		
        logger.debug("exit add2");
        
        return filename;

    }
    
    private int[] getSize(File file)
    {
    	
    	logger.debug("enter getSize");

        Image src = null;
        try
        {
            src = javax.imageio.ImageIO.read(file);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        } 
        if(null == src)
        {
            return null;
        }
        //构造Image对象  
        if(src.getWidth(null) == -1 || src.getHeight(null) == -1)
        {
            return null;
        }
        int wideth=src.getWidth(null); //得到源图宽  
        int height=src.getHeight(null); //得到源图长  
        
  		
        logger.debug("exit getSize");
        
        return new int[]{wideth,height};

    }

    @SuppressWarnings("unchecked")
    public List getAttaById(String ids)
    {
    	
    	logger.debug("enter getAttaById");

        List res = null;
        try
        {
            res = attaMapper.getAttaById(ids);
        }
        catch (RuntimeException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
  		
        logger.debug("exit getAttaById");
        return res;
    }

    public void deleAtta(String id)
    {
    	logger.debug("enter deleAtta");

        try
        {
            attaMapper.delete(id);
        }
        catch (RuntimeException e)
        {
            // TODO Auto-generated catch block
            logger.debug("deleAtta", e);
        }
  		
        logger.debug("exit deleAtta");
    }

}
