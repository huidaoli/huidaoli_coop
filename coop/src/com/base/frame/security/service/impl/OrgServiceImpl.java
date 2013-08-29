package com.base.frame.security.service.impl;

import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.frame.dao.OrgManager;
import com.base.frame.model.Organization;
import com.base.frame.security.service.OrgService;

@Service("orgServiceImpl")
public class OrgServiceImpl implements OrgService
{

    private Log logger = LogFactory.getLog(OrgServiceImpl.class);
    
    @Autowired
    private OrgManager orgManager;

    @Transactional
    public int addOrg(Organization org)
    {

        return orgManager.addOrg(org);

    }

    @Transactional
    public void modOrg(Organization org)
    {
        orgManager.updateOrg(org);

    }
    
    public Organization findOrg(int orgId)
    {
        return orgManager.findOrg(orgId);
    }
    
    
    @Transactional
    public void delOrg(int orgId)
    {
        orgManager.delOrg(orgId);
    }

    /**
     * @param org
     * @param sb
     */
    private void getJsonData(Organization org, StringBuilder sb)
    {
        Set<Organization> orgs = org.getChildren();
        if (hasChild(orgs))
        {
            sb.append("{\"id\":");
            sb.append(org.getId());
            sb.append(",\"text\":");
            sb.append("\"" + org.getName() + "\"");
            sb.append(",\"children\":[");
            for (Organization orgtmp : orgs)
            {
                getJsonData(orgtmp, sb);
            }
            sb.append("]},");
        }
        else
        {
            sb.append("{\"id\":");
            sb.append(org.getId());
            sb.append(",\"text\":");
            sb.append("\"" + org.getName() + "\"");
            sb.append("},");
        }

    }

    // 判断是否有子节点
    public boolean hasChild(Set<Organization> orgs)
    {

        return orgs.size() > 0 ? true : false;

    }

    public String getOrgTreeData(int id)
    {

        StringBuilder sb = new StringBuilder();

        Organization org = orgManager.findOrg(id);
        // 字节点Set
        getJsonData(org, sb);

        String r = ("[" + sb.toString() + "]").replaceAll("\\,]", "\\]");

        //System.out.println(r);

        return r;

    }

}
