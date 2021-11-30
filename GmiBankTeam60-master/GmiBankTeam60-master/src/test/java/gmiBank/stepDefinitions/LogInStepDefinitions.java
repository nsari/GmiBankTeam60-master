package gmiBank.stepDefinitions;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmiBank.pages.LoginPage;
import gmiBank.utilities.ConfigurationReader;
import gmiBank.utilities.Driver;


public class LogInStepDefinitions {

    LoginPage logInPage=new LoginPage();

    @Given("User navigates go to {string}")
    public void user_navigates_go_to(String gmi_url) {
        Driver.getDriver().get(ConfigurationReader.getProperty(gmi_url));
    }

    @Given("User clicks on iconAccountMenu")
    public void user_clicks_on_iconAccountMenu() {
        logInPage.iconAccountMenu.click();
    }

    @Given("User clicks on  sigInHomePage button")
    public void user_clicks_on_sigInHomePage_button() {
        logInPage.signInhomePage.click();
    }

    @Given("User provides username")
    public void user_provides_username() {
      logInPage.usernameBox.sendKeys(ConfigurationReader.getProperty("user_username"));
    }

    @Given("User provides password")
    public void user_provides_password() {
        logInPage.passwordBox.sendKeys(ConfigurationReader.getProperty("user_password"));
    }

    @Then("User clicks on Sign in button")
    public void user_clicks_on_Sign_in_button() {
       logInPage.signInBtn.click();

    }


}
