package com.example.csj21webappultimateway;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // we need to read the input from the clint
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User(name,email,phone,username,password);
        // We need to store the user details in the DB
        saveUser(user);
        PrintWriter writer = resp.getWriter();
        writer.println("Saved in the database");

    }

    private void saveUser(User user) {
        String url ="jdbc:mysql://localhost:3306/cyber_success";
        String username = "root";
        String password = "root@1234";
        Connection connection = null;
        String sql = "insert into user(name,email,phone,username,password) values (?,?,?,?,?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getPhone());
            preparedStatement.setString(4,user.getUsername());
            preparedStatement.setString(5,user.getPassword());

            int executeUpdate = preparedStatement.executeUpdate();
            System.out.println("Saved in the Db");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

         }
}
