package com.sz.meituan.servlets;

import com.sz.meituan.dao.Present;
import com.sz.meituan.dao.Updao;
import com.sz.meituan.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet( "/upd")
public class UPDServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String utele=request.getParameter("utele");
        String orderid=request.getParameter("orderid");
        String uaddr=request.getParameter("uaddr");
        String beizhu=request.getParameter("beizhu");
        String sum1=request.getParameter("sum1");
        String total1=request.getParameter("total1");
        User user= (User) request.getSession().getAttribute("user");
        int userid = user.getUserid();
        Updao u = new Updao();
        u.upd(utele,uaddr,userid,beizhu,orderid);                      //修改订单信息
        HttpSession session =request.getSession();
        session.removeAttribute("cart");                 //清空购物车
        request.setAttribute("orderid",orderid);
        request.setAttribute("utele",utele);
        request.setAttribute("uaddr",uaddr);
        request.setAttribute("beizhu",beizhu);
        Present p = new Present();
        List list=p.chaxun2(Integer.parseInt(orderid));
        request.setAttribute("list",list);
        request.setAttribute("total1",total1);
        request.setAttribute("sum1",sum1);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
