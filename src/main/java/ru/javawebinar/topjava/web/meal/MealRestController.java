package ru.javawebinar.topjava.web.meal;

import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.to.MealTo;
import ru.javawebinar.topjava.util.DateTimeUtil;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MealRestController extends AbstractMealController {

    @Override
    public Meal update(Meal meal, int id) {
        return super.update(meal, id);
    }

    @Override
    public Meal create(Meal meal) {
        return super.create(meal);
    }

    @Override
    public void delete(int id) {
        super.delete(id);
    }

    @Override
    public Meal get(int id) {
        return super.get(id);
    }

    @Override
    public List<MealTo> getAll() {
        return super.getAll();
    }

}