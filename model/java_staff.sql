-- Course: DB Java
-- Assignment: 04
-- Creator: Wenhao Fang
-- Student ID: n01555914

/*************************************************************************************************
 * Course_Name – Assignment 04
 * 
 * I declare that this assignment is my own work in accordance with Humber
 * Academic Policy. 
 * 
 * No part of this assignment has been copied manually or electronically from
 * any other source (including web sites) or distributed to other students/social media.
 * 
 * Name: Wenhao Fand 
 * Student ID: N01555914
 * Date: 2023/03/17
 * 
 *************************************************************************************************/


DROP TABLE java_staff;

CREATE TABLE java_staff (
  id CHAR(9)
, firstname VARCHAR(15)
, lastname VARCHAR(15)
, mi CHAR(1)
, address VARCHAR(20)
, city VARCHAR(20)
, state CHAR(2)
, telephone CHAR(10)
, email VARCHAR(40)
, CONSTRAINT java_staff_id_pk PRIMARY KEY (id)
);

INSERT INTO java_staff VALUES(
  '1'
, 'John'
, 'Doe'
, 'F'
, '290 Bremner Blvd'
, 'Toronto'
, 'ON'
, '4168686937'
, 'email@abc.com'
);

INSERT INTO java_staff VALUES(
  '2'
, 'Derrick'
, 'Smith'
, 'M'
, '401 Richmond Street'
, 'Toronto'
, 'ON'
, '8442507537'
, 'email@def.com'
);

SELECT *
FROM java_staff;