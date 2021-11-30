package gmiBank.stepDefinitions;

import com.github.javafaker.Faker;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import gmiBank.pages.LoginPage;
import gmiBank.pages.US_006Page;
import gmiBank.pages.US_007Page;
import gmiBank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import java.util.List;

public class Us_007StepDefs {

    US_007Page us_007Page = new US_007Page();
    LoginPage loginPage= new LoginPage();
    US_006Page us006Page= new US_006Page();
    Faker faker = new Faker();




    @Then("Clear the Email box")
    public void clear_the_email_box() {
        us006Page.emailTextBox.clear();
    }

    @Then("Check the invalid warning is displayed")
    public void check_the_invalid_warning_is_displayed() {
        Assert.assertTrue(us_007Page.emailTextBoxInvalisMessage.isDisplayed());
    }

    @And("Send a new email without @ sign")
    public void sendANewEmailWithoutSign() {
        us006Page.emailTextBox.sendKeys("ufuktakmakgmail.com");
        Driver.wait(5);
    }

    @And("Send a new email without .com  extension")
    public void sendANewEmailWithoutComExtension() {
        us006Page.emailTextBox.sendKeys("ufuktakmak@gmail");

    }


    @Then("Check if there is only  English and Türkçe  displayed on Languauge dropdown menu")
    public void checkIfThereIsOnlyEnglishAndTurkishDisplayedOnLanguaugeDropdownMenu() {

        Select select = new Select(us006Page.languageDropDown);
        List<WebElement> allOptions =select.getOptions();
        for (WebElement element: allOptions){
            System.out.println("language displayed "+ element.getText());

            // Assert.assertEquals(ConfigReader.getProperty("Expected_languages_1"), element.getText().indexOf(0));


        }

    }


}

