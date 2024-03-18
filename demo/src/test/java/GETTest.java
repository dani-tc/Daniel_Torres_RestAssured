import org.junit.Test;

import config.TestConfig;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class GETTest extends TestConfig {

    @Test
    public void TaskGET() {
        String endpoint = "products/{id}";
        given()
            .log().all()
        .when()
            .get(endpoint,1)
            // .get("https://dummyjson.com/quotes") // If we didn't have a Base/Config class
            // we would make the request like this
        .then()
            .body("id", Matchers.equalTo(1))
            .body("title", Matchers.equalTo("iPhone 9"))
            .body("description", Matchers.equalTo("An apple mobile which is nothing like apple"))
            .body("price", Matchers.equalTo(549))
            .body("discountPercentage", Matchers.equalTo(12.96f))
            .statusCode(Matchers.equalTo(200))
            .body(matchesJsonSchemaInClasspath("getProductSchema.json"))
            .time(Matchers.lessThan(3000L))
            .log().all();
    }
}
