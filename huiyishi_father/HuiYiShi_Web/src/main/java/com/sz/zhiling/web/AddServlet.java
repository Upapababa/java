package com.sz.zhiling.web;

import com.sz.zhiling.servce.IUP;
import com.sz.zhiling.servce.IUPimp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
//    UPDao sd=new UPDao();
    IUP sd=new IUPimp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取页面的信息，会议室每一项内容
        String  crid=request.getParameter("uid");
        String  crno=request.getParameter("uno");
        String  crname=request.getParameter("uname");
        String  craddr=request.getParameter("uaddr");
        String  capacity=request.getParameter("upa");
        PrintWriter out =response.getWriter();
        String msg="";    //提示信息    更改后的提示
        if(crid==""){
            int s=sd.add(crno,crname,craddr,capacity);
            msg=s>0?"增加成功":"增加失败";
        }else{
            int s=sd.upd(crid,crno,crname,craddr,capacity);
            msg=s>0?"修改成功":"修改失败";
        }
        out.write(msg);
        out.flush();
//        request.setAttribute("msg",msg);
//        request.getRequestDispatcher("/show?msg="+msg).forward(request,response);
//        response.sendRedirect("/show?msg="+msg);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //删除一条会议室信息
        //修改发送字符编码，
        response.setContentType("text/html;charset=UTF-8");
        //拿到会议室的序号
        String crid=request.getParameter("crid");
        //根据序号删除一条会议室信息
        int s=sd.del(crid);
        //创建一个对象
        PrintWriter out =response.getWriter();
        //将返回的信息发送到前端页面
        out.write(s);
        out.flush();
    }
}
