package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPaymentPage {
    private WebDriver driver;

    public CartPaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id='cart_summary']//tbody[1]/tr[1]/*[@data-title='Total']/span[1]")
    private WebElement priceFirst;
    @FindBy (xpath = "//*[@id='cart_summary']//tbody[1]/tr[2]/*[@data-title='Total']/span[1]")
    private WebElement priceSecond;
    @FindBy (xpath = "//td [@id = 'total_product']")
    private WebElement sumOfProductPrices;
    @FindBy (xpath = "//td[@id='total_price_container']")
    private WebElement totalPrice;
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
    public void waitTillRefreshProducts(){
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cart_summary']//tbody[1]/tr[1]/*[@data-title='Total']/span[1]")));
    }


}
