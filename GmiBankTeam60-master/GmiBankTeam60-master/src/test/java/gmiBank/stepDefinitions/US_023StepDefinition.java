package gmiBank.stepDefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmiBank.pojos.Registration;
import gmiBank.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class US_023StepDefinition {
    Response response;
    @Given("Read all registrants you created and validate them from your data set {string}")
    public void readAllRegistrantsYouCreatedAndValidateThemFromYourDataSet(String endPointAllAplicant) throws IOException {

        response = given().headers("Authorization",
                "Bearer "+ ConfigurationReader.getProperty("token"),
                "ContentType.Json", ContentType.JSON,
                "Accept",ContentType.JSON)
                .when()
                .get(ConfigurationReader.getProperty(endPointAllAplicant))
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();

        response.prettyPrint();

    }

    @Then("Read all registrants you created and validate them one by one")
    public void readAllRegistrantsYouCreatedAndValidateThemOneByOne() throws IOException {

        ObjectMapper objectMapper=new ObjectMapper();
        Registration[] registration= objectMapper.readValue(response.asString(),
                Registration[].class);

        List<String> SSNlist= new ArrayList<>();
        for (int i=0 ; i<registration.length; i++) {
            SSNlist.add(String.valueOf(registration[i].getSsn()));
        }
        //System.out.println(SSNlist);
        List<String> expectedSSNlist= new ArrayList<>();
        expectedSSNlist.add("800-73-7373");
        expectedSSNlist.add("754-58-4587");
        expectedSSNlist.add("125-58-4587");
        expectedSSNlist.add("148-54-4587");
        expectedSSNlist.add("795-58-4597");
        Assert.assertTrue("SSN ler eslesmedi",SSNlist.containsAll(expectedSSNlist));
        System.out.println("SSN ler eslesti");

    }
}
