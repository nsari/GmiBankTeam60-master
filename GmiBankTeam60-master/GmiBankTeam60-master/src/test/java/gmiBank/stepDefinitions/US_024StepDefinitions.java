package gmiBank.stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmiBank.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import static gmiBank.jsonModels.StateJson.CreateState3;
import static io.restassured.RestAssured.given;

public class US_024StepDefinitions {

    Response responseCreated;
    Response response2;
    String createdStateId;
    String createdStateName;

    @Given("use endpoint {string} and create new states")
    public void useEndpointAndCreateNewStates(String endpoint) {
        responseCreated = given().headers("Authorization",
                "Bearer " + ConfigurationReader.getProperty("token"),
                "Content-Type",
                ContentType.JSON,
                "Accept", ContentType.JSON)
                .when()
                .body(CreateState3)
                .post(endpoint)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();

        responseCreated.prettyPrint();

        //butun responsu jsonpath e atiyorum ve created olan id ve name e bakiyorum
        //expected data yi olusturuyoruz
        JsonPath jsonPath = responseCreated.jsonPath();
        createdStateId = jsonPath.getString("id");
        System.out.println("creates state ids: " + createdStateId);
        System.out.println("===================================");
        createdStateName = jsonPath.getString("name");
        System.out.println("creates state names: " + createdStateName);

    }

    @Then("read all states from end point {string}")
    public void readAllStatesFromEndPoint(String endpoint) {
        response2 = given().headers("Authorization",
                "Bearer " + ConfigurationReader.getProperty("token"),
                "Content-Type",
                ContentType.JSON,
                "Accept", ContentType.JSON)
                .when()
                .get(endpoint)
                .then().contentType(ContentType.JSON)
                .extract()
                .response();
        //  response2.prettyPrint();
    }

    @And("verify new states")
    public void verifyNewStates() {

        JsonPath acualJspath = response2.jsonPath();
        String actualStateName = acualJspath.getString("name");
        System.out.println(actualStateName);
        String actualStateId = acualJspath.getString("id");
        System.out.println("=========================");
        System.out.println(actualStateId);
        Assert.assertTrue(actualStateName.contains(createdStateName));
        System.out.println("success id");
        Assert.assertTrue(actualStateId.contains(createdStateId));
        System.out.println("success name");

    }
}
