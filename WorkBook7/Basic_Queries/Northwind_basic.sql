-- 2
SELECT ProductID, ProductName, UnitPrice
FROM Products;

-- 3
SELECT ProductID, ProductName, UnitPrice
FROM Products
ORDER BY UnitPrice ASC;

-- 4
SELECT *
FROM Products
WHERE UnitPrice <= 7.50;

-- 5
SELECT *
FROM Products
WHERE UnitsInStock >= 100
ORDER BY UnitPrice DESC;

-- 6
SELECT *
FROM Products
WHERE UnitsInStock >= 100
ORDER BY UnitPrice DESC, ProductName ASC;

-- 7
SELECT *
FROM Products
WHERE UnitsInStock = 0 
ORDER BY ProductName;

-- 9
SELECT *
FROM Categories;

-- 10
SELECT *
FROM Products
WHERE CategoryID = 8;

-- 11
SELECT FirstName, LastName
FROM Employees;

-- 12
SELECT *
FROM Employees
WHERE Title LIKE '%Manager%';