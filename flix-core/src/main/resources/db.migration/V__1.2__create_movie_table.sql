CREATE TABLE MOVIE (
  MOVIE_ID      INTEGER NOT NULL AUTO_INCREMENT,
  title         VARCHAR(1000),
  genre         VARCHAR(50),
  runtime       INTEGER,
  PRIMARY KEY (MOVIE_ID)
);