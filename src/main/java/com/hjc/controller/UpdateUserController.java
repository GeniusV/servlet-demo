package com.hjc.controller;

import com.hjc.entity.User;
import com.hjc.service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by GeniusV on 5/27/18.
 */
@WebServlet(name = "UpdateUserServlet", urlPatterns = "/update")
public class UpdateUserController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        User user = (User) req.getSession().getAttribute("user");
        String password;
        if ((password = req.getParameter("password")) != null && !password.equals("")) {
            user.setPwd(password);
        }
        user.setEmail(req.getParameter("email"));
        user.setTel(req.getParameter("phone"));

        UsersService usersService = new UsersService();
        req.getSession().setAttribute("success", usersService.updateUser(user));
        resp.sendRedirect("userInfo.jsp");
    }
}
