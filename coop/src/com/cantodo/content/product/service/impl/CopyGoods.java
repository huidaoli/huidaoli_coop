package com.cantodo.content.product.service.impl;

import java.sql.*;
import java.util.StringTokenizer;
import java.io.*;

public class CopyGoods{
	// 图片源文件夹   
    static String url1 = "E:/Can2DO/PWP/images/201307/";  //图片源文件夹请根据实际情况更改,选中的文件夹中可以包含多个文件和文件夹
    // 图片目标文件夹   
    static String url2 = "D:/AppServ1/www/shop/images/201307/";  //图片目标文件夹请根据实际情况更改,选中的文件夹中可以包含多个文件和文件夹
	//静态全局变量，用来保存从供体库获得的字段值。并提供给受体库复制。d1-d15插入到表goods中，d16-d19插入到表goods_gallery中。
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
	//为供体库创建静态全局变量 
    static Connection conn;   
    static Statement st;  
    //为受体库创建静态全局变量
    static Connection cn = null;
    Statement stmt;
    boolean autoCommit;
    private String DbType="MYSQL";
    //受体库数据库连接初始化操作
    private CopyGoods(){
       init();
    }
    //受体库数据库连接初始化init方法
    private void init(){
        try{
        	Class.forName("com.mysql.jdbc.Driver");// 加载Mysql数据驱动     
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecshop", "root", "");// 创建数据连接   
        }catch(Exception e){
            System.err.println("conndb():连接异常. " + e.getMessage());
        }
    }
    //用于受体库数据库连接的类对象
    public static CopyGoods getNewInstance(){
        return new CopyGoods();
    }
    //事务处理开始
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
    //实现多sql的事务处理
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
    //回滚操作
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
    //默认的情况下一次executeQuery(String sql)是一次事务.
    //但是可以调用beginTrans()，然后多次executeQuery(String sql)，
    //最后commit()实现多sql的事务处理，并在catch(){调用rollBack()})。    
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
    //Method doBatch 的参数sql，是由一些sql语句拼起来的，用;隔开。可以将许多的sql放在一个事务中，一次执行。
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
    //获取数据库类型
    public String getDbType(){
        return DbType;
    }
    //关闭数据库
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
    
