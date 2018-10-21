/** * create the stocks database */

DROP TABLE IF EXISTS quotes CASCADE;
CREATE TABLE quotes(
   id INT NOT NULL AUTO_INCREMENT,
   symbol VARCHAR(4) NOT NULL,
   time DATETIME NOT NULL,
   price DECIMAL NOT NULL,
   PRIMARY KEY ( id )
);

INSERT INTO quotes (symbol,time,price) VALUES ('GOOG','2004-08-19 00:00:01','85.00');
INSERT INTO quotes (symbol,time,price) VALUES ('GOOG','2015-02-03 00:00:01','527.35');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-01-01 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('AMZN','2015-02-03 00:00:01','363.21');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-01-02 00:00:01','119.27');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-01-03 00:00:01','117.27');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-01-04 00:00:01','116.27');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-01-05 00:00:01','115.27');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-01-06 00:00:01','114.27');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-01-07 00:00:01','119.27');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-01-08 00:00:01','120.27');

/** creates a table to store a list of people */
DROP TABLE IF EXISTS person_stocks CASCADE;
DROP TABLE IF EXISTS person CASCADE;
CREATE TABLE person
(
  ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(256) NOT NULL,
  last_name VARCHAR(256) NOT NULL
);

INSERT INTO person (first_name,last_name) VALUES ('Warren', 'Buffett');
INSERT INTO person (first_name,last_name) VALUES ('John', 'Hancock');

/** A list of people and their stocks */
CREATE TABLE person_stocks
(
  ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  person_id INT NOT NULL,
  stock_symbol VARCHAR(4) NOT NULL,
  FOREIGN KEY (person_id) REFERENCES person (ID)
);

INSERT INTO stocks.person_stocks (person_id,stock_symbol) VALUES (1, 'GOOG');
INSERT INTO stocks.person_stocks (person_id,stock_symbol) VALUES (1, 'AMZN');
INSERT INTO stocks.person_stocks (person_id,stock_symbol) VALUES (2, 'APPL');