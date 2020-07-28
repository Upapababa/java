package com.sz.meituan.servlets;

import com.sz.meituan.dao.Present;
import com.sz.meituan.model.Cart;
import com.sz.meituan.model.CartItem;
import com.sz.meituan.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Map<Integer,CartItem> map=new HashMap<>();  //new map
        Object obj = session.getAttribute("cart");  //得到cart
        Cart cart = (Cart) obj;
        map=cart.getMap();                           //得到map
        Object s=session.getAttribute("user");   //得到用户信息
        User user= (User) s;
        int userid=user.getUserid();                // 得到用户ID
        Float total = cart.getTotal();              //得到订单总金额
        int sum=cart.getSum();                       //得到订单总数量
        Present p = new Present();                       // new 一个dao
        int orderid=p.chaxun1();                       //先查询序列的ORDERID
//        int orderid=u1.getOrderid();
        p.tijiao(orderid,userid,total,sum);                      //提交用户订单表
        Set<Integer> key = map.keySet();                   //获取商品ID的set集合
        Iterator it=key.iterator();                       //迭代器取值
//        float total1 =0.0f;
//        int sum1 =0;
        while(it.hasNext()){                        //循环拿值
            int fid= (int) it.next();             //拿到商品ID
            CartItem ci = map.get(fid);              //得到商品的单价、数量、小计类
            System.out.println(fid);
            int num = ci.getNum();                 //得到数量
            float xiaoji = ci.getXiaoji();         //得到小计
//            total1+=xiaoji;
//            sum1+=num;
            p.tijiao2(orderid,fid,num,xiaoji);    //提交订单详情表
        }
        request.setAttribute("orderid",orderid);           //传递值到新界面
        request.setAttribute("uname",user.getUname());
        request.setAttribute("utele",user.getUtele());
        request.setAttribute("uaddr",user.getUaddr());
        List list=p.chaxun2(orderid);
        request.setAttribute("list",list);
        request.setAttribute("total1",total);
        request.setAttribute("sum1",sum);
        session.setAttribute("cart",cart);
//        session.setAttribute("user",user);
//        map.clear();                              //清楚缓存在购物车的商品
//        cart.setMap(map);
        request.getRequestDispatcher("settle.jsp").forward(request,response);
    }
}
