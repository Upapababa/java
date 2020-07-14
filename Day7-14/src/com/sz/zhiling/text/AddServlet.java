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
//        System.out.println("开始增加");
        request.setCharacterEncoding("UTF-8");
        String sid = request.getParameter("sid");
        String sname = request.getParameter("sname");
        String sage = request.getParameter("sage");
        String ssex = request.getParameter("ssex");
        String spwd = request.getParameter("spwd");
        String sclassno = request.getParameter("sclassno");
        if(sid==null ||sid.equals("")){
            Student s =new Student(sname,Integer.parseInt(sage),ssex,Integer.parseInt(spwd),sclassno);
            MyUtil.add(s);
        }else{
            MyUtil.update(Integer.parseInt(sid),sname,Integer.parseInt(sage),ssex,Integer.parseInt(spwd),sclassno);
        }
        response.sendRedirect("http://localhost:8080/users");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
