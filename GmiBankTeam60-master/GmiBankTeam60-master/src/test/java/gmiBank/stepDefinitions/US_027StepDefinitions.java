package gmiBank.stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmiBank.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import static gmiBank.jsonModels.StateJson.CreateState5;
import static io.restassured.RestAssured.given;

public class US_027StepDefinitions {

    Response deleteResponse;
    Response responseNew;
    String actualdata;

    @Given("create a state from end point  {string}")
    public void readAllStatesFromEndPoint(String end_point) {

        responseNew=given().headers("Authorization",
                "Bearer " + ConfigurationReader.getProperty("token"),
                "Content-Type",
                ContentType.JSON,
                "Accept", ContentType.JSON)
                .when()
                .body(CreateState5)
                .post(end_point)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();

        responseNew.prettyPrint();
    }

    @And("delete state using  {string} and its extension {string}")
    public void deleteStateUsingAndItsExtension(String end_point, String name) {

        deleteResponse=  given().headers("Authorization",
                "Bearer "+ ConfigurationReader.getProperty("token"),
                "Content-Type",
                ContentType.JSON,
                "Accept",ContentType.JSON)
                .when()
                .delete(end_point+name)
                .then()
                .extract()
                .response();


        responseNew=given().headers("Authorization",
                "Bearer "+ ConfigurationReader.getProperty("token"),
                "Content-Type",
                ContentType.JSON,
                "Accept",ContentType.JSON)
                .when()
                .get(end_point)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();

    }


    @Then("When user verify if states  {string}")
    public void whenUserVerifyIfStates(String name) {
        JsonPath jsonPath = responseNew.jsonPath();
        actualdata = jsonPath.getString("name");

        Assert.assertFalse("not delete",actualdata.contains(name));
        System.out.println("Validation is succesfull");
    }
}
