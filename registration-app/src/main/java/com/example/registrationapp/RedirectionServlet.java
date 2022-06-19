package com.example.registrationapp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RedirectionServlet", value = "/redirect")
public class RedirectionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer number1 = Integer.parseInt(request.getParameter("number1"));
        Integer number2 = Integer.parseInt(request.getParameter("number2"));

        if(number2 ==0){
            RequestDispatcher error = request.getRequestDispatcher("error");
            error.forward(request,response);
        }
        response.getWriter().println(number1/number2);
    }


}
