<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="java-adlister/src/main/webapp/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>

<% String username = (String) session.getAttribute("username");%>
<body>
    <jsp:include page="java-adlister/src/main/webapp/partials/navbar.jsp" />

    <div class="container">
        <h1>Viewing your profile.</h1>
      <h3>Hae a good day <%=username%> (Should say user)</h3>
      <form method="post" action="/logout">
        <button type="submit">LOGOUT</button>
      </form>
    </div>

</body>
</html>
