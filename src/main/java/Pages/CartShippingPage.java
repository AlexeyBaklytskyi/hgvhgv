package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartShippingPage {
    private WebDriver driver;

    public CartShippingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "uniform-cgv")
    private WebElement agreementCheckBox;
    @FindBy(xpath = "//*[@class = 'cart_navigation clearfix']//*[@name='processCarrier']")
    private WebElement proceedToCheckOutButton;

    public void checkAgreementCheckBox(){
        agreementCheckBox.click();
    }
    public void clickProceedToCheckOutButton(){
        proceedToCheckOutButton.click();
    }
}
