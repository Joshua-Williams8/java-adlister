package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if (request.getSession().getAttribute("user") != null) {
      response.sendRedirect("/profile");
      return;
    }
    request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    // TODO: find a record in your database that matches the submitted password
    // TODO: make sure we find a user with that username
    // TODO: check the submitted password against what you have in your database
    boolean validAttempt = false;
    HttpSession session = request.getSession();

//        if (validAttempt) {
    // TODO: store the logged in user object in the session, instead of just the username
//          String usernameSearch = request.getParameter("username");
//    User results = DaoFactory.getUsersDao().findByUsernameNoList(username);
//    if (results != null) {
//      System.out.println(results.getUsername());
//      if (results.getUsername().equals(username) && results.getPassword().equals(password)) {
//        validAttempt = true;
//        request.getSession().setAttribute("user", username);
//        response.sendRedirect("/profile");
//      }
//    }
//Still haven't gotten above to work
    List<User> results = DaoFactory.getUsersDao().findByUsername(username);
    for (User user : results) {
      System.out.println(user.getUsername());
      if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
        validAttempt = true;
        request.getSession().setAttribute("user", username);
        response.sendRedirect("/profile");
      }
    }


    if (!validAttempt) {

      request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }


//          } else {
//          response.sendRedirect("/login");
////          request.getRequestDispatcher("/profile");
//        }
//    Instead of using just a regular statement where we can't use 's cause it will close out the sql statement early,


  }
}
