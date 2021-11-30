package gmiBank.pages;

import gmiBank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_008PasswordChangePage {

    public US_008PasswordChangePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "account-menu")
    public  WebElement we_008account_menu;

    @FindBy(id="login-item")
    public WebElement we_signinmenu;

    @FindBy(id="username")
    public WebElement we_username;


    @FindBy(xpath = "//input[@id='password']")
    public WebElement we_password;

    @FindBy(xpath = "//a[@href='/account/password']")
    public WebElement we_passwordButton;

    @FindBy(xpath = "//button[@type='submit']")
/*    //*[@id="login-page"]/div/form/div[3]/button[2]/span  */
   public WebElement we_signInSubmit;



    @FindBy(xpath = "//input[@name='currentPassword']")
    public WebElement we_currentPassword;

    @FindBy(xpath = "//input[@name='newPassword']")
    public WebElement we_newPassword;

    @FindBy(xpath = "//input[@name='confirmPassword']")
    public WebElement we_confirmPassword;

    @FindBy(xpath = "//*[@id='account-menu']/div/a[2]")
            public WebElement we_sifremenu;

    @FindBy(className = "invalid-feedback")
    public WebElement failMessageBox;




    @FindBy(xpath = "//ul[@id='strengthBar']/li")
    public WebElement we_StrengthBar;

    @FindBy(xpath ="//*[@id='strengthBar']/li[1]")
    public  WebElement we_008strengthbar1;

    @FindBy(xpath ="//*[@id='strengthBar']/li[2]")
    public  WebElement we_008strengthbar2;

    @FindBy(xpath ="//*[@id='strengthBar']/li[3]")
    public  WebElement we_008strengthbar3;


    @FindBy(xpath ="//*[@id=/'strengthBar/']/li[4]")
    public  WebElement we_008strengthbar4;

    @FindBy(xpath ="//*[@id='strengthBar']/li[5]")
    public  WebElement we_008strengthbar5;


    @FindBy(xpath ="//*[@id='password-form']/button/span")
    public WebElement we_save;


    @FindBy(xpath = "//a[@href='/logout']")
    public WebElement we_LogOut;
}