    /*获取供体数据库myuser连接的函数*/
    public static Connection getConnection() {   
        Connection cm = null;  //创建用于连接数据库的Connection对象   
        try {   
            Class.forName("com.mysql.jdbc.Driver");// 加载Mysql数据驱动          
            cm = DriverManager.getConnection(   
                    "jdbc:mysql://localhost:3306/myuser", "root", "");// 创建数据连接   
        } catch (Exception e) {   
            System.out.println("数据库连接失败" + e.getMessage());   
        }   
        return cm; //返回所建立的数据库连接   
    }    
    // 复制图片文件操作 
	public static void copyFile(File sourceFile,File targetFile)   
	throws IOException{  
	        // 新建文件输入流并对它进行缓冲   
	        FileInputStream input = new FileInputStream(sourceFile);  
	        BufferedInputStream inBuff=new BufferedInputStream(input);  
	  
	        // 新建文件输出流并对它进行缓冲   
	        FileOutputStream output = new FileOutputStream(targetFile);  
	        BufferedOutputStream outBuff=new BufferedOutputStream(output);  
	          
	        // 缓冲数组   
	        byte[] b = new byte[1024 * 5];  
	        int len;  
	        while ((len =inBuff.read(b)) != -1) {  
	            outBuff.write(b, 0, len);  
	        }  
	        // 刷新此缓冲的输出流   
	        outBuff.flush();  
	          
	        //关闭流   
	        inBuff.close();  
	        outBuff.close();  
	        output.close();  
	        input.close();  
	    }  
	// 复制图片文件夹 操作
	public static void copyDirectiory(String sourceDir, String targetDir)  
	 throws IOException {  
	        // 新建目标目录   
	        (new File(targetDir)).mkdirs();  
	        // 获取源文件夹当前下的文件或目录   
	        File[] file = (new File(sourceDir)).listFiles();  
	        for (int i = 0; i < file.length; i++) {  
	            if (file[i].isFile()) {  
	                // 源文件   
	                File sourceFile=file[i];  
	                // 目标文件   
	               File targetFile=new   
	               File(new File(targetDir).getAbsolutePath()  
	            		   +File.separator+file[i].getName());  
	                copyFile(sourceFile,targetFile);  
	            }  
	            if (file[i].isDirectory()) {  
	                // 准备复制的源文件夹   
	                String dir1=sourceDir + "/" + file[i].getName();  
	                // 准备复制的目标文件夹   
	                String dir2=targetDir + "/"+ file[i].getName();  
	                copyDirectiory(dir1, dir2);  
	            }  
	        }  
	    }      
/////////////////////*主函数*//////////////////////////////////
public static void main(String[] args)throws Exception{
	// 创建目标文件夹   
    new File(url2).mkdirs();  
    // 获取源文件夹当前下的文件或目录   
    File[] file = (new File(url1)).listFiles();  
    for (int i = 0; i < file.length; i++) {  
        if (file[i].isFile()) {  
            // 复制文件   
            copyFile(file[i],new File(url2+file[i].getName()));  
        }  
        if (file[i].isDirectory()) {  
            // 复制目录   
            String sourceDir=url1+File.separator+file[i].getName();  
            String targetDir=url2+File.separator+file[i].getName();  
            copyDirectiory(sourceDir, targetDir);  
        }  
     } 
    	/*供体库相关操作*/
    	conn = getConnection(); //连接到供体数据库   
        try {   
            String sql = "select * from staff";     // 查询供体库数据的sql语句   
            st = (Statement) conn.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量      
            ResultSet rs = st.executeQuery(sql);    //执行sql查询语句，返回查询数据的结果集   
            System.out.println("你已经成功从供体库将下面的数据取出：");  
            while (rs.next()) { // 判断是否还有下一个数据    
                // 根据字段名获取相应的值,字段不够的话请自行添加
            	d1 = rs.getInt(2);   //数据库中是字段a2,int类型
                d2 = rs.getString(3);   //字段a3,String类型
                d3 = rs.getString(4);   //字段a4,String类型
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
                //输出查到的记录的各个字段的值   
                System.out.println(d1 + " " + d2 + " " + d3 + " " + d4+ " " + d5 + " " + d6 + " " + d7+ " " + d8+ " " + d9+ " " + d10+ " " + d11+ " " + d12+ " " + d13+ " " + d14+ " " + d15);    
            }    
            conn.close();   //关闭供体数据库连接        
        } catch (SQLException e) {   
            System.out.println("从供体库取数据失败");   
        }  
        /*受体库相关操作*/ 
        try{  
        	CopyGoods con=CopyGoods.getNewInstance();
        	cn.setAutoCommit(false);//开始一个事务
        	System.out.println("你连接的受体库是："+con.getDbType()+"数据库。");//获取当前连接的受体库数据库类型
    
            ////////////////////////受体库插入数据的sql语句群///////////////////////////////////////////////////////////////////////
        	String sql11 = "INSERT INTO ecs_goods(cat_id,goods_sn,goods_name,brand_id,provider_name,goods_number,goods_weight,market_price,shop_price,goods_brief,goods_desc,goods_thumb,goods_img,original_img,goods_type)"  
        			+ " VALUES ("+d1+",'"+d2+"','"+d3+"','"+d4+"','"+d5+"','"+d6+"','"+d7+"','"+d8+"','"+d9+"','"+d10+"','"+d11+"','"+d12+"','"+d13+"','"+d14+"','"+d15+"')";  // 插入数据的sql语句       	  
    	
            ////////////////////////受体库更新数据的sql语句群////////////////////////////////////////////////////////////////////////
            //String sq21 = "update staff set wage='21' where name = 'Tom4'";// 更新数据的sql语句 

            
            ////////////////////////受体库删除数据的sql语句群////////////////////////////////////////////////////////////////////////
            //String sql31 = "delete from ecs_goods where goods_name='手机'";// 删除数据的sql语句

        	
        	String sql41="select * from ecs_goods where goods_sn='ECS000PWP'";// 受体库查询数据的sql语句
        	String sql42="select * from ecs_goods where goods_sn='ECS000PWP'";// 受体库查询数据的sql语句
            con.beginTrans();
            ////插入多条语句
            con.executeUpdate(sql11); 
            System.out.println("你已经将上面数据成功的进行了插入操作，下面将还需获取商品id并进行图片信息插入！");
            ////更新多条语句
            //con.executeUpdate(sql3);
            //System.out.println("你已经进行更新操作！");
            ////删除多条语句
            //con.executeUpdate(sql31);
            //System.out.println("你已经进行删除操作！");
            ////查询操作语句
            ResultSet rs=con.executeQuery(sql41);
            System.out.println("你已经成功获取了上面这条数据的商品id，即将进行图片信息插入！");
            
        while(rs.next()){     
        		d16=rs.getInt(1);
         }
        String sql12 = "INSERT INTO ecs_goods_gallery(goods_id,img_url,img_desc,thumb_url,img_original)"  
			+ " VALUES ("+d16+",'"+d13+"','"+d11+"','"+d12+"','"+d14+"')";  // 向表goods_gallery中插入数据的sql语句
        con.executeUpdate(sql12);
        System.out.println("你已经成功将上面的商品复制到了受体库中，操作已全部完成！");
        ResultSet rs1=con.executeQuery(sql42);
        con.commit();  //提交事务
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
        	cn.rollback();//回滚
        	cn.setAutoCommit(true);
        	exc.printStackTrace();
        	}
    }  
}
