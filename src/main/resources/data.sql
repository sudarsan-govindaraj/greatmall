
/*================== PRODUCT DETAILS STATIC INFORMATION STARTS HERE==============================*/

INSERT INTO 
	TBL_PROD_CATEGORY (category)
VALUES 
	('Television'),
	('Mobiles'),
	('Laptops'),
	('Cameras'),
	('Speakers'),
	('Footwear'),
	('Clothing'),
	('Watches'),
	('Beauty and Grooming'),
	('Jewellery');
	
INSERT INTO 
	TBL_PRODUCT (product_name, quantity, color, price, category_id)
VALUES 
	('Xiaomi Mi TV 4A Pro 32 inch HD Ready Smart LED TV', 20, null, 12499.00, 1),
	('LG 32LJ573D 32 inch HD Ready Smart LED TV', 50, null, 18999.99, 1),
	('Vu 43sm 43 inch Full HD Smart LED TV', 25, null, 18499.90, 1),
	('Sony BRAVIA KLV-24P413D 24 inch HD Ready LED TV Price', 30, null, 12999.00, 1),
	('Thomson 32M3277 32 inch HD Ready Smart LED TV', 15, null, 9499.00, 1),
	('BPL T43BF24A 43 inch Full HD LED TV', 20, null, 15499.00, 1),
	('Micromax 32T8361HD/32T8352HD 32 inch HD Ready LED TV', 25, null, 9798.99, 1),
	('iFFALCON 50K31 50 inch 4K (Ultra HD) Smart LED TV', 10, null, 25999.99, 1),
	('Kodak 32HDXSMART 32 inch HD Ready Smart LED TV Price', 5, null, 8999.00, 1),
	('Samsung UA50NU6100K 50 inch 4K (Ultra HD) Smart LED TV', 25, null, 49990.00, 1),
	
	('Samsung Galaxy M30s', 10, 'Sapphire Blue', 16999.99, 2),
	('Xiaomi Redmi Note 8', 50, 'Black', 9998.00, 2),
	('Motorola One Macro', 10, 'Black', 9999.99, 2),
	('Samsung Galaxy M30 32GB', 25, 'Black', 9999.99, 2),
	('Realme 3 Pro', 50, 'White', 9999.00, 2);
	
	
/*================== END ==============================*/
	

/*================== SHOPS DETAILS STARTS HERE==============================*/
	
INSERT INTO 
	TBL_SHOPS (shop_name, address, mobile_number, phone_number, alternate_number, contact_person, email)
VALUES 
	('Lifestyle', '183, Arcot Rd, Vadapalani, Chennai, Tamil Nadu 600026', null, '044 - 49080200', null, null, 'info@lifestyle.co.in'),
	('Marks & Spencer', '183, Arcot Rd, Vadapalani, Chennai, Tamil Nadu 600026', '9566284882', '044-66528383/ 85', '9841824262', 'Baskar', 'bhaskar.dhupathi@marks-and-spencer.com'),
	('Max', '183, Arcot Rd, Vadapalani, Chennai, Tamil Nadu 600026', '9952000882 ', '044 - 43995959', '8056188814', 'Nishanth', 'chnforum.maxsm@landmarkgroup.in'),
	('HP', '183, 2nd Floor, Arcot Rd, Vadapalani, Chennai, Tamil Nadu 600026', '7299012240', '044 - 43054788', null, 'A. Karthikeyan', 'globusforum@soundry.in'),
	('Amazon', '183, Arcot Rd, Vadapalani, Chennai, Tamil Nadu 600026', '8438127644', null, null, 'Joesin MJ', ' jojonesjj74@gmail.com'),
	('Lenovo', '183, 2nd Floor, Arcot Rd, Vadapalani, Chennai, Tamil Nadu 600026', '9941364343', '044 - 66528343', null, 'E.Tamizharasan', 'lenovo-dotcom@outlook.com'),
	('The Mobile Access', '183, 2nd Floor, Arcot Rd, Vadapalani, Chennai, Tamil Nadu 600026', '9941360090', '044-66528360', null, 'Aslam Basha', 'aslambasha05@gmail.com'),
	('Imagine', '183, Ground Floor, Arcot Rd, Vadapalani, Chennai, Tamil Nadu 600026', '9003677574', '044-66528315', '044-23746954', 'Suresh', 'sivakumar.krishnakumar@ample.co.in'),
	('Estelle', '183, Arcot Rd, Vadapalani, Chennai, Tamil Nadu 600026', '9940137434', null, '9940077506', 'Ali', 'kk.forumchennai@citymaxindia.com'),
	('Casio', '183, 2nd Floor, Arcot Rd, Vadapalani, Chennai, Tamil Nadu 600026', '7708584888', ' 044-45066207', null, 'Baskar', 'forumcasio@gmail.com');
	
	
