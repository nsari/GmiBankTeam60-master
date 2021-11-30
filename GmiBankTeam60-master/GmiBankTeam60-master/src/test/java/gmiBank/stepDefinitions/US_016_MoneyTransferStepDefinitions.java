package gmiBank.stepDefinitions;

import cucumber.api.java.en.Then;
import gmiBank.pages.US_016_Page_Money_Transfer;
import gmiBank.utilities.ConfigurationReader;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class US_016_MoneyTransferStepDefinitions {

    US_016_Page_Money_Transfer us_016_page = new US_016_Page_Money_Transfer();

//    @Given("User on the home page {string}")
//    public void user_on_the_home_page(String string) {
//        Driver.getDriver().get(ConfigurationReader.getProperty("gmi_url"));
//
//    }
//
//    @Then("User clicks menu icon")
//    public void user_clicks_menu_icon() {
//        us_016_page.iconAccountMenu.click();
//
//    }
//
//    @Then("User navigates to SignIn page")
//    public void user_navigates_to_Login_page() {
//        us_016_page.signInHomePage.click();
//    }

//    @Then("User enter valid {string}")
//    public void user_enter_valid(String username) {
//        us_016_page.usernameBox.sendKeys(ConfigurationReader.getProperty("Us_016_username1"));
//
//    }
//
//    @Then("User enters valid {string}")
//    public void user_enters_valid(String password) {
//        us_016_page.passwordBox.sendKeys(ConfigurationReader.getProperty("Us_016_password1"));
//
//    }
//
//    @Then("User cliks sign in button")
//    public void user_cliks_sign_in_button() {
//        us_016_page.signInButton.click();
//
//    }
//
//    @Then("User clicks My Opertions")
//    public void user_clicks_My_Opertions() {
//        us_016_page.myOperations.click();
//    }

    @Then("Verifies that user has two account")
    public void verifies_that_user_has_two_account() {
        Assert.assertTrue(us_016_page.theFirstAccount.isEnabled());
        Assert.assertTrue(us_016_page.theSecondAccount.isEnabled());
    }


    @Then("User clicks Money Transfer")
    public void user_clicks_Money_Transfer() {
        us_016_page.transferMoney.click();

    }

    @Then("User selects account from dropdown menu")
    public void user_selects_account_from_dropdown_menu() throws InterruptedException {

        Thread.sleep(2000);
        Select select = new Select(us_016_page.fromTexBoxOfMoneyTransfer);
        select.selectByIndex(1);

    }

    @Then("User selects account from the to drop-down menu")
    public void user_selects_account_from_the_to_drop_down_menu() {
        Select select = new Select(us_016_page.toTextBoxOfMoneyTransfer);
        select.selectByIndex(1);

    }

    @Then("User enters {string} in the balance text box")
    public void user_enters_in_the_balance_text_box(String balanceOfTransfer) {

        us_016_page.balanceTexBoxOfMoneyTransfer.sendKeys(ConfigurationReader.getProperty("amountOfTransfer1"));
    }

    @Then("User enters {string} in the description text box")
    public void user_enters_in_the_description_text_box(String description) {
        us_016_page.descriptionTextBoxOfMoneyTransfer.sendKeys(ConfigurationReader.getProperty("descriptionOfTransfer1"));

    }

    @Then("User click Make Transfer icon")
    public void user_click_Make_Transfer_icon() {
        us_016_page.makeTrasferButton.click();

    }

    @Then("Assert  visible text")
    public void assert_visible_text() {
        Assert.assertTrue(us_016_page.textOfTransferSuccesfull.isDisplayed());

    }
}
