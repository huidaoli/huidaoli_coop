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
 * 操作Excel表格的功能类
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
     * 读取Excel表格表头的内容
     * 
     * @param InputStream
     * @return String 表头内容的数组
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
        // 标题总列数
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
        // 得到总行数
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        
        Map<String, String> cellMap = null;
        
        String value = "";
        int resint = 0;
        // 正文内容应该从第二行开始,第一行为表头的标题
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
     * 根据HSSFCell类型设置数据
     * 
     * @param cell
     * @return
     */
    private String getCellFormatValue(HSSFCell cell)
    {
        String cellvalue = "";
        if (cell != null)
        {
            // 判断当前Cell的Type
            switch (cell.getCellType())
            {
                // 如果当前Cell的Type为NUMERIC
                case HSSFCell.CELL_TYPE_NUMERIC:// 数字
                case HSSFCell.CELL_TYPE_FORMULA:// 公式
                {
                    // 判断当前的cell是否为Date
                    if (HSSFDateUtil.isCellDateFormatted(cell))
                    {
                        // 如果是Date类型则，转化为Data格式
                        
                        Date date = cell.getDateCellValue();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        cellvalue = sdf.format(date);
                        

                    }
                    // 如果是纯数字
                    else
                    {
                        // 取得当前Cell的数值
                        cellvalue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                case HSSFCell.CELL_TYPE_BLANK: // 空值
                case HSSFCell.CELL_TYPE_ERROR: // 故障
                {
                    cellvalue = "";
                    break;
                }
                  
                    // 如果当前Cell的Type为STRIN
                case HSSFCell.CELL_TYPE_STRING: // 字符串
                    // 取得当前的Cell字符串
                    cellvalue = cell.getRichStringCellValue().getString();
                    break;
                // 默认的Cell值
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
     * 读取Excel数据内容copy map to bean
     * 
     * @param InputStream
     * @return Map 包含单元格数据内容的Map对象
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
        // 得到总行数
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        
        Map<String, Object> cellMap = null;
        
        Object value = "";
        int resint = 0;
        
        Project project = null;
        // 正文内容应该从第二行开始,第一行为表头的标题
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
