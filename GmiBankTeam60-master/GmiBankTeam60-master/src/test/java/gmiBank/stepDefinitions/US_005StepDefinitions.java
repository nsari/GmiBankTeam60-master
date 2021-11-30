package gmiBank.stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmiBank.pages.US_005LoginPage;
import gmiBank.utilities.Driver;
import org.junit.Assert;

public class US_005StepDefinitions {
US_005LoginPage us_005LoginPage=new US_005LoginPage();

    @Given("user go to {string}")
    public void user_go_to(String string) {
        Driver.getDriver().get(string);
    }
    @Given("user click on username checkbox")
    public void user_click_on_username_checkbox() {
        us_005LoginPage.usernameBox.click();
    }
    @Given("user enter a invalid username")
    public void user_enter_a_invalid_username() {
        us_005LoginPage.usernameBox.sendKeys("qwert");
        Driver.wait(3);
    }
    @Given("user click on password checkbox")
    public void user_click_on_password_checkbox() {
        us_005LoginPage.passwordBox.click();
    }
    @Given("user enter a valid password")
    public void user_enter_a_valid_password() {
        us_005LoginPage.passwordBox.sendKeys("Team60user");
        Driver.wait(2);
    }
    @Given("user enter a valid username")
    public void user_enter_a_valid_username() {
        us_005LoginPage.usernameBox.sendKeys("team60user");
        Driver.wait(3);
    }
    @Given("user enter a invalid password")
    public void user_enter_a_invalid_password() {
        us_005LoginPage.passwordBox.sendKeys("qwert");
        Driver.wait(2);
    }
    @Then("user click on option to {string} to reset password")
    public void user_click_on_option_to_to_reset_password(String string) {
        us_005LoginPage.resetpassword.click();
        Driver.wait(2);
    }
    @Given("user click on option to {string} to register")
    public void user_click_on_option_to_to_register(String string) {
        // new Actions(Driver.getDriver()).doubleClick(us05Page.registernew);
        us_005LoginPage.registernew.click();
        Driver.wait(5);
    }

    @And("user click to account menu")

    public void userClickToAccountMenu() {
       us_005LoginPage.accountmenu.click();

    }

    @And("user click on sign in")
    public void userClickOnSignIn() {

        us_005LoginPage.signinmenu.click();
    }

    @And("user click on Sign in button")
    public void userClickOnSignInButton() {
        us_005LoginPage.signinButton.click();
    }

    @Then("verify if the user sign in")
    public void verifyIfTheUserSignIn() {
        Assert.assertTrue(us_005LoginPage.hata.isDisplayed());
    }
}

