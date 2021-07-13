package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      if (request.getSession().getAttribute("user") == null) {
        response.sendRedirect("/login");
        return;
      }
      request.getRequestDispatcher("/WEB-INF/ads/create.jsp").forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Ad ad = new Ad(
          (long) request.getSession().getAttribute("userID"), // We pull the userID from the user object we created using sql.
            request.getParameter("title"),
            request.getParameter("description")
        );
      System.out.println(ad.getUserId());
        DaoFactory.getAdsDao().insert(ad);
        response.sendRedirect("/ads");
    }
}
