package gmiBank.pages;

import com.sun.tools.jxc.ConfigReader;
import gmiBank.utilities.ConfigurationReader;
import gmiBank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "account-menu")
    public WebElement iconAccountMenu;

    @FindBy(xpath = "//span[text()='Sign in']")
    public WebElement signInhomePage;

    @FindBy(xpath = "//span[text()='Register']")
    public WebElement RegisterhomePage;

    @FindBy(id = "username")
    public WebElement usernameBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement signInBtn;
    //  //*[text()='Sign in']

    @FindBy(partialLinkText = "Cancel")
    public WebElement cancelBtn;

    @FindBy(xpath = "//*[span='My Operations']")
    public WebElement myOperations;

    public void loginExecution(){

        iconAccountMenu.click();
        signInhomePage.click();
        usernameBox.sendKeys(ConfigurationReader.getProperty("usernameUSA"));
        passwordBox.sendKeys(ConfigurationReader.getProperty("passwordUSA"));
        signInBtn.click();
    }












    public void loginExecution1(){

        iconAccountMenu.click();
        signInhomePage.click();
        usernameBox.sendKeys(ConfigurationReader.getProperty("employee_username"));
        passwordBox.sendKeys(ConfigurationReader.getProperty("employee_password"));
        signInBtn.click();
    }


}
