package gmiBank.stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmiBank.pages.LoginPage;
import gmiBank.pages.US_009;
import gmiBank.pages.US_010;
import gmiBank.utilities.ConfigurationReader;
import gmiBank.utilities.Driver;
import gmiBank.utilities.ReusableMetods;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class US_010StepDefination {

    LoginPage loginPage = new LoginPage();
    US_009 us009 = new US_009();
    US_010 us010 = new US_010();
    @Given("User should navigate to {string}")
    public void user_should_navigate_to(String string) {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmi_url"));

    }

    @Given("User should login the gmibank")
    public void user_should_login_the_gmibank() {
        loginPage.loginExecution();
        loginPage.signInBtn.click();

    }

    @Given("User should create new customer")
    public void user_should_create_new_customer() {
        us009.createNewCostomerTest();

    }

    @Given("User should search the customer with ssn")
    public void user_should_search_the_customer_with_ssn() {
        us009.SSN.sendKeys(ConfigurationReader.getProperty("employee_SSN"));
        us009.searchButton.click();
    }


    @And("User should enter zipCode {string}")
    public void userShouldEnterZipCode(String Zip_Code) {
        us010.zipcode.sendKeys(ConfigurationReader.getProperty("Zip_Code"));
        ReusableMetods.waitFor(3);
    }

    @And("User sould enter Country {string}")
    public void userSouldEnterCountry(String Country ) {
        Select select = new Select(us010.country);
        select. selectByVisibleText("USA");                                     //selectByValue("1752");
                                                                                // us010.country.sendKeys(ConfigurationReader.getProperty(Country));

    }

    @And("User should enter State{string}")
    public void userShouldEnterState(String state) {
        us010.state.sendKeys(ConfigurationReader.getProperty(state));
    }

    @And("User should enter City {string}")
    public void userShouldEnterCity(String City) {

        us010.city1.sendKeys(ConfigurationReader.getProperty(City));

    }
}

