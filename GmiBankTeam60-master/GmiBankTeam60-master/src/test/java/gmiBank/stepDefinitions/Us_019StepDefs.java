package gmiBank.stepDefinitions;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmiBank.pages.LoginPage;
import gmiBank.pages.US_019Page;
import gmiBank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import javax.lang.model.util.Elements;
import javax.swing.*;
import java.util.List;

public class Us_019StepDefs {
    US_019Page us019Page= new US_019Page();
    LoginPage loginPage= new LoginPage();



//    @And("Click language dropdown menu")
//   public void clickLanguageDropdownMenu() {
//        us019Page.languageDropdownMenu.click();
//   }
//    @Then("Click English on language dropdown menu")
//    public void click_English_on_language_dropdown_menu() {
//
//        WebElement selectElement= us019Page.languageDropdownMenu;
//        Select select= new Select(selectElement);
//           select.selectByVisibleText("English");
//        System.out.println("English was selected");
//
//    }

    @Then("Click the My Operation item")
    public void click_the_My_Operation_item() {
        us019Page.myOperationDropdownMenu.click();

    }

    @Then("Click the Manage Account item")
    public void click_the_Manage_Account_item() {
        us019Page.manageAccountItem.click();
    }

    @Then("Click Create a new Account")
    public void click_Create_a_new_Account() {
        us019Page.createANewAccountItem.click();
    }

    @Then("Fill the Description Textbox")
    public void fill_the_Description_Textbox() {
        us019Page.descriptionTextBox.sendKeys("A new Account");
    }

    @Then("Check the Description TextBox is filled")
    public void check_the_Description_TextBox_is_filled() {
        us019Page.balanceTextBox.sendKeys("500");

    }

    @Then("select an account type as CHECKING")
    public void select_an_account_type_as_CHECKING() {
        Select select=new Select(us019Page.accountTypeDropdown);
        select.selectByIndex(0);
        // Sadece CHECKING, SAVING, CREDIT_CARD or INVESTING elementlerinin oldugunu check etmek istersek
//        Select select= new Select(us019Page.accountTypeDropdown);
//        List<WebElement> options= select.getOptions();
//        for(WebElement element:options){
//            boolean accounts= element.getText().equals("CHECKING") || element.getText().equals("SAVING") || element.getText().equals("CREDIT_CARD")
//             || element.getText().equals("INVESTING");
//           Assert.assertTrue("User can select an account type as CHECKING, SAVING, CREDIT_CARD or INVESTING", accounts);
//            System.out.println(accounts);
    }






    @Then("select an account type as SAVING")
    public void select_an_account_type_as_SAVING() {
        Select select = new Select(us019Page.accountTypeDropdown);
        select.selectByVisibleText("SAVING");

    }

    @Then("select an account type as CREDIT_CARD")
    public void select_an_account_type_as_CREDIT_CARD() {
        Select select= new Select(us019Page.accountTypeDropdown);
        select.selectByIndex(2);


    }

    @Then("select an account type as INVESTING")
    public void select_an_account_type_as_INVESTING() {
        Select select= new Select(us019Page.accountTypeDropdown);
        select.selectByIndex(3);
    }

    @Then("Account status should be defined as ACTIVE")
    public void account_status_should_be_defined_as_ACTIVE() {
        Select select= new Select(us019Page.accountStatusDropdown);
        select.selectByIndex(0);
    }

    @Then("Account status should be defined as SUSPENDED")
    public void account_status_should_be_defined_as_SUSPENDED() {
        Select select=new Select(us019Page.accountStatusDropdown);
        select.selectByIndex(1);
    }

    @Then("Account status should be defined as  CLOSED")
    public void account_status_should_be_defined_as_CLOSED() {
        Select select=new Select(us019Page.accountStatusDropdown);
        select.selectByIndex(2);
        Actions action = new Actions(Driver.getDriver());
        action.click(us019Page.accountStatusDropdown).sendKeys(Keys.ENTER).perform();


        Driver.wait(5);
    }

    @Then("select an employee from the drop-down")
    public void select_an_employee_from_the_drop_down() {
        System.out.println(us019Page.employeeBox.isSelected());
        Assert.assertFalse("the box is empty", false);

    }


    @Then("Fill the Balance Textbox with digits")
    public void fillTheBalanceTextboxWithDigits() {
        us019Page.balanceTextBox.sendKeys("500");
    }


    @And("click acount type dropdown")
    public void clickAcountTypeDropdown() {
        us019Page.accountTypeDropdown.click();


    }

    @Then("click acount status dropdown")
    public void clickAcountStatusDropdown() {
        us019Page.accountStatusDropdown.click();



    }

    @Then("click employee dropdown")
    public void clickEmployeeDropdown() {
        us019Page.employeeBox.click();
    }


}


