package gmiBank.pages;

import gmiBank.utilities.ConfigurationReader;
import gmiBank.utilities.Driver;
import gmiBank.utilities.ReusableMetods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_013EmployeeAccount {

    public US_013EmployeeAccount() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath ="//a[@aria-haspopup='true'][1] ")
    public WebElement languageMenu;
    // //a[@aria-haspopup='true'][1]     //nav[1]/div[1]/ul[1]/li[1]/a[1]

    @FindBy(xpath ="//*[@class='dropdown-item'][1]")
    public WebElement englishMenu;

    @FindBy(id="login-item")
    public WebElement signIn;

    @FindBy(xpath = "//input[contains(@id,'username')]")
    public WebElement username;

    @FindBy(xpath = "//input[contains(@id,'password')]")
    public WebElement password;

    @FindBy(xpath ="//button[@type='submit']")
    public WebElement signInSubmitBtn;

    @FindBy (css = "#account-menu > a > span")
    public WebElement accountMenu1;

    @FindBy(css = "#account-menu > div > a:nth-child(1) > span")
    public WebElement userInfo;

    @FindBy(xpath ="//span[contains(text(),'Operations')]")
    public WebElement myOperations;

    @FindBy(xpath ="//span[contains(text(),'Manage Accounts')]")
    public WebElement manageAccounts;

    @FindBy(xpath ="//span[text()='Create a new Account']")
    public WebElement createNewAccountsBtn;

    @FindBy(xpath =" //input[@name='description']")
    public WebElement descriptionTextBox;

    @FindBy(xpath =" //input[@name='balance']")
    public WebElement balanceTextBox;

    @FindBy(xpath ="//select[@name='accountType']")
    public WebElement accountTypeDropdown;

    @FindBy(xpath ="//select[@name='accountStatusType']")
    public WebElement accountStatusTypeDropdown;

    @FindBy(xpath =" //*[text()='Cancel']")
    public WebElement cancelButton;

    @FindBy (xpath = "//span[contains(text(),'Sign out')]")
    public WebElement signOut;

    @FindBy (xpath = "//input[@value='Saving Account']")
    public WebElement savingAccountText;

    @FindBy(xpath = "//*[text()='This field is required.']")
    public WebElement descriptionWarningText;

//    @FindBy(id="tp-account-createDate")
//    public WebElement createDate;
//
//    @FindBy(id="tp-account-closedDate")
//    public WebElement closedDate;

    @FindBy(id="tp-account-employee")
    public WebElement employeeTextBox;


    public void manageAccounts(){
        Driver.getDriver().get(ConfigurationReader.getProperty("gmibank_signin_url"));
        username.sendKeys(ConfigurationReader.getProperty("employee_username"));
        password.sendKeys(ConfigurationReader.getProperty("employee_password"));
        signInSubmitBtn.click();
        ReusableMetods.waitForClickablility(languageMenu,5);
        languageMenu.click();
        englishMenu.click();
        myOperations.click();
        manageAccounts.click();
    }
    public void userSignOut() {
        accountMenu1.click();
        signOut.click();
    }

}
