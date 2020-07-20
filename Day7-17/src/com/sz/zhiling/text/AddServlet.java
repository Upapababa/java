package com.sz.zhiling.text;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addStudent")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String sid = request.getParameter("sid");
        String sname = request.getParameter("sname");
        String sage = request.getParameter("sage");
        String ssex = request.getParameter("ssex");
        String spwd = request.getParameter("spwd");
        String sclassno = request.getParameter("sclassno");
        if(sid==null ||sid.equals("")){
            User s =new User(sname,Integer.parseInt(sage),ssex,sclassno,Integer.parseInt(spwd));
            MyDao.add(s);
        }else{
            MyDao.upd(Integer.parseInt(sid),sname,Integer.parseInt(sage),ssex,sclassno);
        }
        response.sendRedirect("http://localhost:8080/showservlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
