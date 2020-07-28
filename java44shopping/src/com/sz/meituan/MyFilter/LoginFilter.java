package com.sz.meituan.MyFilter;

import com.sz.meituan.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter({"/order","/appraise"})
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        User user= (User) session.getAttribute("user");
        if(user ==null){
//            request.setAttribute("msg","你还没有登录，无法提交订单");
            request.setAttribute("uri", request.getRequestURI());
            request.setAttribute("fid",request.getParameter("fid"));
            String uri=request.getRequestURI();
            System.out.println( uri);
            request.getRequestDispatcher("login.jsp").forward(request,resp);
        }else{
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
