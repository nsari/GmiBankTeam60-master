package gmiBank.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmiBank.pojos.Country;
import gmiBank.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;


import static gmiBank.jsonModels.CountryJson.CreateCountry3;
import static io.restassured.RestAssured.given;


public class US_025StepDefinition {
    Response response;
    Response response1;
    String expectedCountryId;
    String expectedCountryName;
    String actualCountryId;
    String actualCountryName;
    Country[] countries;


    @Given("use endpoint {string} and create new countries")
    public void use_endpoint_and_create_new_countries(String newCountry) {
        response = given().
                headers("Authorization",
                        "Bearer "
                                + ConfigurationReader.getProperty("token"),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON).
                when().
                body(CreateCountry3).
                post(newCountry).
                then().
                contentType(ContentType.JSON).
                extract().
                response();
        // response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        expectedCountryId = jsonPath.getString("id");
        System.out.println(expectedCountryId);
        expectedCountryName = jsonPath.getString("name");
        System.out.println("=====================");
        System.out.println(expectedCountryName);

    }

    @Then("read all countries from end point {string}")
    public void read_all_countries_from_end_point(String newCountry) {
        response1 = given().headers(
                "Authorization",
                "Bearer " + ConfigurationReader.getProperty("token"),
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON)
                .when()
                .get(newCountry)
                .then().
                        contentType(ContentType.JSON)
                .extract()
                .response();
        response1.prettyPrint();

        JsonPath actualJsnPath = response1.jsonPath();
        actualCountryId = actualJsnPath.getString("id");
        System.out.println(actualCountryId);
        actualCountryName = actualJsnPath.getString("name");
        System.out.println("======================================================");
        System.out.println(actualCountryName);


    }

    @Then("verify new countries")
    public void verify_new_countries() {

        Assert.assertTrue("does not match", actualCountryId.contains(expectedCountryId));
        Assert.assertTrue("does not match", actualCountryName.contains(expectedCountryName));

        System.out.println("Success Assert");

    }
}
