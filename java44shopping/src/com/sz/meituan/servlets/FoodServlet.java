package com.sz.meituan.servlets;

import com.sz.meituan.dao.FoodDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/food")
public class FoodServlet extends HttpServlet {
    FoodDao foodDao =new FoodDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查询所有的菜；
        String orderid=request.getParameter("orderid");
        if(orderid==null){
            request.setAttribute("list",foodDao.getAllFood());
        }else{
            int n=foodDao.update(orderid);
            String msg=n>0?"取消订单成功":"取消订单失败";
            HttpSession session=request.getSession();
            session.removeAttribute("cart");
            request.setAttribute("msg",msg);
            request.setAttribute("list",foodDao.getAllFood());
        }
        request.getRequestDispatcher("/food.jsp").forward(request,response);
    }
}
