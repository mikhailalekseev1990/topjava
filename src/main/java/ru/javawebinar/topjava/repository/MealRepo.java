package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.util.List;

public interface MealRepo {
    void add(LocalDateTime dateTime, String description, int calories);
    void delete(Long id);
    void update(Meal meal);
    List<Meal> getAll();
    Meal getById(Long id);

}
