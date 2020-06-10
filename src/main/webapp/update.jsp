<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mikhail
  Date: 08.06.2020
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<div>
    <div><h2>Edit form</h2></div>
    <div>
        <jsp:useBean id="meal" scope="request" type="ru.javawebinar.topjava.model.Meal"/>
        <form method="post" action="meals">
            <br>
            <div>
                ID ${meal.id}
            </div>
            <label>
                <input hidden placeholder="${meal.id}" type="text" name="id" value="${meal.id}"/>
            </label>
            <br>
            <div>
                Date
            </div>
            <label>
                <input type="datetime-local" name="dateTime" value="${meal.dateTime}"/>
            </label>
            <br>
            <div>
                Description
            </div>
            <label>
                <input type="text" name="description" value="${meal.description}"/>
            </label>
            <br>
            <div>
                Calories
            </div>
            <label>
                <input type="number" name="calories" value="${meal.calories}"/>
            </label>
            <br>
            <br>
            <div>
                <input type="submit" name="submit" value="Update"/>
            </div>
        </form>


</body>
</html>
