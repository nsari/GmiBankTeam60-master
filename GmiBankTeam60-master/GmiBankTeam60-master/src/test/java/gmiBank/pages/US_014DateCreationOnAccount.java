package gmiBank.pages;

import gmiBank.utilities.ConfigurationReader;
import gmiBank.utilities.DateUtil;
import gmiBank.utilities.Driver;
import gmiBank.utilities.ReusableMetods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class US_014DateCreationOnAccount {


    Actions action=new Actions(Driver.getDriver());

    public US_014DateCreationOnAccount(){
        PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "//*[text()='Manage Customers']")
    public WebElement manageCustomerBtn;
    // @FindBy(css = ".dropdown-item:nth-child(1)")

    @FindBy(xpath = "//input[@name='createDate']")
    public WebElement createDateTextBox;

    @FindBy(xpath = "//input[@name='closedDate']")
    public WebElement closedDateTextBox;

    @FindBy(xpath = "//*[text()='Save']")
    public WebElement saveBtnCreationAccount;

    @FindBy(css = "#jh-create-entity")
    public WebElement createNewCustomerButton;

    @FindBy(xpath = "//input[@id='search-ssn']")
    public WebElement ssnTextBox;

    @FindBy(css = ".btn.btn-secondary")
    public WebElement ssnSearchBtn;
    // //button[@type='button'][2]

    @FindBy(css = "#tp-customer-firstName")
    public WebElement firstNameAfterSearchTextBox;

    @FindBy(xpath = "//input[@name='middleInitial']")
    public WebElement middleInitialTextBox;

    @FindBy(xpath = "//input[@name='phoneNumber']")
    public WebElement phoneNumberTextBox;

    @FindBy(xpath = "//input[@name='zipCode']")
    public WebElement zipcodeTextBox;

    @FindBy(xpath = "//input[@name='city']")
    public WebElement cityTextBox;

    @FindBy(xpath = "//select[@name='country.id']")
    public WebElement countryDropdownMenu;

    @FindBy(xpath = "//input[@name='state']")
    public WebElement stateTextBox;

    @FindBy(xpath = "//select[@id='tp-customer-user']")
    public WebElement userTextBox;

    @FindBy(xpath = "//select[@id='tp-customer-account']")
    public WebElement accountSelectionDropdown;


    @FindBy(xpath = "//span[contains(text(),'Zelle Enrolled')]")
    public WebElement zelleEnrolled;

    @FindBy(xpath = "//button[@id='save-entity']")
    public WebElement saveSubmitBtn;

    @FindBy(className = "toast-container--top-left toastify-container")
    public WebElement internalServerErrorMessage;

    //div[@class='Toastify__toast-body']
    @FindBy (xpath = "//nav[1]/ul[1]/li[8]/a[1]")
    public WebElement paginationDropdownBox;


    public void selectTodaysDateforCreateDateTextBox(){
        String today = todaysDate1();
        String todayTime = todaysTime1();
        action.click(createDateTextBox).sendKeys(today+ Keys.TAB+todayTime).perform();

    }
    public void selectTodaysDateforClosedDateTextBox(){
        String today = todaysDate1();
        String todayTime = todaysTime1();
        action.click(closedDateTextBox).sendKeys(today+ Keys.TAB+todayTime).perform();

    }

    public void getCreationDateTextVerify() {
        String today = todaysDate1();
        String todayTime = todaysTime1();
        action.click(createDateTextBox).sendKeys(today + Keys.TAB + todayTime).perform();

        String realDateOnWebpage = createDateTextBox.getAttribute("value");
        System.out.println("Real Date on Webpage is: " + realDateOnWebpage);//09/10/2010T11:15

        //slash li formata ceviriyorum
        String realDateWithSlash = realDateOnWebpage.substring(5, 7) + "/" + realDateOnWebpage.substring(8, 10) + "/" + realDateOnWebpage.substring(0, 4);
        System.out.println("Actual real date with slash used is: " + realDateWithSlash);
        System.out.println("html code format is written <as yyyy-mm-dd hh:mm> which is wrong,there is BUG here in the html codes");

        //substringle indexlerle sadece time kismini aldim,burada zaten int formatinda veriyor,substringe gerek yok
        String realTime = todaysTime1();
        System.out.println("The real time is " + realTime);//11:15

        String realTimeasIntFormatOnWebPage = realDateOnWebpage.substring(11, 16);
        System.out.println("Actual time written on the webpage is " + realTimeasIntFormatOnWebPage);

        //assertion for dates for CreationDateTextBox
        System.out.println("Today is " + todaysDate1());
        Assert.assertEquals("dates are matching", todaysDate1(), realDateWithSlash);

        //assertion for times for CreationDateTextBox
        //12 luch ve midnight yaziliminda hata veriyor
        //assert i test ettigin saate gore degistirmen gerek. assertEquals/assertNotEquals

        Assert.assertEquals("times are matching BUT midnight and lunch time does not match, BUG(realtime: 12:26 webpage: 00:26)", realTime, realTimeasIntFormatOnWebPage);
    }

    public void getClosedDateTextVerify(){

        //bugunun tarihi giriliyor fakat baska tarih yaziyor,tarihler esit degil.
        //tiklandigi andaki zaman giriliyor ama zamanlar esit degil
        String today = todaysDate1();
        String todayTime =todaysTime1();
        action.click(closedDateTextBox).sendKeys(today+ Keys.TAB+todayTime).perform();

        String realDateOnWebpage = closedDateTextBox.getAttribute("value");
        System.out.println( "Real Date on Webpage is: " + realDateOnWebpage);

        //slash li formata ceviriyorum
        String realDateWithSlash = realDateOnWebpage.substring(5,7) + "/"+ realDateOnWebpage.substring(8, 10) + "/"+ realDateOnWebpage.substring(0,4);
        System.out.println("Actual real date with slash used is: "+realDateWithSlash);
        System.out.println("html code format is written <as yyyy-mm-dd hh:mm> which is wrong,there is BUG here in the html codes");

        //substringle indexlerle sadece time kismini aldim,burada zaten int formatinda veriyor,substringe gerek yok
        String realTime=todaysTime1();
        System.out.println("The real time is "+realTime);

        String realTimeasIntFormatOnWebPage=realDateOnWebpage.substring(11,16);
        System.out.println("Actual time written on the webpage is "+realTimeasIntFormatOnWebPage);

        //assertion for dates for ClosedDateTextBox
        System.out.println("Today is "+ todaysDate1());
        Assert.assertNotEquals("dates are not matching",todaysDate1(),realDateWithSlash);

        //assertion for times for ClosedDateTextBox
        Assert.assertNotEquals("times are not matching",realTime,realTimeasIntFormatOnWebPage);
        System.out.println("time and format do not show actual time when manually checked, there is a BUG closedDateTextBox");

    }

    public void orderOfDateFormatVerify(){
        String dateValue=createDateTextBox.getAttribute("value");
        String actualDate = dateValue.substring(5,7) + "/" + dateValue.substring(8, 10) + "/" + dateValue.substring(0,4);
        System.out.println("String actual date with slashes is: "+actualDate);
        String expectedOrderOfDate="Year/Month/Day"; //(html code order is taken)
        System.out.println("ExpectedOrderOfDate is: "+expectedOrderOfDate);

        int month = Integer.parseInt(actualDate.substring(0,2));
        System.out.println("Month is as an integer: "+month);

        int day = Integer.parseInt(actualDate.substring(3,5));
        System.out.println("Day is as an integer: "+day);

        int year = Integer.parseInt(actualDate.substring(6,10));
        System.out.println("Year is as an integer: "+year);

        //Arranging intervals on selections as int day,month,year
        String firstSection = ((month<=12 && month>0)?("Month"):("Day"));
        System.out.println("First selection: "+firstSection);
        String middleSection = ((day>=1 && day<=31)?("Day"):("Month"));
        System.out.println("Middle selection: "+middleSection);
        String thirdSection = ((year>31)?("Year"):("Month"));
        System.out.println("Third selection: "+thirdSection);
        String actualOrderOfDate=firstSection+"/"+middleSection+"/"+thirdSection;
        System.out.println("ActualOrderOfDate is: "+actualOrderOfDate);

        Assert.assertNotEquals("actual date and html date does not match to each other, there is a BUG",expectedOrderOfDate,actualOrderOfDate);

    }


    public static String todaysTime1() {
        String today = new SimpleDateFormat("hh:mm").format(new Date());
        return today;
    }

    public static String todaysDate1() {
        String today = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
        return today;
    }

    public void pageUp(WebElement webElement){
        JavascriptExecutor js =((JavascriptExecutor)Driver.getDriver());
        js.executeScript("window.scrollTo(0, document.body.scrollTop)");
    }

    public void sutunYazdir(int sutunNo){
        // ornek : her hangi bir satirdaki 2.sutunu bulmak istersek //tbody//tr//td[2] yazabiliriz

        String sutunPath= "//tbody//tr//td["+sutunNo+"]";


        WebElement sutunBasligi=Driver.getDriver().findElement(By.xpath("//thead//th[" + sutunNo + "]"));
        System.out.println(sutunBasligi.getText());

        List<WebElement> istenenSutunListeOlarak=Driver.getDriver().findElements(By.xpath(sutunPath));

        for (WebElement each: istenenSutunListeOlarak
        ) {
            System.out.println(each.getText());
        }


    }

    public String dataStringBul(int satirNo, int sutunNo){
        // ornek : her 3. satirdaki 2.sutunu bulmak istersek //tbody//tr[3]//td[2] yazabiliriz
        String dataPath="//tbody//tr["+ satirNo +"]//td["+sutunNo+"]";

        return Driver.getDriver().findElement(By.xpath(dataPath)).getText();
    }

    public WebElement dataWebelementiBul(int satirNo, int sutunNo){
        // ornek : her 3. satirdaki 2.sutunu bulmak istersek //tbody//tr[3]//td[2] yazabiliriz
        String dataPath="//tbody//tr["+ satirNo +"]//td["+sutunNo+"]";

        return Driver.getDriver().findElement(By.xpath(dataPath));
    }

    public void istenenHucreyiYazdir(int satirNo, int sutunNo){

        // ornek : 5.satir 4 sutunu yazdir  //tbody//tr[   5   ]//td[   4    ]
        String hucreXPath= "//tbody//tr["+ satirNo +"]//td["+ sutunNo + "]";

        WebElement istenenDataElementi= Driver.getDriver().findElement(By.xpath(hucreXPath));

        System.out.println(istenenDataElementi.getText());
    }




}
