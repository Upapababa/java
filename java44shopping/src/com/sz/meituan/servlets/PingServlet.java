package com.sz.meituan.servlets;

import com.sz.meituan.dao.Pinlundao;
import com.sz.meituan.model.Food;
import com.sz.meituan.model.Huifu;
import com.sz.meituan.model.Pin;
import com.sz.meituan.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/appraise")
public class PingServlet extends HttpServlet {
    Pinlundao pin = new Pinlundao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fid=request.getParameter("fid");
        String msg=request.getParameter("pinjia");
        HttpSession session=request.getSession();
        User user= (User) session.getAttribute("user");
        int userid=user.getUserid();
        String uname=user.getUname();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        String ppdate = sdf.format(new java.util.Date());
        Date pdate=null;
        try {
            pdate = new Date(sdf.parse(ppdate).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        pin.pp(fid,msg,userid,uname);
        doGet(request,response);
//        response.sendRedirect("/appraise?fid="+request.getParameter("fid"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fid = request.getParameter("fid");
        Food food = pin.chaxun2(fid);
        List<Pin> list=pin.chaxun(fid);
        for (Pin p : list) {
            int ppid=p.getPid();
            List<Huifu> list2=pin.cha(ppid);
            p.setList2(list2);
        }
        request.setAttribute("list",list);
        request.setAttribute("f",food);
        request.getRequestDispatcher("pinjia.jsp").forward(request,response);

    }
}
