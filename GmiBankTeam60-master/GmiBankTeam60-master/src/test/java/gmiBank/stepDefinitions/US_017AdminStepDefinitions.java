package gmiBank.stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmiBank.pages.LoginPage;
import gmiBank.pages.US_013EmployeeAccount;
import gmiBank.pages.US_017AdminRolePage;
import gmiBank.utilities.ConfigurationReader;
import gmiBank.utilities.Driver;
import gmiBank.utilities.JSUtil;
import gmiBank.utilities.ReusableMetods;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class US_017AdminStepDefinitions {
    LoginPage loginPage=new LoginPage();
    US_017AdminRolePage us17=new US_017AdminRolePage();
    Actions action = new Actions(Driver.getDriver());
    US_013EmployeeAccount us013=new US_013EmployeeAccount();

    public static int order;
    public static String userName = "";
    public static int page = 1;

    @Given("Admin navigates to {string}")
    public void adminNavigatesTo(String gmibank_signin_url) {
        Driver.getDriver().get(ConfigurationReader.getProperty(gmibank_signin_url));

    }

    @Then("types username and password")
    public void typesUsernameAndPassword(DataTable datatable) {
        List<String> data = datatable.row(2);
        loginPage.usernameBox.sendKeys(data.get(0));
        loginPage.passwordBox.sendKeys(data.get(1));
    }

    @And("clicks on sign in button on login page")
    public void clicksOnSignInButtonOnLoginPage() {
        loginPage.signInBtn.click();
    }

    @Then("clicks on the Administration dropdown")
    public void clicksOnTheAdministrationDropdown() {
        Driver.waitForPageToLoad(5);
        us17.administrationDropdown.click();
    }

    @Then("clicks on User Management")
    public void selectsTheUserManagement() {

        JSUtil.clickElementByJS(us17.userManagement);
    }

    @Then("clicks on the date arrow button")
    public void clicksOnTheDateArrowButton()   {

        ReusableMetods.waitForClickablility(us17.createdDateClickBtn, 5);
        JSUtil.clickElementByJS(us17.createdDateClickBtn);
    }
    @And("searches for new registrant {string}")
    public void searchesForNewRegistrant(String UserName) {
     //   WebElement userforActivation=Driver.getDriver().findElement(By.xpath("//*[@id='"+UserName+"']/td[4]/button"));

    }

    @Then("clicks on edit to activate and save for validation")
    public void clicksOnEditToActivateAndSave()  {

        us17.editBtn.click();
      //  WebElement activationSection=Driver.getDriver().findElement(By.xpath("//*[text()='Activated']"));
        Driver.waitForClickablility(us17.activatedOption,5);


        if (!us17.activatedOption.isSelected()) {
            //  adminPage.sleep(1000);
            us17.activatedOption.click();
        }

        us17.saveBtn.click();
        Driver.wait(2);
        String message=us17.activatedMessageText.getText();
        System.out.println("mesaj: "+message);
        Assert.assertTrue(message.contains("A user is updated with identifier"));
        System.out.println("passed");


    }

    @And("clicks on adminDropdown and signs out")
    public void clicksOnAdminDropdownAndSignsOut()  {
        ReusableMetods.waitFor(5);
        us17.adminIconMenu.click();
        ReusableMetods.waitFor(5);
        us17.adminSignOut.click();
     //   WebElement signInAgain= Driver.getDriver().findElement(By.xpath("//*[text()='SIGN IN AGAIN'] "));
      //  signInAgain.click();
    }


    @Then("clicks on create a new user")
    public void clicksOnCreateANewUser() {
        us17.createNewUser.click();
    }

    @And("completes all required fields such as role employee")
    public void completesAllRequiredFieldsSuchAsRoleEmployee() {
        Driver.waitForClickablility(us17.loginTextBox,3);
        us17.loginTextBox.click();
        us17.loginTextBox.sendKeys("team60_employee");
        us17.firstNameTextBox.sendKeys("team60");
        us17.lastNameTextBox.sendKeys("team60");
        us17.emailTextBox.sendKeys("team60@gmail.com");
        if (!us17.activatedOption.isSelected()) {
            //  adminPage.sleep(1000);
            us17.activatedOption.click();
        }
        Select select=new Select(us17.languageOptionDropDown);
        select.selectByVisibleText("English");
        Driver.wait(3);
      //  JSUtil.scrollInToViewJS(Driver.getDriver().findElement(By.xpath("//*[text()='Profiles']")));
        Driver.waitForVisibility(us17.roleOptionDropDown,3);
        Select select2=new Select(us17.roleOptionDropDown);
        select2.selectByValue("ROLE_EMPLOYEE");


    }

    @And("clicks on save button sees message for validation")
    public void clicksOnSaveButtonSeesMessageForValidation() {

        us17.saveBtn.click();
        Driver.wait(3);
       String message= us17.activatedMessageText.getText();
        System.out.println("message is: "+message);
        Assert.assertTrue(message.contains("Login name already used!"));
        System.out.println(" Admin can activate user as a role employee but our employee's login name already exists");
    }
}
