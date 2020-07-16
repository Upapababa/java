package com.sz.zhiling.model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/zzservlet")
public class ZzServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String nno=request.getParameter("nno");
        String money=request.getParameter("money");
        String mpwd=request.getParameter("mpwd");
        String mno =request.getParameter("mno");
        String sname = request.getParameter("sname");
        int mn1 = Integer.parseInt(mno);
        int mn2 = Integer.parseInt(nno);
        Double balance = Uitl.show(mno);
        Double balance5 = Uitl.show(nno);
        User s=Uitl.panduan(nno);
        Double jj = Double.parseDouble(money);
        String msg1="";
        if(balance>jj && s!=null){
            double balance2=balance-jj;
            double balance3=jj+balance5;
            Uitl.zz(balance2,mn1,balance3,mn2);
            request.setAttribute("balance",balance2);
            msg1="转账成功";
        }else{
            msg1="余额不足或卡号不存在";
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
