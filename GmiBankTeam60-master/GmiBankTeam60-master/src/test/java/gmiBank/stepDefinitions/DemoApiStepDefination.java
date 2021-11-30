package gmiBank.stepDefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmiBank.pojos.Country;
import gmiBank.utilities.ConfigurationReader;
import gmiBank.utilities.ReadToTxt;
import gmiBank.utilities.WriteToTxt;

import io.restassured.http.ContentType;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;



import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static gmiBank.jsonModels.CountryJson.CreateCountry4;
import static gmiBank.utilities.DatabaseUtil.*;
import static gmiBank.utilities.ReadToTxt.*;
import static io.restassured.RestAssured.given;
import static gmiBank.utilities.PDFGenerator.pdfGeneratorRowsAndCellsWithListFirstToTenForCountry;



public class DemoApiStepDefination {
    Response response;
    Response response2;
    Response updateresponse;
    Country[] countries;
    String readCountryName;
    String countryData;
    String jsonPathCreatName;
    String actualCountryName;
    String expectedUpdateCountry;
    String actualUpdatedCountry;
    String actualDeleteCountryId;
    List<Object> countryList;
    List<String> expecetedCountryList;


    @Given("read all countries data using with api endpoint {string}")
    public void read_all_countries_data_using_with_api_endpoint(String end_point) throws IOException {
        response = given().headers(
                "Authorization",
                "Bearer " + ConfigurationReader.getProperty("token"),
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON)
                .when()
                .get(end_point)
                .then().
                        contentType(ContentType.JSON)
                .extract()
                .response();
        // response.prettyPrint();
        ObjectMapper obj = new ObjectMapper();
        countries = obj.readValue(response.asString(), Country[].class);
        List<String> countryData = new ArrayList<>();
        for (int i = 0; i < countries.length; i++) {
            countryData.add(countries[i].getName());
        }
        System.out.println("Country names:" + countryData);

        WriteToTxt.saveDataInFileWithCountryName("Team60.txt", countries);
        List<String> readCountryName = returnCountryNameList("Team60.txt");

    }

    @Then("validate it is readable or not")
    public void validate_it_is_readable_or_not() {
        Assert.assertEquals(readCountryName, countryData);
        System.out.println("Test passed");
    }

    @Given("create country {string}")
    public void create_country(String end_point) {
        response = given().headers(
                "Authorization",
                "Bearer " + ConfigurationReader.getProperty("token"),
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON)
                .when().
                        body(CreateCountry4).
                        post(end_point)
                .then().
                        contentType(ContentType.JSON)
                .extract()
                .response();
        response.prettyPrint();
        //butun responsu jsonpath e atiyorum ve created olan id ve name e bakiyorum
        //expected data yi olusturuyoruz
        JsonPath jsonPath = response.jsonPath();
        jsonPathCreatName = jsonPath.getString("name");

        System.out.println("Created name is:" + jsonPathCreatName);

        response2 = given().headers(
                "Authorization",
                "Bearer " + ConfigurationReader.getProperty("token"),
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON)
                .when()
                .get(end_point)
                .then().
                        contentType(ContentType.JSON)
                .extract()
                .response();
        // response2.prettyPrint();

        JsonPath actualName = response2.jsonPath();
        actualCountryName = actualName.getString("name");

    }

    @Then("validate it is created or not")
    public void validate_it_is_created_or_not() {
        Assert.assertTrue(actualCountryName.contains(jsonPathCreatName));
        System.out.println("Created name matched succes");

    }

