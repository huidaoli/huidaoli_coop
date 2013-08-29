package com.base.frame.business.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;
import org.dom4j.xpath.DefaultXPath;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.graph.exe.Token;
import org.jbpm.taskmgmt.exe.TaskInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.base.frame.business.service.LeaveService;
import com.base.frame.common.BaseAction;
import com.base.frame.model.AppInfo;
import com.base.frame.model.DictBuss;
import com.base.frame.model.Leave;
import com.base.frame.model.Workflow;
import com.base.frame.security.service.UserInfoService;
import com.base.frame.workflow.jbpm.service.WorkflowService;

@Controller("leaveAction")
@Scope("prototype")
public class LeaveAction extends BaseAction
{
    /**
     * [ºÚ“™√Ë ˆ]:
     * 
     * @author tangdingyi
     */
    private static final long serialVersionUID = 49533011601579502L;

    /**
     * [ºÚ“™√Ë ˆ]:
     * 
     * @author tangdingyi
     */

    private Log logger = LogFactory.getLog(LeaveAction.class);

    private Leave leaveinfo;

    private List<DictBuss> listDictBuss;

    @Autowired
    private UserInfoService userService;

    @Autowired
    private LeaveService leaveService;
    
    @Autowired
    private WorkflowService workflowService;

    public List<DictBuss> getListDictBuss()
    {
        return listDictBuss;
    }

    public void setListDictBuss(List<DictBuss> listDictBuss)
    {
        this.listDictBuss = listDictBuss;
    }

