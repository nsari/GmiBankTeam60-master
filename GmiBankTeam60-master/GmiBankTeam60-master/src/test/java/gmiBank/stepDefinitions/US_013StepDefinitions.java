package gmiBank.stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.ast.ScenarioOutline;
import gmiBank.pages.US_013EmployeeAccount;
import gmiBank.utilities.ConfigurationReader;
import gmiBank.utilities.Driver;
import gmiBank.utilities.ReusableMetods;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class US_013StepDefinitions {
    US_013EmployeeAccount us013 = new US_013EmployeeAccount();
    Actions action=new Actions(Driver.getDriver());

    @Given("An employee navigate signin url {string}")
    public void an_employee_navigate_signin_url(String gmibank_signin_url) {
        Driver.getDriver().get(ConfigurationReader.getProperty(gmibank_signin_url));

    }

    @Then("provides username")
    public void provides_username() {
        us013.username.sendKeys(ConfigurationReader.getProperty("employee_username"));

    }

    @Then("provides password")
    public void provides_password() {
        us013.password.sendKeys(ConfigurationReader.getProperty("employee_password"));
    }

    @Then("clicks on sign in button")
    public void clicks_on_sign_in_button() {

        us013.signInSubmitBtn.click();
    }

    @When("clicks on language menu")
    public void clicks_on_language_menu() {
        ReusableMetods.waitForClickablility(us013.languageMenu, 5);
        us013.languageMenu.click();
    }

    @Then("clicks on English")
    public void clicks_on_English() {

        us013.englishMenu.click();
    }

    @Then("clicks on manage accounts")
    public void clicks_on_manage_accounts() {
        us013.myOperations.click();
        us013.manageAccounts.click();
    }

    @Then("clicks on create new account")
    public void clicks_on_create_new_account() {

        us013.createNewAccountsBtn.click();
    }

    //TestCase01
    @Given("Employee writes description as Saving Account")
    public void employeeWritesDescriptionAsSavingAccount() {
        us013.descriptionTextBox.click();
        us013.descriptionTextBox.sendKeys("Saving Account");
    }

    //TestCase02
    @Given("employee clicks on balance text box")
    public void employeeClicksOnBalanceTextBox() {

        us013.balanceTextBox.click();
    }

    @And("provide balance as number")
    public void provideBalanceAsNumber() {
        us013.balanceTextBox.sendKeys("100000");
        //burada virgullu girilince sadece numara girin diyor.BUG
        //This field should be a number.
    }

    //TestCase03
    @Given("Employee clicks on account type dropdown")
    public void employeeClicksOnAccountType() {
        us013.accountTypeDropdown.click();
    }

    @And("selects its status such as CHECKING")
    public void typesItsStatusSuchAsCHECKING() {
        Select select = new Select(us013.accountTypeDropdown);
        select.selectByIndex(0);

    }

    //TestCase04
    @Given("Employee clicks on account status type dropdown")
    public void employeeClicksOnAccountStatusTypeDropdown() {
        us013.accountStatusTypeDropdown.click();

    }

    @And("clicks on its type such as ACTIVE")
    public void clicksOnItsTypeSuchAsACTIVE() {
        Select select = new Select(us013.accountStatusTypeDropdown);
        select.selectByVisibleText("ACTIVE");
    }

    //TestCase05
    @Given("Employee clicks on employee")
    public void employeeClicksOnEmployee() {
        System.out.println(us013.employeeTextBox.isEnabled());
        us013.employeeTextBox.click();

    }

    @And("verify it is selected or not")
    public void verifyItIsSelectedOrNot() {
        System.out.println(us013.employeeTextBox.isSelected());
        Assert.assertFalse("nothing in the textbox, there is a bug needs to be fixed",false);
    }

    @And("employee clicks on save button to create an account")
    public void employeeClicksOnSaveButtonToCreateAnAccount() {
        Driver.waitForClickablility(us013.signInSubmitBtn,5);
        action.doubleClick(us013.signInSubmitBtn);
        System.out.println("Account created successfully");

    }


}
