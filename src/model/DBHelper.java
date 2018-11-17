package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {
    private Connection conn;	//数据库连接对象
    private Statement stmt;		//sql语句执行对象

    private static final String driverName = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306";
    private static final String sDropDB = "drop database if exists userdb";
    private static final String sCreateDB = "create database userdb";
    private static final String sUseDB = "use userdb";
    private static final String sDropTb = "drop table if exists user";
    private static final String sCreateTb ="create table user (account varchar(20), password varchar(20) )";
    private static final String sInsert = "insert into user values('admin', '123456')";

    public DBHelper(){
        try {
            //1.加载MySQL驱动
            Class.forName(driverName);
            //2.与数据库建立连接
            conn = DriverManager.getConnection(url, "root", "root");
            //3.初始化sql语句对象
            stmt = conn.createStatement();
            stmt.execute(sDropDB);		//如果数据库userdb已存在就先删除
            stmt.execute(sCreateDB);	//创建数据库userdb
            stmt.execute(sUseDB);		//使用数据库userdb
            stmt.execute(sDropTb);		//如果user表已存在就先删除
            stmt.execute(sCreateTb);	//创建数据库user表
            stmt.execute(sInsert);		//向user表插入一条记录
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    //查询某用户是否存在
    public Boolean Query(User user) throws SQLException{
        ResultSet rs = null;

        //查询是否有account='admin',password='123456'的记录
        rs = stmt.executeQuery("select * from user where account='"+user.getAccount()+"' and password='"+user.getPassword()+"'");
        return rs.next();
    }
}
