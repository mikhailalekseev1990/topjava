package ru.javawebinar.topjava.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;

import static ru.javawebinar.topjava.util.ValidationUtil.checkNotFoundWithId;

@Service
public class MealService {
    private final Logger LOG = LoggerFactory.getLogger(getClass());
    @Autowired
    private MealRepository repository;


    public Meal create(Meal meal) throws NotFoundException {
        LOG.info("Create, id {}, userId {}", meal.getId(), meal.getUserId());
        return repository.save(meal, meal.getUserId());
    }

    public Meal update(Meal meal) throws NotFoundException {
        return checkNotFoundWithId(repository.save(meal, meal.getUserId()), meal.getId());
    }

    public void delete(int id, int userId) throws NotFoundException {
        checkNotFoundWithId(repository.delete(id, userId), id);
    }

    // null if not found
    public Meal get(int id, int userId) throws NotFoundException {
        return checkNotFoundWithId(repository.get(id, userId), id);
    }

    public Collection<Meal> getAll(int userId) throws NotFoundException {
        return repository.getAll(userId);
    }

    public List<Meal> filer(int userId, LocalDate start, LocalDate end) {
        return repository.filer(userId, start, end);
    }

    public List<Meal> filer(int userId, LocalTime start, LocalTime end) {
        return repository.filer(userId, start, end);
    }
}