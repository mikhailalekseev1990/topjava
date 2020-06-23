package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.javawebinar.topjava.model.AbstractBaseEntity.START_SEQ;

public class MealTestData {

    public static final int MEAL_ID1 = START_SEQ + 2;
    public static final int MEAL_ID2 = START_SEQ + 3;
    public static final int MEAL_ID3 = START_SEQ + 4;
    public static final int MEAL_ID4 = START_SEQ + 5;
    public static final int MEAL_ID5 = START_SEQ + 6;
    public static final int MEAL_ID6 = START_SEQ + 7;
    public static final int MEAL_ID7 = START_SEQ + 8;
    public static final int MEAL_ID8 = START_SEQ + 9;
    public static final int MEAL_ID9 = START_SEQ + 10;
    public static final int MEAL_ID10 = START_SEQ + 11;
    public static final int MEAL_ID11 = START_SEQ + 12;


    public static final Meal MEAL1 = new Meal(MEAL_ID1, LocalDateTime.of(2020, 01, 30, 10, 23), "Завтрак", 1000);
    public static final Meal MEAL2 = new Meal(MEAL_ID2, LocalDateTime.of(2020, 01, 30, 14, 23), "Обед", 1500);
    public static final Meal MEAL3 = new Meal(MEAL_ID3, LocalDateTime.of(2020, 01, 30, 20, 23), "Ужин", 500);
    public static final Meal MEAL4 = new Meal(MEAL_ID4, LocalDateTime.of(2020, 02, 20, 10, 23), "Завтрак", 1000);
    public static final Meal MEAL5 = new Meal(MEAL_ID5, LocalDateTime.of(2020, 02, 20, 14, 23), "Обед", 1500);
    public static final Meal MEAL6 = new Meal(MEAL_ID6, LocalDateTime.of(2020, 02, 20, 20, 23), "Ужин", 500);
    public static final Meal MEAL7 = new Meal(MEAL_ID7, LocalDateTime.of(2020, 03, 31, 00, 00), "Обед", 1000);
    public static final Meal MEAL8 = new Meal(MEAL_ID8, LocalDateTime.of(2020, 03, 31, 10, 23), "Обед", 600);
    public static final Meal MEAL9 = new Meal(MEAL_ID9, LocalDateTime.of(2020, 03, 31, 14, 23), "Завтрак", 200);
    public static final Meal MEAL10 = new Meal(MEAL_ID10, LocalDateTime.of(2020, 01, 31, 14, 23), "Завтрак", 1000);
    public static final Meal MEAL11 = new Meal(MEAL_ID11, LocalDateTime.of(2020, 01, 30, 20, 23), "Обед", 1500);

//    public static final Meal MEAL1 = new Meal(MEAL_ID1, LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500);
//    public static final Meal MEAL2 = new Meal(MEAL_ID2, LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000);
//    public static final Meal MEAL3 = new Meal(MEAL_ID3, LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500);
//    public static final Meal MEAL4 = new Meal(MEAL_ID4, LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100);
//    public static final Meal MEAL5 = new Meal(MEAL_ID5, LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000);
//    public static final Meal MEAL6 = new Meal(MEAL_ID6, LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500);
//    public static final Meal MEAL7 = new Meal(MEAL_ID7, LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410);
//    public static final Meal MEAL8 = new Meal(MEAL_ID8, LocalDateTime.of(2015, Month.JUNE, 1, 14, 0), "Админ ланч", 510);
//    public static final Meal MEAL9 = new Meal(MEAL_ID9, LocalDateTime.of(2015, Month.JUNE, 1, 21, 0), "Админ ужин", 1500);

    public static Meal getNew() {
        return new Meal(LocalDateTime.of(2020, Month.JUNE, 23, 10, 0), "Завтрак", 500);
    }

    public static Meal getUpdate() {
        Meal updated = MEAL2;
        updated.setCalories(1111);
        updated.setDateTime(LocalDateTime.of(2020, Month.FEBRUARY, 1, 11, 1));
        updated.setDescription("Ланч");
        return updated;
    }
    public static Meal getUpdatedNotFound() {
        Meal updated = new Meal(10, LocalDateTime.of(2020, 01, 30, 10, 23), "Завтрак", 1000);
        updated.setCalories(1111);
        updated.setDateTime(LocalDateTime.of(2020, Month.FEBRUARY, 1, 11, 1));
        updated.setDescription("Ланч");
        return updated;
    }

    public static void assertMatch(Meal actual, Meal expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected);
    }

    public static void assertMatch(Iterable<Meal> actual, Iterable<Meal> expected) {
        assertThat(actual).isEqualTo(expected);
    }

    public void assertMatch(Collection<Meal> expected, Collection<Meal> actual) {
        assertThat(actual).isEqualTo(expected);
    }
}
