create database testdb; 

use database testdb; 

CREATE TABLE cars(
	id int(10) NOT NULL,
	name varchar(30) NOT NULL, 
	price decimal(10,2) NOT NULL,
	PRIMARY KEY (id)
);



/* findByAll */
SELECT * FROM cars;

/* finddById*/
SET @id = 1;
/*SELECT @id;*/
SELECT * FROM cars WHERE id = @id;

/* addCar */
SET @id = 3;
SET @name = 'Tsuru';
SET @price = 140100;
INSERT INTO cars (id, name, price) VALUES (@id,@name,@price)

/* editCar */
SET @id = 3;
SET @name = 'Tsuru';
SET @price = 140000;
UPDATE cars SET name = @name, price = @price WHERE id = @id;
SELECT * FROM cars WHERE id = @id;

/* deleteCar */
SET @id = 3;
DELETE FROM cars WHERE id = @id;
SELECT * FROM cars WHERE id = @id;



