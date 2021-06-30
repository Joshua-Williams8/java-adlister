<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<%--
  Created by IntelliJ IDEA.
  User: joshuawilliams
  Date: 6/30/21
  Time: 11:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  request.setAttribute("lactoseIntolerant", false);
  List<String> dairyProducts = new ArrayList<>();
  dairyProducts.add("milk");
  dairyProducts.add("ice cream");
  dairyProducts.add("cheese");

  request.setAttribute("dairyProducts", dairyProducts);
  boolean textIsBlue = true;
  request.setAttribute("blue",textIsBlue);

%>
<html>
<head>
  <title>Jstl lect</title>
</head>
<body>
  <h1>Hello!</h1>
<%--  choose is like setting up an if statement--%>
  <c:choose>
<%--    When lactoseIntolerant is TRUE then we want to output whats in the whn--%>
    <c:when test="${lactoseIntolerant}">
      <h1>You are lactose intolerant! Please don't buy any diary products.</h1>
    </c:when>
    <c:when test="${blue}">
      <p>Yay! blue text!</p>
    </c:when>
    <c:otherwise>
<%--      The items is the list we are using, the var is what each product is --%>
      <c:forEach items="${dairyProducts}" var="dairyProduct">
        <div>
          <p>${dairyProduct}</p>
        </div>
      </c:forEach>
    </c:otherwise>
  </c:choose>
<%--  http://localhost:8080/jstl.jsp--%>
<%--  --%>
</body>
</html>
