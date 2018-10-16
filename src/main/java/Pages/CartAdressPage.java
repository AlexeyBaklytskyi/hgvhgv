package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartAdressPage {
    private WebDriver driver;

    public CartAdressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id = 'address_delivery']//*[@class='address_firstname address_lastname']")
    private WebElement firstLastNameDelivery;
    @FindBy(xpath = "//*[@id = 'address_delivery']//*[@class='address_address1 address_address2']")
    private WebElement adressDelivery;
    @FindBy(xpath = "//*[@id = 'address_delivery']//*[@class='address_city address_state_name address_postcode']")
    private WebElement cityDelivery;
    @FindBy(xpath = "//*[@id = 'address_delivery']//*[@class='address_country_name']")
    private WebElement stateDelivery;
    @FindBy(xpath = "//*[@id = 'address_delivery']//*[@class='address_phone_mobile']")
    private WebElement mobileNumberDelivery;


    @FindBy(xpath = "//*[@id = 'address_invoice']//*[@class='address_firstname address_lastname']")
    private WebElement firstLastNameBillin;
    @FindBy(xpath = "//*[@id = 'address_invoice']//*[@class='address_address1 address_address2']")
    private WebElement adressBillin;
    @FindBy(xpath = "//*[@id = 'address_invoice']//*[@class='address_city address_state_name address_postcode']")
    private WebElement cityBillin;
    @FindBy(xpath = "//*[@id = 'address_invoice']//*[@class='address_country_name']")
    private WebElement StateDBillin;
    @FindBy(xpath = "//*[@id = 'address_invoice']//*[@class='address_phone_mobile']")
    private WebElement mobileNumberBillin;
    @FindBy (xpath = "//button [@name= 'processAddress']")
    private WebElement proceedToCheckOutButton;

    public void clickProceedToCheckOutButton(){
        proceedToCheckOutButton.click();
    }

    public String getFirstLastNameDelivery (){
       String firstLastNameDeliveryS = firstLastNameDelivery.getText();
       return firstLastNameDeliveryS;    }
    public String getAdressDelivery (){
        String adressDeliveryS = firstLastNameDelivery.getText();
        return adressDeliveryS;    }
    public String getCityDelivery (){
        String cityDeliveryS = firstLastNameDelivery.getText();
        return cityDeliveryS;    }
    public String getStateDelivery (){
        String stateDeliveryS = firstLastNameDelivery.getText();
        return stateDeliveryS;     }
    public String getMobileNumberDelivery (){
        String mobileNumberDeliveryS = firstLastNameDelivery.getText();
        return mobileNumberDeliveryS;    }


    public String getFirstLastNameBillin (){
        String firstLastNameBillinS = firstLastNameBillin.getText();
        return firstLastNameBillinS;    }
    public String getAdressBillin (){
        String adressBillinS = firstLastNameBillin.getText();
        return adressBillinS;    }
    public String getCityBillin (){
        String cityBillinS = firstLastNameBillin.getText();
        return cityBillinS;    }
    public String getStateBillin (){
        String stateBillinS = firstLastNameBillin.getText();
        return stateBillinS;     }
    public String getMobileNumberBillin (){
        String mobileNumberBillinS = firstLastNameBillin.getText();
        return mobileNumberBillinS;    }


}

