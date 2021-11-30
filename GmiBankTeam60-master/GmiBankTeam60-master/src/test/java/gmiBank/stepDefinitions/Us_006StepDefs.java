package gmiBank.stepDefinitions;

import com.github.javafaker.Faker;
import com.sun.tools.jxc.ConfigReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmiBank.pages.LoginPage;
import gmiBank.pages.US_006Page;
import gmiBank.utilities.ConfigurationReader;
import gmiBank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Us_006StepDefs {
    US_006Page us_006Page = new US_006Page();
    LoginPage loginPage= new LoginPage();
    Faker faker = new Faker();

    @Given("Navigate go to {string}")
    public void navigate_go_to(String gmi_url) {
        Driver.getDriver().get(ConfigurationReader.getProperty(gmi_url));
    }

    @Given("Log in")
    public void log_in() {
        loginPage.loginExecution();
    }


    @Then("Check if the First Name item is displayed")
    public void check_if_the_first_name_item_is_displayed() {
        Assert.assertTrue(us_006Page.firstNameItem.isDisplayed());
        System.out.println("First Name item is displayed");

    }
    @Then("Check if the Last Name item is displayed")
    public void check_if_the_last_name_item_is_displayed() {
        Assert.assertTrue(us_006Page.lastNameItem.isDisplayed());
        System.out.println("Last Name item is displayed");

    }
    @Then("Check if the Email item is displayed")
    public void check_if_the_email_item_is_displayed() {
        Assert.assertTrue(us_006Page.emailItem.isDisplayed());
        System.out.println("email item is displayed");
    }
    @Then("Check if the Language item is displayed")
    public void check_if_the_language_item_is_displayed() {
        Assert.assertTrue(us_006Page.languageItem.isDisplayed());
        System.out.println("Language item is displayed");

    }
    @Then("Check if English is displayed on Languauge dropdown menu")
    public void check_if_english_is_displayed_on_languauge_dropdown_menu() {
        WebElement dropDownBox= us_006Page.languageDropDown;
        Select dropDownList= new Select(dropDownBox) ;
        dropDownList.selectByVisibleText("English");
        System.out.println(dropDownList.getFirstSelectedOption().getText());





    }
    @Then("Check if Turkish is displayed on Language dropdown menu")
    public void check_if_turkish_is_displayed_on_language_dropdown_menu() {
        WebElement dropDownBox= us_006Page.languageDropDown;
        Select dropDownList= new Select(dropDownBox) ;
        dropDownList.selectByVisibleText("Türkçe");
        System.out.println(dropDownList.getFirstSelectedOption().getText());


    }
    @Then("Delete the name in the First Name box")
    public void delete_the_name_in_the_first_name_box() {
        us_006Page.firstTextBox.clear();
    }
    @Then("Send a new name to the First Name box")
    public void send_a_new_name_to_the_first_name_box() {
        us_006Page.firstTextBox.sendKeys(faker.name().firstName());
    }
    @Then("Click on the Save button")
    public void click_on_the_save_button() {
        us_006Page.saveButton.click();
    }
    @Then("Check  if the successful popup message is displayed")
    public void check_if_the_successful_popup_message_is_displayed() {
        Assert.assertTrue(us_006Page.successToastMessage.isDisplayed());
        System.out.println("Succes Mesaji alindi");

    }
    @Then("Delete the last name in the Last Name box")
    public void delete_the_last_name_in_the_last_name_box() {
        us_006Page.lastTextBox.clear();
    }
    @Then("Send a new last name to theLast Name box")
    public void send_a_new_last_name_to_the_last_name_box() {
        us_006Page.lastTextBox.sendKeys(faker.name().lastName());
    }

    @Then("Delete the email in the Email box")
    public void delete_the_email_in_the_email_box() {
        Driver.wait(2);
        us_006Page.emailTextBox.click();
        Driver.wait(2);
        us_006Page.emailTextBox.clear();
        Driver.wait(3);
    }
    @Then("Send a new email to the Email box adding {string} sign and {string} extension")
    public void send_a_new_email_to_the_email_box_adding_sign_and_extension(String string, String string2) {
        us_006Page.emailTextBox.sendKeys(faker.internet().emailAddress());
    }

    @Then("Click user info item")
    public void clickUserInfoItem() {
        us_006Page.userInfoiItem.click();
    }

    @Then("Click user name icon")
    public void clickUserNameIcon() {
        us_006Page.userNameIcon.click();
    }
}

