package gmiBank.pages;

import gmiBank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_018Page {

    public US_018Page(){
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = " //*[text()='Created date']")
    public WebElement createdDateClickBtn;

    @FindBy(xpath = "//*[text()='User management']")
    public WebElement userManagement;

    @FindBy(xpath = "//*[text()='Administration'] ")
    public WebElement administrationDropdown;

    @FindBy(xpath = "//button[@class='btn btn-danger'][1]")
    public WebElement deactivatedBtn ;

    @FindBy(xpath = "//*[text()='Activated'] ")
    public WebElement activatedBtn ;

    @FindBy(className = "dropdown-toggle nav-link")
    public WebElement adminDropdown ;

    @FindBy(xpath = "(//a[@class='dropdown-toggle nav-link'])[4]")
    public WebElement adminIconMenu ;


    @FindBy(xpath = "//*[text()='Sign out']")
    public WebElement adminSignOut ;

    @FindBy(xpath = "//span[contains(text(),'Create a new user')]")
    public WebElement createNewUser ;

    @FindBy(xpath = "//input[@id='login']")
    public WebElement loginTextBox ;

    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement firstNameTextBox ;

    @FindBy(xpath = "//input[@id='lastName']")
    public WebElement lastNameTextBox ;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailTextBox ;

    @FindBy(xpath = "//*[text()='Activated']")
    public WebElement activatedOption ;

    @FindBy(xpath = "//select[@id='langKey']")
    public WebElement languageOptionDropDown ;

    @FindBy(xpath = "//select[@id='authorities']")
    public WebElement roleOptionDropDown ;

    @FindBy(xpath = "(//*[text()='Edit'])[1]")
    public WebElement editBtn ;

    @FindBy(xpath = "//*[text()='Save']")
    public WebElement saveBtn ;

    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement activatedMessageText ;

    @FindBy(xpath = "(//a[@class='btn btn-info btn-sm'])[1]")
    public WebElement viewBtn ;

    @FindBy(xpath = "//dd[1]")
    public WebElement loginUserName ;

    @FindBy(xpath = "//*[text()='Back']")
    public WebElement backBtn ;

    @FindBy(xpath ="//span[contains(text(),'Manage Accounts')]")
    public WebElement manageAccounts;

    @FindBy(xpath ="//span[contains(text(),'Manage Customers')]")
    public WebElement manageCustomer;

    @FindBy(xpath ="//span[contains(text(),'Operations')]")
    public WebElement myOperations;

    @FindBy(xpath ="//span[contains(text(),'You are not authorized to access this page.')]")
    public WebElement notauthorizedMessage;




}
