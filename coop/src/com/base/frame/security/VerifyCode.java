package com.base.frame.security;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.TextLayout;
import java.awt.image.BufferedImage;
import java.security.SecureRandom;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;

import com.sun.image.codec.jpeg.JPEGCodec;

public class VerifyCode
{
    private static final String[] jdField_case = {"PNG", "JPEG", "GIF"};

    private static SecureRandom jdField_if = new SecureRandom();

    public static void Create(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1,
            boolean paramBoolean1, int paramInt5, int paramInt6, boolean paramBoolean2, int paramInt7, int paramInt8,
            boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6,
            boolean paramBoolean7, String paramString2, boolean paramBoolean8, boolean paramBoolean9,
            boolean paramBoolean10, boolean paramBoolean11, HttpServletResponse paramHttpServletResponse,
            PageContext paramPageContext) throws Exception
    {
        HttpSession localHttpSession = paramPageContext.getSession();
        Object localObject1 = paramPageContext.getOut();
        int j = 0;
        int k = 0;
        int m = 0;
        long l = paramInt1;
        if (l <= 0L)
            l = 60L;
        l *= 1000L;
        int n = paramInt2;
        if ((n < 0) || (n > 2))
            n = 0;
        else if (paramBoolean11)
            n = 1;
        int i1 = paramInt3;
        int i2 = paramInt4;
        if (i1 < 0)
            i1 = 0;
        if (i2 < 0)
            i2 = 0;
        String[] arrayOfString1 = null;
        int i3 = 0;
        if ((paramString1 == null) || (paramString1 == ""))
        {
            if (paramBoolean1)
            {
                i3 = 4;
                arrayOfString1 = new String[4];
                arrayOfString1[0] = "Arial";
                arrayOfString1[1] = "Courier";
                arrayOfString1[2] = "Courier New";
                arrayOfString1[3] = "Times New Roman";
            }
            else
            {
                i3 = 1;
                arrayOfString1 = new String[1];
                arrayOfString1[0] = "Arial";
            }
        }
        else
        {
            i3 = 0;
            String[] arrayOfString2 = paramString1.split(",");
            for (int i = 0; i < arrayOfString2.length; i++)
            {
                arrayOfString2[i] = arrayOfString2[i].trim().replaceAll("\t", " ").replaceAll("  ", " ");
                if (arrayOfString2[i] == "")
                    continue;
                i3++;
            }
            if (paramBoolean1)
            {
                if (i3 == 0)
                {
                    i3 = 4;
                    arrayOfString1 = new String[4];
                    arrayOfString1[0] = "Arial";
                    arrayOfString1[1] = "Courier";
                    arrayOfString1[2] = "Courier New";
                    arrayOfString1[3] = "Times New Roman";
                }
                else
                {
                    arrayOfString1 = new String[i3];
                    j = 0;
                    for (int i = 0; i < arrayOfString2.length; i++)
                    {
                        if (arrayOfString2[i] == "")
                            continue;
                        arrayOfString1[j] = arrayOfString2[i];
                        j++;
                        if (j == i3)
                            break;
                    }
                }
            }
            else
            {
                arrayOfString1 = new String[1];
                if (i3 == 0)
                    arrayOfString1[0] = "Arial";
                else
                    for (int i = 0; i < arrayOfString2.length; i++)
                    {
                        if (arrayOfString2[i] == "")
                            continue;
                        arrayOfString1[0] = arrayOfString2[i];
                        break;
                    }
                i3 = 1;
            }
            arrayOfString2 = null;
        }
        if (paramInt5 <= 0)
            paramInt5 = 100;
        if (paramInt6 <= 0)
            paramInt6 = 60;
        int i4 = Math.max(paramInt5, paramInt6);
        int i5;
        if (!paramBoolean2)
        {
            i5 = i4;
        }
        else
        {
            i5 = Math.min(paramInt5, paramInt6);
            if (i4 == i5)
                paramBoolean2 = false;
        }
        if (paramInt7 < 4)
            paramInt7 = 4;
        else if (paramInt7 > 8)
            paramInt7 = 8;
        if (paramInt8 < 4)
            paramInt8 = 4;
        else if (paramInt8 > 8)
            paramInt8 = 8;
        j = Math.max(paramInt7, paramInt8);
        k = Math.min(paramInt7, paramInt8);
        int i6;
        if (!paramBoolean3)
        {
            i6 = j;
        }
        else
        {
            i6 = k;
            if (j == k)
                paramBoolean3 = false;
            else
                i6 += a(j - k + 1);
        }
        String str = "1234567890";
        if (paramBoolean5)
            str = str + "qwertyuiopasdfghjklzxcvbnm";
        if (paramBoolean6)
            str = str + "QWERTYUIOPASDFGHJKLZXCVBNM";
        if (paramBoolean7)
            if ((paramString2 == null) || (paramString2 == ""))
                str = str + "#$%&*+<=>?@~";
            else
                for (int i = 0; i < paramString2.length() - 1; i++)
                {
                    char c = paramString2.charAt(i);
                    if (((c <= ' ') || (c >= '0')) && ((c <= '9') || (c >= 'A')) && ((c <= 'Z') || (c >= 'a'))
                            && ((c <= 'z') || (c >= '')))
                        continue;
                    str = str + String.valueOf(c);
                }
        int i7 = str.length();
        int i8;
        if (paramBoolean8)
            i8 = 1;
        else
            i8 = 11;
        BufferedImage localBufferedImage = new BufferedImage(1, 1, i8);
        Graphics localGraphics = localBufferedImage.getGraphics();
        Color localColor = null;
        if (paramBoolean9)
            localColor = a(0, 255);
        else
            localColor = new Color(255, 255, 255);
        char[] arrayOfChar = new char[i6];
        String[] arrayOfString3 = new String[i6];
        int[] arrayOfInt1 = new int[i6];
        int[] arrayOfInt2 = new int[i6];
        Color[] arrayOfColor = new Color[i6];
        int[] arrayOfInt3 = new int[i6];
        int[] arrayOfInt4 = new int[i6];
        int[] arrayOfInt5 = new int[i6];
        int[] arrayOfInt6 = new int[i6];
        if (i4 == i5)
            for (int i = 0; i < i6; i++)
                arrayOfInt2[i] = i4;
        else
            for (int i = 0; i < i6; i++)
                arrayOfInt2[i] = (i5 + a(i4 - i5 + 1));
        if ((paramBoolean9) || (paramBoolean10))
            j = 200;
        else
            j = 255;
        int i9 = 0;
        k = 0;
        m = 0;
        for (int i = 0; i < i6; i++)
        {
            arrayOfChar[i] = str.charAt(a(i7));
            if (paramBoolean1)
            {
                arrayOfString3[i] = arrayOfString1[a(i3)];
                if (a(2) == 0)
                    arrayOfInt1[i] = 0;
                else
                    arrayOfInt1[i] = 1;
                if (a(2) == 0)
                    arrayOfInt1[i] |= 2;
            }
            else
            {
                arrayOfString3[i] = arrayOfString1[0];
                arrayOfInt1[i] = 0;
            }
            while (true)
            {
                arrayOfColor[i] = a(0, j);
                if (arrayOfColor[i] != localColor)
                    break;
            }
            Rectangle localRectangle = new TextLayout(String.valueOf(arrayOfChar[i]), new Font(arrayOfString3[i],
                    arrayOfInt1[i], arrayOfInt2[i]), ((Graphics2D) localGraphics).getFontRenderContext()).getBounds().getBounds();
            arrayOfInt3[i] = localRectangle.x;
            arrayOfInt4[i] = (-localRectangle.y);
            arrayOfInt5[i] = (localRectangle.width + 1);
            arrayOfInt6[i] = localRectangle.height;
            i9 += arrayOfInt5[i];
            if (k < arrayOfInt5[i])
                k = arrayOfInt5[i];
            if (m >= arrayOfInt6[i])
                continue;
            m = arrayOfInt6[i];
        }
        str = null;
        boolean bool1 = paramBoolean4;
        boolean bool2 = paramBoolean4;
        if ((bool1) && (i1 > 0) && (i1 < j))
            bool1 = false;
        if (i1 == 0)
        {
            i1 = j;
            if (bool1)
                i1 += 20;
        }
        if ((bool2) && (i2 > 0) && (i2 < m))
            bool2 = false;
        if (i2 == 0)
        {
            i2 = m;
            if (bool2)
                i2 += 20;
        }
        paramHttpServletResponse.setContentType("image/" + jdField_case[n].toLowerCase());
        paramHttpServletResponse.setHeader("Pragma", "No-cache");
        paramHttpServletResponse.setHeader("Cache-Control", "no-cache");
        paramHttpServletResponse.setDateHeader("Expires", 0L);
        localBufferedImage = new BufferedImage(i1, i2, i8);
        localGraphics = localBufferedImage.getGraphics();
        localGraphics.setColor(localColor);
        localGraphics.fillRect(0, 0, i1, i2);
        if (paramBoolean10)
        {
            j = i1 + 1;
            k = i2 + 1;
            for (int i = 0; i < i2 / 10; i++)
            {
                ((Graphics2D) localGraphics).setStroke(new BasicStroke((float) ((a(i5) + 1) / 16.0D)));
                localGraphics.setColor(a(100, 255));
                localGraphics.drawLine(0, a(k), i1, a(k));
            }
            for (int i = 0; i < i1 / 10; i++)
            {
                ((Graphics2D) localGraphics).setStroke(new BasicStroke((float) ((a(i5) + 1) / 16.0D)));
                localGraphics.setColor(a(100, 255));
                localGraphics.drawLine(a(j), 0, a(j), i2);
            }
        }
        j = 0;
        k = i1 - i9;
        for (int i = 0; i < i6; i++)
        {
            arrayOfInt3[i] = (j - arrayOfInt3[i]);
            if ((bool1) && (k > 0))
            {
                m = a(k + 1);
                arrayOfInt3[i] += m;
                j += m;
                k -= m;
            }
            j += arrayOfInt5[i];
            m = i2 - arrayOfInt6[i];
            if (bool2)
                arrayOfInt4[i] += a(m + 1);
            else
                arrayOfInt4[i] += m / 2;
            localGraphics.setFont(new Font(arrayOfString3[i], arrayOfInt1[i], arrayOfInt2[i]));
            localGraphics.setColor(arrayOfColor[i]);
            new TextLayout(String.valueOf(arrayOfChar[i]), new Font(arrayOfString3[i], arrayOfInt1[i], arrayOfInt2[i]),
                    ((Graphics2D) localGraphics).getFontRenderContext()).draw((Graphics2D) localGraphics,
                    arrayOfInt3[i], arrayOfInt4[i]);
        }
        arrayOfString1 = null;
        arrayOfString3 = null;
        arrayOfInt1 = null;
        arrayOfInt2 = null;
        arrayOfColor = null;
        arrayOfInt3 = null;
        arrayOfInt4 = null;
        arrayOfInt5 = null;
        arrayOfInt6 = null;
        localGraphics.dispose();
        localGraphics = null;
        if (!paramHttpServletResponse.isCommitted())
            ((JspWriter) localObject1).clear();
        localObject1 = paramPageContext.pushBody();
        ServletOutputStream localServletOutputStream = paramHttpServletResponse.getOutputStream();
        try
        {
            if (paramBoolean11)
            {
                JPEGCodec.createJPEGEncoder(localServletOutputStream).encode(localBufferedImage);
            }
            else
            {
                ImageIO.setUseCache(false);
                ImageIO.write(localBufferedImage, jdField_case[n], localServletOutputStream);
            }
            localServletOutputStream.flush();
        }
        catch (Exception localException)
        {
            throw localException;
        }
        finally
        {
            localServletOutputStream.close();
        }
        localBufferedImage = null;
        if (!paramHttpServletResponse.isCommitted())
            ((JspWriter) localObject1).clear();
        localObject1 = paramPageContext.pushBody();
        localHttpSession.setAttribute("GLY_VERIRY_CODE", String.valueOf(arrayOfChar));
        arrayOfChar = null;
        localHttpSession.setAttribute("GLY_VERIRY_CODE_TIMEOUT", Long.toString(l + new Date().getTime()));
    }

