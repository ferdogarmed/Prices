DROP TABLE IF EXISTS PRICES; 
CREATE TABLE PRICES (
ID INT PRIMARY KEY,
BRAND_ID INT NOT NULL,
START_DATE TIMESTAMP,
END_DATE DATETIME,
PRICE_LIST INT,
PRODUCT_ID INT,
PRIORITY INT,
PRICE NUMERIC(20,2),
CURR VARCHAR(50)
);