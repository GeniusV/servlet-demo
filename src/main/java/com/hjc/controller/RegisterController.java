package com.hjc.controller;

import com.hjc.entity.User;
import com.hjc.util.DBHelp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by GeniusV on 3/27/18.
 */

@WebServlet(name = "registerServlet", urlPatterns = "/signup")
public class RegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("usename");
        String email = req.getParameter("inputEmail");
        String passsword = req.getParameter("inputPassword3");
        String tel = req.getParameter("phone");

        User user = new User(name, passsword, email, tel);

        try {
            Connection conn = DBHelp.getCon();
            String sql = "select * from user where user name = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setObject(1, name);
            ResultSet set = statement.getResultSet();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