INSERT INTO
	TBL_SHOPS_PRODUCT_CATEGORIES(shop_id, category_id)
VALUES
	(1 , 1), (1 , 2), (1 , 3), (1 , 4), (1 , 5),(1, 6), (1, 7), (1, 8), (1, 9), (1, 10),
	(2 , 1), (2 , 2), (2 , 3), (2 , 4), (2 , 5),(2, 6), (2, 7), (2, 8), (2, 9), (2, 10),
	(3 , 1), (2 , 3), (3 , 3), (3 , 4), (3 , 5),(3, 6), (3, 7), (3, 8), (3, 9), (3, 10),
	(4 , 1), (4 , 2), (4 , 3), (4 , 4), (4 , 5),(4, 6), (4, 7), (4, 8), (4, 9), (4, 10),
	(5 , 1), (5 , 2), (5 , 3), (5 , 4), (5 , 5),(5, 6), (5, 7), (5, 8), (5, 9), (5, 10),
	(6 , 1), (6 , 2), (6 , 3), (6 , 4), (6 , 5),(6, 6), (6, 7), (6, 8), (6, 9), (6, 10),
	(7 , 1), (7 , 2), (7 , 3), (7 , 4), (7 , 5),(7, 6), (7, 7), (7, 8), (7, 9), (7, 10),
	(8 , 1), (8 , 2), (8 , 3), (8 , 4), (8 , 5),(8, 6), (8, 7), (8, 8), (8, 9), (8, 10),
	(9 , 1), (9 , 2), (9 , 3), (9 , 4), (9 , 5),(9, 6), (9, 7), (9, 8), (9, 9), (9, 10),
	(10 , 1), (10 , 2), (10 , 3), (10 , 4), (10 , 5),(10, 6), (10, 7), (10, 8), (10, 9), (10, 10);
	
/*================== END ==============================*/
	
	

/*================== CUSTOMERS DETAILS STARTS HERE==============================*/
	
INSERT INTO
	TBL_CUSTOMERS (first_name, last_name, gender, email, mobile_number, alternate_number)
VALUES
	('Sudarsan', 'Govind', 'Male', 'sudarsan.govindaraj@colanonline.com', '919568235479', null),
	('Senthilnathan', 'Subash', 'Male', 'senthilnathan@colanonline.com', '9865243058', null),
	('Aadil', 'Ahamad', 'Male', 'aadil@colanonline.com', '9842136925', null),
	('Rajendra', 'Kumar', 'Male', 'rajendrakumar@colanonline.com', null, null),
	('Induja', 'K', 'Female', 'indujakuamr@colanonline.com', '9875642310', null);
	
	
INSERT INTO
	TBL_ADDRESS (address_details, city, state, country, pincode, landmark, address_type, customer_id)
VALUES
	('Murugesanayakakr complex','Chennai', 'Tamilnadu', 'India', '600006', 'Greams Road West', 'Work', 1),
	('Murugesanayakakr complex','Chennai', 'Tamilnadu', 'India', '600006', 'Greams Road West', 'Work', 2),
	('Murugesanayakakr complex','Chennai', 'Tamilnadu', 'India', '600006', 'Greams Road West', 'Work', 3),
	('Murugesanayakakr complex','Chennai', 'Tamilnadu', 'India', '600006', 'Greams Road West', 'Work', 4),
	('Murugesanayakakr complex','Chennai', 'Tamilnadu', 'India', '600006', 'Greams Road West', 'Work', 5);
	
	
	
/*================== END ==============================*/