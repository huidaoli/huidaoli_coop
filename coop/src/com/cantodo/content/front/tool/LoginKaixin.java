//package com.cantodo.content.front.tool;
//
//import org.apache.http.NameValuePair;
//import org.apache.http.cookie.Cookie;
//
//public class LoginKaixin
//{
//    private static final String LOGON_SITE = "http://www.kaixin001.com";
//
//    private static final int LOGON_PORT = 80;
//
//    public static void main(String[] args) throws Exception
//    {
//        HttpClient client = new HttpClient();
//        client.getHostConfiguration().setHost(LOGON_SITE, LOGON_PORT);
//        // ��¼ҳ��
//        PostMethod post = new PostMethod("http://www.kaixin001.com/login/login.php");
//        NameValuePair ie = new NameValuePair("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows 2000)");
//        NameValuePair url = new NameValuePair("url", "/home/");
//        NameValuePair username = new NameValuePair("email", "xxx@163.com");
//        NameValuePair password = new NameValuePair("password", "xxxxxx");
//        post.setRequestBody(new NameValuePair[] {ie, url, username, password});
//        client.executeMethod(post);
//        System.out.println("******************************��¼******************************");
//        Cookie[] cookies = client.getState().getCookies();
//        client.getState().addCookies(cookies);
//        post.releaseConnection();
//        System.out.println("******************************ҳ��ת��******************************");
//        String newUrl = "http://www.kaixin001.com/home/";
//        System.out.println("==========Cookies============");
//        int i = 0;
//        for (Cookie c : cookies)
//        {
//            System.out.println(++i + ": " + c);
//        }
//        client.getState().addCookies(cookies);
//        post.releaseConnection();
//        GetMethod get = new GetMethod(newUrl);
//        get.setRequestHeader("Cookie", cookies.toString());
//        client.executeMethod(get);
//        String responseString = get.getResponseBodyAsString();
//        // ��¼����ҳ������
//        System.out.println(responseString);
//        get.releaseConnection();
//        System.out.println("******************************�������******************************");
//        // "http://www.kaixin001.com/!slave/index.php", "��������"
//        // "http://www.kaixin001.com/!parking/index.php", "����λ"
//        // "http://www.kaixin001.com/!house/index.php?_lgmode=pri", "����"
//        // http://www.kaixin001.com/!house/index.php?_lgmode=pri&t=49
//        // "http://www.kaixin001.com/!house/garden/index.php","��԰"
//        // (1)������������****************
//        System.out.println("******************************(1)������������******************************");
//        String slave = "http://www.kaixin001.com/!slave/index.php";
//        get = new GetMethod(slave);
//        get.setRequestHeader("Cookie", cookies.toString());
//        client.executeMethod(get);
//        responseString = get.getResponseBodyAsString();
//        System.out.println(responseString);
//        get.releaseConnection();
//        // (2)��������λ****************
//        System.out.println("******************************(2)��������λ******************************");
//        String parking = "http://www.kaixin001.com/!parking/index.php";
//        get = new GetMethod(parking);
//        get.setRequestHeader("Cookie", cookies.toString());
//        client.executeMethod(get);
//        responseString = get.getResponseBodyAsString();
//        System.out.println(responseString);
//        get.releaseConnection();
//        // (3)��������****************
//        System.out.println("******************************(3)��������*******************************");
//        String house = "http://www.kaixin001.com/!house/index.php?_lgmode=pri&t=49";
//        get = new GetMethod(house);
//        get.setRequestHeader("Cookie", cookies.toString());
//        client.executeMethod(get);
//        responseString = get.getResponseBodyAsString();
//        System.out.println(responseString);
//        get.releaseConnection();
//        // (4)���뻨԰****************
//        System.out.println("******************************(4)���뻨԰*******************************");
//        String garden = "http://www.kaixin001.com/!house/garden/index.php";
//        get = new GetMethod(garden);
//        get.setRequestHeader("Cookie", cookies.toString());
//        client.executeMethod(get);
//        responseString = get.getResponseBodyAsString();
//        System.out.println(responseString);
//        get.releaseConnection();
//    }
//
//}
