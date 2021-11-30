package gmiBank.stepDefinitions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import cucumber.api.java.en.And;
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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static gmiBank.jsonModels.CountryJson.createCountry;
import static io.restassured.RestAssured.given;


@JsonIgnoreProperties(ignoreUnknown = true)
public class US_026StepDefinitions {

    Response response;
    Response responseNew;
    String token;
    US_020StepDefinitions us_020StepDefinitions = new US_020StepDefinitions();
    int createdCountryID;
    String updatedCountryName;


//    @Given("user enters to url to get token from {string}")
//    public void user_enters_to_url_to_get_token_from(String token_endpoint) {
//
//        String username = "team60_employee";
//        String password = "Team60employee.";
//
//        String token1=  "{\"username\" : \""+ username + "\",\n" +
//                "\"password\" : \""+ password + "\",\n" +
//                "\"rememberMe\" : false}";
//
//        token = given().headers("Content-Type", ContentType.JSON,"Accept",ContentType.JSON).
//                when().
//                body(token1).
//                post(token_endpoint).
//                then().
//                extract().
//                path("id_token");
//
//        System.out.println("token: " + token);
//
//    }

    @Then("read all countries and write country ids to txt using api endpoint {string}")
    public void read_all_countries_and_write_country_ids_to_txt_using_api_endpoint_bank(String api_endpoint) throws IOException {
        response = given().headers("Authorization",
                "Bearer " + ConfigurationReader.getProperty("token_US026"),
                "Content-Type",
                ContentType.JSON, "Accept", ContentType.JSON).
                when().
                get(api_endpoint).
                then().
                contentType(ContentType.JSON).
                extract().response();

//        response.prettyPrint();

        //1. asama : country id'lerini bir listin icine atalim
        List<String> countryId = new ArrayList<>();

        // objectmapper kullanarak deserilazition yapiyoruz
        ObjectMapper objectMapper = new ObjectMapper();
        Country[] country = objectMapper.readValue(response.asString(),Country[].class);

        // for dongusu ile tum country id lerini daha  once olusturdugumuz listin icine ekleyelim
        for (int i = 0; i< country.length; i++){
            countryId.add(String.valueOf(country[i].getId()));
        }
        System.out.println("All country ids are: " + countryId);

        Faker faker = new Faker();
        String countryFakerNames = faker.name().title();


        // country id'lerini txt dosyasi olaak yazdiralim

        WriteToTxt.saveDataInFileWithCountry6Id("US_026_CountryId",country);

        //id ve name ile write

        WriteToTxt.saveDataInFileWithCountryIdAndName("US_026_CountryNameAndId",country);

        // txt olarak yazdirdigimiz idleri readtxt uzerinden okutalim

       List<String> readtTxtCountryId = ReadToTxt.returnCountryIdList("US_026_CountryId");

        System.out.println("=====================================================");

        List<String> readTxtCountryIdANDName = ReadToTxt.returnCountryNameList("US_026_CountryNameAndId");

        // validasyon
        Assert.assertEquals("not matched",countryId,readtTxtCountryId);
        System.out.println("=======================");
        System.out.println("validation for reading country is successfully");



    }


    @And("user creates an country {string}")
    public void userCreatesAnCountry(String api_endpoint) {

        response= given().headers("Authorization",
                "Bearer " + ConfigurationReader.getProperty("token_US026"),
                "Content-type",ContentType.JSON, "Accept",ContentType.JSON).
                when().
                body(createCountry).
                post(api_endpoint).
                then().
                contentType(ContentType.JSON).
                extract().response();

//        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        int createdCountryID = jsonPath.getInt("id");

        System.out.println("==========================================");

        System.out.println("Created country Id: " + createdCountryID);//103614


    }

    @Then("validate created a country")
    public void validate_crated_a_country(){
        response = given().headers("Authorization",
                "Bearer "+ ConfigurationReader.getProperty("token_US026"),
                "Content-Type", ContentType.JSON,"Accept",ContentType.JSON).
                when().get("https://www.gmibank.com/api/tp-countries").
                then().
                contentType(ContentType.JSON).
                extract().response();

        JsonPath jsonPath = response.jsonPath();
        String strindids = jsonPath.getString("id");

        String stringcreatedCountryId = String.valueOf(createdCountryID);
        Assert.assertTrue("not comtains", strindids.contains(stringcreatedCountryId));
        System.out.println("validation for created country is successfully");
    }

    @Then("update created a country using api end point {string}  {string} and its extension {string}")
    public void update_created_a_country_using_api_end_point_and_its_extension(String api_endpoint, String name, String id) {
        Map<String,Object> putCountry = new HashMap<>();
        putCountry.put("id",id);
        putCountry.put("name",name);
        putCountry.put("states",null);

        responseNew = given().headers("Authorization",
                "Bearer " + ConfigurationReader.getProperty("token_US026"),
                "Content-Type",ContentType.JSON,"Accept",ContentType.JSON).
                when().
                body(putCountry).
                put(api_endpoint).
                then().
                contentType(ContentType.JSON).
                extract().response();

        responseNew.prettyPrint();

    }

    @Given("user validates this updated country with Api end point {string} {string} and its extension {string}")
    public void user_validates_this_updated_country_with_Api_end_point_and_its_extension(String api_endpoint, String name, String id) {

        responseNew =given().headers("Authorization",
                "Bearer "+ ConfigurationReader.getProperty("token_US026"),
                "Content-Type", ContentType.JSON,"Accept",ContentType.JSON).
                when().get("https://www.gmibank.com/api/tp-countries").
                then().
                contentType(ContentType.JSON).
                extract().response();

        responseNew.prettyPrint();

        JsonPath jsonPath = responseNew.jsonPath();
        String stringNames = jsonPath.getString("name");
        System.out.println(stringNames);
        String idNames = jsonPath.getString("id");
        updatedCountryName= name;
        createdCountryID= Integer.parseInt(id);

        Assert.assertTrue("not contain", stringNames.contains(updatedCountryName));
        System.out.println("Validation is succesfull foor id " + createdCountryID +" with " + updatedCountryName);



    }


}
