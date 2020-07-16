package com.sz.zhiling.model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/yzsevlet")
public class MyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mno2=request.getParameter("mno");
        String mpwd=request.getParameter("mpwd");
        User s=Uitl.panduan(mno2,mpwd);
        Double balance=Uitl.show(mno2);
        String msg="账号或密码错误";
        String msg1="欢迎光临";
        if(s!=null){
            String sname=s.getMname();
            request.setAttribute("sname",sname);
            request.setAttribute("balance",balance);
            request.setAttribute("mno",mno2);
            request.setAttribute("mpwd",mpwd);
            request.setAttribute("msg1",msg1);
            request.getRequestDispatcher("/manager.jsp").forward(request,response);
        }else{
            request.setAttribute("msg",msg);
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
