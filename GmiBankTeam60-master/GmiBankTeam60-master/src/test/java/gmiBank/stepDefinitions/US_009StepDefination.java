package gmiBank.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmiBank.pages.LoginPage;
import gmiBank.pages.US_009;
import gmiBank.utilities.ConfigurationReader;
import gmiBank.utilities.Driver;
import gmiBank.utilities.ReusableMetods;
import org.junit.Assert;

public class US_009StepDefination {

    LoginPage loginPage = new LoginPage();
    US_009 us009 = new US_009();

    @Given("User navigate to  {string}")
    public void user_navigate_to(String string) {

        Driver.getDriver().get(ConfigurationReader.getProperty("gmi_url"));
    }

    @Given("User should  login")
    public void user_should_login() {
        loginPage.loginExecution();

        ReusableMetods.waitFor(3);

    }

    @Given("User should  click My Opertions")


    public void user_should_click_My_Opertions() {

        us009.myOperations.click();
    }

    @Given("User should  select Manage Customers")
    public void user_should_select_Manage_Customers() {
        us009.manageCustomer.click();
    }

    @Given("User should  click Create a New Customer")
    public void user_should_click_Create_a_New_Customer() {
        us009.createNewCustomer.click();
    }

    @Given("User should  enter ssn")
    public void user_should_enter_ssn() {
        us009.SSN.sendKeys(ConfigurationReader.getProperty("employee_SSN"));
    }

    @Given("User should  click Search button")
    public void user_should_click_Search_button() {
        us009.searchButton.click();
    }

    @Given("User should  see success message")
    public void user_should_see_success_message() {
        ReusableMetods.waitFor(5);

        String message =us009.succesmessage.getText();

        System.out.println("Succes message : " +message);

        Assert.assertTrue(us009.succesmessage.isDisplayed());

    }

    @Given("User should  see firstname")
    public void user_should_see_firstname() {
        String actual = us009.firstname.getAttribute("value");
        System.out.println("Actual firstName : " +actual);
        String expected =ConfigurationReader.getProperty("firstname");
        System.out.println("Expected firstName : " + expected);

        Assert.assertEquals(expected,actual);

    }

    @Given("User should  see lastname")
    public void user_should_see_lastname() {
        String actual = us009.lastname.getAttribute("value");
        System.out.println("Actual lastName : " +actual);
        String expected =ConfigurationReader.getProperty("lastname");
        System.out.println("Expected lastName : " + expected);

        Assert.assertEquals(expected,actual);

    }

    @Given("User should  see Email")
    public void user_should_see_Email() {
        String actual = us009.email.getAttribute("value");
        System.out.println("Actual Email : " +actual);
        String expected =ConfigurationReader.getProperty("email1");
        System.out.println("Expected Email : " + expected);

        Assert.assertEquals(expected,actual);

    }

    @Given("User should  see mobile phone")
    public void user_should_see_mobile_phone() {
        String actual = us009.mobile.getAttribute("value");
        System.out.println("Actual mobile phone : " +actual);
        String expected =ConfigurationReader.getProperty("mobilePhone");
        System.out.println("Expected mobile phone : " + expected);

        Assert.assertEquals(expected,actual);
    }

    @Given("User should  see Adress")
    public void user_should_see_Adress() {
        String actual = us009.adress.getAttribute("value");
        System.out.println("Actual adress : " +actual);
        String expected =ConfigurationReader.getProperty("address");
        System.out.println("Expected adress : " + expected);

        Assert.assertEquals(expected,actual);

    }

    @Then("User should  see Create Date")
    public void user_should_see_Create_Date() {
        String actual = us009.createDate.getAttribute("value");
        System.out.println("Actual date : " +actual);
        String expected = ConfigurationReader.getProperty("createDate");
        System.out.println("Expected date : " + expected);

        Assert.assertEquals(expected,actual);
    }



}

