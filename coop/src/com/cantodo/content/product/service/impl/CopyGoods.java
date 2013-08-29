package com.cantodo.content.product.service.impl;

import java.sql.*;
import java.util.StringTokenizer;
import java.io.*;

public class CopyGoods{
	// ͼƬԴ�ļ���   
    static String url1 = "E:/Can2DO/PWP/images/201307/";  //ͼƬԴ�ļ��������ʵ���������,ѡ�е��ļ����п��԰�������ļ����ļ���
    // ͼƬĿ���ļ���   
    static String url2 = "D:/AppServ1/www/shop/images/201307/";  //ͼƬĿ���ļ��������ʵ���������,ѡ�е��ļ����п��԰�������ļ����ļ���
	//��̬ȫ�ֱ�������������ӹ�����õ��ֶ�ֵ�����ṩ������⸴�ơ�d1-d15���뵽��goods�У�d16-d19���뵽��goods_gallery�С�
	public static int d1=1;   
	public static String d2="";   
	public static String d3="";   
	public static int d4=1;   
	public static String d5="";   
	public static int d6=1;   
	public static int d7=1; 
	public static int d8=1;   
	public static int d9=1;   
	public static String d10="";   
	public static String d11="";   
	public static String d12="";   
	public static String d13="";   
	public static String d14="";
	public static int d15=1;
	public static int d16=1;
	//Ϊ����ⴴ����̬ȫ�ֱ��� 
    static Connection conn;   
    static Statement st;  
    //Ϊ����ⴴ����̬ȫ�ֱ���
    static Connection cn = null;
    Statement stmt;
    boolean autoCommit;
    private String DbType="MYSQL";
    //��������ݿ����ӳ�ʼ������
    private CopyGoods(){
       init();
    }
    //��������ݿ����ӳ�ʼ��init����
    private void init(){
        try{
        	Class.forName("com.mysql.jdbc.Driver");// ����Mysql��������     
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecshop", "root", "");// ������������   
        }catch(Exception e){
            System.err.println("conndb():�����쳣. " + e.getMessage());
        }
    }
    //������������ݿ����ӵ������
    public static CopyGoods getNewInstance(){
        return new CopyGoods();
    }
    //������ʼ
    public void beginTrans() throws SQLException{ 
    try{
            autoCommit=cn.getAutoCommit();
            cn.setAutoCommit(false);
        }catch(SQLException ex){
            ex.printStackTrace();
            System.out.print("beginTrans Errors");
            throw ex;
        }
    }
    //ʵ�ֶ�sql��������
    public void commit()throws SQLException{
        try{
            cn.commit();
            cn.setAutoCommit(autoCommit);
        }catch(SQLException ex){
            ex.printStackTrace();
            System.out.print("Commit Errors");
            throw ex;
        }
    } 
    //�ع�����
    public void rollback() throws SQLException{
        try{
            cn.rollback();
            cn.setAutoCommit(autoCommit);
        }catch(SQLException ex){
            ex.printStackTrace();
            System.out.print("Rollback Errors");
            throw ex;
        }
    }   
    //Ĭ�ϵ������һ��executeQuery(String sql)��һ������.
    //���ǿ��Ե���beginTrans()��Ȼ����executeQuery(String sql)��
    //���commit()ʵ�ֶ�sql������������catch(){����rollBack()})��    
    public ResultSet executeQuery(String sql) throws SQLException{
        ResultSet rs = null;
        try{
            stmt=cn.createStatement();
            rs = stmt.executeQuery(sql);
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            System.out.println("conndb.executeQuery:"+ex.getMessage());
            throw ex;
        }
        return rs;
    }
    
