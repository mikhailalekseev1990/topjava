package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.to.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.List;

import static ru.javawebinar.topjava.util.ValidationUtil.assureIdConsistent;
import static ru.javawebinar.topjava.util.ValidationUtil.checkNew;
import static ru.javawebinar.topjava.web.SecurityUtil.authUserId;


public abstract class AbstractMealController {
    private final Logger LOG = LoggerFactory.getLogger(getClass());
    @Autowired
    private MealService mealService;



    public Meal update(Meal meal, int id) {
        LOG.info("update {}", meal);
        assureIdConsistent(meal, id);
        return mealService.update(meal,authUserId());
    }

    public Meal create(Meal meal) {
        LOG.info("create {}", meal);
        checkNew(meal);
        return mealService.create(meal, authUserId());
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
        return MealsUtil.getTos(mealService.getAll(authUserId()), MealsUtil.DEFAULT_CALORIES_PER_DAY);
    }
}
