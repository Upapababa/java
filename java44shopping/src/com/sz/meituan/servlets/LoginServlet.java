package com.sz.meituan.servlets;

import com.sz.meituan.dao.Userdao;
import com.sz.meituan.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname= request.getParameter("uname");
        String upwd=request.getParameter("upwd");
        String uri=request.getParameter("uri");
        Userdao userdao = new Userdao();
        User user=userdao.getuser(uname,upwd);
        if(user!=null){
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            if("/order".equals(uri)){
                request.getRequestDispatcher("/car.jsp").forward(request,response);
            }else{
                response.sendRedirect("/appraise?fid="+request.getParameter("fid"));
            }
        }else{
            request.setAttribute("msg","用户名或密码错误");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
