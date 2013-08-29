package com.cantodo.content.project.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.frame.common.MessTool;
import com.base.frame.common.SystemException;
import com.base.frame.dao.DictBussManager;
import com.cantodo.content.project.service.impl.ProjectServiceImpl;

/**
 * ����Excel���Ĺ�����
 */
@Service("excelReader")
public class ExcelReader
{
	
	private Log logger = LogFactory.getLog(ExcelReader.class);
	
    private POIFSFileSystem fs;

    private HSSFWorkbook wb;

    private HSSFSheet sheet;

    private HSSFRow row;
    
    @Autowired
    private DictBussManager dictBussManager;
    
    private static Map<Integer, String> fieldMap = new HashMap<Integer, String>();
    {
        fieldMap.put(0, "no");
        fieldMap.put(1, "name");
        fieldMap.put(2, "type");
        fieldMap.put(3, "itfx");
        fieldMap.put(4, "yyfx");
        fieldMap.put(5, "longday");
        fieldMap.put(6, "startTime");
        fieldMap.put(7, "endTime");
        fieldMap.put(8, "groupper");
        fieldMap.put(9, "ry");
        fieldMap.put(10, "touzif");
        fieldMap.put(11, "fbf");
        fieldMap.put(12, "cbf");
        fieldMap.put(13, "pm");
        fieldMap.put(14, "desctio");

    }
    
    /**
     * ��ȡExcel����ͷ������
     * 
     * @param InputStream
     * @return String ��ͷ���ݵ�����
     * @throws Exception 
     */
    public String[] readExcelTitle(File file) throws Exception
    {
        try
        {
            fs = new POIFSFileSystem(new FileInputStream(file));
            wb = new HSSFWorkbook(fs);
        }
        catch (Exception e)
        {
            logger.debug("readExcelTitle(File file)",e);
            throw e;
        }
        sheet = wb.getSheetAt(0);
        row = sheet.getRow(0);
        // ����������
        int colNum = row.getPhysicalNumberOfCells();
        //System.out.println("colNum:" + colNum);
        String[] title = new String[colNum];
        for (int i = 0; i < colNum; i++)
        {
            title[i] = getCellFormatValue(row.getCell(i));
        }
        return title;
    }

    
    
    public Map<String,List <Map<String,String>>> readExcelContent(File file, String ctype)
    {
        
        Map<String,List <Map<String,String>>> res = new HashMap<String,List <Map<String,String>>>();
        
        List <Map<String,String>> contents = new ArrayList<Map<String,String>>();
        
        
        try
        {
            fs = new POIFSFileSystem(new FileInputStream(file));
            wb = new HSSFWorkbook(fs);
        }
        catch (Exception e)
        {
            logger.debug("readExcelTitle(File file)",e);
        }
        sheet = wb.getSheetAt(0);
        // �õ�������
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        
        Map<String, String> cellMap = null;
        
        String value = "";
        int resint = 0;
        // ��������Ӧ�ôӵڶ��п�ʼ,��һ��Ϊ��ͷ�ı���
        for (int i = 1; i <= rowNum; i++)
        {
            row = sheet.getRow(i);
            cellMap = new HashMap<String, String> ();
            int j = 0;
            while (j < colNum)
            {
                value = getCellFormatValue(row.getCell(j));
                
                if(fieldMap.get(j).equals("type"))
                {
                    resint = dictBussManager.getIdByName(String.valueOf(value),7);
                    cellMap.put(fieldMap.get(j),String.valueOf(resint));
                    j++;
                    continue;
                }
                if(fieldMap.get(j).equals("itfx"))
                {
                    resint = dictBussManager.getIdByName(String.valueOf(value),5);
                    cellMap.put(fieldMap.get(j),String.valueOf(resint));
                    j++;
                    continue;
                }
                if(fieldMap.get(j).equals("yyfx"))
                {
                    resint = dictBussManager.getIdByName(String.valueOf(value),6);
                    cellMap.put(fieldMap.get(j),String.valueOf(resint));
                    j++;
                    continue;
                }
                cellMap.put(fieldMap.get(j), value);
                j++;
            }
            cellMap.put("ctype",ctype);
            cellMap.put("contcode", UUID.randomUUID().toString());
            contents.add(cellMap);
            
        }

        res.put("res", contents);
        return res;
    }

   

