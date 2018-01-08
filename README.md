# code_test_supermarketcheckout
Supermarket checkout component with readable API that calculates the total price of a number of items:-- implemented by Sudheer Kosuru


Business requirements:

· Design and implement supermarket checkout component with readable API that calculates the total price of a number of items.

· Checkout mechanism can scan items and return actual price (is stateful)

· Our goods are priced individually. In addition, some items are multi-priced: "buy n of them, and they’ll cost you y cents"

      Item   Unit      Special

              Price     Price

  --------------------------

    A        40       3 for 70

    B        10       2 for 15

    C        30

    D        25
    
We value:

· simple, elegant code that reads like a narrative – don't overcomplicate

· excellent testing that acts as documentation

· challenging boundaries where necessary

Additional notes:

· use maven or gradle build system

· make task available on the public GitHub

· if in doubt please document your design choice in README file

Prerequisites
-------------- 
Jdk 1.7, 
Spring Boot, 
Embeded MongoDB, 
Maven

Procedure to build and run
--------------------------

*Clone the repo: git clone https://github.com/saysudheer/code_test_supermarketcheckout.git  or download zip

*Navigate to extracted application path or clonedrepo

*Run mvn clean install or mvn clean package in the root directory(execute at the path of pom.xml)

*To run: mvn spring-boot:run

API
----

Swagger API docs are enabled and avaliable at UI version at :http://localhost:8080/swagger-ui.html

GET /supermarket/api/getitems
------------------------------
Curl
	curl -X GET --header 'Accept: application/json' 'http://localhost:8080/supermarket/api/getitems'

Request URL
	http://localhost:8080/supermarket/api/getitems

POST /supermarket/api/addtocart/items
-------------------------------------

Curl
	curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' 'http://localhost:8080/supermarket/api/addtocart/items?itemId=1&quantity=10'

Request URL
	http://localhost:8080/supermarket/api/addtocart/items?itemId=1&quantity=10

GET /supermarket/api/checkoutcart
----------------------------------

Curl
	curl -X GET --header 'Accept: application/json' 'http://localhost:8080/supermarket/api/checkoutcart'

Request URL
	http://localhost:8080/supermarket/api/checkoutcart

Implementation Overview:
-----------------------
Application is implemented using embeded mongo which stores items,when an item is added to cart, a session is created to store individual cart items till checkout.
Session stored is used to preserve object data inturn eliminates the need to store temporary data in database.
Price of items added to cart are calculated based on special price conditions.
