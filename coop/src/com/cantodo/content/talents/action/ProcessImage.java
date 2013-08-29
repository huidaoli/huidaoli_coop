package com.cantodo.content.talents.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.base.frame.common.BaseAction;
import com.base.frame.model.Workflow;


@Controller("processImage")
@Scope("prototype")
public class ProcessImage extends BaseAction
{

    /**
     * [简要描述]:
     * @author tangdingyi
     */
    private static final long serialVersionUID = -5315838728242934496L;
    
    
    //========================================================================================================
    public String procimg()
    {

   
        
        String path = "";
        String imgName ="";
        
        String resStr = null;
        
        
        try
        {
            resStr = createTable(path ,imgName);
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
    
    private String createTable(String path,String imgName) throws IOException, DocumentException
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
        int[] imageDimension = extractImageDimension();
        
        int taskInstanceId = -1;

        int tokenInstanceId = -1;
        
        
        
        StringBuilder sb = new StringBuilder();
        
        

        //根据tokenInstanceId生成
//         if (tokenInstanceId > 0)
//        {
//
//            sb.append("<div style='position:relative; background-image:url(" + imageLink + "); width: "
//                    + imageDimension[0] + "px; height: " + imageDimension[1] + "px;'>");
//
//            for (int i = 0; i < allTokens.size(); i++)
//            {
//                Token token = (Token) allTokens.get(i);
//
//                // check how many tokens are on teh same level (= having the
//                // same parent)
//                int offset = i;
//                if (i > 0)
//                {
//                    while (offset > 0 && ((Token) allTokens.get(offset - 1)).getParent().equals(token.getParent()))
//                    {
//                        offset--;
//                    }
//                }
//                boxConstraint = extractBoxConstraint();
//
//                // Adjust for borders
//                // boxConstraint[2]-=borderWidth*2;
//                // boxConstraint[3]-=borderWidth*2;
//
//                sb.append("<div style='position:absolute; left: " + (boxConstraint[0] - borderWidth) + "px; top: "
//                        + (boxConstraint[1] - borderWidth) + "px; ");
//
//                if (i == (allTokens.size() - 1))
//                {
//                    sb.append("border: " + currentTokenColor);
//                }
//                else
//                {
//                    sb.append("border: " + childTokenColor);
//                }
//
//                sb.append(" " + borderWidth + "px groove; " + "width: " + boxConstraint[2] + "px; height: "
//                        + boxConstraint[3] + "px;'>");
//
//                if (token.getName() != null)
//                {
//                    sb.append("<span style='color:" + tokenNameColor + ";font-style:italic;position:absolute;left:"
//                            + (boxConstraint[2] + 10) + "px;top:" + ((i - offset) * 20) + ";'>&nbsp;" + token.getName()
//                            + "</span>");
//                }
//
//                sb.append("</div>");
//            }
//            sb.append("</div>");
//        }
        boxConstraint = extractBoxConstraint();

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
        
        return sb.toString();
    }
    
    private int[] extractBoxConstraint()
    {
        int[] result = new int[4];
        
        result[0] = 1;
        result[1] = 2;
        result[2] = 3;
        result[3] = 4;
        return result;
    }

    private int[] extractImageDimension()
    {
        int[] result = new int[2];
        result[0] = 1;
        result[1] = 2;
        return result;
    }


}
