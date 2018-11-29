INSERT INTO user (user_id, login, password, age, gender) VALUES (1, 'max_edel', 'max_edel', 33, 'MALE');
INSERT INTO user (user_id, login, password, age, gender) VALUES (2, 'Legolas', 'legolas12', 150, 'MALE');
INSERT INTO user (user_id, login, password, age, gender) VALUES (3, '123', '123', 15, 'MALE');

INSERT INTO user_role (role_id, role) VALUES (1, 'ADMIN');
INSERT INTO user_role (role_id, role) VALUES (2, 'USER');

INSERT INTO role_mapping (user_id, role_id) VALUES (1, 1);
INSERT INTO role_mapping (user_id, role_id) VALUES (2, 2);
INSERT INTO role_mapping (user_id, role_id) VALUES (3, 1);


insert into movie(movie_id, title, genre, runtime) values (1, 'Lord of the rings', 'FANTASY', 180);
