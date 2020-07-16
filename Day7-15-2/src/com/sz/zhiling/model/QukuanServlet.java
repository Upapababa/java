package com.sz.zhiling.model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/qukuanservlet")
public class QukuanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String jine=request.getParameter("jine");
        String mno =request.getParameter("mno");
        String sname = request.getParameter("sname");
        int mn = Integer.parseInt(mno);
        Double balance = Uitl.show(mno);
        Double jj = Double.parseDouble(jine);
        String msg1="";
        if(balance>jj){
            double balance2=balance-jj;
            Uitl.save(balance2,mn);
            request.setAttribute("balance",balance2);
            msg1="取款成功";
        }else{
            msg1="余额不足";
            request.setAttribute("balance",balance);
        }
        request.setAttribute("sname",sname);
        request.setAttribute("mno",mno);
        request.setAttribute("msg1",msg1);
        request.getRequestDispatcher("/manager.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
