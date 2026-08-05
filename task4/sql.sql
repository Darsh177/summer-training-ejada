
create table Products(
product_id int primary key ,
product_name varchar(30),
categorys varchar(30),
price decimal(20 , 2),
stock_quantity int,
created_at DATE
);


create table Customers(
customer_id int primary key,
first_name varchar(30),
last_name varchar(30),
email varchar(30),
city varchar(30)
);

ALTER TABLE Products ADD description VARCHAR2(250);
ALTER TABLE Customers MODIFY email VARCHAR2(100);


INSERT INTO Products (product_id, product_name, categorys, price, stock_quantity, created_at, description) VALUES (1, 'Laptop Dell', 'Electronics', 1200.50, 15, DATE '2026-01-10', 'High performance laptop');
INSERT INTO Products (product_id, product_name, categorys, price, stock_quantity, created_at, description) VALUES (2, 'Smartphone', 'Electronics', 800.00, 30, DATE '2026-01-15', NULL);
INSERT INTO Products (product_id, product_name, categorys, price, stock_quantity, created_at, description) VALUES (3, 'Office Chair', 'Furniture', 150.00, NULL, DATE '2026-02-01', 'Ergonomic chair');
INSERT INTO Products (product_id, product_name, categorys, price, stock_quantity, created_at, description) VALUES (4, 'Coffee Table', 'Furniture', 85.25, 10, NULL, NULL);
INSERT INTO Products (product_id, product_name, categorys, price, stock_quantity, created_at, description) VALUES (5, 'Wireless Mouse', 'Accessories', 25.00, 50, DATE '2026-02-10', 'Optical mouse');
INSERT INTO Products (product_id, product_name, categorys, price, stock_quantity, created_at, description) VALUES (6, 'Keyboard', 'Accessories', 45.00, NULL, DATE '2026-02-12', 'Mechanical keyboard');
INSERT INTO Products (product_id, product_name, categorys, price, stock_quantity, created_at, description) VALUES (7, 'Monitor 24 inch', 'Electronics', 200.00, 20, DATE '2026-02-20', NULL);
INSERT INTO Products (product_id, product_name, categorys, price, stock_quantity, created_at, description) VALUES (8, 'Desk Lamp', 'Lighting', 30.00, 15, NULL, 'LED lamp');
INSERT INTO Products (product_id, product_name, categorys, price, stock_quantity, created_at, description) VALUES (9, 'Running Shoes', 'Sports', 90.00, 40, DATE '2026-03-01', NULL);
INSERT INTO Products (product_id, product_name, categorys, price, stock_quantity, created_at, description) VALUES (10, 'Backpack', 'Bags', 50.00, NULL, NULL, 'Waterproof backpack');

INSERT INTO Customers (customer_id, first_name, last_name, email, city) VALUES (101, 'Ahmed', 'Ali', 'ahmed.ali@email.com', 'Cairo');
INSERT INTO Customers (customer_id, first_name, last_name, email, city) VALUES (102, 'Sara', 'Mohamed', 'sara.m@email.com', NULL);
INSERT INTO Customers (customer_id, first_name, last_name, email, city) VALUES (103, 'Omar', 'Hassan', NULL, 'Alexandria');
INSERT INTO Customers (customer_id, first_name, last_name, email, city) VALUES (104, 'Mona', 'Ibrahim', 'mona.i@email.com', 'Giza');
INSERT INTO Customers (customer_id, first_name, last_name, email, city) VALUES (105, 'Khaled', 'Samy', NULL, NULL);
INSERT INTO Customers (customer_id, first_name, last_name, email, city) VALUES (106, 'Youssef', 'Nabil', 'youssef.n@email.com', 'Cairo');
INSERT INTO Customers (customer_id, first_name, last_name, email, city) VALUES (107, 'Nour', 'El-Din', 'nour.e@email.com', NULL);
INSERT INTO Customers (customer_id, first_name, last_name, email, city) VALUES (108, 'Hany', 'Adel', NULL, 'Mansoura');
INSERT INTO Customers (customer_id, first_name, last_name, email, city) VALUES (109, 'Dina', 'Tarek', 'dina.t@email.com', 'Tanta');
INSERT INTO Customers (customer_id, first_name, last_name, email, city) VALUES (110, 'Mahmoud', 'Saeed', 'mahmoud.s@email.com', NULL);




UPDATE Products SET price = price * 1.10 WHERE categorys = 'Electronics';
DELETE FROM Products WHERE stock_quantity = 0;




SELECT * FROM Products WHERE price > 500 AND stock_quantity > 5;
select * from Products where price between 100 and 1000;
select * from customers where city In ('cairo' , 'Alexandria' , 'Giza');
select * from products where product_name like 'S%' or product_name like '%Pro';
SELECT * FROM Customers WHERE email IS NULL;
SELECT * FROM Customers WHERE email IS not NULL;
SELECT * FROM products Order by price desc;
