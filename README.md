# ezara TEST by dguerrar@gmail.com

##DESIGN
- DB are created using the Flyway frameworks. 2 revisions for creating the tables and insert the initial data
- I chose to create one table for each of the entities needed (brand, product, price and price list) and use the following entities (brand, product, price) as FK in the main table (price_list)
- logs are build through SLF4 +  AOP in order to make code clear
- lombok is used in order to avoid getters&setters in POJOs. make the code clear
- Repositories are used
- JPA queries are not used for PriceList. I prefer JPA specifications over JPA queries because it always makes the maintenance easier
- DTOs are created through converters in order to return a DTO and not a POJO on the request (best preactices)
- a Validator is used only for priceEntry. It throws a custom exception is anything is correct (best practice).
- Exception are caught on advices to custom messages are returned on erroneous requests
- In order to make this **TEST** easier and **real-life** focus, I am not using HATEOS neither GraphQL libraries.
- swagger info is available for reviewing at **http://localhost:8080/swagger-ui/index.html**
- health check (spring boot actuators) are available at http://localhost:8080/actuator/health

##IMPORTANT
- On the request asked in this **TEST**, I prefer to use a POST + a DTO in the body for maintenance optimization.
- A common way of "getting" info on a RESt service is through a GET + params in the URL. I do not recomment this practice as the URL has 255 character limit and some requests could no be processed.
- Is clear that this **TEST** is easy and a GET could be used, but I preferred to implement the best practice option.


##TESTS
- junit + integration tests are used
- postman collection is enclosed for all requests
- Only junit + integration tests are done for brand and priceEntry entities
- Tests for product & priceList are analogs

###Sample json for postman

{
"brandId":"1",
"productId":"1",
"date":"2022/01/01 10:00:00"
}
