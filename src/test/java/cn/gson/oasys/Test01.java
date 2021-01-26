package cn.gson.oasys;

import java.sql.*;

/**
 * @author lipw4
 * @createTime 21-1-21
 * @describe
 */
public class Test01 {

    public static void main(String[] args) {
        String driver="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://127.0.0.1:3306/mytest";
        String userName="root";
        String password="root";


        try {
            Class.forName(driver);  //1、加载驱动
            Connection connection = DriverManager.getConnection(url, userName, password);//2、连接数据库
            if(!connection.isClosed()){
                String sql ="SELECT * FROM USER WHERE USERNAME=?";

                /*Statement stmt = connection.createStatement();
                String sql = "SELECT id, name, url FROM websites";
                ResultSet rs = stmt.executeQuery(sql);*/

                PreparedStatement statement = connection.prepareStatement(sql); //3、创建Statement对象
                statement.setString(1,"wangwu");
                ResultSet resultSet = statement.executeQuery();  //4、查询结果
                while (resultSet.next()){
                    System.out.println("resultSet.getString(\"ID\")+ = " + resultSet.getString("ID"));
                }
                if(!resultSet.isClosed()){  //5、关闭连接
                    resultSet.close();
                }if(!connection.isClosed()){
                    connection.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
