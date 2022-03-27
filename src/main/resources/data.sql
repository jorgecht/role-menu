delete from user;

INSERT INTO user (id, firstname, lastname, dni, status, create_at) VALUES 
(1,'Jorge','Chacaltana',45262771,'CREATED','2018-09-05');

INSERT INTO user (id, firstname, lastname, dni, status, create_at) VALUES 
(2,'Daniel','Paredes',20202002,'CREATED','2019-09-05');

INSERT INTO user (id, firstname, lastname, dni, status, create_at) VALUES 
(3,'Poma', 'Chavez',87452541,'CREATED','2020-09-05');


delete from role;

INSERT INTO role (id, name, description, status, create_at)
VALUES (1, 'ADMINISTRADOR','Privilegios nivel 1','CREATED','2018-09-05');

INSERT INTO role (id, name, description, status, create_at)
VALUES (2, 'STAFF','Privilegios nivel 2','CREATED','2019-09-05');

INSERT INTO role (id, name, description, status, create_at)
VALUES (3, 'MANAGER','Privilegios nivel 1','CREATED','2020-09-05');



delete from user_role;

INSERT INTO user_role (user_id, role_id, status, create_at)
VALUES (1, 1,'CREATED','2018-09-05');

INSERT INTO user_role (user_id, role_id, status, create_at)
VALUES (2, 2,'CREATED','2019-09-05');

INSERT INTO user_role (user_id, role_id, status, create_at)
VALUES (3, 3,'CREATED','2020-09-05');