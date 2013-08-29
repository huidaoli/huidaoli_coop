package com.base.frame.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.base.frame.common.BaseManager;
import com.base.frame.dao.EquipmentManager;
import com.base.frame.model.Equipment;

@Repository
public class EquipmentManagerImpl extends BaseManager implements EquipmentManager
{

    @Override
    public void addEquipment(Equipment equipment)
    {
        if (equipment.getParent().getId() == 0)
        {
            equipment.setParent(findEquipment(equipment.getParent().getId()));
        }

        getHibernateTemplate().save(equipment);
        
    }

    @Override
    public void delEquipment(int equipmentId)
    {
        Equipment equipment = (Equipment) findEquipment(equipmentId);
        getHibernateTemplate().delete(equipment);
        
    }

    @Override
    public Equipment findEquipment(int equipmentId)
    {
        return (Equipment) getHibernateTemplate().get(Equipment.class, equipmentId);
    }

   
    @SuppressWarnings("unchecked")
    @Override
    public List<Equipment> searchEquipmentsData(int parentId)
    {

        String selectHql = "select m from Equipment m where m.parent is null";
        if (parentId != 0)
        {
            selectHql = "select m from Equipment m where m.parent.id = " + parentId + " order by m.id asc,m.orderNo desc";
        }

        return searchPaginatedData(selectHql);
    }

    @Override
    public void updateEquipment(Equipment equipment)
    {
        int parentId = equipment.getParent().getId();
        if (parentId == 0)
        {
            equipment.setParent(null);
        }
        getHibernateTemplate().update(equipment);
        
    }

}
