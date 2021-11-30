package gmiBank.pages;


import gmiBank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class US_011Page {
    public US_011Page(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath = "(//li[@class='dropdown show nav-item']")
    public WebElement languageIcon;

    @FindBy(xpath = "(//button[@class='dropdown-item'])[1]")
    public WebElement englishSelect;

    @FindBy(partialLinkText = "My Operations")
    public WebElement myOperations;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[1]")
    public WebElement manageCustomer;

    @FindBy(id = "jh-create-entity")
    public WebElement createANewCustomer;

    @FindBy(id="search-ssn")
    public WebElement sSN;

    @FindBy(xpath ="//button[@class='btn btn-secondary']")
    public WebElement searchButton;

    @FindBy(id="tp-customer-firstName")
    public WebElement firstName;

    @FindBy(id="tp-customer-lastName")
    public WebElement lastName;

    @FindBy(id="tp-customer-middleInitial")
    public WebElement middleInitial;

    @FindBy(id="tp-customer-email")
    public WebElement email;

    @FindBy(id="tp-customer-mobilePhoneNumber")
    public WebElement mobilePhoneNumber;

    @FindBy(id="tp-customer-phoneNumber")
    public WebElement phoneNumber;

    @FindBy(id="tp-customer-zipCode")
    public WebElement zipCode;

    @FindBy(id="tp-customer-address")
    public WebElement adress;

    @FindBy(id="tp-customer-city")
    public WebElement city;

    @FindBy(id="tp-customer-ssn")
    public WebElement ssnSecond;

    @FindBy(id="tp-customer-createDate")
    public WebElement creatDate;

    @FindBy(id="tp-customer-country")
    public WebElement country;

    @FindBy(id="tp-customer-state")
    public WebElement state;

    @FindBy(id="tp-customer-user")
    public WebElement user;

    @FindBy(id = "tp-customer-account")
    public WebElement account;

    @FindBy(id = "tp-customer-zelleEnrolled")
    public WebElement zelleEndrolled;

    @FindBy(id = "save-entity")
    public WebElement saveButton;

    @FindBy(xpath ="//a[@aria-haspopup='true'][1] ")
    public WebElement languageMenu;
    // //a[@aria-haspopup='true'][1]     //nav[1]/div[1]/ul[1]/li[1]/a[1]

    @FindBy(xpath ="//*[@class='dropdown-item'][1]")
    public WebElement englishMenu;


}
