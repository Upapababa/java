package com.sz.zhiling.model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/updservlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String opwd=request.getParameter("opwd");
        String npwd=request.getParameter("npwd");
        String mpwd=request.getParameter("mpwd");
        String mno =request.getParameter("mno");
        String sname = request.getParameter("sname");
        int mn = Integer.parseInt(mno);
        Double balance = Uitl.show(mno);
        String msg1="";
        if(mpwd.equals(opwd)){
            Uitl.upd(npwd,mno);
            msg1="修改密码成功";
            request.setAttribute("mpwd",npwd);
        }else{
            msg1="原密码输入错误";
            request.setAttribute("mpwd",mpwd);
        }
        request.setAttribute("sname",sname);
        request.setAttribute("balance",balance);
        request.setAttribute("mno",mno);
        request.setAttribute("msg1",msg1);
        request.getRequestDispatcher("/manager.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
