package Testing.step_definitions;

import Testing.utilities.ConfigurationReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.Argument;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.IsEqual.equalTo;

public class ApiStepDef {

    String URL;
    Response response;


    @Given("the {string} endpoint is available")
    public void the_endpoint_is_available(String endPoint) {

        URL = ConfigurationReader.getProperty("baseURI") + endPoint;


    }

    @When("I send GET request to the API endpoint")
    public void i_send_get_request_to_the_api_endpoint() {

        response = RestAssured.given().log().body().accept(ContentType.JSON).and()
                .when().get(URL);

        //response.prettyPrint();
    }

    @Then("the API response status should be {int}")
    public void the_api_response_status_should_be(Integer expectedStatusCode) {


        int actualStatusCode = response.statusCode();

        Assertions.assertEquals(expectedStatusCode, actualStatusCode);

    }

    @Then("the response payload should contain the following {string} is {string}")
    public void the_response_payload_should_contain_the_following_is(String attributeTitle, String valueTitle) {

        response.then().body(attributeTitle,Matchers.is(valueTitle));

        System.out.println("attributeTitle = " + attributeTitle);

    }
    @Then("{string} is {string}")
    public void is(String attributeDesc, String valueDesc) {

        response.then().body(attributeDesc,Matchers.is(valueDesc));


    }


}

/*
 "title": "OS Downloads API",
    "description": "The available Download APIs offered by Ordnance Survey.
    These provide access to bulk data through RESTful services.",
 */

