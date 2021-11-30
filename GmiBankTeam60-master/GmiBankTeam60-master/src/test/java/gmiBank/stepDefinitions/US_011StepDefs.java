package gmiBank.stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmiBank.pages.LoginPage;
import gmiBank.pages.US_011Page;
import gmiBank.utilities.ConfigurationReader;
import gmiBank.utilities.DateUtil;
import gmiBank.utilities.Driver;
import gmiBank.utilities.ReusableMetods;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class US_011StepDefs {
    US_011Page us_011 = new US_011Page();
    LoginPage loginPage = new LoginPage();
    DateUtil dateUtil = new DateUtil();
    Actions action = new Actions(Driver.getDriver());


    @Given("User click My Operations")
    public void user_click_My_Operations() {

        us_011.myOperations.click();

    }

    @Given("User select Manage Custormers")
    public void user_select_Manage_Custormers() {

        us_011.manageCustomer.click();
    }

    @Given("User click Create a new Customer")
    public void user_click_Create_a_new_Customer() {

        us_011.createANewCustomer.click();
    }

    @Given("User enter SSN")
    public void user_enter_SSN() {
        us_011.sSN.sendKeys(ConfigurationReader.getProperty("valid_ssn_no"));

    }

    @Given("User click Search button")
    public void user_click_Search_button() throws InterruptedException {
        ReusableMetods.waitFor(3);
        us_011.searchButton.click();

    }

    @Then("User sees entered today date and time")
    public void user_sees_entered_today_date_and_time() {
        String today = DateUtil.todaysDate1();
        String todayTime = DateUtil.todaysTime1();

        action.click(us_011.creatDate).sendKeys(today + Keys.TAB + todayTime).perform();

        String dateValue = us_011.creatDate.getAttribute("value");
        System.out.println("DATE: " + dateValue);

        String actualDate = dateValue.substring(8, 10) + "/" + dateValue.substring(5, 7) + "/" + dateValue.substring(0, 4);
        System.out.println(actualDate);

        System.out.println(DateUtil.todaysTime1());
        String actualTime = dateValue.substring(11, 16);
        System.out.println(actualTime);

        System.out.println(DateUtil.todaysDate1());

        Assert.assertEquals(DateUtil.todaysDate1(), actualDate);
        Assert.assertEquals(DateUtil.todaysTime1(), actualTime);

    }

    @Then("User sees correct order date")
    public void user_sees_correct_order_date() {
        String dateValue=us_011.creatDate.getAttribute("value");
        String actualDate = dateValue.substring(5,7) + "/" + dateValue.substring(8, 10) + "/" + dateValue.substring(0,4);
        System.out.println("String actual date with slashes is: "+actualDate);
        String expectedOrderOfDate="Year/Month/Day"; //(html code order is taken)
        System.out.println("ExpectedOrderOfDate is: "+expectedOrderOfDate);

        int month = Integer.parseInt(actualDate.substring(0,2));
        System.out.println("Month is as an integer: "+month);

        int day = Integer.parseInt(actualDate.substring(3,5));
        System.out.println("Day is as an integer: "+day);

        int year = Integer.parseInt(actualDate.substring(6,10));
        System.out.println("Year is as an integer: "+year);

        //Arranging intervals on selections as int day,month,year
        String firstSection = ((month<=12 && month>0)?("Month"):("Day"));
        System.out.println("First selection: "+firstSection);
        String middleSection = ((day>=1 && day<=31)?("Day"):("Month"));
        System.out.println("Middle selection: "+middleSection);
        String thirdSection = ((year>31)?("Year"):("Month"));
        System.out.println("Third selection: "+thirdSection);
        String actualOrderOfDate=firstSection+"/"+middleSection+"/"+thirdSection;
        System.out.println("ActualOrderOfDate is: "+actualOrderOfDate);

        Assert.assertNotEquals("actual date and html date does not match to each other, there is a BUG",expectedOrderOfDate,actualOrderOfDate);

    }


    @Then("User choose valid account")
    public void user_choose_valid_account() {
        Select select1 = new Select(us_011.account);
        select1.selectByVisibleText("hakan");


    }

    @Given("User click zelle enrolled check box")
    public void user_click_zelle_enrolled_check_box() {

        if (!us_011.zelleEndrolled.isSelected()) {
            us_011.zelleEndrolled.click();
        }


    }

    @Then("User click save button")
    public void user_click_save_button() {
        us_011.saveButton.click();

    }

    @And("User sees all his her registration info populated")
    public void userSeesAllHisHerRegistrationInfoPopulated() {
        us_011.middleInitial.sendKeys(ConfigurationReader.getProperty("middle"));
        us_011.zipCode.sendKeys(ConfigurationReader.getProperty("zip_code"));
        us_011.city.sendKeys(ConfigurationReader.getProperty("city"));
        Select select = new Select(us_011.country);
        select.selectByValue("24105");
        us_011.state.sendKeys(ConfigurationReader.getProperty("state1"));

    }

    @And("User Login in")
    public void userLoginIn() {
        loginPage.loginExecution1();

    }

    @And("User choose Language")
    public void userChooseLanguage() throws InterruptedException {
        ReusableMetods.waitForClickablility(us_011.languageMenu, 4);

        us_011.languageMenu.click();
        us_011.englishMenu.click();

    }


}