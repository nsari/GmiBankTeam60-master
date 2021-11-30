package gmiBank.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmiBank.pages.US_001RegistrationPage;
import gmiBank.utilities.ConfigurationReader;
import gmiBank.utilities.Driver;
import org.junit.Assert;

import java.util.NoSuchElementException;

public class US_001RegistrationStepDefinition {
    US_001RegistrationPage us_001=new US_001RegistrationPage();
    @Given("User go to URL")
    public void user_go_to_URL() {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmi_url"));

    }

    @Given("User clicks on icon")
    public void user_clicks_on_icon() {
        us_001.icon.click();
    }

    @Given("User clicks on registerButton")
    public void user_clicks_on_registerButton() {
        us_001.registerButton.click();
    }

    @Given("User Click on SSN textBox")
    public void user_Click_on_SSN_textBox() {
        us_001.ssnTextBox.click();
    }

    @Given("User Enter the SSN number")
    public void user_Enter_the_SSN_number() {
        us_001.ssnTextBox.sendKeys(ConfigurationReader.getProperty("SSNnumber"));
    }

    @Then("User ssn should be valid")
    public void user_ssn_should_be_valid() {
      String actuelSSN=us_001.ssnTextBox.getAttribute("value");
      String expectedSSN=ConfigurationReader.getProperty("SSNnumber");
      Assert.assertEquals(expectedSSN,actuelSSN);
    }

    @Given("User click on nameTextBox")
    public void user_click_on_nameTextBox() {
       us_001.firstNameTextBox.click();
    }

    @Given("Enter {string}")
    public void enter(String string) {
       us_001.firstNameTextBox.sendKeys(ConfigurationReader.getProperty(string));
    }

    @Then("User firstName should be valid")
    public void user_firstName_should_be_valid() {
        String actuelFirstName=us_001.firstNameTextBox.getAttribute("value");
        String expectedFirstName=ConfigurationReader.getProperty("firstName");
        Assert.assertEquals(expectedFirstName,actuelFirstName);
    }

    @Given("User click on lastNameTextBox")
    public void user_click_on_lastNameTextBox() {
        us_001.lastNameTextBox.click();
    }

    @Given("User Enter {string}")
    public void user_Enter(String string) {
       us_001.lastNameTextBox.sendKeys(ConfigurationReader.getProperty("lastName"));
    }

    @Then("User lastName should be valid")
    public void user_lastName_should_be_valid() {
        String actuelLastName=us_001.lastNameTextBox.getAttribute("value");
        String expectedLastName=ConfigurationReader.getProperty("lastName");
        Assert.assertEquals(expectedLastName,actuelLastName);

    }

    @Given("User clicks on adresTextBox")
    public void user_clicks_on_adresTextBox() {
        us_001.adresTextBox.click();
    }

    @Given("User Enter the adres")
    public void user_Enter_the_adres() {
        us_001.adresTextBox.sendKeys(ConfigurationReader.getProperty("adress"));
    }

    @Then("User adres should be valid")
    public void user_adres_should_be_valid() {
        String actuelAdres=us_001.adresTextBox.getAttribute("value");
        String expectedAdres=ConfigurationReader.getProperty("adress");
        Assert.assertEquals(expectedAdres,actuelAdres);
    }

    @Given("User clicks on mobilPhoneNumber")
    public void user_clicks_on_mobilPhoneNumber() {
        us_001.mobilPhoneNumberTextBox.click();
    }

    @Given("User Enter the mobilePhoneNumber")
    public void user_Enter_the_mobilePhoneNumber() {
        us_001.mobilPhoneNumberTextBox.sendKeys(ConfigurationReader.getProperty("mobilePhoneNumber"));
    }


    @Then("User mobilePhoneNumber should be valid")
    public void userMobilePhoneNumberShouldBeValid() {
        String actuelMobilePhoneNumber=us_001.mobilPhoneNumberTextBox.getAttribute("value");
        String expectedMobilePhoneNumber=ConfigurationReader.getProperty("mobilePhoneNumber");
    }

    @Given("User click on userNameTextBox")
    public void user_click_on_userNameTextBox() {us_001.userNameTextBox.click();

    }

    @Given("User Enter the userName")
    public void user_Enter_the_userName() {
       us_001.userNameTextBox.sendKeys(ConfigurationReader.getProperty("userName"));
    }


    @Then("User userName should be valid")
    public void user_userName_should_be_valid() {
        String actuelUserName=us_001.userNameTextBox.getAttribute("value");
        String expectedUserName=ConfigurationReader.getProperty("userName");
        Assert.assertEquals(expectedUserName,actuelUserName);

    }

    @Given("User click on emailTextBox")
    public void user_click_on_emailTextBox() {
       us_001.emailTextBox.click();

    }

    @Given("User Enter the email")
    public void user_Enter_the_email() {
        us_001.emailTextBox.sendKeys(ConfigurationReader.getProperty("email"));
    }

    @Then("User email should be valid")
    public void user_email_should_be_valid() {
        String actuelEmail=us_001.emailTextBox.getAttribute("value");
        String expectedEmail=ConfigurationReader.getProperty("email");
        Assert.assertEquals(expectedEmail,actuelEmail);
    }

    @Then("User click on newPassword")
    public void user_click_on_newPassword() {
    us_001.newPassword.click();
    }

    @Then("User enter the newPassword")
    public void user_enter_the_password() {
    us_001.newPassword.sendKeys(ConfigurationReader.getProperty("newPassword"));
    }

    @Then("User click on newPasswordConfirmation")
    public void user_click_on_passwordConfirmation() {
     us_001.newPasswordConfirmation.click();

    }

    @Then("User enter the newPasswordConfirmation")
    public void userEnterTheNewPasswordConfirmation() {
        us_001.newPasswordConfirmation.sendKeys(ConfigurationReader.getProperty("newPasswordConfirmation"));
    }

    @Then("user click on registerButtonLast")
    public void user_click_on_registerButtonLast() {
    us_001.RegisterButtonLast.click();
    }



}
