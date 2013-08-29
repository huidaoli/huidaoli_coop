package com.base.frame.business.service.impl;

import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.frame.business.service.EquipmentService;
import com.base.frame.dao.EquipmentManager;
import com.base.frame.model.Equipment;
import com.base.frame.security.service.impl.ModuleServiceImpl;

@Service
public class EquipmentServiceImpl implements EquipmentService
{

    

    @Autowired
    private EquipmentManager equipmentManager;
    
    @Override
    @Transactional
    public void addEquipment(Equipment equipment)
    {
        equipmentManager.addEquipment(equipment);
        
    }

    @Override
    @Transactional
    public void delEquipment(int equipmentId)
    {
        equipmentManager.delEquipment(equipmentId);
        
    }

    @Override
    public Equipment findEquipment(int equipmentId)
    {
        return equipmentManager.findEquipment(equipmentId);
    }
    
    
    /**
     * 
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author tangdingyi
     * @param module
     * @param sb
     */
     private void getJsonData(Equipment equipment, StringBuilder sb)
     {
         Set<Equipment> equipments = equipment.getChildren();
         if (hasChild(equipments))
         {
             sb.append("{\"id\":");
             sb.append(equipment.getId());
             sb.append(",\"text\":");
             sb.append("\"" + equipment.getName() + "\"");
             sb.append(",\"children\":[");
             for (Equipment equipmentemp : equipments)
             {
                 getJsonData(equipmentemp, sb);
             }
             sb.append("]},");
         }
         else
         {
             sb.append("{\"id\":");
             sb.append(equipment.getId());
             sb.append(",\"text\":");
             sb.append("\"" + equipment.getName() + "\"");
             sb.append("},");
         }

     }

     /**
      * 
      * [简要描述]:<br/>// 判断是否有子节点
      * [详细描述]:<br/>
      * 
      * @author tangdingyi
      * @param orgs
      * @return
      */
     
     private boolean hasChild(Set<Equipment> equipments)
     {

         return equipments.size() > 0 ? true : false;

     }

    @Override
    public String getEquipmentTreeData(int oid)
    {
        StringBuilder sb = new StringBuilder();

        Equipment equipment = equipmentManager.findEquipment(oid);
        // 子节点Set
        getJsonData(equipment, sb);

        String r = ("[" + sb.toString() + "]").replaceAll("\\,]", "\\]");

        return r;
    }

    @Override
    @Transactional
    public void modEquipment(Equipment equipment)
    {
        equipmentManager.updateEquipment(equipment);
        
    }

    @Override
    public List<Equipment> searchEquipmentsData(int parentId)
    {
        return equipmentManager.searchEquipmentsData(parentId);
    }

}