    /**
     * [ºÚ“™√Ë ˆ]:<br/> [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String addLeave()
    {

        int workflowId = 16;

        request.setAttribute("workflowId", workflowId);

        listDictBuss = userService.listDictBuss(3);

        return SUCCESS;
    }

    /**
     * [ºÚ“™√Ë ˆ]:<br/> [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String saveLeave()
    {
        int workflowId = Integer.parseInt(request.getParameter("workflowId"));
        
        String opt = request.getParameter("opt"); 
        
        int userId = currentUser(request).getId();

        if (opt.equals("add"))
        {
            leaveService.addLeave(leaveinfo, workflowId, userId);

        }
        if (opt.equals("edit"))
        {
            leaveService.updateLeave(leaveinfo, workflowId, userId);
        }
        
        return success();
    }

    /**
     * [ºÚ“™√Ë ˆ]:<br/> [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    @SuppressWarnings("unchecked")
    public String submitInput()
    {
        int leaveId = Integer.parseInt(request.getParameter("leaveId"));

        String type = request.getParameter("type");

        List<String> lists = leaveService.searchNextSteps(leaveId, currentUser(request).getId());

        request.setAttribute("lists", lists);

        if (type.equals("approve"))
        {
            return "approve";
        }
        if (type.equals("submit"))
        {
            return "submit";
        }

        return SUCCESS;
    }

    /**
     * [ºÚ“™√Ë ˆ]:<br/> [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String submit()
    {

        String transistionName = request.getParameter("transistionName");

        int leaveId = Integer.parseInt(request.getParameter("leaveId"));

        leaveService.submitToWorkflow(currentUser(request).getId(), leaveId, transistionName);

        return success();
    }
    
    //========================================================================================================
    public String processImage()
    {

        int workflowId = Integer.parseInt(request.getParameter("workflowId"));
        
        int leaveId = Integer.parseInt(request.getParameter("leaveId"));
        
        Workflow wf = workflowService.findWorkflow(workflowId);
        
        String path = ServletActionContext.getServletContext().getRealPath("/attach/jbpmfile");
        
        String resStr = null;
        
        
        try
        {
            resStr = createTable(path + File.separator + wf.getProcessDefCord(),wf.getProcessImagePath(),leaveId);
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            //e.printStackTrace();
        }
        catch (DocumentException e)
        {
            // TODO Auto-generated catch block
           // e.printStackTrace();
        }
        
        request.setAttribute("table", resStr);
        
        return SUCCESS;
    }
    
    
    
    
  
    
    Token currentToken = null;

    private String createTable(String path,String imgName,int leaveId) throws IOException, DocumentException
    {

        
                
        String currentTokenColor = "red";

        String childTokenColor = "blue";

        String tokenNameColor = "blue";
        
        
        String imageLink = "../attach/jbpmfile/"+imgName;
        
        int borderWidth = 4;
        SAXReader reader = new SAXReader();
        Document doc = null;
        try
        {
            doc = reader.read(new File(path));
        }
        catch (DocumentException e)
        {
            
        }
        Element rootDiagramElement =doc.getRootElement();
        
        int[] boxConstraint;
        int[] imageDimension = extractImageDimension(rootDiagramElement);
        
        int taskInstanceId = -1;

        int tokenInstanceId = -1;
        
        ProcessInstance processInstance = leaveService.loadProcessInstance(leaveId);
        
        tokenInstanceId = (int)processInstance.getRootToken().getId();
        
        StringBuilder sb = new StringBuilder();
        
        
        if (taskInstanceId > 0)
        {
            TaskInstance taskInstance = leaveService.loadTaskInstance(taskInstanceId);
            currentToken = taskInstance.getToken();
        }
        else
        {
            if (tokenInstanceId > 0)
                currentToken = leaveService.loadToken(tokenInstanceId);
        }

        //∏˘æ›tokenInstanceId…˙≥…
        if (tokenInstanceId > 0)
        {

            List<Token> allTokens = new ArrayList<Token>();
            walkTokens(currentToken, allTokens);

            sb.append("<div style='position:relative; background-image:url(" + imageLink + "); width: "
                    + imageDimension[0] + "px; height: " + imageDimension[1] + "px;'>");

            for (int i = 0; i < allTokens.size(); i++)
            {
                Token token = (Token) allTokens.get(i);

                // check how many tokens are on teh same level (= having the
                // same parent)
                int offset = i;
                if (i > 0)
                {
                    while (offset > 0 && ((Token) allTokens.get(offset - 1)).getParent().equals(token.getParent()))
                    {
                        offset--;
                    }
                }
                boxConstraint = extractBoxConstraint(rootDiagramElement, token);

                // Adjust for borders
                // boxConstraint[2]-=borderWidth*2;
                // boxConstraint[3]-=borderWidth*2;

                sb.append("<div style='position:absolute; left: " + (boxConstraint[0]-borderWidth) + "px; top: "
                        + (boxConstraint[1]-borderWidth) + "px; ");

                if (i == (allTokens.size() - 1))
                {
                    sb.append("border: " + currentTokenColor);
                }
                else
                {
                    sb.append("border: " + childTokenColor);
                }

                sb.append(" " + borderWidth + "px groove; " + "width: " + boxConstraint[2] + "px; height: "
                        + boxConstraint[3] + "px;'>");

                if (token.getName() != null)
                {
                    sb.append("<span style='color:" + tokenNameColor
                            + ";font-style:italic;position:absolute;left:" + (boxConstraint[2] + 10) + "px;top:"
                            + ((i - offset) * 20) + ";'>&nbsp;" + token.getName() + "</span>");
                }

                sb.append("</div>");
            }
            sb.append("</div>");
        }
        else
        {
            boxConstraint = extractBoxConstraint(rootDiagramElement);

            sb.append("<table border=0 cellspacing=0 cellpadding=0 width=" + imageDimension[0] + " height="
                    + imageDimension[1] + ">");
            sb.append("  <tr>");
            sb.append("    <td width=" + imageDimension[0] + " height=" + imageDimension[1]
                    + " style=\"background-image:url(" + imageLink + ")\" valign=top>");
            sb.append("      <table border=0 cellspacing=0 cellpadding=0>");
            sb.append("        <tr>");
            sb.append("          <td width=" + (boxConstraint[0] - borderWidth) + " height="
                    + (boxConstraint[1] - borderWidth) + " style=\"background-color:transparent;\"></td>");
            sb.append("        </tr>");
            sb.append("        <tr>");
            sb.append("          <td style=\"background-color:transparent;\"></td>");
            sb.append("          <td style=\"border-color:" + currentTokenColor + "; border-width:" + borderWidth
                    + "px; border-style:groove; background-color:transparent;\" width=" + boxConstraint[2] + " height="
                    + (boxConstraint[3]) + ">&nbsp;</td>");
            //(boxConstraint[3] + (2 * borderWidth))
            sb.append("        </tr>");
            sb.append("      </table>");
            sb.append("    </td>");
            sb.append("  </tr>");
            sb.append("</table>");
        }
        
        return sb.toString();
    }

    private int[] extractBoxConstraint(Element root)
    {
        int[] result = new int[4];
        String nodeName = currentToken.getNode().getName();
        XPath xPath = new DefaultXPath("//node[@name='" + nodeName + "']");
        Element node = (Element) xPath.selectSingleNode(root);
        result[0] = Integer.valueOf(node.attribute("x").getValue()).intValue();
        result[1] = Integer.valueOf(node.attribute("y").getValue()).intValue();
        result[2] = Integer.valueOf(node.attribute("width").getValue()).intValue();
        result[3] = Integer.valueOf(node.attribute("height").getValue()).intValue();
        return result;
    }

    private int[] extractBoxConstraint(Element root, Token token)
    {
        int[] result = new int[4];
        String nodeName = token.getNode().getName();
        XPath xPath = new DefaultXPath("//node[@name='" + nodeName + "']");
        Element node = (Element) xPath.selectSingleNode(root);
        result[0] = Integer.valueOf(node.attribute("x").getValue()).intValue();
        result[1] = Integer.valueOf(node.attribute("y").getValue()).intValue();
        result[2] = Integer.valueOf(node.attribute("width").getValue()).intValue();
        result[3] = Integer.valueOf(node.attribute("height").getValue()).intValue();
        return result;
    }

    private int[] extractImageDimension(Element root)
    {
        int[] result = new int[2];
        result[0] = Integer.valueOf(root.attribute("width").getValue()).intValue();
        result[1] = Integer.valueOf(root.attribute("height").getValue()).intValue();
        return result;
    }
    
    private void walkTokens(Token parent, List allTokens)
    {
        Map children = parent.getChildren();
        if (children != null && children.size() > 0)
        {
            Collection childTokens = children.values();
            for (Iterator iterator = childTokens.iterator(); iterator.hasNext();)
            {
                Token child = (Token) iterator.next();
                walkTokens(child, allTokens);
            }
        }

        allTokens.add(parent);
    }
    //============================================================================================================
    
    /**
     * 
     * [ºÚ“™√Ë ˆ]:<br/>
     * [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String deleteLeave()
    {
        
        int leaveId = Integer.parseInt(request.getParameter("idstr"));
        
        leaveService.delLeave(leaveId);
        
        return success();
    }

    /**
     * [ºÚ“™√Ë ˆ]:<br/> [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String leaveApprove()
    {

        return SUCCESS;
    }

    /**
     * [ºÚ“™√Ë ˆ]:<br/> [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String approve()
    {
        response.setHeader("Cache-Control", "no-cache");
        
        String type = request.getParameter("type");

        if (type.equals("noApprove"))
        {
            return "noApprove";
        }
        if (type.equals("hasApprove"))
        {
            return "hasApprove";
        }

        return SUCCESS;
    }

    /**
     * 
     * [ºÚ“™√Ë ˆ]:<br/>
     * [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String approvedList()
    {

        response.setHeader("Cache-Control", "no-cache");

        String strpage = request.getParameter("page");

        String strrows = request.getParameter("rows");

        int rows = Integer.parseInt(strrows);

        int offset = (Integer.parseInt(strpage) - 1) * rows;

        String title = request.getParameter("title");
        
        String treeData = leaveService.searchApprovedLeaves(title, offset, rows,currentUser(request).getId());

        return toJsonData(treeData);
    }
    
    public String approvedHistory()
    {
        int leaveId = Integer.parseInt(request.getParameter("leaveId"));
        
        
        List<AppInfo> historys = leaveService.searchApproveInfos(leaveId);
        
        request.setAttribute("historys", historys);
        
        
        return SUCCESS;
    }
    
    
    public String approvingList()
    {

        response.setHeader("Cache-Control", "no-cache");

        String strpage = request.getParameter("page");

        String strrows = request.getParameter("rows");

        int rows = Integer.parseInt(strrows);

        int offset = (Integer.parseInt(strpage) - 1) * rows;

        String title = request.getParameter("title");
        
        
        String treeData = leaveService.searchApprovingLeaves(title, offset, rows,currentUser(request).getId());

        return toJsonData(treeData);
    }

    /**
     * [ºÚ“™√Ë ˆ]:<br/> [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String approveData()
    {
        
        boolean back = false;
        
        String transistionName = request.getParameter("transistionName");
        
        String aggType = "Õ¨“‚";
        
        if(transistionName.equals("true"))
        {
            
            back = true;
            aggType = "ÕÀªÿ–ﬁ∏ƒ";
        }

        int leaveId = Integer.parseInt(request.getParameter("leaveId"));
        
        String mess = request.getParameter("commentVal");
        
        int approverId = currentUser(request).getId();
        
        AppInfo approveInfo = new AppInfo();
        
        approveInfo.setApproveTime(new Date());
        
        approveInfo.setAggType(aggType);
        
        approveInfo.setMess(mess);
        
        leaveService.addApproveInfo(approveInfo, leaveId, approverId, back, transistionName);

        return success();
    }

    /**
     * [ºÚ“™√Ë ˆ]:<br/> [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String leaveList()
    {

        return SUCCESS;

    }

    /**
     * [ºÚ“™√Ë ˆ]:<br/> [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String loadLeaveById()
    {
        int workflowId = 16;

        request.setAttribute("workflowId", workflowId);
        
        String id = request.getParameter("id");

        String opt = request.getParameter("opt");

        this.leaveinfo = leaveService.findLeave(Integer.parseInt(id));

        listDictBuss = userService.listDictBuss(3);

        request.setAttribute("opt", "edit");

        if (opt.equals("edit"))
        {

            return SUCCESS;
        }
        else
        {

            return "view";
        }

    }

    /**
     * [ºÚ“™√Ë ˆ]:<br/> [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String getLeaveAjaxData()
    {

        response.setHeader("Cache-Control", "no-cache");
        
        String type = request.getParameter("type");
        
      

        String strpage = request.getParameter("page");

        String strrows = request.getParameter("rows");

        int rows = Integer.parseInt(strrows);

        int offset = (Integer.parseInt(strpage) - 1) * rows;

        String title = request.getParameter("title");

        String jsonData = leaveService.searchLeaves(title, offset, rows, currentUser(request).getId(),type);

        return toJsonData(jsonData);

    }
    
    /**
     * 
     * [ºÚ“™√Ë ˆ]:<br/>
     * [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String exceCartList()
    {
        
        return SUCCESS;
    }
    
    /**
     * 
     * [ºÚ“™√Ë ˆ]:<br/>
     * [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String toAddExceCart()
    {
        

        int workflowId = 16;

        request.setAttribute("workflowId", workflowId);
        
        
        return SUCCESS;
    }

    public Leave getLeaveinfo()
    {
        return leaveinfo;
    }

    public void setLeaveinfo(Leave leaveinfo)
    {
        this.leaveinfo = leaveinfo;
    }

}
