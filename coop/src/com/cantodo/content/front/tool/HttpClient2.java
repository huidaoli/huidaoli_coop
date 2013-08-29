package com.cantodo.content.front.tool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.base.frame.business.Init;

public class HttpClient2
{

    private static String homeURL = Init.getMap().get("basehome");
    
    private static String hostURL = Init.getMap().get("hostURL");
    //private static String homeURL = "http://172.17.214.202/bss";

    public static Map<String, String> fiterHtmlTag(String str, String tag)
    {

        String[] keys = new String[] {"usename", "password", "password2", "email"};
        String regxp = "<\\s*" + tag + "\\s+([^>]*)\\s*>";

        Map<String, String> hashMap = new HashMap<String, String>();

        Pattern pattern = Pattern.compile(regxp);

        Matcher matcher = pattern.matcher(str);

        boolean result = matcher.find();

        String s = "";

        int i = 0;
        while (result)
        {

            s = matcher.group();
            s = s.substring(s.indexOf("\"") + 1, s.lastIndexOf("\""));
            hashMap.put(keys[i++], s);
            //System.out.println(s);
            result = matcher.find();

        }
        return hashMap;

    }

    public static String register(String[] para) throws ClientProtocolException, IOException
    {
        DefaultHttpClient httpclient = new DefaultHttpClient();

        HttpGet httpGet = new HttpGet(homeURL + "/member.php?mod=register");

        HttpResponse response = httpclient.execute(httpGet);

        HttpEntity entity = null;

        String sb = null;

        try
        {
            entity = response.getEntity();
            sb = EntityUtils.toString(entity, "gbk");

            int pos = sb.indexOf("<form method=\"post\" autocomplete=\"off\" name=\"register\"");

            int end = sb.lastIndexOf("</form>");

            sb = sb.substring(pos, end + 7);

            Map<String, String> map = fiterHtmlTag(sb, "label");

            map.put("formhash", getFormhashRegister(httpclient));
            map.put("regsubmit", "yes");
            map.put("referer", homeURL + "/forum.php");
            map.put("activationauth", "");

            HttpPost httpPost = new HttpPost(homeURL + "/member.php?mod=register");
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            
            EntityUtils.consume(entity);

            String key = "";
            String value = "";
            for (Map.Entry<String, String> mapentry : map.entrySet())
            {
                key = mapentry.getKey();
                value = mapentry.getValue();
                if ("usename".equals(key))
                {
                    nvps.add(new BasicNameValuePair(value, para[0]));
                    continue;
                }
                if ("password".equals(key))
                {
                    nvps.add(new BasicNameValuePair(value, para[1]));
                    continue;
                }
                if ("password2".equals(key))
                {
                    nvps.add(new BasicNameValuePair(value, para[1]));
                    continue;
                }
                if ("email".equals(key))
                {
                    nvps.add(new BasicNameValuePair(value, para[2]));
                    continue;
                }
                nvps.add(new BasicNameValuePair(key, value));
                

            }

            httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
            HttpResponse response2 = httpclient.execute(httpPost);
            HttpEntity entity2 = response2.getEntity();
            EntityUtils.consume(entity2);
            
            //System.out.println(EntityUtils.toString(entity2, "gbk"));

        }
        catch (Exception e)
        {

        }
        finally
        {
            httpGet.releaseConnection();
            httpclient.getConnectionManager().shutdown();
        }

        return null;
    }
    
    public static String getFormhash2() throws Exception
    {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        String formhash =  getFormhash(homeURL+"/forum.php", httpclient);
        httpclient.getConnectionManager().shutdown();
        return formhash;
    }
    
    
    public static boolean login(String[] para) throws Exception
    {
        DefaultHttpClient httpclient = new DefaultHttpClient();

        HttpPost httpPost = new HttpPost(homeURL + "//member.php?mod=logging&action=login&loginsubmit=yes&infloat=yes&lssubmit=yes&inajax=1");
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();

        String formhash = getFormhash(homeURL+"/forum.php", httpclient);
        nvps.add(new BasicNameValuePair("formhash", formhash));
        nvps.add(new BasicNameValuePair("username", para[0]));
        nvps.add(new BasicNameValuePair("password", para[1]));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));
        HttpResponse response = httpclient.execute(httpPost);

        try
        {
            HttpEntity entity = response.getEntity();
            String res = EntityUtils.toString(entity, "gbk");
            if(res.indexOf("window.location.href")==-1)
            {
            	return false;
            }

            //System.out.println(sb);

            List<Cookie> cookies = httpclient.getCookieStore().getCookies();
            
            if (cookies.isEmpty())
            {
                //System.out.println("None");
            }
            else
            {
                for (int i = 0; i < cookies.size(); i++)
                {
                    //System.out.println("- " + cookies.get(i).toString());
                }
            }
            //sb = cookies.toString();
            //System.out.println(sb);
            EntityUtils.consume(entity);
            
        }
        catch (Exception e) {
        	return false;
			// TODO: handle exception
		}
        finally
        {
            httpPost.releaseConnection();
            httpclient.getConnectionManager().shutdown();
        }
        return true;

    }

    /**
     * [ºÚ“™√Ë ˆ]:<br/> [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @param url
     * @param httpclient
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static String getFormhash(String url, DefaultHttpClient httpclient) throws ClientProtocolException,
            IOException
    {
        HttpGet httpGet = new HttpGet(url);

        HttpResponse response = httpclient.execute(httpGet);

        HttpEntity entity = null;

        String sb = null;
        
        String login_formhash = null;

        try
        {
            entity = response.getEntity();
            sb = EntityUtils.toString(entity, "gbk");
            int pos = sb.indexOf("name=\"formhash\" value=");

            login_formhash = sb.substring(pos + 23, pos + 23 + 8);

            EntityUtils.consume(entity);
        }
        finally
        {
            httpGet.releaseConnection();
            //httpclient.getConnectionManager().shutdown();
        }

       

        return login_formhash;
    }

    public static String getFormhashRegister(DefaultHttpClient httpclient) throws Exception
    {
        return getFormhash(homeURL + "/forum.php", httpclient);
    }
    
    
    public static void createHTML(String actionPath,String savapath) throws Exception {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(hostURL+"/"+actionPath);

        HttpResponse response = httpclient.execute(httpGet);

        try {
            HttpEntity entity = response.getEntity();
            
            byte[] data = new byte[8192];
            int byteRead = -1;
            
            if (entity != null) {
            	InputStream in = entity.getContent();
                FileOutputStream out = new FileOutputStream(savapath);
                 while ((byteRead = in.read(data)) != -1)
                 {
                     out.write(data, 0, byteRead);
                     out.flush();
                 }
                 out.close();
                 in.close();
            }
            
            //BufferedOutputStream bos = new 
            
           // OutputStream os = new FileOutputStream(f);
            
            //System.out.println("Response content: " + EntityUtils.toString(entity, "gbk"));
          
            EntityUtils.consume(entity);
        }catch (Exception e) {
			// TODO: handle exception
		} 
        
        finally {
            httpGet.releaseConnection();
            httpclient.getConnectionManager().shutdown();
        }
    }

    public static void main(String[] args) throws Exception
    {
    	//createHTML("queryInfoById.action","E:/2013/01");
    }

}
