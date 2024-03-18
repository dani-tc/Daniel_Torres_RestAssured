import org.junit.Test;

import config.TestConfig;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;

public class PUTTest extends TestConfig {

    @Test
    public void TaskPUT() {
        String createProductJson = "{\n" +
        " \"title\": \"Airpods\"\n" +
        "}";
        String endpoint = "products/{id}";
        given()
            .contentType("application/json")
            .body(createProductJson)
            .pathParam("id", "2")
            .log().all()
        .when()
            .put(endpoint)
        .then()
            .body("id", Matchers.equalTo(2))
            .body("title", Matchers.equalTo("Airpods"))
            .body("price", Matchers.equalTo(899))
            .body("discountPercentage", Matchers.equalTo(17.94f))
            .body("stock", Matchers.equalTo(34))
            .body("rating", Matchers.equalTo(4.44f))
            .body("brand", Matchers.equalTo("Apple"))
            .header("Content-Type", "application/json; charset=utf-8") 
            .time(Matchers.lessThan(2500L))
            .statusCode(Matchers.equalTo(200))
            .log().all();
    }
}
