package gmiBank.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gmiBank.pages.US_012Page;
import gmiBank.utilities.ConfigurationReader;
import gmiBank.utilities.ReusableMetods;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import java.util.List;

public class US_012StepDefs {
    US_012Page us_012=new US_012Page();



    @Given("User sees all registrations info")
    public void user_sees_all_registrations_info(DataTable dataTable) {
        System.out.println(us_012.columnList);

        Assert.assertTrue(us_012.columnList.get(0).getText().contains(dataTable.cell(0,0)));
        System.out.println(us_012.columnList.get(0).getText());

        Assert.assertTrue(us_012.columnList.get(1).getText().contains(dataTable.cell(1,0)));
        System.out.println(us_012.columnList.get(1).getText());

        Assert.assertTrue(us_012.columnList.get(2).getText().contains(dataTable.cell(2,0)));
        System.out.println(us_012.columnList.get(2).getText());

        Assert.assertTrue(us_012.columnList.get(3).getText().contains(dataTable.cell(3,0)));
        System.out.println(us_012.columnList.get(3).getText());

        Assert.assertTrue(us_012.columnList.get(4).getText().contains(dataTable.cell(4,0)));
        System.out.println(us_012.columnList.get(4).getText());

        Assert.assertTrue(us_012.columnList.get(5).getText().contains(dataTable.cell(5,0)));
        System.out.println(us_012.columnList.get(5).getText());

        Assert.assertTrue(us_012.columnList.get(6).getText().contains(dataTable.cell(6,0)));
        System.out.println(us_012.columnList.get(6).getText());

        Assert.assertTrue(us_012.columnList.get(7).getText().contains(dataTable.cell(7,0)));
        System.out.println(us_012.columnList.get(7).getText());

        Assert.assertTrue(us_012.columnList.get(8).getText().contains(dataTable.cell(8,0)));
        System.out.println(us_012.columnList.get(8).getText());


    }

    @Given("User click view button")
    public void user_click_view_button() {
        us_012.viewButton.click();

    }

    @Then("User sees all information populated")
    public void user_sees_all_information_populated() {
        ReusableMetods.waitFor(1);
        String actualfistName=us_012.firstName.getText();
        String expectedFirstname= ConfigurationReader.getProperty("first_name");
        String actualLAstName=us_012.lastName.getText();
        String expectedLastName=ConfigurationReader.getProperty("last_name");
        Assert.assertEquals(expectedFirstname,actualfistName);
        Assert.assertEquals(expectedLastName,actualLAstName);
    }

    @Then("User sees edit button")
    public void user_sees_edit_button() {
        ReusableMetods.waitFor(2);
        us_012.viewButton.isDisplayed();
        ReusableMetods.waitFor(3);
    }

    @Then("User clicks edit button")
    public void user_clicks_edit_button() {

        us_012.editButton.click();
    }


    @Then("User sees all editable information populated")
    public void user_sees_all_editable_information_populated() {
        List<WebElement> editableList = us_012.editList;
        for (WebElement each : editableList){
            //   System.out.println(each.getText());

        }
        Assert.assertTrue(editableList.get(0).getText().contains("ID"));
        ReusableMetods.waitFor(3);


    }

    @Then("User update information")
    public void user_update_information() {

        us_012.editButton.click();
        ReusableMetods.waitFor(2);
        us_012.firstName2.clear();
        us_012.firstName2.sendKeys("Islam");
        ReusableMetods.waitFor(3);
        String firstname = us_012.firstName2.getAttribute("value");
        Assert.assertEquals(firstname,"Islam");

        us_012.lastName2.clear();
        us_012.lastName2.sendKeys("Dogan");
        ReusableMetods.waitFor(3);
        String lastname = us_012.lastName2.getAttribute("value");
        Assert.assertEquals(lastname,"Dogan");

        us_012.middleInitial.clear();
        us_012.middleInitial.sendKeys("M");
        ReusableMetods.waitFor(3);
        String midInitial = us_012.middleInitial.getAttribute("value");
        Assert.assertEquals(midInitial,"M");
    }

    @Then("User back customerHomePage")
    public void user_back_customer_home_page() {
        us_012.backButton.click();
        ReusableMetods.waitFor(3);
    }

    @When("User click delete button")
    public void user_click_delete_button() {
        us_012.delete.click();

    }


    @Then("User sees confirm delete operation message")
    public void user_sees_confirm_delete_operation_message() {

        ReusableMetods.waitFor(3);
        us_012.confDeleteMessage.isDisplayed();

    }

    @Then("User click second delete button")
    public void user_click_second_delete_button() {
        ReusableMetods.waitFor(3);
        us_012.delete2.click();
    }

    @Then("User sees success edit message")
    public void user_sees_success_edit_message() {

        ReusableMetods.waitFor(3);
        us_012.deleteSuccesMessage.isDisplayed();
    }


}
