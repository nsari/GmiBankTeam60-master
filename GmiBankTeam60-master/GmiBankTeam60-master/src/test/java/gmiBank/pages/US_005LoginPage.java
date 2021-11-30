package gmiBank.pages;


import gmiBank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_005LoginPage {
    public US_005LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "account-menu")
    public WebElement accountmenu;

    @FindBy(id = "login-item")
    public WebElement signinmenu;

    @FindBy(id = "login-item")
    public WebElement login;
    @FindBy(id = "username")
    public WebElement usernameBox;
    @FindBy(id = "password")
    public WebElement passwordBox;
    @FindBy (xpath = "//*[@class='btn btn-primary']")
    public WebElement signinButton;
    @FindBy (xpath = "//*[@id=\"login-page\"]/div/form/div[2]/div[3]/a/span")
    public WebElement resetpassword;
    @FindBy (xpath = "//*[@id=\"login-page\"]/div/form/div[2]/div[4]/a/span")
    public WebElement registernew;

    @FindBy(xpath = "(//div[@class='col-md-12'])[1]")
    public WebElement hata;

}




