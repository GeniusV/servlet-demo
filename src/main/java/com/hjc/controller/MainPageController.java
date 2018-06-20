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
        List<Good> goodList;
        GoodService goodService = new GoodService();
        String categoryStr = req.getParameter("category");
        String pageStr = req.getParameter("page");
        int page;
        if (pageStr == null) {
            page = 0;
        }else{
            page = Integer.parseInt(pageStr);
        }

        if (categoryStr == null) {
            goodList = goodService.getGoodList(100, page);
        } else {
            int category = Integer.parseInt(categoryStr);
            goodList = goodService.getGoodList(category, page);
        }
        req.setAttribute("goodList", goodList);
        req.getRequestDispatcher("./mainPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("./mainPage.jsp").forward(req, resp);
    }
}
