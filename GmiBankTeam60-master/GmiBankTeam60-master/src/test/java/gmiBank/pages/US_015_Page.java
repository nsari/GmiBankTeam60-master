package gmiBank.pages;

import gmiBank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_015_Page {

    public US_015_Page(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(id = "account-menu")
    public WebElement iconAccountMenu;

    @FindBy(xpath = "//span[text()='Sign in']")
    public WebElement signInhomePage;

    @FindBy(id = "username")
    public WebElement usernameBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement signInButton;

    @FindBy(xpath = "//span[text()='My Operations']")
    public WebElement myOperations;

    @FindBy(xpath = "//a[text()='My Accounts']")
    public WebElement myAccounts;

    @FindBy(xpath = "//tbody//tr[1]//td[2]")
    public WebElement accountType;

    @FindBy(xpath = "//tbody//tr[1]//td[2]")
    public WebElement accountBalance;

    @FindBy(xpath = "//tbody//tr[1]//td[3]")
    public WebElement amountOfBalance;

    @FindBy(xpath = "(//button[text()='View Transaction'])[1]")
    public WebElement viewTransaction1;

    @FindBy(xpath = "(//button[text()='View Transaction'])[2]")
    public WebElement viewTransaction2;

    @FindBy(xpath = "//a[text()='Transfer Money']")
    public WebElement transferMoney;

    @FindBy(xpath = "//td[text()='Transfer 1000.00 from account ID: 98325 ']")
    public WebElement birinciTransferBilgileri;



}