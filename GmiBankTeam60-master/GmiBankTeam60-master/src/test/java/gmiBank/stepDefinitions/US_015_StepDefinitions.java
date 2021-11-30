package gmiBank.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmiBank.pages.US_015_Page;
import gmiBank.utilities.ConfigurationReader;
import gmiBank.utilities.Driver;
import org.junit.Assert;

public class US_015_StepDefinitions {

    US_015_Page us_015_page = new US_015_Page();


    @Given("User on the home page {string}")
    public void user_on_the_home_page(String string) {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmi_url"));

    }

    @Then("User clicks menu icon")
    public void user_clicks_menu_icon() {
        us_015_page.iconAccountMenu.click();

    }

    @Then("User navigates to SignIn page")
    public void user_navigates_to_Login_page() {
        us_015_page.signInhomePage.click();
    }

    @Then("User enter valid {string}")
    public void user_enter_valid(String username) {
        us_015_page.usernameBox.sendKeys(ConfigurationReader.getProperty("Us_015_username"));

    }

    @Then("User enters valid {string}")
    public void user_enters_valid(String password) {
        us_015_page.passwordBox.sendKeys(ConfigurationReader.getProperty("Us_015_password"));

    }

    @Then("User cliks sign in button")
    public void user_cliks_sign_in_button() {
        us_015_page.signInButton.click();

    }

    @Then("User clicks My Opertions")
    public void user_clicks_My_Opertions() {
        us_015_page.myOperations.click();
        Driver.wait(2);
    }

    @Then("User cliks My Accounts")
    public void user_cliks_My_Accounts() {
        us_015_page.myAccounts.click();
    }

    @Then("User clicks View Transfer")
    public void user_clicks_View_Transfer() {
        us_015_page.viewTransaction1.click();
    }

    @Then("User verifies that Transfer transactions are displayed")
    public void user_verifies_that_Transfer_transactions_are_displayed() {
        Assert.assertTrue(us_015_page.birinciTransferBilgileri.isDisplayed());

    }

    @Then("User close driver")
    public void user_close_driver() {
        Driver.closeDriver();
    }

    @Then("User verifies account type")
    public void user_verifies_account_id() {
        Assert.assertTrue(us_015_page.accountType.isDisplayed());

    }

    @Then("User verifies balance populated")
    public void user_verifies_balance_populated() {
        Assert.assertTrue(us_015_page.accountBalance.isDisplayed());

    }

}
