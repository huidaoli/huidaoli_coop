package com.cantodo.content.trainingsys.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.cantodo.content.dto.Divproper;

public class Tool
{
    // ---------------------------------------------------------------------------------------------
    public static String createTable(String imgName, int[] p, List<Divproper> divlist, int from)
    {

        String childTokenColor = "blue";

        String imageLink = "";
        String action = "";
        if (from == 1)
        {
            imageLink = "attach/file/" + imgName;
            action = "downAtta.action";
        }
        if (from == 2)
        {
            imageLink = "../attach/file/" + imgName;
            action = "../upload/downLoadAtta.action";
        }

        int borderWidth = 4;

        int[] boxConstraint;
        int[] imageDimension = p;

        StringBuilder sb = new StringBuilder();

        sb.append("<div style='position:relative; background-image:url(" + imageLink + "); width: " + imageDimension[0]
                + "px; height: " + imageDimension[1] + "px; z-index:1000;'>");

        Divproper divpro = null;
        

        for (int i = 0; i < divlist.size(); i++)
        {
            divpro = (Divproper) divlist.get(i);

            boxConstraint = extractBoxConstraint(divpro);

            if (StringUtils.isNotBlank(divpro.getAttaname()))
            {
                sb.append("<a href='" + action + "?atta=" + divpro.getAttaname() + "'>");
            }

            sb.append("<div title='" + divpro.getTitle() + "' style='position:absolute;");
            if (StringUtils.isNotBlank(divpro.getAttaname()))
            {
                sb.append("cursor:pointer;");
            }
            sb.append("left: "
                    + (boxConstraint[0] - borderWidth) + "px; top: " + (boxConstraint[1] - borderWidth) + "px; ");
            
            sb.append("border: " + childTokenColor);

            sb.append(" " + borderWidth + "px groove; " + "width: " + boxConstraint[2] + "px; height: "
                    + boxConstraint[3] + "px;'>");

            sb.append("</div>");
            if (StringUtils.isNotBlank(divpro.getAttaname()))
            {
                sb.append("</a>");
            }
        }
        sb.append("</div>");

        return sb.toString();
    }

    private static int[] extractBoxConstraint(Divproper divpro)
    {
        int[] result = new int[4];

        result[0] = divpro.getX1();
        result[1] = divpro.getY1();
        result[2] = divpro.getW();
        result[3] = divpro.getH();
        return result;
    }
}
