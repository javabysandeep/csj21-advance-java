package com.example.registrationapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserDetailsServlet", value = "/users")
public class UseDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = getUserList();
        PrintWriter writer = resp.getWriter();
        writer.println("User list ");
        writer.println(users);
    }

    private List<User> getUserList() {
        String url ="jdbc:mysql://localhost:3306/cyber_success";
        String dbUsername= "root";
        String dbPassword= "root@1234";
        String selectQuery = "select * from user";
        List<User> userList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                String phone = resultSet.getString(4);
                String username = resultSet.getString(5);
                String password = resultSet.getString(6);
                User user = new User(id,name,email,phone,username,password);
                userList.add(user);
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Exception occured");
        }
        return userList;
    }
}