    public void executeUpdate(String sql) throws SQLException{
        try{
            stmt=cn.createStatement();
            stmt.executeUpdate(sql);
        }catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("conndb.executeUpdate:"+ex.getMessage());
            throw ex;
        }
    }     
    //Method doBatch �Ĳ���sql������һЩsql���ƴ�����ģ���;���������Խ�����sql����һ�������У�һ��ִ�С�
    public int[] doBatch(String sql) throws SQLException{
        int[] rowResult=null;
        String a;
        try{
            cn.setAutoCommit(false);
            stmt=cn.createStatement();
            StringTokenizer st = new StringTokenizer(sql,";");
            while (st.hasMoreTokens()){
                 a=st.nextToken();
                 stmt.addBatch(a);
             }
             rowResult=stmt.executeBatch();
        }catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("conndb.doBatch:"+ex.getMessage());
            throw ex;
        }
        return rowResult;
    }
    //��ȡ���ݿ�����
    public String getDbType(){
        return DbType;
    }
    //�ر����ݿ�
    public void close() throws SQLException{
        try{
            stmt.close();
            stmt=null;
            cn.close();
            cn=null;
        }catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("Closeing connection fail"+ex.getMessage());
            throw ex;
        }
    }
    
    /*��ȡ�������ݿ�myuser���ӵĺ���*/
    public static Connection getConnection() {   
        Connection cm = null;  //���������������ݿ��Connection����   
        try {   
            Class.forName("com.mysql.jdbc.Driver");// ����Mysql��������          
            cm = DriverManager.getConnection(   
                    "jdbc:mysql://localhost:3306/myuser", "root", "");// ������������   
        } catch (Exception e) {   
            System.out.println("���ݿ�����ʧ��" + e.getMessage());   
        }   
        return cm; //���������������ݿ�����   
    }    
    // ����ͼƬ�ļ����� 
	public static void copyFile(File sourceFile,File targetFile)   
	throws IOException{  
	        // �½��ļ����������������л���   
	        FileInputStream input = new FileInputStream(sourceFile);  
	        BufferedInputStream inBuff=new BufferedInputStream(input);  
	  
	        // �½��ļ���������������л���   
	        FileOutputStream output = new FileOutputStream(targetFile);  
	        BufferedOutputStream outBuff=new BufferedOutputStream(output);  
	          
	        // ��������   
	        byte[] b = new byte[1024 * 5];  
	        int len;  
	        while ((len =inBuff.read(b)) != -1) {  
	            outBuff.write(b, 0, len);  
	        }  
	        // ˢ�´˻���������   
	        outBuff.flush();  
	          
	        //�ر���   
	        inBuff.close();  
	        outBuff.close();  
	        output.close();  
	        input.close();  
	    }  
	// ����ͼƬ�ļ��� ����
	public static void copyDirectiory(String sourceDir, String targetDir)  
	 throws IOException {  
	        // �½�Ŀ��Ŀ¼   
	        (new File(targetDir)).mkdirs();  
	        // ��ȡԴ�ļ��е�ǰ�µ��ļ���Ŀ¼   
	        File[] file = (new File(sourceDir)).listFiles();  
	        for (int i = 0; i < file.length; i++) {  
	            if (file[i].isFile()) {  
	                // Դ�ļ�   
	                File sourceFile=file[i];  
	                // Ŀ���ļ�   
	               File targetFile=new   
	               File(new File(targetDir).getAbsolutePath()  
	            		   +File.separator+file[i].getName());  
	                copyFile(sourceFile,targetFile);  
	            }  
	            if (file[i].isDirectory()) {  
	                // ׼�����Ƶ�Դ�ļ���   
	                String dir1=sourceDir + "/" + file[i].getName();  
	                // ׼�����Ƶ�Ŀ���ļ���   
	                String dir2=targetDir + "/"+ file[i].getName();  
	                copyDirectiory(dir1, dir2);  
	            }  
	        }  
	    }      
