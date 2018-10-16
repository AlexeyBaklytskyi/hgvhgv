package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateAccauntPage {
    private WebDriver driver;

    public CreateAccauntPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "id_gender1")
    private WebElement radioGender;
    @FindBy(xpath = "//*[@id=\"customer_firstname\"]")
    private WebElement fitstName;
    @FindBy(id = "customer_lastname")
    private WebElement secondName;
    @FindBy(id = "passwd")
    private WebElement password;
    @FindBy(id = "address1")
    private WebElement address;
    @FindBy(id = "city")
    private WebElement city;
    @FindBy(id = "id_state")
    private WebElement stateSelector;
    @FindBy(id = "postcode")
    private WebElement zipCode;
    @FindBy(id = "phone_mobile")
    private WebElement mobileNumber;
    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    public void checkGenderRadioButton() {
        radioGender.click();
    }
    public void fillInFitstName () {
        fitstName.sendKeys("Alex");
    }
    public void fillInSecondName() {
        secondName.sendKeys("Bakl");
    }
    public void fillInPassword(){
        password.sendKeys("123456789");
    }
     public void fillInCity (){
        city.sendKeys("Kiev");
    }
    public void fillInAddress(){
        address.sendKeys("Hreschatick str.");
    }
        public void chooseState() {
        Select value = new Select(stateSelector);
        value.selectByValue("32");
    }
    public void fillInZipCode(){
        zipCode.sendKeys("00000");
    }
    public void fillInMobileNumber(){
        mobileNumber.sendKeys("+90877654321");
    }
    public void clickButtonRegister(){
        registerButton.click();
    }
    public void createAccaunt(){
        checkGenderRadioButton ();
        fillInFitstName ();
        fillInSecondName();
        fillInPassword();
        fillInCity ();
        fillInAddress();
        chooseState();
        fillInZipCode();
        fillInMobileNumber();
        clickButtonRegister();

    }
    }

