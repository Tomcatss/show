package com.test.controller;

import com.alibaba.fastjson.JSON;
import com.test.model.Weather;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/servlet/json")

public class Servletjson extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        TestJson testJson = new TestJson();
        StringBuffer sb = testJson.doGet("https://www.sojson.com/open/api/weather/json.shtml?city=%E9%A9%AC%E9%9E%8D%E5%B1%B1");
        Weather weather = JSON.parseObject(sb.toString(),Weather.class);
        out.println(weather);
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

}
