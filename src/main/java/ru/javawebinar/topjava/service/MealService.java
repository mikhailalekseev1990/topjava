package ru.javawebinar.topjava.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import static ru.javawebinar.topjava.util.ValidationUtil.checkNotFoundWithId;

@Service
public class MealService {
    private final Logger LOG = LoggerFactory.getLogger(getClass());
    @Autowired
    private MealRepository repository;


    public Meal create(Meal meal, int userId) throws NotFoundException {
        LOG.info("Create, id {}, userId {}", meal.getId(), meal.getUserId());
        return repository.save(meal, userId);
    }

    public Meal update(Meal meal, int userId) throws NotFoundException {
        return checkNotFoundWithId(repository.save(meal, userId), meal.getId());
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

    public List<Meal> filerByDate(int userId, LocalDate startDate, LocalDate endDate) {
        return repository.filerByDate(userId, startDate, endDate);
    }
}