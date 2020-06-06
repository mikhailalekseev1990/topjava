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
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
    </tr>

    <jsp:useBean id="mealsList" scope="request" type="java.util.List"/>
    <c:forEach items="${mealsList}" var="mealTo">
        <tr style="color:${mealTo.isExcess() ? 'blue' : 'red'}">
            <td><c:out value="${mealTo.parseDateTime()}"/></td>
            <td><c:out value="${mealTo.getDescription()}"/></td>
            <td><c:out value="${mealTo.getCalories()}"/></td>
        </tr>
    </c:forEach>

    <%--    <%--%>
    <%--        List<MealTo> meals = (List<MealTo>) request.getAttribute("mealsList");--%>

    <%--        if (meals != null && !meals.isEmpty()) {--%>
    <%--            out.println("<ui>");--%>
    <%--            <c : forEach--%>
    <%--            for (MealTo meal : meals) {--%>
    <%--                if (!meal.isExcess()) out.println("<tr  style=\"color:blue;\">");--%>
    <%--                else out.println("<tr  style=\"color:red;\">");--%>
    <%--                out.println("<td> " + meal.getDateTime().toLocalDate() + " " + meal.getDateTime().toLocalTime() + "</td>");--%>
    <%--                out.println("<td>" + meal.getDescription() + "</td>");--%>
    <%--                out.println("<td>" + meal.getCalories() + "</td>");--%>
    <%--            }--%>
    <%--            out.println("</ui>");--%>
    <%--        } else out.println("<p>There are no meals yet!</p>");--%>
    <%--  </tr>   %>--%>

</table>
<div>
    <button onclick="location.href='/topjava'">Back</button>
</div>
</body>
</html>
