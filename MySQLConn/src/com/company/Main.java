package com.company;

import java.sql.*;

public class Main {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/user";

    static final String USERNAME = "root";
    static final String PASSWORD = null;

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            System.out.println("\n- MySQL Connection");
            stmt = conn.createStatement();

            String sql;
            sql = "SELECT * FROM umi";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                String classNumber = rs.getString("classNumber");
                String name = rs.getString("name");
                String phoneNumber = rs.getString("phoneNumber");
                String password = rs.getString("password");

                System.out.print("\n** classNumber : " + classNumber);
                System.out.print("\n    -> name: " + name);
                System.out.print("\n    -> phoneNumber: " + phoneNumber);
                System.out.print("\n    -> password: " + password);

            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se1){
            se1.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("\n\n- MySQL Connection Close");
    }
}