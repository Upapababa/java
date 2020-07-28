package com.sz.meituan.servlets;

import com.sz.meituan.dao.HuifuDao;
import com.sz.meituan.model.Huifu;
import com.sz.meituan.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/HuifuServlet")
public class HuifuServlet extends HttpServlet {
    HuifuDao h=new HuifuDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String amsg=request.getParameter("huifu");
        String pid=request.getParameter("pid");
        HttpSession session=request.getSession();
        User user= (User) session.getAttribute("user");
        int userid=user.getUserid();
        String uname=user.getUname();
        int n=h.huifu(Integer.parseInt(pid),userid,amsg,uname);
        System.out.println(n>0?"回复成功":"回复失败");
        response.sendRedirect("/appraise?fid="+request.getParameter("fid"));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
