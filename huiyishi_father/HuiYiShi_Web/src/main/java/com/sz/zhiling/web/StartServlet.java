package com.sz.zhiling.web;

import com.alibaba.fastjson.JSON;
import com.sz.zhiling.modle.Conferenceroom;
import com.sz.zhiling.modle.Pagemodle;
import com.sz.zhiling.servce.IShow;
import com.sz.zhiling.servce.IShowImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/show")
public class StartServlet extends HttpServlet {
//    ShowDao sd=new ShowDao();

    IShow sd=new IShowImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/json;charset=UTF-8"); //返回json格式的集合； 并且设置响应字符集为UTF-8,避免出现乱码；
        String page=request.getParameter("page");
//        String msg=request.getParameter("msg");
        PrintWriter out=response.getWriter();
        List<Conferenceroom> list =new ArrayList<>();
        int key=1;
        if(page==null){
            list=sd.showAll(1);
        }else{
            key=Integer.parseInt(page);
            list=sd.showAll(Integer.parseInt(page));
        }
        int count =sd.showAllpage();
        if(count%4!=0){
            count=count/4+1;
        }else{
            count=count/4;
        }
        Pagemodle pp=new Pagemodle(key,count,list);
        Object str=  JSON.toJSON(pp);
//        System.out.println("str="+str);
        out.print(str);
        out.flush();
//        request.setAttribute("list",list);
//        request.setAttribute("count",count);
//        request.setAttribute("page",key);
//        request.setAttribute("msg",msg);
//        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
