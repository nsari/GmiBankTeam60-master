package gmiBank.stepDefinitions;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmiBank.pages.US_001RegistrationPage;
import gmiBank.pages.US_002;
import gmiBank.utilities.ConfigurationReader;
import gmiBank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.NoSuchElementException;

public class US_002StepDefinition {
    US_002 us_002=new US_002();

    @Given("User go to  URL")
    public void user_go_to_URL() {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmi_url"));

    }

    @Given("User clicks on  icon")
    public void user_clicks_on_icon() {
    us_002.icon.click();

    }

    @Given("User click on the ssnTextBox")
    public void user_click_on_the_ssnTextBox() {
    us_002.ssnTextBox.click();

    }

    @Given("User does not enter the SSNTextBox")
    public void user_does_not_enter_the_SSNTextBox() {
    us_002.ssnTextBox.sendKeys(" ", Keys.ENTER);

    }

    @Then("User see an SSN error message")
    public void userSeeAnSSNErrorMessage() {
        Assert.assertTrue(us_002.SSNerrorMessage.isDisplayed());
    }




    @Given("User click on the firstNameTextBox")
    public void user_click_on_the_firstNameTextBox() {
        us_002.firstNameTextBox.click();

    }

    @Given("User does not enter the firstNameTextBox")
    public void user_does_not_enter_the_firstNameTextBox() {
    us_002.firstNameTextBox.sendKeys(" ",Keys.ENTER);

    }

    @Then("User see an firstname error message")
    public void userSeeAnFirstnameErrorMessage() {
        Assert.assertTrue(us_002.firstnameErrorMessage.isDisplayed());
    }



    @Given("User click on the lastNameTextBox")
    public void user_click_on_the_lastNameTextBox() {
    us_002.lastNameTextBox.click();

    }

    @Given("User does not enter the lastNameTextBox")
    public void user_does_not_enter_the_lastNameTextBox() {
    us_002.lastNameTextBox.sendKeys(" ",Keys.ENTER);

    }

    @Then("User see an lastname error message")
    public void userSeeAnLastnameErrorMessage() {
        Assert.assertTrue(us_002.lastnameErrorMessage.isDisplayed());
    }


    @Given("User click on the adresTextBox")
    public void user_click_on_the_adresTextBox() {
    us_002.adresTextBox.click();

    }

    @Given("User does not enter the adresTextBox")
    public void user_does_not_enter_the_adresTextBox() {
     us_002.adresTextBox.sendKeys(" ",Keys.ENTER);
    }
    @Then("User see an adres error message")
    public void userSeeAnAdresErrorMessage() {
        Assert.assertTrue(us_002.adresErrorMessage.isDisplayed());
    }


    @Given("User click on the phoneNumberTextBox")
    public void user_click_on_the_phoneNumberTextBox() {
     us_002.mobilPhoneNumberTextBox.click();

    }

    @Given("User does not enter the phoneNumberTextBox")
    public void user_does_not_enter_the_phoneNumberTextBox() {
    us_002.mobilPhoneNumberTextBox.sendKeys(" ",Keys.ENTER);

    }

    @Then("User see an phoneNumber error message")
    public void userSeeAnPhoneNumberErrorMessage() {
        Assert.assertTrue(us_002.phoneNumberErrorMessage.isDisplayed());
    }

    @Given("User click on the userNameTextBox")
    public void user_click_on_the_userNameTextBox() {
    us_002.userNameTextBox.click();

    }

    @Given("User does not enter the userNameTextBox")
    public void user_does_not_enter_the_userNameTextBox() {
    us_002.userNameTextBox.sendKeys(" ",Keys.ENTER);

    }

    @Then("User see an userName error message")
    public void userSeeAnUserNameErrorMessage() {
        Assert.assertTrue(us_002.usernameErrorMessage.isDisplayed());
    }

    @Given("User click on the emailTextBox")
    public void user_click_on_the_emailTextBox() {
    us_002.emailTextBox.click();

    }

    @Given("User does not enter the emailTextBox")
    public void user_does_not_enter_the_emailTextBox() {
    us_002.emailTextBox.sendKeys(" ",Keys.ENTER);

    }

    @Then("User see an email error message")
    public void userSeeAnEmailErrorMessage() {
        Assert.assertTrue(us_002.emailErrorMessage.isDisplayed());
    }

    @Given("User click on the newPasswordTextBox")
    public void user_click_on_the_newPasswordTextBox() {
    us_002.newPassword.click();

    }

    @Given("User does not enter the newPasswordTextBox")
    public void user_does_not_enter_the_newPasswordTextBox() {
     us_002.newPassword.sendKeys(" ",Keys.ENTER);

    }

    @Then("User see a newPassword error message")
    public void userSeeANewPasswordErrorMessage() {
        Assert.assertTrue(us_002.newPassword.isDisplayed());
    }

    @Given("User click on the newPasswordConfirmation")
    public void user_click_on_the_newPasswordConfirmation() {
     us_002.newPasswordConfirmation.click();

    }

    @Given("User does not enter the newPasswordConfirmation")
    public void user_does_not_enter_the_newPasswordConfirmation() {
     us_002.newPasswordConfirmation.sendKeys(" ",Keys.ENTER);

    }

    @Then("User see a passwordConfirmation error message")
    public void userSeeAPasswordConfirmationErrorMessage() {
        Assert.assertTrue(us_002.newPasswordConfirmation.isDisplayed());
    }

    @Given("User click on the SSNTextBox")
    public void user_click_on_the_SSNTextBox() {
    us_002.ssnTextBox.click();

    }

    @Given("User enter an SSNnumber with chars or specific chars")
    public void user_enter_an_SSNnumber_with_chars_or_specific_chars() {
    us_002.ssnTextBox.sendKeys("123-@4-5*67",Keys.ENTER);
    }

    @Then("User see an invalid SSN error message")
    public void userSeeAnInvalidSSNErrorMessage() {
        Assert.assertTrue(us_002.invalidSSNMessage.isDisplayed());
    }

    @Given("User click on the phoneTextBox")
    public void user_click_on_the_phoneTextBox() {
     us_002.mobilPhoneNumberTextBox.click();

    }

    @Given("User enter a mobilePhoneNumber with chars or spesific chars")
    public void user_enter_a_mobilePhoneNumber_with_chars_or_spesific_chars() {
    us_002.mobilPhoneNumberTextBox.sendKeys("123a456@7890",Keys.ENTER);

    }

    @Then("User see an invalid mobilePhoneNumber error message")
    public void userSeeAnInvalidMobilePhoneNumberErrorMessage() {
        Assert.assertTrue(us_002.invalidPhoneNumberMessage.isDisplayed());
    }

    @And("User clicks on emailTextBox")
    public void userClicksOnEmailTextBox() {
    }

    @Given("User enter an email without @ and . extensions")
    public void user_enter_an_email_without_and_extensions() {
        us_002.emailTextBox.sendKeys("peter60gmailcom",Keys.ENTER);
    }


    @Then("User see an invalid email error message")
    public void userSeeAnInvalidEmailErrorMessage() {
      Assert.assertTrue(us_002.invalidEmailMessage.isDisplayed());
    }
}
