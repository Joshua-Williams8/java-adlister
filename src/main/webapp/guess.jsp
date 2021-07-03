<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: joshuawilliams
  Date: 7/1/21
  Time: 10:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<%--%>
<%--  int ranNumI = new Random().nextInt(3) + 1;--%>
<%--  String ranNum = Integer.toString(ranNumI);--%>
<%--  request.setAttribute("ranNum", ranNum);--%>
<%--%>--%>
<html>
<head>
  <jsp:include page="partials/head.jsp">
    <jsp:param name="title" value="Guess a number!"/>
  </jsp:include>
</head>
<body>
<form method="post" action="guess">
  <input type="text" disabled hidden value="${param.ranNum}">
  <label for="guessNum">Guess which number I picked, from 1 2 or 3.</label>
  <input type="text" name="guessNum" id="guessNum">
  <button type="submit">SEND IT</button>

<%--  <h2>Testing Correct: ${param.ranNum}</h2>--%>
</form>
</body>
</html>
