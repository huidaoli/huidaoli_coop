package com.base.frame.business.service;

import java.util.List;

import com.base.frame.model.Equipment;

public interface EquipmentService
{

    void addEquipment(Equipment equipment);
    
    void modEquipment(Equipment equipment);
    
    Equipment findEquipment(int equipmentId);
    
    String getEquipmentTreeData(int oid);
    
    void delEquipment(int equipmentId);
    
    List<Equipment> searchEquipmentsData(int parentId);
}
