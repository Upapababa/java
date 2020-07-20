package com.sz.zhiling.text;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/showservlet")
public class ShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page=request.getParameter("page");
        int page1 = page==null?1:Integer.parseInt(page);
        List list=MyDao.show(page1);
        int count1=MyDao.show1();
        request.setAttribute("list",list);
        request.setAttribute("count1",count1);
        request.setAttribute("page",page1);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
