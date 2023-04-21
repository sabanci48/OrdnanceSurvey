package Testing.step_definitions;


import Testing.utilities.TestBase;

import io.restassured.path.json.JsonPath;


import io.restassured.http.ContentType;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class API_automation extends TestBase {


    @DisplayName("GET /downloads/v1")
    @Test
    public void test01(){

        JsonPath jsonPath = given().accept(ContentType.JSON).log().uri()
                .contentType(ContentType.JSON)
                .when().get("https://api.os.uk/downloads/v1").prettyPeek()
                .then().statusCode(200)
                .contentType(ContentType.JSON)
                .body("title", is("OS Downloads API"))
                .body("links.href", everyItem(containsString("os.uk"))).extract().jsonPath();



    }








}
