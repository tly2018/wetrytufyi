package com.neuedu.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {
    private static final String URL="jdbc:mysql://127.0.0.1:3306/second?useUnicode=true&characterEncoding=utf8";
    private static final String ROOT="root";
    private static final String PSW="1234";
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstm=null;
        try {
            conn = DriverManager.getConnection(URL,ROOT,PSW);
            pstm = conn.prepareStatement("insert into teacher(name,password,flag) values(?,?,?)");
            pstm.setString(1,"fdjdfjgfjg");
            pstm.setString(2,"1234");
            pstm.setInt(3,2);
            int result = pstm.executeUpdate();
            System.out.println(result);
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }


    }
}
