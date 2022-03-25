DROP TABLE IF EXISTS user;

CREATE TABLE user(
	id INTEGER NOT NULL,
	firstname VARCHAR(25),
	lastname VARCHAR(25),
	dni BIGINT(8) NOT NULL,
	status VARCHAR(50), 
	create_at TIMESTAMP,
	PRIMARY KEY (id)
);

DROP TABLE IF EXISTS role;

CREATE TABLE role(
  	id INTEGER NOT NULL,
	name VARCHAR(50),
	description VARCHAR(250),
	status VARCHAR(50), 
	create_at TIMESTAMP,
	PRIMARY KEY (id)
);

DROP TABLE IF EXISTS user_role;

CREATE TABLE user_role(
	user_id INTEGER NOT NULL,
	role_id INTEGER NOT NULL,
	status VARCHAR(50), 
	create_at TIMESTAMP,
	FOREIGN KEY(user_id) REFERENCES user(id),
	FOREIGN KEY(role_id) REFERENCES role(id)
);



