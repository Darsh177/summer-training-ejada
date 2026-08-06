CREATE TABLE Orders (
    order_id INT PRIMARY KEY,
    customer_id INT,
    product_id INT,
    quantity INT,
    order_date DATE,
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id),
    FOREIGN KEY (product_id) REFERENCES Products(product_id)
);

INSERT INTO Orders VALUES (1, 101, 1, 2, DATE '2026-03-01');
INSERT INTO Orders VALUES (2, 101, 5, 1, DATE '2026-03-02');
INSERT INTO Orders VALUES (3, 102, 2, 1, DATE '2026-03-05');
INSERT INTO Orders VALUES (4, 104, 3, 4, DATE '2026-03-10');
INSERT INTO Orders VALUES (5, 106, 7, 2, DATE '2026-03-12');
INSERT INTO Orders VALUES (6, 106, 1, 1, DATE '2026-03-15');


SELECT 
    categorys,
    COUNT(product_id) AS total_products,
    AVG(price) AS avg_price,
    MAX(price) AS max_price,
    MIN(price) AS min_price
FROM Products
GROUP BY categorys;

SELECT 
   categorys,
    COUNT(product_id) AS total_products
FROM Products
GROUP BY categorys
HAVING COUNT(product_id) > 1;




SELECT 
    o.order_id,
    c.first_name || ' ' || c.last_name AS customer_name,
    p.product_name,
    o.quantity,
    o.order_date
FROM Orders o
INNER JOIN Customers c ON o.customer_id = c.customer_id
INNER JOIN Products p ON o.product_id = p.product_id;


SELECT 
    c.customer_id,
    c.first_name,
    c.last_name,
    o.order_id
FROM Customers c
LEFT JOIN Orders o ON c.customer_id = o.customer_id;



SELECT product_name, price
FROM Products
WHERE price > (SELECT AVG(price) FROM Products);

SELECT city FROM Customers WHERE city IS NOT NULL
UNION
SELECT 'City Not Specified' FROM DUAL;