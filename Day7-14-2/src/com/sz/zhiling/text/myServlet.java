package com.sz.zhiling.text;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/users")
public class myServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("删除："+request.getParameter("sid"));
        request.setCharacterEncoding("UTF-8");
        String search=request.getParameter("search");
        List<Student> list = MyUtil.show(search);
        request.setAttribute("list",list);
        request.getRequestDispatcher("index.jsp").forward(request,response);

    }
}
