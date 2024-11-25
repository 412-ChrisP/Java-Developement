-- 1.)
INSERT INTO suppliers (CompanyName, ContactName, ContactTitle, Address, City, Region, PostalCode, Country, Phone, Fax, HomePage)
VALUES ('YearUp', 'Chris Pham', 'Boss', '112 Green Drive', 'Pittsburgh', 'PA', '15236', 'United States', '123-0000', '123-6969', NULL);

-- 2.)
INSERT INTO products (ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued)
VALUES ('HugsForPurchase', 
	(SELECT SupplierID FROM suppliers WHERE CompanyName = 'YearUp'), 
    1, '1 hug per purchase', .99, 50, 0, 10, 0);

-- 3.)
SELECT p.ProductID, p.ProductName, s.CompanyName, p.UnitPrice
FROM products p
JOIN suppliers s ON p.SupplierID = s.SupplierID
ORDER BY s.CompanyName, p.ProductName;

-- 4.)
UPDATE products
SET UnitPrice = UnitPrice * 1.15
WHERE ProductName = 'HugsForPurchase';

-- 5.)
SELECT p.ProductID, p.ProductName, p.UnitPrice
FROM products p
JOIN suppliers s ON p.SupplierID = s.SupplierID
WHERE s.CompanyName = 'YearUp';

-- 6.)
DELETE FROM products
WHERE ProductName = 'HugsForPurchase';

-- 7.)
DELETE FROM suppliers
WHERE CompanyName = 'YearUp';

-- 8.)
SELECT * FROM products;

-- 9.)
SELECT * FROM suppliers;
