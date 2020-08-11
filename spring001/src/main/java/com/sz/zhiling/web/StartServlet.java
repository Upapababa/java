package com.sz.zhiling.web;

import com.alibaba.fastjson.JSON;
import com.sz.zhiling.model.Conferenceroom;
import com.sz.zhiling.model.Pagemodle;
import com.sz.zhiling.service.IShow;
import com.sz.zhiling.service.IShowImp;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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


//    IShow sd;
    ClassPathXmlApplicationContext cx=new ClassPathXmlApplicationContext("applicationContext.xml");
    IShow iShow= (IShowImp) cx.getBean("iShowImp");

//    public void setSd(IShow iShow) {
//        this.iShow = iShow;
//    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=UTF-8"); //返回json格式的集合； 并且设置响应字符集为UTF-8,避免出现乱码；
        String page=request.getParameter("page");
        PrintWriter out=response.getWriter();
        List<Conferenceroom> list =new ArrayList<>();
        int key=1;
        if(page==null){
            list=iShow.showAll(1);
        }else{
            key=Integer.parseInt(page);
            list=iShow.showAll(Integer.parseInt(page));
        }
        int count =iShow.showAllpage();
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

    }
}
