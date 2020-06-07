package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Storage {
    public static Storage instance = new Storage();
    public final Map<Long, Meal> storage = new ConcurrentHashMap<>();

    public static Storage getInstance() {
        return instance;
    }

    public Map<Long, Meal> getStorage() {
        return storage;
    }

    private Storage() {
        Meal meal1 = new Meal(1L, LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500);
        Meal meal2 = new Meal(2L, LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000);
        Meal meal3 = new Meal(3L, LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500);
        Meal meal4 = new Meal(4L, LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100);
        Meal meal5 = new Meal(5L, LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000);
        Meal meal6 = new Meal(6L, LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500);
        Meal meal7 = new Meal(7L, LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 310);
        storage.put(meal1.getId(), meal1);
        storage.put(meal2.getId(), meal2);
        storage.put(meal3.getId(), meal3);
        storage.put(meal4.getId(), meal4);
        storage.put(meal5.getId(), meal5);
        storage.put(meal6.getId(), meal6);
        storage.put(meal7.getId(), meal7);


    }

}
