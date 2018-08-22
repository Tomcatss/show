package com.test.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestJson {
    public static void main(String[] args) {

    }
    public StringBuffer doGet(String url) {
        StringBuffer sb = new StringBuffer();
        try {
            URL thisurl = new URL(url); // 把字符串转换为URL请求地址
            //获取connection对象
            HttpURLConnection connection = (HttpURLConnection) thisurl.openConnection();// 打开连接
            connection.setConnectTimeout(5000);//连接超时
            connection.setReadTimeout(5000);//读取内容超时
            //设置请求方式
            connection.setRequestMethod("GET");
            connection.connect();// 连接会话
            //获取响应码
            int code = connection.getResponseCode();
            if (code == HttpURLConnection.HTTP_OK) {
                //获取输入流
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        connection.getInputStream(), "UTF-8"));
                String line;
                while ((line = br.readLine()) != null) {// 循环读取流
                    sb.append(line).append("\n");
                }
                br.close();// 关闭流
                connection.disconnect();// 断开连接
            }
        } catch (Exception e) {
            e.printStackTrace();
            // System.out.println("失败!");
            return null;
        }
        return sb;
    }
}
