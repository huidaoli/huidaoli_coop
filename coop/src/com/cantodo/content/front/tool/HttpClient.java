package com.cantodo.content.front.tool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

public class HttpClient
{

    private static String homeURL = Init.getMap().get("basehome");
    //private static String homeURL = "http://172.17.214.121:8080/bbs";

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

        try
        {
            // System.out.println(response.getStatusLine());
            entity = response.getEntity();
            sb = EntityUtils.toString(entity, "gbk");

            EntityUtils.consume(entity);
        }
        finally
        {
            httpGet.releaseConnection();
        }

        // System.out.println("Response content: " + sb);

        int pos = sb.indexOf("name=\"formhash\" value=");

        String login_formhash = sb.substring(pos + 23, pos + 23 + 8);

        return login_formhash;
    }

    /**
     * [ºÚ“™√Ë ˆ]:<br/> [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @throws Exception
     */
    public static void register(String[] para) throws Exception
    {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(homeURL + "/register.php?regsubmit=yes&inajax=1");
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();

        nvps.add(new BasicNameValuePair("formhash", getFormhash(homeURL + "/register.php", httpclient)));
        nvps.add(new BasicNameValuePair("referer", "index.php"));
        nvps.add(new BasicNameValuePair("activationauth", ""));
        nvps.add(new BasicNameValuePair("username", para[0]));
        nvps.add(new BasicNameValuePair("password", para[1]));
        nvps.add(new BasicNameValuePair("password2", para[1]));
        nvps.add(new BasicNameValuePair("email", para[2]));
        nvps.add(new BasicNameValuePair("regmessage", "—ßœ∞"));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
        HttpResponse response2 = httpclient.execute(httpPost);

        try
        {
            // System.out.println(response2.getStatusLine());
            HttpEntity entity2 = response2.getEntity();
            // System.out.println("Response content: " +
           System.out.println( EntityUtils.toString(entity2, "gbk"));

            EntityUtils.consume(entity2);
        }
        finally
        {
            httpPost.releaseConnection();
        }
    }

    /**
     * [ºÚ“™√Ë ˆ]:<br/> [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @throws Exception
     */
    public static String login() throws Exception
    {
        DefaultHttpClient httpclient = new DefaultHttpClient();

        HttpPost httpPost = new HttpPost(homeURL + "/logging.php?action=login&loginsubmit=yes&inajax=1");
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();

        nvps.add(new BasicNameValuePair("formhash", getFormhash(homeURL + "/logging.php?action=login", httpclient)));
        nvps.add(new BasicNameValuePair("username", "sssasdfiii"));
        nvps.add(new BasicNameValuePair("password", "aA111111"));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));
        HttpResponse response = httpclient.execute(httpPost);

        String sb = null;
        try
        {
            HttpEntity entity = response.getEntity();
            //sb = EntityUtils.toString(entity, "gbk");

           

            List<Cookie> cookies = httpclient.getCookieStore().getCookies();
            
            if (cookies.isEmpty())
            {
                System.out.println("None");
            }
            else
            {
                for (int i = 0; i < cookies.size(); i++)
                {
                    System.out.println("- " + cookies.get(i).toString());
                }
            }
            sb = cookies.toString();
            
//            HttpGet httpget = new HttpGet("http://172.17.214.202/index.php");
//            httpget.setHeader("Cookie", cookies.toString());
//
//            HttpResponse response2 = httpclient.execute(httpget);
//            entity = response2.getEntity();
//
//            System.out.println("Login form get: " + response.getStatusLine());
//            
//            //sb = EntityUtils.toString(entity, "gbk");
//            
//            System.out.println(sb);
//            
//            EntityUtils.consume(entity);
//
//            System.out.println("Initial set of cookies:");
           


        }
        finally
        {
            httpPost.releaseConnection();
        }

        return sb;
    }
    
    public static String getFormhash2() throws Exception
    {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        return  getFormhash(homeURL+"/logging.php?action=login", httpclient);
    }
    
    public static List login2() throws Exception
    {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(homeURL + "/bss/member.php?mod=logging&action=login&loginsubmit=yes&infloat=yes&lssubmit=yes&inajax=1");
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();

        nvps.add(new BasicNameValuePair("formhash", getFormhash(homeURL + "/bss/forum.php", httpclient)));
        nvps.add(new BasicNameValuePair("username", "admin"));
        nvps.add(new BasicNameValuePair("password", "iptvCMS123"));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));
        HttpResponse response = httpclient.execute(httpPost);

        String sb = null;
        
        List<Cookie> cookies = null;
        
        try
        {
            HttpEntity entity = response.getEntity();
            
            sb = EntityUtils.toString(entity, "gbk");
            
            System.out.println(sb);

            cookies = httpclient.getCookieStore().getCookies();
            
            if (cookies.isEmpty())
            {
                System.out.println("None");
            }
            else
            {
                for (int i = 0; i < cookies.size(); i++)
                {
                    System.out.println("- " + cookies.get(i).toString());
                }
            }
            //sb = cookies.toString();
           
        }
        finally
        {
            httpPost.releaseConnection();
        }

        return cookies;
    }

    public static void main(String[] args) throws Exception
    {
        //login2();
    	register(new String[]{"222@143.com","2222222","222@143.com"});
    }

}
