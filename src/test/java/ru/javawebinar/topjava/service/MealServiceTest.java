package ru.javawebinar.topjava.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.MealTestData;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static ru.javawebinar.topjava.MealTestData.*;
import static ru.javawebinar.topjava.UserTestData.ADMIN_ID;
import static ru.javawebinar.topjava.UserTestData.USER_ID;

@ContextConfiguration({"classpath:spring/spring-app.xml", "classpath:spring/spring-db.xml"})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class MealServiceTest {

    @Autowired
    MealService service;


    @Autowired
    MealRepository repository;

    @Test
    public void get() {
        Meal meal = service.get(MEAL_ID1, USER_ID);
        assertMatch(meal, MEAL1);
    }

    @Test
    public void getNotFound() throws Exception {
        assertThrows(NotFoundException.class, () -> service.get(100_200, ADMIN_ID));
    }

    @Test
    public void delete() {
        service.delete(MEAL_ID3, USER_ID);
        assertNull(repository.get(MEAL_ID3, USER_ID));
    }

    @Test
    public void deletedNotFound() throws Exception {
        assertThrows(NotFoundException.class, () -> service.delete(100_200, ADMIN_ID));
    }

    @Test
    public void getBetweenInclusive() {
        assertMatch(service.getBetweenInclusive(LocalDate.of(2020, 01, 30)
                , LocalDate.of(2020, 02, 21), USER_ID),
                Arrays.asList(MEAL6, MEAL5, MEAL4, MEAL3, MEAL2, MEAL1));
    }

    @Test
    public void getAll() {
//        List<Meal> allUserId = service.getAll(USER_ID);
        List<Meal> allUserId = Arrays.asList(MEAL9, MEAL8, MEAL7, MEAL6, MEAL5, MEAL4, MEAL3, MEAL2, MEAL1);
        assertMatch(allUserId, repository.getAll(USER_ID));
    }

    @Test
    public void update() {
        Meal updated = getUpdate();
        service.update(updated, USER_ID);
        assertMatch(repository.get(MEAL_ID2, USER_ID), updated);
    }
    @Test
    public void updatedNotFound() throws Exception {
        Meal updated = getUpdatedNotFound();
        assertThrows(NotFoundException.class, () -> service.update(updated, USER_ID));
    }

    @Test
    public void create() {
        Meal newMeal = getNew();
        Meal created = service.create(newMeal, USER_ID);
        Integer newId = created.getId();
        newMeal.setId(newId);
        assertMatch(created, newMeal);
        assertMatch(repository.get(newId, USER_ID), newMeal);
    }
}