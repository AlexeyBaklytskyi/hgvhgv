package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DressesPage {
    private WebDriver driver;
    public DressesPage(WebDriver driver){this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (className = "icon-th-list")
    private WebElement toListButton;
    @FindBy (id = "uniform-layered_id_attribute_group_3")
     private WebElement ButtonL;
    @FindBy (xpath = "//*[@class='selectProductSort form-control']")
    private WebElement selectorBySort;
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div/div[2]/h5/a")
    private WebElement firstDressName;
    @FindBy (xpath = "//li[@class= 'ajax_block_product first-in-line first-item-of-tablet-line first-item-of-mobile-line col-xs-12']//*[@class='button ajax_add_to_cart_button btn btn-default']")
    private WebElement addToCartButton1;
    @FindBy (xpath = "//*[@id=\"center_column\"]/ul/li[2]/div/div/div[3]/div/div[2]/a[1]/span")
    private WebElement addToCartButton2;
   @FindBy (xpath = "//*[@title='Continue shopping']")
   private WebElement continueShopingButton;
   @FindBy(xpath = "//*[@title='Proceed to checkout']")
   private WebElement proceedToCheckoutButton;
    public void swichToListView(){
        toListButton.click();
    }
    public  void filterBySizeL(){
        ButtonL.click();
    }
    public void chooseSelectorBySort() {
        Select value = new Select(selectorBySort);
        value.selectByValue("price:asc");
    }
    public void waitTillRefreshProducts(){
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class = 'ajax_block_product first-in-line first-item-of-tablet-line first-item-of-mobile-line col-xs-12']//*[@id='color_37']")));
    }
    public void addProductToCart(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class= 'ajax_block_product first-in-line first-item-of-tablet-line first-item-of-mobile-line col-xs-12']//*[@class='button ajax_add_to_cart_button btn btn-default']")));
        addToCartButton1.click();
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Continue shopping']")));
        continueShopingButton.click();
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div/div[3]/div/div[2]/a[1]/span")));
        addToCartButton2.click();
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Proceed to checkout']")));
        proceedToCheckoutButton.click();
    }
}
