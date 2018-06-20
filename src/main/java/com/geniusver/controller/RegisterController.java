package com.geniusver.controller;

import com.geniusver.entity.User;
import com.geniusver.service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("username");
        String email = req.getParameter("inputEmail");
        String passsword = req.getParameter("inputPassword3");
        String tel = req.getParameter("phone");

        User user = new User(name, passsword, email, tel);

        UsersService usersService = new UsersService();

        if (usersService.checkUsernameValid(user)) {
            usersService.registerWriteDB(user);
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("index.jsp");
        } else {
            resp.addHeader("refresh", "5;url=\"signup.jsp\"");
            resp.setCharacterEncoding("utf-8");
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.print("User name already exists, please choose a new one. If not junp in 5 seconds, please click" +
                    "<a href=\"signup.jsp\">Sign Up</a>");
        }

    }


}
