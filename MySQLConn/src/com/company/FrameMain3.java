/*package com.company;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class FrameMain3 extends JFrame {
    public FrameMain3() {
        JPanel panel = new JPanel();
        add(panel, BorderLayout.CENTER);

        JLabel firstLabel = new JLabel("찾는 학번");
        JTextField firstTextField = new JTextField(15);
        JButton firstButton = new JButton("검색");

        panel.add(firstLabel);
        panel.add(firstTextField);
        panel.add(firstButton);

        JLabel secondLabel = new JLabel("학번            ");
        JTextField classNumberTextField = new JTextField(15);

        panel.add(secondLabel);
        panel.add(classNumberTextField);

        JLabel thirdLabel = new JLabel("성명            ");
        JTextField NameTextField = new JTextField(15);

        panel.add(thirdLabel);
        panel.add(NameTextField);

        JLabel fourthLabel = new JLabel("전화번호        ");
        JTextField NumberTextField = new JTextField(15);

        panel.add(fourthLabel);
        panel.add(NumberTextField);

        JLabel fifthLabel = new JLabel("비밀번호        ");
        JTextField passwordTextField = new JTextField(15);

        panel.add(fifthLabel);
        panel.add(passwordTextField);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(400,410);
    }
    public static void getting() {
        find = findTF.getText();

        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            stmt = conn.createStatement();

            String sql;
            sql = "select name, phoneNumber, password from umi where classNumber = '" + find + "';";
            ResultSet rs = stmt.executeQuery(sql);

            numTF.setText(null);
            nameTF.setText(null);
            pnumTF.setText(null);
            psTF.setText(null);

            while (rs.next()) {

                String name = rs.getString("name");
                String phoneNumber = rs.getString("phoneNumber");
                String password = rs.getString("password");

                num = find;
                nameA = name;
                pNum = phoneNumber;
                ps = password;

                numTF.setText(num);
                nameTF.setText(nameA);
                pnumTF.setText(pNum);
                psTF.setText(ps);
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
}
*/