package ru.javawebinar.topjava.web;

import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class MealServlet extends HttpServlet {
    List<MealTo> meals = MealsUtil.meals.stream()
            .map(meal -> new MealTo(meal.getDateTime(), meal.getDescription(), meal.getCalories(), meal.getCalories() > 500))
            .collect(Collectors.toList());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("mealsList", meals);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("meals.jsp");
        requestDispatcher.forward(request, response);

    }
}
