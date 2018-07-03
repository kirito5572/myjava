package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class FrameMain extends JFrame {

    private String text = null;
    public FrameMain() {
        super("Database");
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://127.0.0.1:3306/user";

        final String USERNAME = "root";
        final String PASSWORD = null;
        JButton jb = new JButton("Show Database Record");
        JPanel jp = new JPanel(new FlowLayout());
        JPanel jp2 = new JPanel(new FlowLayout());
        JTextArea ta = new JTextArea(19,34);
        setSize(400,410);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        jb.setPreferredSize(new Dimension(380,25));
        jp.add(jb);
        ta.setPreferredSize(new Dimension(380,320));
        add(jp,BorderLayout.NORTH);
        add(jp2,BorderLayout.CENTER);
        jp2.add(ta);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e5) {
                Connection conn = null;
                Statement stmt = null;
                try{
                    Class.forName(JDBC_DRIVER);
                    conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
                    text = "\n- MySQL Connection";

                    String sql = "SELECT * FROM umi";
                    ResultSet rs = stmt.executeQuery(sql);

                    while(rs.next()){
                        String classNumber = rs.getString("classNumber");
                        String name = rs.getString("name");
                        String phoneNumber = rs.getString("phoneNumber");
                        String password = rs.getString("password");

                        text = text + "\n** classNumber : " + classNumber;
                        text = text + "\n    -> name: " + name;
                        text = text + "\n    -> phoneNumber: " + phoneNumber;
                        text = text + "\n    -> password: " + password;


                    }
                    rs.close();
                    stmt.close();
                    conn.close();
                }catch(Exception ex){
                    ex.printStackTrace();
                }finally{
                    try{
                        if(stmt!=null)
                            stmt.close();
                    }catch(SQLException se2){
                        se2.printStackTrace();
                    }
                    try{
                        if(conn!=null)
                            conn.close();
                    }catch(SQLException se){
                        se.printStackTrace();
                    }
                }
                text = text + "\n\n- MySQL Connection Close";
                ta.setText(text);
            }
        });
    }

    public static void main(String[] args) {
        FrameMain fm = new FrameMain();
    }
}