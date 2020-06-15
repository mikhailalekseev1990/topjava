package ru.javawebinar.topjava.repository.inmemory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.to.MealTo;
import ru.javawebinar.topjava.util.DateTimeUtil;
import ru.javawebinar.topjava.util.MealsUtil;
import sun.util.resources.LocaleData;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class InMemoryMealRepository implements MealRepository {
    private final Logger LOG = LoggerFactory.getLogger(getClass());
    private Map<Integer, Meal> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        MealsUtil.MEALS.forEach(meal -> save(meal, meal.getUserId()));
    }

    @Override
    public Meal save(Meal meal, int userId) {
        if (meal.isNew()) {
            meal.setId(counter.incrementAndGet());
            repository.put(meal.getId(), meal);
            return meal;
        }
        LOG.info("Create, id {}, userId {}", meal.getId(), meal.getUserId());
        return isMealNotNullAndTrueUserId(meal.getId(), userId) ? repository.computeIfPresent(meal.getId(), (id, oldMeal) -> meal) : null;
    }

    @Override
    public boolean delete(int id, int userId) {
        return isMealNotNullAndTrueUserId(id, userId) && repository.remove(id) != null;
    }

    @Override
    public Meal get(int id, int userId) {
        return
                isMealNotNullAndTrueUserId(id, userId) ? repository.get(id) : null;
    }

    @Override
    public List<Meal> getAll(int userId) {
        return repository.values().stream()
                .filter(meal -> meal.getUserId() == userId)
                .sorted(Comparator.comparing(Meal::getDateTime).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public List<Meal> filerByDate(int userId, LocalDate startDate, LocalDate endDate) {
        return getAll(userId).stream()
                .filter(mealTo -> DateTimeUtil.isBetween(mealTo.getDateTime().toLocalDate(), startDate, endDate))
                .collect(Collectors.toList());
    }


    private boolean isMealNotNullAndTrueUserId(int id, int userId) {
        Meal meal = repository.get(id);
        return (meal != null && meal.getUserId() == userId);
    }


}
