package gmiBank.pages;
import gmiBank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_001RegistrationPage {
    public US_001RegistrationPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//*[@id='account-menu']/a")
    public WebElement icon;

    @FindBy(xpath = "//*[@id='account-menu']/div/a[2]/span")
    public WebElement registerButton;

    @FindBy(xpath = "//*[@id='ssn']")
    public  WebElement ssnTextBox;

    @FindBy(xpath = "//*[@id='register-form']/div[1]/div")
    public WebElement errorMessage;

    @FindBy(xpath = "//*[@id='firstname']")
    public WebElement firstNameTextBox;

    @FindBy(xpath = "//*[@id='lastname']")
    public WebElement lastNameTextBox;

    @FindBy(xpath = "//*[@id='address']")
    public WebElement adresTextBox;

    @FindBy(xpath = "//*[@id='mobilephone']")
    public WebElement mobilPhoneNumberTextBox;

    @FindBy(xpath = "//*[@id='username']")
    public WebElement userNameTextBox;

    @FindBy(xpath = "//*[@id='email']")
    public WebElement emailTextBox;

    @FindBy(xpath ="//*[@id='firstPassword']" )
    public WebElement newPassword;

    @FindBy(xpath = "//*[@id='secondPassword']")
    public WebElement newPasswordConfirmation;

    @FindBy(xpath = "//*[@id='register-submit']/span")
    public WebElement RegisterButtonLast;



}
