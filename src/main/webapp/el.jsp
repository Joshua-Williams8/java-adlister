<%--
  Created by IntelliJ IDEA.
  User: joshuawilliams
  Date: 6/30/21
  Time: 10:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  request.setAttribute("userRole", "admin");
//We're making a variable named userRole with the value of  admin
//  This is usually done in a servlet.
  String message;
  switch (request.getAttribute("userRole").toString()) {
    case "admin":
      message = "administrator";
      break;
    case "s_admin":
      message = "Super Administrator";
      break;
    case "user_1":
      message = "active user";
      break;
    default:
      message = "unknown status";
  }
  request.setAttribute("userRoleMessage", message);

//  User ul = new User("trillwill",22,"josh@email.com");
//  request.setAttribute("user","ul");
//  Ideally our servlet would define user and we could establist user as an attribute, and access it's properties
//  THIS DOESN'T WORK BUT IT'S SHOWN AS AN EXAMPLE FOR USER.... below.
//  servlet as in classes in our java src folder
%>
<html>
<head>
  <title>Expression Language</title>
</head>
<body>
<h1>role is: ${userRole}</h1>
<h2>name is: ${param.name}</h2>
<%--Even tho we didn't say what name was yet, it will pull it from the URL.--%>
<%--http://localhost:8080/el.jsp?name=hio--%>
<h1> role message :${userRoleMessage}</h1>
<%--<h2>Username : ${user.username}</h2>--%>
<%--<p>User Age = ${user.age}</p>--%>
<%--This would work yes because we haven't set an attribute to our user--%>
</body>
</html>
