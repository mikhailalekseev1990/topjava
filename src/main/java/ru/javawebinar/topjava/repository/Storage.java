package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class Storage {
    private static Storage instance = new Storage();
    private final Map<Long, Meal> storage = new ConcurrentHashMap<>();
    private  AtomicLong atomicId = new AtomicLong(0);

    public AtomicLong getAtomicId() {
        return atomicId;
    }

    public static Storage getInstance() {
        return instance;
    }

    public Map<Long, Meal> getStorage() {
        return storage;
    }

    private Storage() {
        Meal meal1 = new Meal(atomicId.incrementAndGet(), LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500);
        Meal meal2 = new Meal(atomicId.incrementAndGet(), LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000);
        Meal meal3 = new Meal(atomicId.incrementAndGet(), LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500);
        Meal meal4 = new Meal(atomicId.incrementAndGet(), LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100);
        Meal meal5 = new Meal(atomicId.incrementAndGet(), LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000);
        Meal meal6 = new Meal(atomicId.incrementAndGet(), LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500);
        Meal meal7 = new Meal(atomicId.incrementAndGet(), LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 310);
        storage.put(meal1.getId(), meal1);
        storage.put(meal2.getId(), meal2);
        storage.put(meal3.getId(), meal3);
        storage.put(meal4.getId(), meal4);
        storage.put(meal5.getId(), meal5);
        storage.put(meal6.getId(), meal6);
        storage.put(meal7.getId(), meal7);


    }

}
