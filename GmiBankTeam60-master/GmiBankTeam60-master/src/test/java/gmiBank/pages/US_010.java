package gmiBank.pages;

import gmiBank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_010 {

    public US_010() { PageFactory.initElements(Driver.getDriver(), this);}


    @FindBy(xpath = "//input[@name='middleInitial']")
    public WebElement middleInitial;

    @FindBy(xpath = "//input[@name='zipCode']")
    public WebElement zipcode;

    @FindBy(xpath = "//input[@name='city']")
    public WebElement city1;

    @FindBy(xpath = "//select[@name='country.id']")
    public WebElement country;

    @FindBy(xpath = "//input[@name='state']")
    public WebElement state;

    @FindBy(xpath = "//select[@id='tp-customer-user']")
    public WebElement user;

    @FindBy(xpath = "//button[@id='save-entity']")
    public WebElement saveBtn;

    @FindBy(xpath = "//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement acceptMessage;   // Bir daha kisa olanini dene . Sistem gelince Unutma


    @FindBy(xpath = "(//div[@class='invalid-feedback'])[4]")
    public WebElement errorMessage;


}


