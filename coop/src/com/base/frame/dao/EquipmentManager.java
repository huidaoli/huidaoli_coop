package com.base.frame.dao;

import java.util.List;

import com.base.frame.model.Equipment;

public interface EquipmentManager
{
    public void addEquipment(Equipment equipment);

    public void delEquipment(int equipment);

    public void updateEquipment(Equipment equipment);

    public Equipment findEquipment(int equipmentId);

    public List<Equipment> searchEquipmentsData(int parentId);

}
