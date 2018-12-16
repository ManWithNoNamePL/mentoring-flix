INSERT INTO user (user_id, login, password, age, gender) VALUES (1, 'max_edel', 'max_edel', 33, 'MALE');
INSERT INTO user (user_id, login, password, age, gender) VALUES (2, 'Legolas', 'legolas12', 150, 'MALE');
INSERT INTO user (user_id, login, password, age, gender) VALUES (3, '123', '123', 15, 'MALE');

INSERT INTO user_role (role_id, role) VALUES (1, 'ADMIN');
INSERT INTO user_role (role_id, role) VALUES (2, 'USER');

INSERT INTO role_mapping (user_id, role_id) VALUES (1, 1);
INSERT INTO role_mapping (user_id, role_id) VALUES (2, 2);
INSERT INTO role_mapping (user_id, role_id) VALUES (3, 1);


insert into movie(movie_id, title, genre, runtime) values (1, 'The Lord of the rings', 'FANTASY', 180);
insert into movie(movie_id, title, genre, runtime) values (2, 'The Hobbit', 'FANTASY', 175);
insert into movie(movie_id, title, genre, runtime) values (3, 'Avatar', 'FANTASY', 190);
insert into movie(movie_id, title, genre, runtime) values (4, 'The Godfather', 'DRAMA', 190);
insert into movie(movie_id, title, genre, runtime) values (5, 'Gladiator', 'DRAMA', 190);
insert into movie(movie_id, title, genre, runtime) values (6, 'Interstellar', 'DRAMA', 190);
insert into movie(movie_id, title, genre, runtime) values (7, 'WALL·E ', 'ANIMATION', 190);
insert into movie(movie_id, title, genre, runtime) values (8, 'Pirates of the Caribbean', 'FANTASY', 190);
insert into movie(movie_id, title, genre, runtime) values (9, 'Terminator', 'FANTASY', 190);
insert into movie(movie_id, title, genre, runtime) values (10, 'Spider-man', 'FANTASY', 190);
insert into movie(movie_id, title, genre, runtime) values (11, 'The Avengers', 'FANTASY', 190);
insert into movie(movie_id, title, genre, runtime) values (12, 'The Batman', 'FANTASY', 190);


insert into user_movie(user_id, movie_id) values (2, 1);
insert into user_movie(user_id, movie_id) values (2, 2);
insert into user_movie(user_id, movie_id) values (2, 4);
insert into user_movie(user_id, movie_id) values (2, 5);
insert into user_movie(user_id, movie_id) values (2, 6);
insert into user_movie(user_id, movie_id) values (2, 7);
insert into user_movie(user_id, movie_id) values (2, 8);
insert into user_movie(user_id, movie_id) values (2, 9);
insert into user_movie(user_id, movie_id) values (2, 10);
insert into user_movie(user_id, movie_id) values (2, 11);
insert into user_movie(user_id, movie_id) values (2, 12);
