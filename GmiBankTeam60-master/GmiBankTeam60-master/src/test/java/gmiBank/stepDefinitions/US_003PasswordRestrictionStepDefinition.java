package gmiBank.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmiBank.pages.US_003PasswordRestrictionPage;
import gmiBank.utilities.ConfigurationReader;
import gmiBank.utilities.Driver;
import org.junit.Assert;


public class US_003PasswordRestrictionStepDefinition {

    US_003PasswordRestrictionPage us_003PasswordRestrictionPage=new US_003PasswordRestrictionPage();

    @Given("User go to the GMi Bank home page")
    public void user_go_to_the_GMi_Bank_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmi_url"));
    }


    @Given("User click on user icon")
    public void user_click_on_user_icon() {
        us_003PasswordRestrictionPage.we_account_menu.click();
    }

    @Given("User click on the registration menu")
    public void user_click_on_the_registration_menu() {
        us_003PasswordRestrictionPage.we_register_submit.click();
    }

    @Given("Click on New Password textbox")
    public void click_on_New_Password_textbox() {
        us_003PasswordRestrictionPage.we_password.click();
    }

    @Then("Assert that strenght bar is red")
    public void assert_that_strenght_bar_is_red() {
        String color="red";
        String strengthbarColor= us_003PasswordRestrictionPage.we_strengthbar1.getCssValue("background-color");
        System.out.println(strengthbarColor + color);
        Assert.assertTrue(strengthbarColor.contains("rgba(255, 0, 0, 1)"));

    }

    @Then("Enter a password with one uppercase letter")
    public void enter_a_password_with_one_uppercase_letter() {
        us_003PasswordRestrictionPage.we_password.sendKeys(ConfigurationReader.getProperty("gmi_password"));

    }

    @Then("Observe that strenght bar is yellow")
    public void observe_that_strenght_bar_is_yellow() {
        String strengthbarColor= us_003PasswordRestrictionPage.we_strengthbar3.getCssValue("background-color");
        System.out.println(us_003PasswordRestrictionPage.we_strengthbar3.getCssValue("background-color"));
        Assert.assertTrue(strengthbarColor.contains("rgba(255, 255, 0, 1)"));
    }

    @Then("Enter one lowercase letter to password test box")
    public void enter_one_lowercase_letter_to_password_test_box() {
        us_003PasswordRestrictionPage.we_password.sendKeys("a");
        System.out.println("copy çalıştı" + us_003PasswordRestrictionPage.we_password.getText());
    }

    @Then("Strength Bar must be green")
    public void strength_Bar_must_be_green() {
        String color="green";
        String strengthbarColor= us_003PasswordRestrictionPage.we_strengthbar5.getCssValue("background-color");
        System.out.println(us_003PasswordRestrictionPage.we_strengthbar5.getCssValue("background-color"));
        Assert.assertTrue(strengthbarColor.contains("rgba(0, 255, 0, 1)"));
    }

    @Then("Click on password confirmation textbox")
    public void click_on_password_confirmation_textbox() {
        us_003PasswordRestrictionPage.we_password1.click();
    }

    @Then("Copy new password text box value to new password confirmation texbox")
    public void copy_new_password_text_box_value_to_new_password_confirmation_texbox() {
        System.out.println("copy çalıştı" + us_003PasswordRestrictionPage.we_password.getText());
        us_003PasswordRestrictionPage.we_password1.sendKeys("Sİmferopol1.");

    }

}