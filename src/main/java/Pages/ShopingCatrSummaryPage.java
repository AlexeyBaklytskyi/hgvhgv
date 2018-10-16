package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopingCatrSummaryPage {
    private WebDriver driver;

    public ShopingCatrSummaryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy (id = "summary_products_quantity")
    private WebElement summaryProductsQuantity;
    @FindBy (xpath = "//*[@class = 'cart_navigation clearfix']//*[@title='Proceed to checkout']")
    private WebElement proceedToCheckOutButton;
    @FindBy (xpath= "//*[contains(@class,'cart_item first_item')]//*[@data-title='Total']/span[1]")
    private WebElement priceFirst;
    @FindBy (xpath = "//*[contains(@class,'cart_item last_item ')]//*[@data-title='Total']/span[1]")
    private WebElement priceSecond;
    @FindBy (xpath = "//td [@id = 'total_product']")
    private WebElement sumOfProductPrices;
    @FindBy (xpath = "//td[@id='total_price_container']")
    private WebElement totalPrice;
    @FindBy (xpath = "//*[@id=\"3_13_0_0\"]")
    private WebElement dellteButton1;
    @FindBy(xpath = "//*[@id=\"5_19_0_0\"]")
    private WebElement dellteButton2;


 public char GetsummaryProductsQuantity(){
     String  sumProdQnty = summaryProductsQuantity.getText();
      char sumProdQntyChar = sumProdQnty.charAt(0);
     return sumProdQntyChar;
 }
   public void clickProceedToCheckOutButton(){
       proceedToCheckOutButton.click();
   }
    public String GetPriceFirst() {
        String priceFirstS = priceFirst.getText();
        return priceFirstS;
    }
    public String GetPriceSecond() {
        String priceSecondS = priceSecond.getText();
        return priceSecondS;
    }
    public String getSumOfProductPrices() {
        String sumOfProductPricesS = sumOfProductPrices.getText();
        return sumOfProductPricesS;
    }
    public String getTotalPrice() {
        String totalPriceS = totalPrice.getText();
        return totalPriceS;
    }
    public void deleteProduct1(){
        dellteButton1.click();
    }
    public void deleteProduct2(){
        dellteButton2.click();
    }
}
