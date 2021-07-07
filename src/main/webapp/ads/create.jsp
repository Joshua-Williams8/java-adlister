<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Create A Ad</title>
</head>
<body>
<h1>Create A Ad</h1>
<form action="/ads/create" method="post">
  <label for="title">title</label>
  <input title="title" id="title" type="text">
  <br />
  <label for="description">Description</label>
  <input title="description" id="description" type="text">
  <br />
  <label for="id">ID</label>
  <input title="id" id="id" type="text">
  <br />
  <label for="userId">userId</label>
  <input title="userId" id="userId" type="text">
  <br />
  <input type="submit">
</form>
</body>
</html>
