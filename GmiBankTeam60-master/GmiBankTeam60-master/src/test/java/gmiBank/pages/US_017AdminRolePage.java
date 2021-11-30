package gmiBank.pages;

import gmiBank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_017AdminRolePage {

    public US_017AdminRolePage(){
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


}
