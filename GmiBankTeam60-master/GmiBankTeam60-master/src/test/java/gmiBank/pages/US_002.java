package gmiBank.pages;

import gmiBank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_002 {
    public US_002() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//*[@id='account-menu']/a")
    public WebElement icon;

    @FindBy(xpath = "//*[@id='account-menu']/div/a[2]/span")
    public WebElement registerButton;

    @FindBy(xpath = "//*[@id='ssn']")
    public  WebElement ssnTextBox;

    @FindBy(xpath = "//*[@id='register-form']/div[1]/div")
    public WebElement SSNerrorMessage;

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

    @FindBy(xpath = "//*[@id='register-form']/div[2]/div")
    public WebElement firstnameErrorMessage;

    @FindBy(xpath = "//*[@id='register-form']/div[3]/div")
    public WebElement lastnameErrorMessage;

    @FindBy(xpath = "//*[@id='register-form']/div[4]/div")
    public WebElement adresErrorMessage;

    @FindBy(xpath ="//*[@id='register-form']/div[5]/div")
    public WebElement phoneNumberErrorMessage;

    @FindBy(xpath = "//*[@id='register-form']/div[6]/div")
    public WebElement usernameErrorMessage;

    @FindBy(xpath = "//*[@id='register-form']/div[7]/div")
    public WebElement emailErrorMessage;

    @FindBy(xpath = "//*[@id='ssn']")
    public WebElement invalidSSNMessage;

    @FindBy(xpath = "//*[@id='register-form']/div[5]/div")
    public WebElement invalidPhoneNumberMessage;

    @FindBy(xpath = "//*[@id='register-form']/div[7]/div")
    public WebElement invalidEmailMessage;

}
