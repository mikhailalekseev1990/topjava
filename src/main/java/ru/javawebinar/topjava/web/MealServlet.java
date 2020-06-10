package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.repository.MealRepo;
import ru.javawebinar.topjava.repository.MealRepoImp;
import ru.javawebinar.topjava.util.MealsUtil;
import ru.javawebinar.topjava.util.TimeUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class MealServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(MealServlet.class);


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        MealRepo mealRepo = new MealRepoImp();

        String mealId = request.getParameter("id");
        LOG.debug(mealId);
        String dateTime = request.getParameter("dateTime");
        LOG.debug(dateTime);
        String description = request.getParameter("description");
        LOG.debug(description);
        String calories = request.getParameter("calories");
        LOG.debug(calories);
        String submit = request.getParameter("submit");
        LOG.debug(submit);

        if (submit.equalsIgnoreCase("delete")) {                //condition for delete
            Long id = Long.parseLong(mealId);
            mealRepo.delete(id);
        } else if (submit.equalsIgnoreCase("add")) {
            LocalDateTime localDateTime = LocalDateTime
                    .parse(dateTime);

            mealRepo.add(localDateTime, description, Integer.parseInt(calories));
        } else if (submit.equalsIgnoreCase("update")) {
            Long idUpdate = Long.parseLong(mealId);
            LocalDateTime dateTimeUpdate = LocalDateTime.parse(dateTime);

            mealRepo.update(new Meal(idUpdate, dateTimeUpdate, description, Integer.parseInt(calories)));
        } else if (submit.equalsIgnoreCase("save")) {
            Long idUpdate = Long.parseLong(mealId);
            LocalDateTime dateTimeUpdate = LocalDateTime.parse(dateTime);

            mealRepo.update(new Meal(idUpdate, dateTimeUpdate, description, Integer.parseInt(calories)));
        }
        response.sendRedirect("meals");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        MealRepo mealRepo = new MealRepoImp();
        List<Meal> meals = mealRepo.getAll();
        Map<LocalDate, Integer> caloriesSumByDate = meals.stream()
                .collect(
                        Collectors.groupingBy(Meal::getDate, Collectors.summingInt(Meal::getCalories))
                );

        List<MealTo> mealsTo = meals.stream()
                .map(meal -> MealsUtil.createTo(meal, caloriesSumByDate.get(meal.getDate()) > 1999))
                .collect(Collectors.toList());


        if (action == null) {
            request.setAttribute("mealsList", mealsTo);
            request.getRequestDispatcher("meals.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("update")) {
            Long id = Long.parseLong(request.getParameter("id"));
            Meal meal = mealRepo.getById(id);
            mealRepo.update(meal);
            request.setAttribute("meal", meal);
            request.getRequestDispatcher("update.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("delete")) {
            LOG.debug(action);
            mealRepo.delete(Long.parseLong(request.getParameter("id")));
            request.setAttribute("mealsList", mealsTo);
            response.sendRedirect("meals");
        }
    }
}
