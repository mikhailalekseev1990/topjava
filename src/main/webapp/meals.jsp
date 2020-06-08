<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page import="ru.javawebinar.topjava.model.Meal" %>
<%@ page import="java.util.List" %>
<%@ page import="static sun.misc.MessageUtils.out" %>
<%@ page import="ru.javawebinar.topjava.model.MealTo" %><%--
  Created by IntelliJ IDEA.
  User: mikhail
  Date: 05.06.2020
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <title>Meals</title>
</head>
<body>
<table border="3">
    <caption>
        <h2>Meals</h2></caption>
    <tr>
        <th>Id</th>
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
    </tr>

    <jsp:useBean id="mealsList" scope="request" type="java.util.List"/>
    <c:forEach items="${mealsList}" var="mealTo">
        <tr style="color:${mealTo.isExcess() ? 'blue' : 'red'}">
            <td><c:out value="${mealTo.getId()}"/></td>
            <td><c:out value="${mealTo.parseDateTime()}"/></td>
            <td><c:out value="${mealTo.getDescription()}"/></td>
            <td><c:out value="${mealTo.getCalories()}"/></td>
            <td><a href="meals?action=update&id=<c:out value="${mealTo.id}"/>">Update</a></td>
            <td><a href="meals?action=delete&id=<c:out value="${mealTo.id}"/>">Delete</a></td>
        </tr>
    </c:forEach>


</table>
<%--<p><a href="meals?action=add">Add</a></p>--%>

<div>
    <form action="meals" method="post">

        <p>
            Meal Id:
            <input type="number" name="id" value="<c:out value="${id}"/> ">
            Meal DateTime:
            <input type="text" name="dateTime" value="<c:out value="${dateTime}"/> ">
            Meal Description:
            <input type="text" name="description" value="<c:out value="${description}"/>">
            Meal Calories:
            <input type="text" name="calories" value="<c:out value="${calories}"/>"></p>
        <p>
            <input type="submit" name="submit" value="add"></p>
        <p>
            <input type="submit" name="submit" value="update"></p>
        <p>
            <input type="submit" name="submit" value="delete"></p>
        <p>

    </form>
</div>

<div>
    <button onclick="location.href='/topjava'">Back</button>
</div>
</body>
</html>
