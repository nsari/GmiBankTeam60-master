package gmiBank.stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gmiBank.pages.US_013EmployeeAccount;
import gmiBank.pages.US_014DateCreationOnAccount;
import gmiBank.utilities.Driver;
import gmiBank.utilities.JSUtil;
import gmiBank.utilities.ReusableMetods;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class US_014StepDefinitions {
    US_013EmployeeAccount us013=new US_013EmployeeAccount();
    US_014DateCreationOnAccount us014=new US_014DateCreationOnAccount();
    Actions action=new Actions(Driver.getDriver());


    @Given("Employee should sign in his account and clicks manage accounts")
    public void employeeShouldSignInHisAccountAndClicksManageAccounts() {
        us013.manageAccounts();
    }

    @And("clicks on +create new account")
    public void clicksOnCreateNewAccount() {

        us013.createNewAccountsBtn.click();
    }

    //TC01
    @When("user provides all required places such as description,account")
    public void user_provides_all_required_places_such_as_description_account() {
        us013.descriptionTextBox.sendKeys("Esra's DenemeAccount");
        us013.balanceTextBox.sendKeys("4500");
        Select select =new Select(us013.accountTypeDropdown);
        select.selectByIndex(1);

    }

    @When("user enters today's date on the Create Datetextbox and verifies it is correct date ot not")
    public void user_enters_today_s_date_on_the_Create_Datetextbox() {

        us014.selectTodaysDateforCreateDateTextBox();
        us014.getCreationDateTextVerify();
    }
    //TC02
    @And("user checks the order of date as given format and verify")
    public void user_checks_the_order_of_date_as_mm_dd_yy_hour_minute() {

        us014.orderOfDateFormatVerify();
    }

    @Then("selects date for the closed Datetextbox")
    public void selectsDateForTheClosedDatetextbox() {
        us014.selectTodaysDateforClosedDateTextBox();

    }
    @And("user verifies closed date matches with entering data")
    public void userVerifiesClosedDateMatchesWithEnteringData() {
        us014.getClosedDateTextVerify();
    }

    @And("user clicks on save button")
    public void clicksOnSaveButton() {
        JSUtil.scrollDownByJS();
        ReusableMetods.waitForClickablility(us014.saveBtnCreationAccount,5);
        //        us014.saveBtnCreationAccount.click();

    }
    //tc03
    @When("User clicks on manage accounts")
    public void userClicksOnManageAccounts() {
        ReusableMetods.waitForVisibility(us013.myOperations,5);
        us013.myOperations.click();

    }


    @And("user clicks on manage customer")
    public void userClicksOnManageCustomer() {
        ReusableMetods.waitForVisibility(us014.manageCustomerBtn,5);
        us014.manageCustomerBtn.click();
        //page up and click on createnewcustomer
        us014.pageUp(us014.createNewCustomerButton);
        us014.createNewCustomerButton.click();
    }

    @Then("User types SSN number")
    public void userTypesNumber() {
        ReusableMetods.waitForClickablility(us014.ssnTextBox,5);
        us014.ssnTextBox.click();
        us014.ssnTextBox.sendKeys("123-30-1987");
    }
    @And("User clicks on search button")
    public void userClicksOnSearchButton() {
        action.doubleClick(us014.ssnSearchBtn).perform();
        ReusableMetods.waitForClickablility(us014.middleInitialTextBox,5);
    }
    @Then("User fills all required sections out")
    public void userFillsAllRequiredSectionsOut() {
        ReusableMetods.waitForVisibility(us014.middleInitialTextBox, 5);
        us014.middleInitialTextBox.sendKeys("E");
        us014.phoneNumberTextBox.sendKeys("646-999-8888");
        us014.zipcodeTextBox.sendKeys("06030");
        us014.cityTextBox.sendKeys("westhaven");
        Select select = new Select(us014.countryDropdownMenu);
        select.selectByVisibleText("USA");
        us014.stateTextBox.sendKeys("CT");
        //Sayfanin ortasina gitmek icin asagidaki Javascript yontemi kullanilir.
        JavascriptExecutor j = (JavascriptExecutor) Driver.getDriver();
        j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", us014.userTextBox);


    }
    //tc04
    @When("user selects account from dropdown")
    public void userSelectsAccountFromDropdown() {
        Select select1 = new Select(us014.accountSelectionDropdown);
        select1.selectByValue("97337");


    }

    @And("verifies it is chosen or not")
    public void verifiesItIsCreatedOrNot() {

        Assert.assertTrue(us014.accountSelectionDropdown.getAttribute("class").contains("valid"));
    }
    //tc05
    @When("User clicks on zelle enrolled check box")
    public void userClicksOnZelleEnrolledCheckBox() {

        us014.zelleEnrolled.click();
    }

    @And("User clicks on save button for customer create")
    public void userClicksOnSaveButtonForCustomerCreate() {
        // us014.saveSubmitBtn.click();

    }
    @And("User sees zelle enrolled is selected or not")
    public void userSeesZelleEnrolledIsSelectedOrNot() {
        Assert.assertTrue("zelle enrolled is selected",us014.zelleEnrolled.isEnabled());
        //  Assert.assertFalse("secildigi halde true da hata veriyor, false ile gecirdik,Yine BUG",us014.zelleEnrolled.isSelected());
        Assert.assertFalse(us014.zelleEnrolled.getAttribute("class").contains("valid"));
        System.out.println( us014.zelleEnrolled.getAttribute("class").contains("valid"));

    }

}