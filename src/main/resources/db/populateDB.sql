DELETE
FROM user_roles;
DELETE
FROM users;
DELETE
FROM meals;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id)
VALUES ('ROLE_USER', 100000),
       ('ROLE_ADMIN', 100001);

INSERT INTO meals (user_id, dateTime, description, calories)
VALUES (100000, TIMESTAMP '2020-01-30 10:23', 'Завтрак', 1000),
       (100000, TIMESTAMP '2020-01-30 14:23', 'Обед', 1500),
       (100000, TIMESTAMP '2020-01-30 20:23', 'Ужин', 500),
       (100000, TIMESTAMP '2020-01-31 00:00', 'Обед', 1000),
       (100000, TIMESTAMP '2020-01-31 10:23', 'Обед', 600),
       (100000, TIMESTAMP '2020-01-31 14:23', 'Завтрак', 200),
       (100000, TIMESTAMP '2020-01-31 20:23', 'Обед', 200),
       (100001, TIMESTAMP '2020-01-31 14:23', 'Завтрак', 1000),
       (100001, TIMESTAMP '2020-01-30 20:23', 'Обед', 1500);

