package com.base.frame.workflow.jbpm.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.frame.dao.WorkflowManager;
import com.base.frame.model.Workflow;
import com.base.frame.system.PagerModel;
import com.base.frame.workflow.jbpm.service.WorkflowService;
import com.cantodo.content.dto.FileUpload;

/**
 * [简要描述]:<br/> [详细描述]:<br/>
 * 
 * @author tangdingyi
 * @version 1.0, Oct 26, 2011
 */
@Service("workflowServiceImpl")
public class WorkflowServiceImpl implements WorkflowService
{

    private Log logger = LogFactory.getLog(WorkflowServiceImpl.class);

    @Autowired
    private WorkflowManager workflowManager;

    @Override
    @Transactional
    public void add(String path, List<FileUpload> list, Workflow workflow)
    {

        File[] uploadFiles = null;
        String[] fileNames = null;
        for (FileUpload fileUpload : list)
        {
            uploadFiles = fileUpload.getUploadFiles();
            fileNames = fileUpload.getFileNames();
            for (int i = 0; i < uploadFiles.length; i++)
            {
                File uploadFile = uploadFiles[i];
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

                String filename = UUID.randomUUID().toString() + ext;

                
                if (fileUpload.getControlName().equals("processDefPath"))
                {
                    workflow.setProcessDefPath(filename);
                }
                if (fileUpload.getControlName().equals("processImagePath"))
                {
                    workflow.setProcessImagePath(filename);
                }
                if (fileUpload.getControlName().equals("processDefCord"))
                {
                    workflow.setProcessDefCord(filename);
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

        workflowManager.addOrUpdateWorkflow(workflow,path);

    }

    @Override
    @SuppressWarnings("unchecked")
    public String searchRoles(Object param, int offset, int pagesize)
    {
        Map result = new HashMap();
        PagerModel pm = workflowManager.searchRoles(param, offset, pagesize);
        List datas = pm.getDatas();
        int totals = pm.getTotal();
        result.put("total", totals);
        result.put("rows", datas);
        return JSONObject.fromObject(result).toString();
    }

    @Override
    public Workflow findWorkflow(int workflowId)
    {
        return workflowManager.findWorkflow(workflowId);
    }

    @Override
    @Transactional
    public void delWorkflow(String strids)
    {
        JSONArray jsonArray = JSONArray.fromObject(strids);

        int[] ids = (int[]) JSONArray.toArray(jsonArray, int.class);

        for (int id : ids)
        {
            workflowManager.delWorkflow(id);
        }

    }

}
