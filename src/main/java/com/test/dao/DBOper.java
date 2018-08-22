package com.test.dao;

import com.test.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DBOper {

    public boolean selectt(List<User> list){
        boolean bok = false;
        int num = 0;
        User user = list.get(0);
        Connection conn = new DBHelper().getConn();
        String sql = "select * from user where username = ? && password = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            int i =1 ;
            pstmt.setString(i++,user.getUsername());
            pstmt.setString(i++,user.getPassword());
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                bok = true;
            }
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bok;
    }
    public boolean insert(List<User> list){
        boolean bok = false;
        int num = 0;
        User user = list.get(0);
        Connection conn = new DBHelper().getConn();
        String sql = "insert into user(username,password,number) values (?,?,?);";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            int i = 1;
            pstmt.setString(i++,user.getUsername());
//            try {
//                //����һ��MD5���ܼ���ժҪ
//             MessageDigest md = MessageDigest.getInstance("MD5");
//                //����md5����
//             md.update((user.getPassword()).getBytes());
//             pstmt.setString(i++, String.valueOf(new BigInteger(1, md.digest()).toString(16)));
//           } catch (NoSuchAlgorithmException e1) {
//               e1.printStackTrace();
//           }
            pstmt.setString(i++,user.getPassword());
            pstmt.setString(i++,user.getNumber());
            num = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(num != 0){
            bok = true;
        }
        return bok;
    }


    public boolean select(User user){
        boolean bok = false;
        Connection conn = new DBHelper().getConn();
        String sql = "select * from user where username = ? && password = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            int i =1 ;
            pstmt.setString(i++,user.getUsername());
//            try {
//                MessageDigest md = MessageDigest.getInstance("MD5");
//                md.update((user.getPassword()).getBytes());
//                pstmt.setString(i++,String.valueOf(new BigInteger(1, md.digest()).toString(16)));
//            } catch (NoSuchAlgorithmException e1) {
//                e1.printStackTrace();
//            }
            pstmt.setString(i++,user.getPassword());
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                bok = true;
            }
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bok;
    }

    public boolean checkUsername(String username) {
        boolean bok = false;
        Connection conn = new DBHelper().getConn();
        String sql = "select * from user where username = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                bok = true;
            }
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bok;
    }
}
