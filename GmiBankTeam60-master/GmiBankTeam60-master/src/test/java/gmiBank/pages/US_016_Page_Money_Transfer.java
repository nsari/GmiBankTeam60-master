package gmiBank.pages;

import gmiBank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_016_Page_Money_Transfer {

    public US_016_Page_Money_Transfer(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "account-menu")
    public WebElement iconAccountMenu;

    @FindBy(xpath = "//span[text()='Sign in']")
    public WebElement signInHomePage;

    @FindBy(id = "username")
    public WebElement usernameBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement signInButton;

    @FindBy(xpath = "//span[text()='My Operations']")
    public WebElement myOperations;

    @FindBy(xpath = "//a[text()='Transfer Money']")
    public WebElement transferMoney;

    @FindBy(id = "fromAccountId")
    public WebElement fromTexBoxOfMoneyTransfer;

    @FindBy(id = "toAccountId")
    public WebElement toTextBoxOfMoneyTransfer;

    @FindBy(id = "balance")
    public WebElement balanceTexBoxOfMoneyTransfer;

    @FindBy(xpath = "//div[@style='pointer-events: none;']")
    public WebElement textOfTransferSuccesfull;

    @FindBy(id = "description")
    public WebElement descriptionTextBoxOfMoneyTransfer;

    @FindBy(id = "make-transfer")
    public WebElement makeTrasferButton;

    @FindBy (xpath = "(//td)[1]")
    public WebElement theFirstAccount;

    @FindBy(xpath = "(//td)[5]")
    public WebElement theSecondAccount;







}