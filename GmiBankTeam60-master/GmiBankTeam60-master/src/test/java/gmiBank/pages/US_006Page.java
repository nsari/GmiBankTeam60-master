package gmiBank.pages;

import gmiBank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_006Page {
    public US_006Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//a[@class='dropdown-item'])[3]")
    public WebElement userInfoiItem;

    @FindBy(xpath = "(//a[@class='dropdown-toggle nav-link'])[3]")
    public WebElement  userNameIcon;


    @FindBy(xpath = "//label[@for='firstName']")
    public WebElement firstNameItem;

    @FindBy(xpath = "//label[@for='lastName']")
    public WebElement lastNameItem;

    @FindBy(xpath = "//label[@for='email']")
    public WebElement emailItem;

    @FindBy(xpath = "//label[@for='langKey']")
    public WebElement languageItem;

    @FindBy(xpath = "//select[@name='langKey']")
    public WebElement languageDropDown;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstTextBox;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastTextBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailTextBox;

    @FindBy(xpath = "//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement successToastMessage;




}
