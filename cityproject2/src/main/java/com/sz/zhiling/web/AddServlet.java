package com.sz.zhiling.web;

import com.sz.zhiling.dao.CityDao;
import com.sz.zhiling.service.ICity;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/add")
public class AddServlet extends HttpServlet {

    private CityDao cityDao;

    @Override
    public void init() throws ServletException {
        WebApplicationContext web= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        cityDao=web.getBean(CityDao.class);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cname =request.getParameter("cname");
        String pname =request.getParameter("pname");
        String msg="";
        if(cname=="" ||cname ==null){
            //市为空，添加省
            int n=cityDao.addPname(pname);
            msg=n>1?"添加省成功":"添加省失败";
        }else{
            int aid=cityDao.showAid(pname);
            if(aid==0){
                int n=cityDao.addPname(pname);
                aid=cityDao.showAid(pname);
                int s=cityDao.addCname(cname,aid);
                msg=s>1?"添加省市成功":"添加省市失败";
            }else{
                int s=cityDao.addCname(cname,aid);
                msg=s>1?"添加市成功":"添加市失败";
            }
        }
        PrintWriter out=response.getWriter();
        out.write(msg);
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int aid=Integer.parseInt(request.getParameter("aid"));
        int x=cityDao.del(aid);
        PrintWriter out=response.getWriter();
        out.write(x);
        out.flush();
        out.close();
    }
}
