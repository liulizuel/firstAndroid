package com.example.myapplication;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectRecords {
    private Connection connect() {
        String url = "jdbc:sqlite:F:\\sqlite-tools-win32-x86-3360000\\sqlite-tools-win32-x86-3360000\\test.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public List<List<String>> selectAll() {
        String sql = "SELECT * FROM users";
        try {
            Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            List<List<String>> list = new ArrayList<>();
            while (rs.next()) {
                List<String> stringList = new ArrayList<>();
                stringList.add(rs.getString("name"));
                stringList.add(rs.getString("age"));
                stringList.add(rs.getString("sex"));
                list.add(stringList);
                System.out.println( rs.getString("NAME") + "\t" + rs.getString("SEX") + "\t" +rs.getString("AGE") + "\t");
            }

            return list;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
//    public static void main(String[] args) {
//        SelectRecords app = new SelectRecords();
//        app.selectAll();
//    }
}