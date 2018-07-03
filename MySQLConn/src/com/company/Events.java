package com.company;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;

public class Events extends KeyAdapter{
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            getting();
        }
    }
    public static void getting() {
        FrameMain2.find = FrameMain2.findTF.getText();

        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(FrameMain2.JDBC_DRIVER);
            conn = DriverManager.getConnection(FrameMain2.DB_URL, FrameMain2.USERNAME, FrameMain2.PASSWORD);
            stmt = conn.createStatement();

            String sql;
            sql = "select name, phoneNumber, password from umi where classNumber = '" + FrameMain2.find + "';";
            ResultSet rs = stmt.executeQuery(sql);

            FrameMain2.numTF.setText(null);
            FrameMain2.nameTF.setText(null);
            FrameMain2.pnumTF.setText(null);
            FrameMain2.psTF.setText(null);

            while (rs.next()) {

                String name = rs.getString("name");
                String phoneNumber = rs.getString("phoneNumber");
                String password = rs.getString("password");

                FrameMain2.num = FrameMain2.find;
                FrameMain2.nameA = name;
                FrameMain2.pNum = phoneNumber;
                FrameMain2.ps = password;

                FrameMain2.numTF.setText(FrameMain2.num);
                FrameMain2.nameTF.setText(FrameMain2.nameA);
                FrameMain2.pnumTF.setText(FrameMain2.pNum);
                FrameMain2.psTF.setText(FrameMain2.ps);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new FrameMain2();
    }
}

