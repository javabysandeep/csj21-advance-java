package com.example.csj21webappultimateway;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.LocalTime;

@WebServlet(name = "ThirdServlet", value = "/thirdServlet")
public class ThirdServlet extends HttpServlet {
    //GET
    //POST
    //DELETE
    //PUT
    //server will call public service method in HttpServlet
    /*in service method, servletRequest and ServletResponse objects are converted into
     HttpServletRequest and HttpServletResponse
     it will call protected service method in HttpServlet class.

     Inside the protected service method,
     It checks the client Http request method type, based on that doXXX() method will be call.

     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /// this method will be executed.
        PrintWriter writer = resp.getWriter();
        writer.println("Writing back to the client from do Get method");

    }
}
