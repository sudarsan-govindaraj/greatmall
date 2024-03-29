
/*================== PRODUCT DETAILS STARTS HERE==============================*/

DROP TABLE IF EXISTS TBL_PROD_CATEGORY CASCADE;

CREATE TABLE TBL_PROD_CATEGORY (
	id INT AUTO_INCREMENT PRIMARY KEY,
	category VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS TBL_PRODUCT CASCADE;

CREATE TABLE TBL_PRODUCT (
	id  NUMBER(10,0) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	product_name VARCHAR(250) NOT NULL,
	price NUMERIC(8, 2) NOT NULL,
	quantity INT,
	color VARCHAR(250),
	category_id INT,
	CONSTRAINT FK_PROD_CATEGORY_PRODUCT FOREIGN KEY(category_id) REFERENCES TBL_PROD_CATEGORY(id) ON DELETE CASCADE
);

/*================== END ==============================*/

/*================== SHOPS DETAILS STARTS HERE==============================*/


DROP TABLE IF EXISTS TBL_SHOPS CASCADE;

CREATE TABLE TBL_SHOPS (
	id INT AUTO_INCREMENT PRIMARY KEY,
	shop_name VARCHAR(250),
	address VARCHAR(250),
	mobile_number VARCHAR(250),
	phone_number VARCHAR(250),
	alternate_number VARCHAR(250),
	contact_person VARCHAR(250),
	email VARCHAR(250)
);

DROP TABLE IF EXISTS TBL_SHOPS_CUSTOMERS CASCADE;

CREATE TABLE TBL_SHOPS_CUSTOMERS (
	id INT AUTO_INCREMENT PRIMARY KEY,
	shop_id INT,
	customer_id INT,
	CONSTRAINT FK_TBL_SHOPS_CUSTOMERS_SHOP_ID FOREIGN KEY(shop_id) REFERENCES TBL_SHOPS(id)ON DELETE CASCADE,
	CONSTRAINT FK_TBL_SHOPS_CUSTOMERS_CUSTOMER_ID FOREIGN KEY(customer_id) REFERENCES TBL_CUSTOMERS(id)ON DELETE CASCADE
);

DROP TABLE IF EXISTS TBL_SHOPS_PRODUCT_CATEGORIES CASCADE;

CREATE TABLE TBL_SHOPS_PRODUCT_CATEGORIES (
	shop_id INT,
	category_id INT,
	CONSTRAINT FK_TBL_SHOPS_PRODUCT_CATEGORIES_SHOP_ID FOREIGN KEY(shop_id) REFERENCES TBL_SHOPS(id)ON DELETE CASCADE,
	CONSTRAINT FK_TBL_SHOPS_PRODUCT_CATEGORIES_CATEGORY_ID FOREIGN KEY(category_id) REFERENCES TBL_CUSTOMERS(id)ON DELETE CASCADE
);

/*================== END ==============================*/


/*================== CUSTOMERS DETAILS STARTS HERE==============================*/

DROP TABLE IF EXISTS TBL_CUSTOMERS CASCADE;
 
CREATE TABLE TBL_CUSTOMERS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250),
  gender VARCHAR(250),
  email VARCHAR(250) DEFAULT NULL,
  mobile_number VARCHAR(250),
  alternate_number VARCHAR(250)
);

DROP TABLE IF EXISTS TBL_ADDRESS CASCADE;

CREATE TABLE TBL_ADDRESS (
	id INT AUTO_INCREMENT PRIMARY KEY,
	address_details VARCHAR(250),
	landmark VARCHAR(250),
	city VARCHAR(250),
	state VARCHAR(250),
	country VARCHAR(250),
	pincode VARCHAR(250),
	address_type VARCHAR(250),
	customer_id INT,
	CONSTRAINT FK_TBL_CUSTOMERS_ADDRESS FOREIGN KEY(customer_id) REFERENCES TBL_CUSTOMERS(id) ON DELETE CASCADE
);


/*================== END ==============================*/






/*================== ORDER DETAILS STARTS HERE ==============================*/

DROP TABLE IF EXISTS TBL_ORDERS CASCADE;

CREATE TABLE TBL_ORDERS (
	id INT AUTO_INCREMENT PRIMARY KEY,
	order_id VARCHAR(250),
	no_of_item INT,
	total_amount NUMERIC(8, 2),
	create_date DATE,
	modify_date DATE,
	delivery_date DATE,
	status VARCHAR(250),
	customer_id INT,
	shop_id INT,
	CONSTRAINT FK_TBL_ORDERS_CUSTOMER_ID FOREIGN KEY(customer_id) REFERENCES TBL_CUSTOMERS(id) ON DELETE CASCADE,
	CONSTRAINT FK_TBL_ORDERS_SHOP_ID FOREIGN KEY(shop_id) REFERENCES TBL_SHOPS(id) ON DELETE CASCADE
);

DROP TABLE IF EXISTS TBL_ORDER_PRODUCT_SUMMARY CASCADE;

CREATE TABLE TBL_ORDER_PRODUCT_SUMMARY (
	id INT AUTO_INCREMENT PRIMARY KEY,
	product_quantity INT,
	price NUMERIC(8, 2),
	product_id INT,
	order_id INT,
	CONSTRAINT FK_TBL_ORDER_PRODUCT_SUMMARY_PRODUCT_ID FOREIGN KEY(product_id) REFERENCES TBL_PRODUCT(id)ON DELETE CASCADE,
	CONSTRAINT FK_TBL_ORDER_PRODUCT_SUMMARY_ORDER_ID FOREIGN KEY(order_id) REFERENCES TBL_ORDERS(id)ON DELETE CASCADE
);

/*================== END ==============================*/