    @Then("update created a country using api end point {string}  {string} and its extension {string}")
    public void update_created_a_country_using_api_end_point_and_its_extension(String end_point, String name, String id) {
        Map<String, Object> updateCountry = new HashMap<>();
        updateCountry.put("id", id);
        updateCountry.put("name", name);
        updateCountry.put("states", null);
        updateresponse = given().headers(
                "Authorization",
                "Bearer " + ConfigurationReader.getProperty("token"),
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON)
                .when().
                        body(updateCountry).
                        put(end_point)
                .then().
                        contentType(ContentType.JSON)
                .extract()
                .response();
        updateresponse.prettyPrint();
        JsonPath jsonPath = updateresponse.jsonPath();
        expectedUpdateCountry = jsonPath.getString("name");
        System.out.println("Updated country name is: " + expectedUpdateCountry);

        response2 = given().headers(
                "Authorization",
                "Bearer " + ConfigurationReader.getProperty("token"),
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON)
                .when()
                .get(end_point)
                .then().
                        contentType(ContentType.JSON)
                .extract()
                .response();
        // response2.prettyPrint();
        JsonPath actualJsonPath = response2.jsonPath();
        actualUpdatedCountry = actualJsonPath.getString("name");
        System.out.println("====================================");
        System.out.println("Actual response name Data: " + actualUpdatedCountry);
    }

    @Then("validate it is updated or not")
    public void validate_it_is_updated_or_not() {
        Assert.assertTrue(actualUpdatedCountry.contains(expectedUpdateCountry));
        System.out.println("Validate was succes");
    }

    @Given("delete updated a country using endpoint {string} and its extension {string}")
    public void delete_updated_a_country_using_endpoint_and_its_extension(String end_point, String id) {
        response2 = given().headers(
                "Authorization",
                "Bearer " + ConfigurationReader.getProperty("token"),
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON)
                .when()
                .delete(end_point + id)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
        response = given().headers(
                "Authorization",
                "Bearer " + ConfigurationReader.getProperty("token"),
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON)
                .when()
                .get(end_point)
                .then().
                        contentType(ContentType.JSON)
                .extract()
                .response();

        JsonPath jsonPath = response.jsonPath();
        actualDeleteCountryId = jsonPath.getString("id");
        System.out.println("=====================================");
        System.out.println("after deleting country id are:" + actualDeleteCountryId);

    }

    @Given("validate it is deleted or not using {string}")
    public void validate_it_is_deleted_or_not_using(String id) {
        Assert.assertFalse(actualDeleteCountryId.contains(id));
        System.out.println("103638 was deleted");


    }

    @Given("user should create a connection with db using {string} , {string} and {string}")
    public void user_should_create_a_connection_with_db_using_and(String url, String username, String password) {
        createConnection(url, username, password);
    }

    @Given("user should read all countries data using {string} and {string}")
    public void user_should_read_all_countries_data_using_and(String query, String name) {

        countryList = getColumnData(query, name);
        System.out.println("country  list:" + countryList);
    }

    @Then("validates countries exist or not")
    public void validates_countries_exist_or_not() {
        expecetedCountryList = new ArrayList<>();
        expecetedCountryList.add("FRANCE");
        expecetedCountryList.add("ANGOLA");
        expecetedCountryList.add("USA");
        Assert.assertTrue(countryList.containsAll(expecetedCountryList));
        System.out.println("Database validation is succesful");
    }

    @Given("user should create a connection using {string} , {string} and {string}")
    public void user_should_create_a_connection_using_and(String url, String username, String password) {
        createConnection(url, username, password);
    }

    @Then("user should provide the query {string} and sees first ten country datas on pdf")
    public void user_should_provide_the_query_and_sees_first_ten_country_datas_on_pdf(String query) {
        List<Country> countryList = new ArrayList<>();
        List<List<Object>> lists = getQueryResultList(query);
        for (int i = 0; i < 10; i++) {
            Country country = new Country();
            country.setId(Integer.parseInt(lists.get(i).get(0).toString()));
            country.setName(lists.get(i).get(1).toString());

            countryList.add(country);
        }
        pdfGeneratorRowsAndCellsWithListFirstToTenForCountry("    Team60 Pdf Country List Name   ", countryList, "list.pdf");
    }


}
