<%--
  Created by IntelliJ IDEA.
  User: joshuawilliams
  Date: 7/12/21
  Time: 12:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="/WEB-INF/partials/head.jsp">
    <jsp:param name="title" value="Register Account"/>
  </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>


<div class="container">
  <h1>Register Account</h1>

  <form method="POST" action="/register">
    <div class="form-group">
      <label for="username">Username</label>
      <input id="username" name="username" class="form-control" type="text" required>
    </div>
    <div class="form-group">
      <label for="email">Email</label>
      <input id="email" name="email" class="form-control" type="text" required>
    </div>
    <div class="form-group">
      <label for="password">Password</label>
      <input id="password" name="password" class="form-control" type="password" required>
    </div>
    <div class="form-group">
      <label for="passwordConfirm">Confirm Password</label>
      <input id="passwordConfirm" name="passwordConfirm" class="form-control" type="password">
    </div>
<%--  Test stuff
  NewUser
  newUser@gmail.com
  BadPass
  --%>
    <input type="submit" class="btn btn-primary btn-block" value="Create Account">
  </form>
</div>
</body>
</html>
