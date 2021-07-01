<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: joshuawilliams
  Date: 6/30/21
  Time: 12:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
 if(request.getMethod().equalsIgnoreCase("post")) {
//   We only want to check for post not get request.

   try {
     boolean logUser = false;
//    Just for saying if the login had bad credentials

     String testUser = request.getParameter("username");
     String testPass = request.getParameter("password");
//  String testUser = request.getAttribute("username").toString();
//  String testPass = request.getAttribute("password").toString();
     if (testUser.equalsIgnoreCase("admin") && testPass.equals("password123")) {
       logUser = true;
       response.sendRedirect("/profile.jsp");
     } else {

       logUser = false;
       request.setAttribute("loginFail", true);

     }
   } catch (NullPointerException npe) {
//    request.setAttribute("username","");
//    request.setAttribute("password","");
//    response.sendRedirect("/login.jsp");
//    response.sendRedirect("/login.jsp?username=&password=");
// If it's null it goes back to ^
   }
 }


%>
<html>
<head>
  <title>Login Portal</title>
  <%@ include file="java-adlister/src/main/webapp/WEB-INF/partials/head.jsp"%>
<%-- Head for bootstrap --%>

</head>
<body>
<div class="card text-center">
  <div class="card-header">
    Enter Login Information
  </div>
  <div class="card-body">
    <form method="post" action="/WEB-INF/login.jsp">
<%--   Sends us back to the login page when the data is posted.   --%>
      <div class="form-group">
        <label for="username">Username</label>
        <input name="username" type="username" class="form-control form-control-lg" id="username" aria-describedby="usernameHelp">
        <small id="usernameHelp" class="form-text text-muted">We'll never share your username with anyone else.</small>
      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input name="password" type="password" class="form-control form-control-lg" id="password">
      </div>
      <button type="submit" class="btn btn-primary btn-lg">Submit</button>
    </form>
  </div>
</div>



<%--<form method="post" action="/login.jsp">--%>
<%--  <label for="username">Username</label>--%>
<%--  <input id="username" name="username" type="text" placeholder="Enter Username">--%>

<%--  <label for="password">Password</label>--%>
<%--  <input id="password" name="password" type="password" placeholder="Enter Password">--%>
<%--  <button type="submit">Login!</button>--%>

<%--</form>--%>
<h2>name is: ${param.username}</h2>
<h2>Password is: ${param.password}</h2>
<%--For showing what the values when the page was loaded.--%>

<c:choose>
  <c:when test="${loginFail}">
    <h3 class="text-danger">Credentials are invalid!</h3>
<%--  Displays if the wrong info is put in  --%>
  </c:when>
</c:choose>

<%@ include file="java-adlister/src/main/webapp/WEB-INF/partials/bootstrap-script.jsp"%>

</body>
</html>
