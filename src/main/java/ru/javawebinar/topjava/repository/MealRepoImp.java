package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class MealRepoImp implements MealRepo {

   private Map<Long, Meal> storage = Storage.getInstance().getStorage();
    private long lastIndex = Collections.max(storage.keySet());

    @Override
    public void add(LocalDateTime dateTime, String description, int calories) {
        storage.put(lastIndex + 1, new Meal(lastIndex + 1, dateTime, description, calories));
    }

    @Override
    public void delete(Long id) {
        storage.remove(id);
    }

    @Override
    public void update(Meal meal) {
        storage.put(meal.getId(), meal);
    }

    @Override
    public List<Meal> getAll() {
        return new CopyOnWriteArrayList<>(storage.values());
    }

    @Override
    public Meal getById(Long id) {
        return storage.get(id);
    }
}
