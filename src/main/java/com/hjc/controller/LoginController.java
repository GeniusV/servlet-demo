package com.hjc.controller;

import com.hjc.entity.User;
import com.hjc.service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by GeniusV on 4/24/18.
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/signin")
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("username");
        String password = req.getParameter("inputPassword3");

        User user = new User(name, password);

        UsersService usersService = new UsersService();

        if ((user = usersService.checkUserValid(user)) != null) {
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("index.jsp");
        } else {
            resp.addHeader("refresh", "5;url=\"signup.jsp\"");
            resp.setCharacterEncoding("utf-8");
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.print("Username or error error. Please check your user name and password and try again. If not junp in 5 seconds, please click" +
                    "<a href=\"signin.jsp\">Sign In</a>");
        }
    }
}
