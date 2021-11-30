package gmiBank.stepDefinitions;



import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import gmiBank.pages.LoginPage;
import gmiBank.pages.US_004SignInPage;
import gmiBank.utilities.ConfigurationReader;
import gmiBank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

public class US_004StepDefinitions {
    LoginPage logInPage=new LoginPage();
  US_004SignInPage us004 =new US_004SignInPage();
    Actions action=new Actions(Driver.getDriver());


    @Given("User navigates to url {string}")
    public void userNavigatesToUrl(String gmi_url) {
        Driver.getDriver().get(ConfigurationReader.getProperty(gmi_url));
    }
    @Given("user clicks on iconAccountMenu")
    public void userClicksOnIconAccountMenu() {
        logInPage.iconAccountMenu.click();
        logInPage.signInhomePage.click();
    }


    @Given("user types a valid username")
    public void userTypesAValid() {
       logInPage.usernameBox.sendKeys(ConfigurationReader.getProperty("user_username"));
    }

    @Given("user enters a valid password")
    public void userEntersAValid() {
        logInPage.passwordBox.sendKeys(ConfigurationReader.getProperty("user_password"));
    }
    @Given("user clicks on signinSubmit button")
    public void userClicksOnSigninSubmitButton() {
        logInPage.signInBtn.click();
    }

    @And("verifies that sign in is done successfully")
    public void verifiesThatSignInIsDoneSuccessfully() {
        Driver.waitForPageToLoad(3);
        String  expectedUserNameAfterSignIn="Whitney Swaniawski";
        String actualUserNameAfterSignIn=us004.userNameIsim.getText();
        System.out.println("username is: "+ actualUserNameAfterSignIn);
        Assert.assertEquals("User signs in successfully",expectedUserNameAfterSignIn,actualUserNameAfterSignIn);



    }
    @Given("user provides valid username and password")
    public void userProvidesValidUsernameAndPassword() {
        us004.userNameIsim.click();
        Driver.waitForClickablility(us004.signoutCikis,5);
        us004.signoutCikis.click();

        Driver.waitForPageToLoad(5);
        us004.signInTekrar.click();

        //  Driver.getDriver().get(ConfigurationReader.getProperty("gmibank_signin_url"));
        logInPage.usernameBox.sendKeys(ConfigurationReader.getProperty("user_username"));
        logInPage.passwordBox.sendKeys(ConfigurationReader.getProperty("user_password"));
    }

    @And("clicks on cancel button and verifies.")
    public void clicksOnCancelButtonAndVerifies() {
        Assert.assertTrue("there is cancel option" , us004.iptalCancel.isDisplayed());
        us004.iptalCancel.click();
    }


}
