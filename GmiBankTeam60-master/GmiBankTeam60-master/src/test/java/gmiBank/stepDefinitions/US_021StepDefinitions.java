package gmiBank.stepDefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.sun.tools.jxc.ConfigReader;
import cucumber.api.java.en.Then;

import gmiBank.pojos.Country;
import gmiBank.utilities.ConfigurationReader;
import gmiBank.utilities.ReadToTxt;

import gmiBank.utilities.WriteToTxt;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;




public class US_021StepDefinitions {
    Faker faker=new Faker();
    String readTxtCountryNames;
    String countrynames;
   Country[] countries;



    @Then("Read all countries using with api endpoint {string}")
    public void read_all_countries_using_with_api_endpoint(String api_endpoint) throws IOException {
        Response response = given().headers(
                "Authorization",
                "Bearer " + ConfigurationReader.getProperty("token"),
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON)
                .when()
                .get(ConfigurationReader.getProperty(api_endpoint))
                .then().
                        contentType(ContentType.JSON)
                .extract()
                .response();

        response.prettyPrint();

        List<String> countrynames = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        countries = objectMapper.readValue(response.asString(), Country[].class);


        for (int i=0; i<countries.length; i++){
            countrynames.add((countries[i].getName()));
        }
        System.out.println(countrynames);

        String countryNamesFaker=faker.name().title();
        WriteToTxt.saveDataInFileWithCountry6Name(countryNamesFaker,countries);

        List<String> readTxtCountryNames= ReadToTxt.returnCountry6NameList(countryNamesFaker);
    }


    @Then("validate countries")
    public void validate_countries() {
        Assert.assertEquals(readTxtCountryNames,countrynames);
        System.out.println("===============");
        System.out.println("validated succesfully");
    }
}
