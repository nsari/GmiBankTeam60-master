package gmiBank.pages;

import gmiBank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_004SignInPage {
    public US_004SignInPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "  //*[text()='Çıkış']")
    public WebElement signoutCikis;

    @FindBy(xpath = "//*[text()='Whitney Swaniawski']")
    public WebElement userNameIsim;

    @FindBy(className = "dropdown-menu dropdown-menu-right show")
    public WebElement signOutDropdown;

    @FindBy(xpath = " //button[@class='btn btn-primary']")
    public WebElement signInTekrar;

    @FindBy(xpath = "//*[text()='İptal']")
    public WebElement iptalCancel;


}