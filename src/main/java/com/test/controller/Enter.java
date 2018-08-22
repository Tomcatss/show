package com.test.controller;

import com.test.dao.DBOper;
import com.test.model.User;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "enter",urlPatterns = "/test/enter")
public class Enter extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        User user = new User();
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        boolean b = new DBOper().select(user);
        if (b == true) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/html/Main.html");
            dispatcher.forward(req, resp);
        } else {
            String jsonStr ="{\"id\":\"登录失败！\",}";
            out.println(jsonStr);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    doPost(req,resp);
        doGet(req,resp);
    }
}
