package com.codeup.adlister.controllers;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    String query = request.getParameter("query");
    List<Ad> results = DaoFactory.getAdsDao().searchByTitle(query);
    request.setAttribute("ads",results);
    request.getRequestDispatcher("WEB-INF/ads/index.jsp").forward(request,response);
//    Instead of using just a regular statement where we can't use 's cause it will close out the sql statement early,

  }
}
