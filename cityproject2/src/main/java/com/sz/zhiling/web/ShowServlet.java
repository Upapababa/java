package com.sz.zhiling.web;

import com.alibaba.fastjson.JSON;
import com.sz.zhiling.module.ResoultPage;
import com.sz.zhiling.service.ICity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/show")
public class ShowServlet extends HttpServlet {

    private ICity iCity;

    private ResoultPage resoultPage;

    @Override
    public void init() throws ServletException {
        WebApplicationContext web= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        iCity=web.getBean(ICity.class);
        resoultPage=web.getBean(ResoultPage.class);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int fid=Integer.parseInt(request.getParameter("fid"));
        String data=iCity.showCityName(fid);
        PrintWriter out=response.getWriter();
        out.write(data);
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pa = request.getParameter("page");
        int page=Integer.parseInt(pa);
//        iCity.showAllCity(page);
//        iCity.showAllPage();
        resoultPage.setCount(iCity.showAllPage());
        resoultPage.setList(iCity.showAllCity(page));
        resoultPage.setPage(page);
        String rea= JSON.toJSONString(resoultPage);
        PrintWriter out=response.getWriter();
        out.write(rea);
        out.flush();
        out.close();
    }



}
