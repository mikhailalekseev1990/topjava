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
<h2>Meals</h2>
</div>
<table border="3">
    <caption>Meals</caption>
    <tr>
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>

    </tr>
    <%--            <tr>--%>

    <%
        List<MealTo> meals = (List<MealTo>) request.getAttribute("mealsList");

        if (meals != null && !meals.isEmpty()) {
            out.println("<ui>");
            for (MealTo meal : meals) {
                if (meal.isExcess()) out.println("<tr  style=\"color:blue;\">");
                else out.println("<tr  style=\"color:red;\">");
                out.println("<td> " + meal.getDateTime() + "</td>");
                out.println("<td>" + meal.getDescription() + "</td>");
                out.println("<td>" + meal.getCalories() + "</td>");
            }
            out.println("</ui>");
        } else out.println("<p>There are no meals yet!</p>");
    %>
    </tr>
</table>


<div>
    <button onclick="location.href='/topjava'">Back</button>
</div>
</body>
</html>
