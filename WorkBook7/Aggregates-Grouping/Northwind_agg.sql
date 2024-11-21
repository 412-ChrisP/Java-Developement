-- 1.)
SELECT COUNT(*) 
AS SupplierCount
FROM Suppliers;

-- 2.)
SELECT SUM(Salary) 
AS TotalSalary
FROM Employees;

-- 3.)
SELECT MIN(UnitPrice) 
AS CheapestPrice
FROM Products;

-- 4.)
SELECT AVG(UnitPrice) 
AS AveragePrice
FROM Products;

-- 5.)
SELECT MAX(UnitPrice) 
AS MostExpensivePrice
FROM Products;

-- 6.)
SELECT SupplierID, COUNT(*) 
AS ItemCount
FROM Products
GROUP BY SupplierID;

-- 7.)
SELECT CategoryID, AVG(UnitPrice) 
AS AveragePrice
FROM Products
GROUP BY CategoryID;

-- 8.)
SELECT SupplierID, COUNT(*) 
AS ItemCount
FROM Products
GROUP BY SupplierID
HAVING ItemCount >= 5;

-- 9.)
