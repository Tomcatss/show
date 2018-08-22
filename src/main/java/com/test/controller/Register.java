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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "register",urlPatterns = "/test/register")

public class Register extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        User user = new User();
        PrintWriter out = resp.getWriter();
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        user.setNumber(req.getParameter("number"));
        List<User> list  = new ArrayList<User>();
        list.add(user);
        //boolean a = new DBOper().selectt(list);
        boolean b = new DBOper().insert(list);
        if(b) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/html/Enter.html");
            dispatcher.forward(req, resp);
        }else {
            String jsonStr ="{\"id\":\"注册失败！\",}";
            out.println(jsonStr);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
