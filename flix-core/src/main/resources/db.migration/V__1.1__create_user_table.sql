CREATE TABLE USER (
  USER_ID       INTEGER NOT NULL AUTO_INCREMENT,
  login         VARCHAR(1000),
  password      VARCHAR(50),
  age           INTEGER,
  gender        VARCHAR(10),
  PRIMARY KEY (USER_ID)
);