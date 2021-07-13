package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.mysql.cj.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    // TODO: show the registration form
    request.getRequestDispatcher("WEB-INF/register.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    // TODO: ensure the submitted information is valid
    HttpSession session = request.getSession();

    session.setAttribute("loggedIn", true);
    String username = request.getParameter("username");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String passwordConfirm = request.getParameter("passwordConfirm");
    boolean realEmail = email.contains("@") && email.contains(".");
    boolean passwordsMatch = password.equals(passwordConfirm);
    boolean newUsername = DaoFactory.getUsersDao().findByUsername(username).isEmpty();
    System.out.println("valid email "+realEmail);
    System.out.println("password match "+passwordsMatch);
    System.out.println("username not taken "+newUsername);
//Checking all the conditions before we continue to create the user.
    if (username.isEmpty() || email.isEmpty() || password.isEmpty() || !realEmail || !passwordsMatch || !newUsername) {
      request.getRequestDispatcher("WEB-INF/register.jsp").forward(request, response);
    } else {
      // TODO: create a new user based off of the submitted information

//Keep in mind we are hardcoding the ID, Idk if we went over how to make it yet.
      User newUser = new User(username, email, password);
      // TODO: if a user was successfully created, send them to their profile

      DaoFactory.getUsersDao().insert(newUser);
      request.getSession().setAttribute("user", username);
      response.sendRedirect("/profile");

    }
  }
}
