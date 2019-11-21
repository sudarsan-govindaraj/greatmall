# greatmall
Great Mall

For this great mall api are found in swagger-ui http://localhost:8080/swagger-ui.html

POST Request for create Order
	http://localhost:8080/orders/place
	{
		"customer": {
			"id": 1
		},
		"products":[
			{
				"id": 4,
				"quantity": 2
			},
			{
				"id": 13,
				"quantity": 1
			}


		],
		"shop": {
			"id" : 1
		}
	}
above parmeter's are tplace order
