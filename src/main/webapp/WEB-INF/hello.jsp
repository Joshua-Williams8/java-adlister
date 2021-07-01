<%--
  Created by IntelliJ IDEA.
  User: joshuawilliams
  Date: 7/1/21
  Time: 11:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Hello</title>
</head>
<body>
<%--<h1>Hello ${helloToName}!</h1>--%>
<h1>Hello ${helloToName}!</h1>
<p>Why is my form not showing</p>
<form method="post" action="hello">
  <label for="name">Enter name</label>
  <input type="text" name="name" id="name">
  <input type="submit">
</form>
<%--Redeploy allows us to refresh out STATIC CONTENT or assets, So updates made to webapp, html, ...--%>
<%--Restarts the server instead of just refreshing assets. This is more for changes to the servlet, or think of this as the java portion. --%>

</body>
</html>
