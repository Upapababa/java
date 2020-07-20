package com.sz.zhiling.text;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteStudent")
public class DelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String sid=request.getParameter("sid");
//        MyDao.del(sid);
//        request.getRequestDispatcher("/index.jsp").forward(request,response);
        String[] sid=request.getParameterValues("xz");
        MyDao.del(sid);
        response.sendRedirect("http://localhost:8080/showservlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sid=request.getParameter("sid");
        MyDao.del(sid);
        response.sendRedirect("http://localhost:8080/showservlet");
    }
}
