package ru.javawebinar.topjava.web;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;
import ru.javawebinar.topjava.util.TimeUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MealServlet extends HttpServlet {
    Map<LocalDate, Integer> caloriesSumByDate = MealsUtil.meals.stream()
            .collect(
                    Collectors.groupingBy(Meal::getDate, Collectors.summingInt(Meal::getCalories))
            );

    List<MealTo> mealsTo = MealsUtil.meals.stream()
            .map(meal -> MealsUtil.createTo(meal, caloriesSumByDate.get(meal.getDate()) > 1999))
            .collect(Collectors.toList());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("mealsList", mealsTo);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("meals.jsp");
        requestDispatcher.forward(request, response);

    }
}
