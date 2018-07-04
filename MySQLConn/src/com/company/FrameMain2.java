package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.InetAddress;
import java.sql.*;

public class FrameMain2 extends JFrame implements ActionListener{

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/user";

    static final String USERNAME = "root";
    static final String PASSWORD = null;

    static String find = null;
    static String nameA = null;
    static String pNum = null;
    static String num = null;
    static String ps = null;
    static JTextField findTF;
    static JTextField numTF;
    static JTextField nameTF;
    static JTextField pnumTF;
    static JTextField psTF;

    public FrameMain2() {
        super("Database");
        JButton sBT = new JButton("검색");
        JPanel jp = new JPanel(new FlowLayout());
        JPanel jp2 = new JPanel(new GridLayout(4,2,5,2));
        JLabel findL = new JLabel("찾는 학번");
        findTF = new JTextField(12);
        JLabel numL = new JLabel("  학번");
        numTF = new JTextField(10);
        JLabel nameL = new JLabel("  성명");
        nameTF = new JTextField(10);
        JLabel pnuml = new JLabel("  전화번호");
        pnumTF = new JTextField(10);
        JLabel psL = new JLabel("  패스워드");
        psTF = new JTextField(10);
        setSize(300,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        add(jp,BorderLayout.NORTH);
        sBT.setPreferredSize(new Dimension(65,25));
        findTF.setPreferredSize(new Dimension(135,25));
        findL.setPreferredSize(new Dimension(60,25));
        jp.add(findL);
        jp.add(findTF);
        jp.add(sBT);

        jp2.add(numL);
        numTF.setPreferredSize(new Dimension(115,25));
        jp2.add(numTF);
        jp2.add(nameL);
        nameTF.setPreferredSize(new Dimension(115,25));
        jp2.add(nameTF);
        jp2.add(pnuml);
        pnumTF.setPreferredSize(new Dimension(115,25));
        jp2.add(pnumTF);
        jp2.add(psL);
        psTF.setPreferredSize(new Dimension(115,25));
        jp2.add(psTF);

        add(jp2,BorderLayout.CENTER);
        sBT.addActionListener(this);
        findTF.addKeyListener(new Events());
    }
    public void actionPerformed(ActionEvent e) {
        Events.getting();
    }
}