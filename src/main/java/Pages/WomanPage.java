package Pages;

import Utils.Log;
import io.qameta.allure.Step;
import javafx.beans.value.WeakChangeListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WomanPage {

    private WebDriver driver;

    public WomanPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy (xpath = "//*[@id=\"layered_price_slider\"]/a[1]")
    private WebElement minPriceSlider;

    @FindBy (xpath = "//*[@id=\"layered_price_slider\"]/a[2]")
    private WebElement maxPriceSlider;
    @FindBy (xpath = "//a[contains(@title,'Printed Dress')]")
    private WebElement SomeDress;
    @FindBy (xpath = "//*[@id=\"center_column\"]/ul/li[3]/div/div[1]/div/a[1]/img")
    private WebElement SomeOtherDress;
    @FindBy (xpath = "//a[@title='Add to cart' and @data-id-product='3']")
    private WebElement addToCartButton1;
    @FindBy (xpath = "//a[@title='Add to cart' and @data-id-product='5']")
    private WebElement addToCartButton2;
    @FindBy(xpath = "//*[@title='Proceed to checkout']")
    private WebElement proceedToCheckoutButton;
    @FindBy (xpath = "//*[@title='Continue shopping']")
    private WebElement continueShopingButton;

    @Step
    public void filterByPrice(){
        Log.LOG.info("Filtering be price");
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(minPriceSlider,60,0).build().perform();
        actions.dragAndDropBy(maxPriceSlider,-50,0).build().perform();
    }
    public void mooveToProduct1(){
        Actions actions = new Actions(driver);
        actions.moveToElement(SomeDress).build().perform();
      }
    @Step
    public void clikToAddtoCartButton1(){
        addToCartButton1.click();
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Continue shopping']")));
        continueShopingButton.click();
    }
    public void mooveToProduct2(){
        Actions actions = new Actions(driver);
        actions.moveToElement(SomeOtherDress).build().perform();
    }
    @Step
    public void clikToAddtoCartButton2(){
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Add to cart' and @data-id-product='5']")));
        addToCartButton2.click();
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Proceed to checkout']")));
        proceedToCheckoutButton.click();
    }
 public void addProductsToCart(){

     mooveToProduct1();
     Log.LOG.info("Adding first product to cart");
     clikToAddtoCartButton1();
     mooveToProduct2();
     Log.LOG.info("Adding second product to cart");
    clikToAddtoCartButton2();
 }


}
