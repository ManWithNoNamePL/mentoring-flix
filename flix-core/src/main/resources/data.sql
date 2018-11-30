INSERT INTO user (user_id, email, password, name, last_name, active, age, gender) VALUES (1, 'max123@mail.com', '$2a$10$FvsMgub6XFAHyUxbhpqKk.PvDksOMChSiwD9Ez4xrAIcknOcr6.BO', 'Max', 'Peters', true, 33, 'MALE');
INSERT INTO user (user_id, email, password, name, last_name, active, age, gender) VALUES (2, '123@mail.com', '123', '123', 'test', true, 21, 'MALE');

INSERT INTO user_role (role_id, role) VALUES (1, 'ADMIN');
INSERT INTO user_role (role_id, role) VALUES (2, 'USER');

INSERT INTO role_mapping (user_id, role_id) VALUES (1, 1);
INSERT INTO role_mapping (user_id, role_id) VALUES (2, 2);
