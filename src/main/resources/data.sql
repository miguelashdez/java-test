DROP TABLE IF EXISTS users;

DROP TABLE IF EXISTS phones;

CREATE TABLE phones (
  id_phone INT AUTO_INCREMENT  PRIMARY KEY,
  number VARCHAR(10) NOT NULL,
  city_code INTEGER NOT NULL,
  country_code INTEGER NOT NULL
);

CREATE TABLE users (
  id_user INT AUTO_INCREMENT  PRIMARY KEY,
  id_phone INT NOT NULL,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  password VARCHAR(100) NOT NULL,
  created DATE,
  modified DATE,
  last_login DATE,
  token VARCHAR(250),
  is_active INT, -- 1 is active, 2 is inactive.
  FOREIGN KEY (id_phone) REFERENCES phones(id_phone)
);

INSERT INTO phones (number, city_code, country_code)
    VALUES ('0000000000', 241, 52), ('0000000000', 55, 52);

INSERT INTO users (name, email, password, id_phone)
    VALUES ('Miguel', 'miguel@email.com', '1234567890', 1), ('Angel', 'angel@email.com', '1234567890', 1);