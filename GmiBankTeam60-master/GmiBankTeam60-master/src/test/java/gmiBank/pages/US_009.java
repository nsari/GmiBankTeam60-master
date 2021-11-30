package gmiBank.pages;

import gmiBank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_009 {
    public US_009(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "entity-menu")
    public WebElement myOperations;

    @FindBy(xpath = "//span[contains(text(),'Manage Customers')]")
    public WebElement manageCustomer;

    @FindBy(xpath = "//span[contains(text(),'Create a new Customer')]")
    public WebElement createNewCustomer;


    @FindBy(id = "search-ssn")
    public WebElement SSN;

    @FindBy(xpath = "//button[@class='btn btn-secondary']")
    public WebElement searchButton;

    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement succesmessage;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstname;

    @FindBy(id = "tp-customer-lastName")
    public WebElement lastname;

    @FindBy(id = "tp-customer-email")
    public WebElement email;

    @FindBy(xpath = "//input[@id='tp-customer-mobilePhoneNumber']")
    public WebElement mobile;

    @FindBy(xpath = "//input[@name='phoneNumber']")  //input[@id='tp-customer-phoneNumber']
    public WebElement phone;

    @FindBy(xpath = "//input[@name='address']")
    public WebElement adress;

    @FindBy(id = "//input[@id='tp-customer-ssn']")      //input[@name='ssn']
    public WebElement ssn;

    @FindBy(xpath = "//input[@id='tp-customer-createDate']")
    public WebElement createDate;



    public void createNewCostomerTest(){
        myOperations.click();
        manageCustomer.click();
        createNewCustomer.click();
    }


}


