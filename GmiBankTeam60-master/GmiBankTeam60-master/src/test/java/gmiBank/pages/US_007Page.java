package gmiBank.pages;


import gmiBank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
;

public class US_007Page {
    public US_007Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy (xpath = "//div[@class='invalid-feedback']")
    public WebElement emailTextBoxInvalisMessage ;


}
