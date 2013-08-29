package com.cantodo.content.ads.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.cantodo.content.ads.service.AdsService;
import com.cantodo.content.dto.Ads;
import com.cantodo.content.dto.FileUpload;
import com.cantodo.content.dto.Resource;
import com.cantodo.content.front.tool.HtmlRegexpUtil;
import com.cantodo.content.persistence.AdsMapper;

@Service("adsServiceImpl")
public class AdsServiceImpl implements AdsService {

	private Log logger = LogFactory.getLog(AdsServiceImpl.class);

	@Autowired
	private AdsMapper adsMapper;

	@Override
	@SuppressWarnings("unchecked")
	public String getList(Map pata) {
		logger.debug("enter getList");

		JsonConfig jsonConfig = new JsonConfig();

		// 处理属性为Date类型
		jsonConfig.registerJsonValueProcessor(Date.class,
				new JsonValueProcessor() {
					public Object processArrayValue(Object value,
							JsonConfig jsonConfig) {
						if (value == null) {
							return "";
						}
						return value;
					}

					public Object processObjectValue(String key, Object value,
							JsonConfig jsonConfig) {

						if (key.equals("createDate")) {
							if (null == value) {
								return "";
							}
							String res = DateFormatUtils.format((Date) value,
									"yyyy-MM-dd");

							return res;
						}

						return value;

					}

				});

		Map result = new HashMap();
		List<Ads> list = null;
		int total = 0;
		int ctype = (Integer)pata.get("cctype");
		try {
			list = adsMapper.getAllInfo(pata);
			total = adsMapper.getCounts(ctype);
		} catch (RuntimeException e1) {
			logger.debug("", e1);
		}
		// System.out.println(list.size());

		result.put("total", total);
		result.put("rows", list);

		String s = "";
		try {
			s = JSONObject.fromObject(result, jsonConfig).toString();
		} catch (DataAccessException e) {
			logger.error("JSONObject.fromObject(result,jsonConfig).toString()",
					e);
		}

		logger.debug("exit getList");
		return s;

	}

	public void add(Ads ads,String path,List<FileUpload> list) {
		logger.debug("enter  add");
		
		String filename = upload(path,list,null);
		
		ads.setNewname(filename);
		//ads.setUrl(filename);

		adsMapper.insert(ads);

		logger.debug("exit  add");
	}
	
	private String upload(String path,List<FileUpload> list, String fname)
	{
		logger.debug("enter add");

        File[] uploadFiles = null;
        String[] fileNames = null;
        String filename = null;
        for (FileUpload fileUpload : list)
        {

            uploadFiles = fileUpload.getUploadFiles();
            fileNames = fileUpload.getFileNames();
            for (int i = 0; i < uploadFiles.length; i++)
            {

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

                filename = UUID.randomUUID().toString() + ext;
                
                if(null != fname)
                {
                	filename = fname;
                }

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

            }
        }
        
        logger.debug("exit add");
        
        return filename;
	}

	public void update(Ads ads,String path,List<FileUpload> list) {
		logger.debug("enter update");
		
		upload(path,list,ads.getNewname());

		adsMapper.update(ads);

		logger.debug("exit update");
	}

	public Ads getInfoById(int id) {
		logger.debug("enter getInfoById");

		Ads r = adsMapper.getInfoById(id);

		logger.debug("exit getInfoById");
		return r;
	}

	public void delete(String strids) {
		logger.debug("enter delete");

		JSONArray jsonArray = JSONArray.fromObject(strids);

		int[] ids = (int[]) JSONArray.toArray(jsonArray, int.class);

		for (int id : ids) {
			adsMapper.delete(id);
		}

		logger.debug("exit delete");
	}
	
	public List<Ads> getAllInfo2(int type)
	{
		return adsMapper.getAllInfo2(type);
	}

}
