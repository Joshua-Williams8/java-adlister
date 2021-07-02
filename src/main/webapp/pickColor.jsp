<%--
  Created by IntelliJ IDEA.
  User: joshuawilliams
  Date: 7/1/21
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="partials/head.jsp">
    <jsp:param name="title" value="Guess a number!"/>
  </jsp:include>
</head>
<body>
<form method="POST" action="viewColor">

  <div class="form-group">
    <label for="chosenColor">Please enter a color.</label>
    <input id="chosenColor" name="chosenColor" class="form-control" type="text">
  </div>

  <div>
    <button type="submit" >View Color</button>
  </div>

</form>
</body>
</html>
