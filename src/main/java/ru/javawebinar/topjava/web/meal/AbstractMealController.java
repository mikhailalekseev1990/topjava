package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.to.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static ru.javawebinar.topjava.util.ValidationUtil.assureIdConsistent;
import static ru.javawebinar.topjava.util.ValidationUtil.checkNew;
import static ru.javawebinar.topjava.util.MealsUtil.getTos;
import static ru.javawebinar.topjava.util.MealsUtil.DEFAULT_CALORIES_PER_DAY;
import static ru.javawebinar.topjava.web.SecurityUtil.authUserId;


public abstract class AbstractMealController {
    private final Logger LOG = LoggerFactory.getLogger(getClass());
    @Autowired
    private MealService mealService;


    public Meal update(Meal meal, int id) {
        LOG.info("update {}", meal);
        assureIdConsistent(meal, id);
        meal.setUserId(authUserId());
        return mealService.update(meal);
    }

    public Meal create(Meal meal) {
        LOG.info("create {}", meal);
        checkNew(meal);
        meal.setUserId(authUserId());
        return mealService.create(meal);
    }

    public void delete(int id) {
        LOG.info("delete {}", id);
        mealService.delete(id, authUserId());
    }

    // null if not found
    public Meal get(int id) {
        LOG.info("get {}", id);
        return mealService.get(id, authUserId());
    }

    public List<MealTo> getAll() {
        LOG.info("getAll for userID {}", authUserId());
        return getTos(mealService.getAll(authUserId()), DEFAULT_CALORIES_PER_DAY);
    }

    public List<MealTo> filer(LocalDate startDate, LocalDate endDate) {
        LOG.info("filterByDate for userID {}", authUserId());
        return getTos(mealService.filer(authUserId(), startDate, endDate), DEFAULT_CALORIES_PER_DAY);
    }
    public List<MealTo> filer(LocalTime startDate, LocalTime endDate) {
        LOG.info("filterByTime for userID {}", authUserId());
        return getTos(mealService.filer(authUserId(), startDate, endDate), DEFAULT_CALORIES_PER_DAY);
    }
}
