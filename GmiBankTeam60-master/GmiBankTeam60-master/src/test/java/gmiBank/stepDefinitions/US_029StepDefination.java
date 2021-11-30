package gmiBank.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import java.util.List;

import static gmiBank.utilities.DatabaseUtil.createConnection;
import static gmiBank.utilities.DatabaseUtil.getColumnData;


public class US_029StepDefination {
    List<Object> list;



    @Given("database user creates a connection with database using {string} , {string} and {string}")
    public void databaseDersBankUserCreatesAConnectionWithDatabaseUsingAnd(String url, String user, String password) {

        createConnection(url,user,password);   //--1 islem  connection kurmak
    }

    @Then("user reads the customer data using {string} and {string}")
    public void user_reads_the_customer_data_using_and(String query, String ssn) {

        list= getColumnData(query,ssn);
        System.out.println("customers ssn Number : " + list.toString());


    }


    @Then("user validates customer data")
    public void user_validates_customer_data() {
        Assert.assertTrue(list.contains("123-30-1388"));
        System.out.println("====================================================");
        System.out.println("Validation is succesfull");

        System.out.println("====================================================");

    }

    @Then("user reads the country data using {string} and {string}")
    public void user_reads_the_country_data_using_and(String query, String id) {

        list =getColumnData(query,id);
        System.out.println("country id : " +list.toString());


    }




    @Then("user validates all country data")
    public void user_validates_all_country_data() {
        Assert.assertTrue(list.toString().contains("22322"));
        System.out.println("====================================================");
        System.out.println("Validation is succesfull");
        System.out.println("====================================================");

    }

    @Then("user reads the names of the state from USA {string} and {string}")
    public void user_reads_the_names_of_the_state_from_USA_and(String query, String state) {

        list= getColumnData(query,state);

        System.out.println("state name" +list.toString());



    }

    @Then("user validates the names of the state from USA data")
    public void user_validates_the_names_of_the_state_from_USA_data() {

        Assert.assertTrue(list.contains("New York"));
        Assert.assertTrue(list.contains("California"));
        System.out.println("Validation is succesfull");


    }



}


