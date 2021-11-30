package gmiBank.pages;


import gmiBank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_003PasswordRestrictionPage {
    public US_003PasswordRestrictionPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id ="strengthBar")
    public  WebElement strengthBar;

    @FindBy(id = "account-menu")
    public  WebElement we_account_menu;

    @FindBy (xpath = "//*[.='Register']")
    public WebElement we_register_submit;

    @FindBy (id = "firstPassword")
    public  WebElement we_password;

    @FindBy(xpath ="//*[@id='secondPassword']")
    public  WebElement we_password1;

    @FindBy(xpath ="//*[@id=\"register-form\"]/div[8]/div")
    public  WebElement we_passworderrormessage;

    @FindBy(xpath ="//*[@id=\"strength\"]")
    public  WebElement we_passwordstrength;

    @FindBy(xpath ="//*[@id=\"strengthBar\"]")
    public  WebElement we_strengthbar0;

    @FindBy(xpath ="//*[@id='strengthBar']/li[1]")
    public  WebElement we_strengthbar1;

    @FindBy(xpath ="//*[@id='strengthBar']/li[2]")
    public  WebElement we_strengthbar2;

    @FindBy(xpath ="//*[@id='strengthBar']/li[3]")
    public  WebElement we_strengthbar3;


    @FindBy(xpath ="//*[@id=/'strengthBar/']/li[4]")
    public  WebElement we_strengthbar4;

    @FindBy(xpath ="//*[@id='strengthBar']/li[5]")
    public  WebElement we_strengthbar5;




}





