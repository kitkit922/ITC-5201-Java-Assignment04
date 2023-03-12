-- Course: java
-- Assignment: 04

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

-- UPDATE java_staff
-- SET
--   firstname = 'FIRST_NAM03'
-- , lastname = 'LAST_NAME03'
-- , mi = upper(
--     'm'
--   )
-- , address = 'address03'
-- , city = 'city03'
-- , state = 'ON'
-- , telephone = '8442507537'
-- , email = 'email@def.com'
-- WHERE
--   id = 5;

SELECT *
FROM java_staff
WHERE id = '1';

SELECT COUNT(*) AS count
FROM java_staff
WHERE id = 1;

DELETE FROM java_staff
WHERE
  id = '3';

DELETE FROM java_staff
WHERE
  id = '5';