import org.junit.Test;

import config.TestConfig;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;

public class POSTTest extends TestConfig {

    @Test
    public void TaskPOST() {
        String createProductJson = "{\n" +
        " \"title\": \"mouse pad\"\n" +
        "}";
        given()
            .contentType("application/json")
            .body(createProductJson)
            .log().all()
        .when()
            .post("products/add")
        .then()
            .body("id", Matchers.equalTo(101))
            .body("title", Matchers.equalTo("mouse pad"))
            .header("Content-Type", "application/json; charset=utf-8") 
            .time(Matchers.lessThan(3000L))
            .statusCode(Matchers.equalTo(200))
            .log().all();
    }
}
