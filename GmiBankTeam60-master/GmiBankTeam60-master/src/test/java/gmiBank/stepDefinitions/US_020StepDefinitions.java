package gmiBank.stepDefinitions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmiBank.pojos.Customer;
import gmiBank.utilities.ConfigurationReader;
import gmiBank.utilities.ReadToTxt;
import gmiBank.utilities.WriteToTxt;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;


@JsonIgnoreProperties(ignoreUnknown = true)
public class US_020StepDefinitions {

    Response response;
    Customer[] customer;
    String customerDatasNames;
    String readCustomerNames;
    String token;
    String customerFakerNames;

    @Given("user enters to url to get token {string}")
    public void userEntersToUrlToGetToken(String token_endpoint) {
        String token1 = "{\n" +
                "    \"username\" : \"team60_employee\",\n" +
                "    \"password\" : \"Team60employee.\",\n" +
                "    \"rememberMe\" : false\n" +
                "}";

        token = RestAssured.given().headers("Content-Type",
                ContentType.JSON, "Accept", ContentType.JSON)
                .when()
                .body(token1)
                .post(token_endpoint)
                .then()
                .extract()
                .path("id_token");

        System.out.println("token: " + token);

    }


    @Then("Read all customers using with api endpoint {string}")
    public void readAllCustomersUsingWithApiEndpoint(String api_endpoint) throws IOException {

        response = given().headers("Authorization",
                "Bearer " + token,
                "ContentType.Json", ContentType.JSON, "Accept", ContentType.JSON)
                .when()
                .get(api_endpoint).then()
                .contentType(ContentType.JSON).extract().response();
        //  response.prettyPrint();

        //response dan gelen cevabi object mapper ile java diline cevirdik
        ObjectMapper objectMapper = new ObjectMapper();
        //customer icine attik, pojo classimizi kullandik.
        customer = objectMapper.readValue(response.asString(), Customer[].class);
        //name datalarimizi listemizin icine aticaz
        List<String> customerDataNames = new ArrayList<>();


        for (int i = 0; i < customer.length; i++) {
            customerDataNames.add(customer[i].getFirstName());
        }

        System.out.println("all customer names :" + customerDataNames);


       //dosyalara kendisi yeni isimler veriyor
      Faker faker = new Faker();
        customerFakerNames = faker.name().title();

        //dosyamiza isimleri yazdiralim
       WriteToTxt.saveDataInFileWithCustomerFirstName(customerFakerNames,customer);
        //isimleri okutalim, assertion icin mutlaka okutmamiz gerek
        List<String> readcustomerNames = ReadToTxt.returnCountryNameList(customerFakerNames);

    }

        @And("validate customer datas")
    public void validateCustomerDatas() {
        //okuttugum dosyada isimlerim var mi?
        Assert.assertEquals(customerDatasNames,readCustomerNames);
        System.out.println("passed");

    }

    @Given("read customer datas using api endpoint {string}")
    public void readCustomerDatasUsingApiEndpoint(String api_endpoint) {
        response = given().headers("Authorization",
                "Bearer " + ConfigurationReader.getProperty("token"),
                "ContentType.Json", ContentType.JSON, "Accept", ContentType.JSON)
                .when()
                .get(api_endpoint).then()
                .contentType(ContentType.JSON).extract().response();
          response.prettyPrint();
    }

    @Then("validate customers one by one")
    public void validateCustomersOneByOne() {

        JsonPath jsonPath = response.jsonPath();
        String customerNames = jsonPath.getString("firstName");
        System.out.println("customerNames : "+customerNames);
        Assert.assertTrue("not found",customerNames.contains("Nikita"));

        String customerLastName = jsonPath.getString("lastName");
        System.out.println("customerLastName :"+customerLastName);
         Assert.assertTrue("not found", customerLastName.contains("Ernser"));

        System.out.println("passed");

    }


}




