package gmiBank.stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmiBank.pages.US_018Page;
import gmiBank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

public class US_018StepDefinitions {

    US_018Page us18=new US_018Page();
    String loginName;

    @Then("clicks on view section")
    public void clicksOnViewSection() {
        us18.viewBtn.click();

    }

    @Then("sees user info as validaton valides login name can be seen")
    public void seesUserInfoAsValidatonValidesLoginNameCanBeSeen() {

      loginName=  us18.loginUserName.getText();
        System.out.println("Admin sees login as :"+loginName);
        Assert.assertTrue("not seen",us18.loginUserName.isDisplayed());
        System.out.println("validation is successfull");
    }

    @And("clicks on back button")
    public void clicksOnBackButton() {

        us18.backBtn.click();
        Driver.wait(3);
    }

    @Given("clicks on My Operations")
    public void clicksOnMyOperations() {

        us18.myOperations.click();
    }

    @And("clicks on Manage Customer")
    public void clicksOnManageCustomer() {
        us18.manageCustomer.click();
    }

    @And("admin sees a message {string} and verifies")
    public void adminSeesAMessage(String message) {
        String actualMessage=us18.notauthorizedMessage.getText();
        System.out.println("actual message is :"+actualMessage);
        Assert.assertEquals("no matches",message,actualMessage);

    }

    @And("clicks on Manage Accounts")
    public void clicksOnManageAccounts() {
        Driver.wait(3);
        us18.myOperations.click();
        us18.manageAccounts.click();
    }

    @And("admin sees a mesage {string} and verifies the message")
    public void adminSeesAMesage(String expectedMessage) {
        Driver.wait(3);
        String actualMessage=us18.notauthorizedMessage.getText();
        System.out.println("actual message for account is :"+actualMessage);
        Assert.assertEquals("no matches",expectedMessage,actualMessage);
        System.out.println("Admin can not access Manage Account and Manage Customer sections");
    }


}
