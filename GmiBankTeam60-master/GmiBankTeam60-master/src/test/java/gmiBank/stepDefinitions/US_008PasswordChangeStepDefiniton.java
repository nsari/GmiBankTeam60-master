package gmiBank.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gmiBank.pages.US_008PasswordChangePage;
import gmiBank.utilities.ConfigurationReader;
import gmiBank.utilities.Driver;
import gmiBank.utilities.ReusableMetods;
import org.junit.Assert;

public class US_008PasswordChangeStepDefiniton {

US_003PasswordRestrictionStepDefinition us_003Page=new US_003PasswordRestrictionStepDefinition();
LogInStepDefinitions loginpage=new LogInStepDefinitions();
US_008PasswordChangePage us_008Page=new US_008PasswordChangePage();

    @Given("Go to the GMi Bank home page")
    public void go_to_the_GMi_Bank_home_page() {

        us_003Page.user_go_to_the_GMi_Bank_home_page();
    }

    @Given("click on user icon")
    public void click_on_user_icon() {
        us_003Page.user_click_on_user_icon();
    }

    @Given("sign in with a valid username and password")
    public void sign_in_with_a_valid_username_and_password() {
        us_008Page.we_signinmenu.click();
        us_008Page.we_username.sendKeys(ConfigurationReader.getProperty("gmi_username"));
        us_008Page.we_password.sendKeys(ConfigurationReader.getProperty("gmi_password"));
        us_008Page.we_signInSubmit.click();
    }

    @Then("Click on the password menu")
    public void click_on_the_password_menu() {
        //us_003Page.user_click_on_user_icon();
        us_008Page.we_008account_menu.click();
        ReusableMetods.waitFor(5);
        us_008Page.we_sifremenu.click();
    }


    @When("User enters the old password as new password")
    public void user_enters_the_old_password_as_new_password() {
        us_008Page.we_currentPassword.click();
        us_008Page.we_currentPassword.sendKeys("Simferopol1.");
        us_008Page.we_newPassword.click();
        us_008Page.we_newPassword.sendKeys("Simferopol1.");
        ReusableMetods.waitFor(5);

    }

    @Then("Check the fail message")
    public void check_the_fail_message() {

        us_008Page.we_confirmPassword.click();
        System.out.println(us_008Page.failMessageBox.getText());
        String failmessage = us_008Page.failMessageBox.getText();
        Assert.assertEquals("New password should be different from the current one.",failmessage );
        System.out.println("fail message calıştı");
    }

    @Given("user clicks password text box")
    public void user_clicks_password_text_box() {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmi_password_url"));

        us_008Page.we_newPassword.click();
        us_008Page.we_newPassword.clear();
        System.out.println("///////////////////");
    }
/*
    @Given("enters pwd_lowercase password")
    public void enters_pwd_lowercase_password() {

        us_008Page.we_newPassword.sendKeys("a.12345");
        System.out.println("***********************");

    }

    @Then("Observe the strenght bar changing")
    public void observe_the_strenght_bar_changing() {
        String strengthbarColor= us_008Page.we_008strengthbar5.getCssValue("background-color");
        System.out.println(us_008Page.we_008strengthbar5.getCssValue("background-color"));
        org.testng.Assert.assertTrue(strengthbarColor.contains("rgba(0, 255, 0, 1)"));
        System.out.println("///////////////////");

    }

    @Given("enters pwd_uppercase password")
    public void enters_pwd_uppercase_password() {

        us_008Page.we_newPassword.sendKeys("A");
    }

    @Given("enters pwd_digit password")
    public void enters_pwd_digit_password() {
        us_008Page.we_newPassword.sendKeys("1");

    }

    @Given("enters pwd_specialchar password")
    public void enters_pwd_specialchar_password() {
        us_008Page.we_newPassword.sendKeys(".");

    }

    @Given("user enters one uppercase, lowercase, digit and special char")
    public void user_enters_one_uppercase_lowercase_digit_and_special_char() {
        us_008Page.we_newPassword.sendKeys("Aa1.");

    }

    @Given("enters three more chars")
    public void enters_three_more_chars() {
        us_008Page.we_newPassword.sendKeys("2345");

    }

    @Then("Observe the strenght bar is yellow")
    public void observe_the_strenght_bar_is_yellow() {
        String strengthbarColor= us_008Page.we_008strengthbar5.getCssValue("background-color");
        System.out.println(us_008Page.we_008strengthbar5.getCssValue("background-color"));
        org.testng.Assert.assertTrue(strengthbarColor.contains("rgba(0, 255, 0, 1)"));
    }

    @Given("User enter current password in password box")
    public void user_enter_current_password_in_password_box() {
        us_008Page.we_password.sendKeys(ConfigurationReader.getProperty("gmi_password"));
    }

    @Given("User enter a valid new password in new password text box")
    public void user_enter_a_valid_new_password_in_new_password_text_box() {
        us_008Page.we_password.sendKeys(ConfigurationReader.getProperty("Ss1234."));

    }

    @Given("ser enter a valid new password confirmation password text box")
    public void ser_enter_a_valid_new_password_confirmation_password_text_box() {
        us_008Page.we_password.sendKeys(ConfigurationReader.getProperty("Ss1234."));

    }

    @Given("User click save button for password")
    public void user_click_save_button_for_password() {
        us_008Page.we_save.click();
    }

    @Then("Assert that pwd change is succeeded")
    public void assert_that_pwd_change_is_succeeded() {
        System.out.println("///////////////////");

    }
*/
}
