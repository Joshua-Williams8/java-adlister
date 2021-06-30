<%--
  Created by IntelliJ IDEA.
  User: joshuawilliams
  Date: 6/30/21
  Time: 10:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Random" %>
<%--above is an example is how we would import a java class --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  Random r = new Random();
  int randNum = r.nextInt((7-1) + 1) + 1;
//  We want a random integer between 7 to 0, but we also want to start at 1 so it's 7 to 1
//  default syntax: r.nextInt((max-1?) + 1) + minimum
  if(randNum == 1 ){
    response.sendRedirect("/hello-world");
  } else if (randNum == 7){
    response.sendError(500);
  }
  String testColor = (request.getParameter("color") != null ) ? request.getParameter("color") : "";
//  If the color is not null we want to make it equal test color
  //  If color is null then we will leave it blank


%>
<html>
<head>
  <title>Implicit Objects</title>
</head>
<body>
<h1><%=randNum%></h1>
<h3 style="color: <%=testColor%>"> The color you have is <%=testColor%></h3>
<p>Query String: <%= request.getQueryString()%></p>
<p>Path: <%= request.getRequestURL()%></p>
<p>User-Agent Header: <%= request.getHeader("user-agent")%></p>
</body>
</html>
