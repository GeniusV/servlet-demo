package com.hjc.controller;

import com.hjc.entity.Good;
import com.hjc.service.GoodService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by GeniusV on 5/15/18.
 */
@WebServlet(name = "MainPageServlet", urlPatterns = "/mainpage")
public class MainPageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GoodService goodService = new GoodService();
        List<Good> goodList = goodService.getGoodList(100);
        req.setAttribute("goodList", goodList);
        req.getRequestDispatcher("./mainPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("./mainPage.jsp").forward(req, resp);
    }
}
