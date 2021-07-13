<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
    </div>

    <form method="GET" action="/ads/create">
      <button type="submit">Create New Ad</button>
    </form>
    <form method ="GET">
      <button type="submit">View add listings</button>
    </form>

</body>
</html>