    /**
     * ����HSSFCell������������
     * 
     * @param cell
     * @return
     */
    private String getCellFormatValue(HSSFCell cell)
    {
        String cellvalue = "";
        if (cell != null)
        {
            // �жϵ�ǰCell��Type
            switch (cell.getCellType())
            {
                // �����ǰCell��TypeΪNUMERIC
                case HSSFCell.CELL_TYPE_NUMERIC:// ����
                case HSSFCell.CELL_TYPE_FORMULA:// ��ʽ
                {
                    // �жϵ�ǰ��cell�Ƿ�ΪDate
                    if (HSSFDateUtil.isCellDateFormatted(cell))
                    {
                        // �����Date������ת��ΪData��ʽ
                        
                        Date date = cell.getDateCellValue();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        cellvalue = sdf.format(date);
                        

                    }
                    // ����Ǵ�����
                    else
                    {
                        // ȡ�õ�ǰCell����ֵ
                        cellvalue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                case HSSFCell.CELL_TYPE_BLANK: // ��ֵ
                case HSSFCell.CELL_TYPE_ERROR: // ����
                {
                    cellvalue = "";
                    break;
                }
                  
                    // �����ǰCell��TypeΪSTRIN
                case HSSFCell.CELL_TYPE_STRING: // �ַ���
                    // ȡ�õ�ǰ��Cell�ַ���
                    cellvalue = cell.getRichStringCellValue().getString();
                    break;
                // Ĭ�ϵ�Cellֵ
                default:
                    cellvalue = "";
            }
        }
        else
        {
            cellvalue = "";
        }
        return cellvalue;

    }
    
    
    /**
     * ��ȡExcel��������copy map to bean
     * 
     * @param InputStream
     * @return Map ������Ԫ���������ݵ�Map����
     */
    
    /**
    public Map<String,List <Project>> readExcelContent(File file)
    {
        
        Map<String,List <Project>> res = new HashMap<String,List <Project>>();
        
        List <Project> contents = new ArrayList<Project>();
        
        
        try
        {
            fs = new POIFSFileSystem(new FileInputStream(file));
            wb = new HSSFWorkbook(fs);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        sheet = wb.getSheetAt(0);
        // �õ�������
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        
        Map<String, Object> cellMap = null;
        
        Object value = "";
        int resint = 0;
        
        Project project = null;
        // ��������Ӧ�ôӵڶ��п�ʼ,��һ��Ϊ��ͷ�ı���
        for (int i = 1; i <= rowNum; i++)
        {
            row = sheet.getRow(i);
            cellMap = new HashMap<String, Object> ();
            int j = 0;
            while (j < colNum)
            {
                //value = getCellFormatValue(row.getCell(j)).trim();
                value = getCellFormatValue2(row.getCell(j));
                System.out.println("====="+fieldMap.get(j));
                if(fieldMap.get(j).equals("type"))
                {
                    resint = dictBussManager.getIdByName(String.valueOf(value),7);
                    cellMap.put(fieldMap.get(j),resint);
                    j++;
                    continue;
                }
                if(fieldMap.get(j).equals("itfx"))
                {
                    resint = dictBussManager.getIdByName(String.valueOf(value),5);
                    cellMap.put(fieldMap.get(j),resint);
                    j++;
                    continue;
                }
                if(fieldMap.get(j).equals("yyfx"))
                {
                    resint = dictBussManager.getIdByName(String.valueOf(value),6);
                    cellMap.put(fieldMap.get(j),resint);
                    j++;
                    continue;
                }
                cellMap.put(fieldMap.get(j), value);
                j++;
            }
            cellMap.put("contcode", UUID.randomUUID().toString());
            try
            {
                project = new Project();
                Set entr = cellMap.entrySet();
                Iterator iss = entr.iterator();
                while(iss.hasNext())
                {
                    Map.Entry e = (Map.Entry)iss.next();
                    System.out.println(e.getKey() +"="+e.getValue());
                }
                BeanUtils.populate(project, cellMap);
            }
            catch (IllegalAccessException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (InvocationTargetException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            contents.add(project);
        }
        res.put("res", contents);
        return res;
    }*/
    
}
