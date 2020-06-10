package ru.javawebinar.topjava;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @see <a href="http://topjava.herokuapp.com">Demo application</a>
 * @see <a href="https://github.com/JavaOPs/topjava">Initial project</a>
 */
public class Main {
    public static void main(String[] args) {
        System.out.format("Hello TopJava Enterprise!");



        LocalDateTime localDateTime = LocalDateTime
                .parse( "2020-01-31T21:00, 11:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        System.out.println(localDateTime);
    }
}
