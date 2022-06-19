package com.example.registrationapp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // step1: read the data which was sent from the client
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //step2 : save this data in the Database;
        User user = new User(name,email,phone,username,password);
        saveUser(user);

        //step3: Write to the client
        PrintWriter writer = response.getWriter();
        writer.println("Registration complete!");


    }

    private void saveUser(User user) {
        String url ="jdbc:mysql://localhost:3306/cyber_success";
        String username= "root";
        String password= "root@1234";
        String insertQuery = "insert into user(name,email, phone,username,password) values(?,?,?,?,?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getPhone());
            preparedStatement.setString(4,user.getUsername());
            preparedStatement.setString(5,user.getPassword());

            int i = preparedStatement.executeUpdate();
            System.out.println("Saved in the database");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Exception occured");
        }
    }
}
