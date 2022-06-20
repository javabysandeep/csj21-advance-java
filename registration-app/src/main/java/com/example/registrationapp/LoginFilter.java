package com.example.registrationapp;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "LoginFilter", urlPatterns = {"/Servlet1","/Servlet2", "/Servlet3","/register"})
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        //server --> filter --> servlet
        System.out.println("Filter init method. called only once");
    }

    public void destroy() {
        System.out.println("Filter destroy method, called only once when the app is undeplyed");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //pre-processing
//        PrintWriter writer = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("Before filter");
        if("abc".equals(username) && "pass".equals(password)){
            chain.doFilter(request, response);
        } else{
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request,response);
        }

        //post-processing
        System.out.println("After filter");
    }
}