/////////////////////*������*//////////////////////////////////
public static void main(String[] args)throws Exception{
	// ����Ŀ���ļ���   
    new File(url2).mkdirs();  
    // ��ȡԴ�ļ��е�ǰ�µ��ļ���Ŀ¼   
    File[] file = (new File(url1)).listFiles();  
    for (int i = 0; i < file.length; i++) {  
        if (file[i].isFile()) {  
            // �����ļ�   
            copyFile(file[i],new File(url2+file[i].getName()));  
        }  
        if (file[i].isDirectory()) {  
            // ����Ŀ¼   
            String sourceDir=url1+File.separator+file[i].getName();  
            String targetDir=url2+File.separator+file[i].getName();  
            copyDirectiory(sourceDir, targetDir);  
        }  
     } 
    	/*�������ز���*/
    	conn = getConnection(); //���ӵ��������ݿ�   
        try {   
            String sql = "select * from staff";     // ��ѯ��������ݵ�sql���   
            st = (Statement) conn.createStatement();    //��������ִ�о�̬sql����Statement����st���ֲ�����      
            ResultSet rs = st.executeQuery(sql);    //ִ��sql��ѯ��䣬���ز�ѯ���ݵĽ����   
            System.out.println("���Ѿ��ɹ��ӹ���⽫���������ȡ����");  
            while (rs.next()) { // �ж��Ƿ�����һ������    
                // �����ֶ�����ȡ��Ӧ��ֵ,�ֶβ����Ļ����������
            	d1 = rs.getInt(2);   //���ݿ������ֶ�a2,int����
                d2 = rs.getString(3);   //�ֶ�a3,String����
                d3 = rs.getString(4);   //�ֶ�a4,String����
                d4 = rs.getInt(5);   
                d5 = rs.getString(6);   
                d6 = rs.getInt(7);   
                d7 = rs.getInt(8);  
                d8 = rs.getInt(9);
                d9 = rs.getInt(10);
                d10 = rs.getString(11);
                d11 = rs.getString(12);
                d12 = rs.getString(13);
                d13 = rs.getString(14);
                d14 = rs.getString(15);
                d15 = rs.getInt(16);
                //����鵽�ļ�¼�ĸ����ֶε�ֵ   
                System.out.println(d1 + " " + d2 + " " + d3 + " " + d4+ " " + d5 + " " + d6 + " " + d7+ " " + d8+ " " + d9+ " " + d10+ " " + d11+ " " + d12+ " " + d13+ " " + d14+ " " + d15);    
            }    
            conn.close();   //�رչ������ݿ�����        
        } catch (SQLException e) {   
            System.out.println("�ӹ����ȡ����ʧ��");   
        }  
        /*�������ز���*/ 
        try{  
        	CopyGoods con=CopyGoods.getNewInstance();
        	cn.setAutoCommit(false);//��ʼһ������
        	System.out.println("�����ӵ�������ǣ�"+con.getDbType()+"���ݿ⡣");//��ȡ��ǰ���ӵ���������ݿ�����
    
            ////////////////////////�����������ݵ�sql���Ⱥ///////////////////////////////////////////////////////////////////////
        	String sql11 = "INSERT INTO ecs_goods(cat_id,goods_sn,goods_name,brand_id,provider_name,goods_number,goods_weight,market_price,shop_price,goods_brief,goods_desc,goods_thumb,goods_img,original_img,goods_type)"  
        			+ " VALUES ("+d1+",'"+d2+"','"+d3+"','"+d4+"','"+d5+"','"+d6+"','"+d7+"','"+d8+"','"+d9+"','"+d10+"','"+d11+"','"+d12+"','"+d13+"','"+d14+"','"+d15+"')";  // �������ݵ�sql���       	  
    	
            ////////////////////////�����������ݵ�sql���Ⱥ////////////////////////////////////////////////////////////////////////
            //String sq21 = "update staff set wage='21' where name = 'Tom4'";// �������ݵ�sql��� 

            
            ////////////////////////�����ɾ�����ݵ�sql���Ⱥ////////////////////////////////////////////////////////////////////////
            //String sql31 = "delete from ecs_goods where goods_name='�ֻ�'";// ɾ�����ݵ�sql���

        	
        	String sql41="select * from ecs_goods where goods_sn='ECS000PWP'";// ������ѯ���ݵ�sql���
        	String sql42="select * from ecs_goods where goods_sn='ECS000PWP'";// ������ѯ���ݵ�sql���
            con.beginTrans();
            ////����������
            con.executeUpdate(sql11); 
            System.out.println("���Ѿ����������ݳɹ��Ľ����˲�����������潫�����ȡ��Ʒid������ͼƬ��Ϣ���룡");
            ////���¶������
            //con.executeUpdate(sql3);
            //System.out.println("���Ѿ����и��²�����");
            ////ɾ���������
            //con.executeUpdate(sql31);
            //System.out.println("���Ѿ�����ɾ��������");
            ////��ѯ�������
            ResultSet rs=con.executeQuery(sql41);
            System.out.println("���Ѿ��ɹ���ȡ�������������ݵ���Ʒid����������ͼƬ��Ϣ���룡");
            
        while(rs.next()){     
        		d16=rs.getInt(1);
         }
        String sql12 = "INSERT INTO ecs_goods_gallery(goods_id,img_url,img_desc,thumb_url,img_original)"  
			+ " VALUES ("+d16+",'"+d13+"','"+d11+"','"+d12+"','"+d14+"')";  // ���goods_gallery�в������ݵ�sql���
        con.executeUpdate(sql12);
        System.out.println("���Ѿ��ɹ����������Ʒ���Ƶ���������У�������ȫ����ɣ�");
        ResultSet rs1=con.executeQuery(sql42);
        con.commit();  //�ύ����
        cn.setAutoCommit(true);
        while(rs1.next()){     
         System.out.print(rs1.getInt(1)+"\t");
         System.out.print(rs1.getString(2)+"\t");    
         System.out.print(rs1.getString(3)+"\t");         
         System.out.print(rs1.getString(4)+"\t");                     
         System.out.print(rs1.getString(7)+"\t");           
         System.out.print(rs1.getString(8)+"\t");
         System.out.print(rs1.getString(9)+"\t");
         System.out.print(rs1.getString(10)+"\t");
         System.out.print(rs1.getString(11)+"\t");
         System.out.print(rs1.getString(12)+"\t");
         System.out.print(rs1.getString(18)+"\t");
         System.out.print(rs1.getString(19)+"\t");
         System.out.print(rs1.getString(20)+"\t");    
         System.out.print(rs1.getString(21)+"\t");         
         System.out.print(rs1.getString(22)+"\t");           
         System.out.print(rs1.getString(38)+"\t");
         System.out.println(" ");   
     }
        con.close(); 
        }catch (Exception exc) {
        	cn.rollback();//�ع�
        	cn.setAutoCommit(true);
        	exc.printStackTrace();
        	}
    }  
}
