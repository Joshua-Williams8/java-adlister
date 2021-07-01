<%--
  Created by IntelliJ IDEA.
  User: joshuawilliams
  Date: 7/1/21
  Time: 2:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% %>


<html>
<head>
  <jsp:include page="partials/head.jsp">
    <jsp:param name="title" value="ORDER OUR PIZZA!"/>
  </jsp:include>
</head>
<body>
<h1>Pizza!</h1>
<form method="POST" action="pizzaOrder">
  <%-- Select for Crust --%>
  <div>
    <h4>What kind of Crust do you want?</h4>
    <label for="crustType">Please select from the dropdown.</label>
    <select id="crustType" name="crustType">
      <option value="hand-tossed">Hand Tossed (normal)</option>
      <option value="thin">Thin</option>
      <option value="cheese-stuffed">Cheese Stuffed</option>
    </select>
  </div>

  <div>
    <h4>What kind of Sauce do you want?</h4>
    <label for="sauceType">Please select from the dropdown.</label>
    <select id="sauceType" name="sauceType">
      <option value="normal">Normal Tomato Sauce</option>
      <option value="light">Lite Tomato Sauce</option>
      <option value="alfredo">Alfredo</option>
    </select>
  </div>
  <div>
    <h4>Please select your toppings.</h4>
    <div>
      <label for="peperoni"><input type="checkbox" id="peperoni" name="toppings" value="peperoni" >Peperoni</label>
      <label for="sausage"><input type="checkbox" id="sausage" name="toppings" value="sausage" >Sausage</label>
      <label for="bacon"><input type="checkbox" id="bacon" name="toppings" value="bacon" >Bacon</label>
    </div>

    <div>
      <h2>Your Address</h2>
      <label for="address">Street, City, State, Zip Code</label>
      <br>
      <textarea id="address" name="address" type="text" rows="10" cols="30"></textarea>
      <!-- Stuff in between the tags above gets put in the box value by default. -->
      <br>

    </div>
  </div>

    <button type="submit">Order Pizza</button>
<%--  <input type="submit">--%>
</form>

<div>
<%--  <h2>Inputs received</h2>--%>
<%--  <h3>Crust : ${param.crustType}</h3>--%>
<%--  <h3>Sauce : ${param.sauceType}</h3>--%>

<%--  <h3>Toppings below : ${param.toppings}</h3>--%>
<%--  <h3>Add Peperoni? : ${param.peperoni.equals("add")}</h3>--%>
<%--  <h3>Add Sausage : ${param.sausage.equals("add")}</h3>--%>
<%--  <h3>Add Bacon? : ${param.bacon.equals("add")}</h3>--%>


<%--  <h3>${param.address}</h3>--%>


</div>

</body>
</html>
