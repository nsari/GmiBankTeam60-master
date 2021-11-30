package gmiBank.pages;

import gmiBank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class US_019Page {
    public US_019Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "((//a[@aria-haspopup='true'])[1]")
    public WebElement languageDropdownMenu;

    @FindBy(xpath = "//button[@value='en']")
    public WebElement englishOnDropdownMenu;

    @FindBy(xpath = "(//a[@href='#'])[2]")
    public WebElement myOperationDropdownMenu;

    @FindBy(xpath = " (//a[@class='dropdown-item'])[2]")
    public WebElement manageAccountItem;

    @FindBy(id = "jh-create-entity")
    public WebElement createANewAccountItem;

    @FindBy(xpath = "//input[@name='description']")
    public WebElement descriptionTextBox;

    @FindBy(xpath = "//input[@name='balance']")
    public WebElement balanceTextBox;

    @FindBy(xpath = "//select[@id='tp-account-accountType']")
    public WebElement accountTypeDropdown;

    @FindBy(xpath = "//select[@id='tp-account-accountStatusType']")
    public WebElement accountStatusDropdown;

    @FindBy(xpath = "//input[@name='createDate']")
    public WebElement createDateBox;

    @FindBy(xpath = " //select[@id='tp-account-employee']")
    public WebElement employeeBox;

}





