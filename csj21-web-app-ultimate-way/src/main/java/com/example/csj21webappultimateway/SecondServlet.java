package com.example.csj21webappultimateway;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@WebServlet(name="secondServlet", value = "/genericServlet")
public class SecondServlet extends GenericServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("init method");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Service method");
        PrintWriter writer = res.getWriter();
        writer.println(LocalDateTime.now());
        writer.println("Writing to the client back. and this is coming from service method of the servlet");
    }

    @Override
    public void destroy() {
        System.out.println("Destroy method");
    }
}
