<%--
  Created by IntelliJ IDEA.
  User: joshuawilliams
  Date: 6/30/21
  Time: 9:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Directive tags are symbolized with a <%@ directive attributes %> --%>
<%--The @ sign means it's a directive--%>
<%--<%@ include file=""%>--%>
<%--Used for including files from our directive.--%>
<%--Comments aren't sent to the page, only the html is, jsps need a server inorder to run.--%>
<%--http://localhost:8080/jsp-tag-lect.jsp--%>
<%--You need the .jsp at the end so it pulls the page and doesn't redirect you to hello world.--%>
<%! int instanceCount = 0;%>
<%--Exclaimation point allows us to create variables--%>
<%-- This will presist through the page, so if I refresh it will go up, but local count will not.--%>
<%----%>
<%
  int localCount = 1;
  localCount += 1;
  instanceCount +=1;
  %>
<html>
<head>
  <title>JSP tags</title>
  <%@include file="partials/head.jsp"%>
<%--  This is really useful because if you want to reuse the same asset you can just change the include file, instead of editing it on each page individually.--%>
</head>
<body>
<h1>Hello there</h1>
<h2>Local count <%= localCount%></h2>
<h2>Instance count <%= instanceCount%></h2>

<%@ include file="partials/jsp-include-park.jsp"%>
<%@ include file="partials/bootstrap-script.jsp"%>
</body>
</html>