    public static int Check(String paramString, HttpSession paramHttpSession)
    {
        String str1 = (String) paramHttpSession.getAttribute("GLY_VERIRY_CODE");
        String str2 = (String) paramHttpSession.getAttribute("GLY_VERIRY_CODE_TIMEOUT");
        if ((str1 == null) || (str2 == null))
            return 3;
        paramHttpSession.setAttribute("GLY_VERIRY_CODE", "");
        paramHttpSession.setAttribute("GLY_VERIRY_CODE_TIMEOUT", "");
        long l = 0L;
        if (!str2.equals(""))
            l = Long.parseLong(str2);
        if ((l == 0L) || (str1.equals("")))
            return 2;
        Date localDate = new Date();
        int i = localDate.getTime() > l ? 1 : 0;
        localDate = null;
        if (i != 0)
            return 1;
        if (!str1.equals(paramString))
            return -1;
        return 0;
    }

    private static int a(int paramInt)
    {
        int i = 0;
        byte[] arrayOfByte = new byte[4];
        jdField_if.nextBytes(arrayOfByte);
        for (int k = 0; k < 4; k++)
        {
            int j = arrayOfByte[k];
            i += ((j & 0xFF) << 8 * k);
        }
        arrayOfByte = null;
        return Math.abs(i % paramInt);
    }

    private static Color a(int paramInt1, int paramInt2)
    {
        if (paramInt1 < 0)
            paramInt1 = 0;
        if (paramInt1 > 255)
            paramInt1 = 255;
        if (paramInt2 < 0)
            paramInt2 = 0;
        if (paramInt2 > 255)
            paramInt2 = 255;
        int i = Math.max(paramInt1, paramInt2);
        int j = Math.min(paramInt1, paramInt2);
        if (j == i)
            return new Color(j, j, j);
        i -= j - 1;
        return new Color(j + a(i), j + a(i), j + a(i));
    }

}
