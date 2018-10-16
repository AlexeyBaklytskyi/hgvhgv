import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class automationPactice2 {
    private static WebDriver driver;
    @Before
    public void getWebDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\Train\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com");

    }
    @Test
    public void verifyThatProductsDeletedFromCart(){
        fillInSearchField("Blouse");
        clickSearchButton();
        swichToListView();
        addToCart();
        addMoreOneItemToProductsInTheCart();
            new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ajax_cart_no_product']")));
               String emptyCartMassege = driver.findElement(By.id("total_product_price_2_7_103282")).getText();
        verifyPricesInTheCart("$54.00", "$54.00","$2.00",
                "$56.00", "$0.00", "$56.00");
        deleteProductsFromCart();

        Assert.assertEquals("(empty)", emptyCartMassege);
    }
    @After
    public void finish() {
        driver.close();
    }
    private void fillInSearchField(String name){
        WebElement searchField = driver.findElement(By.id("search_query_top"));
        searchField.sendKeys(name);

    }
    private void clickSearchButton(){
        driver.findElement(By.name("submit_search")).click();
            }
    private void swichToListView(){
        driver.findElement(By.className("icon-th-list")).click();
    }
    private void addToCart(){
        driver.findElement(By.xpath("//*[@title='Add to cart']")).click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Proceed to checkout']")));
        driver.findElement(By.xpath("//*[@title='Proceed to checkout']")).click();
        }
    private void addMoreOneItemToProductsInTheCart(){
        new WebDriverWait(driver, 10);
        driver.findElement(By.xpath("c//*[@class='icon-plus']")).click();
    }
    private void verifyPricesInTheCart(String expectedtotal, String expectedTotalProducts,String expectedTotalShipping,
                                       String expectedTotalProductsVsShipping,String expectedTax, String expectedTotalFinal){
        String actualTotal= driver.findElement(By.id("total_product_price_2_7_103282")).getText();
        Assert.assertEquals(expectedtotal, actualTotal);
        String actualTotalProducts= driver.findElement(By.id("total_product_price_2_7_103282")).getText();
        Assert.assertEquals(expectedTotalProducts, actualTotalProducts);
        String actualTotalShipping= driver.findElement(By.id("total_product_price_2_7_103282")).getText();
        Assert.assertEquals(expectedTotalShipping, actualTotalShipping);
        String actualTotalProductsVsShipping= driver.findElement(By.id("total_product_price_2_7_103282")).getText();
        Assert.assertEquals(expectedTotalProductsVsShipping, actualTotalProductsVsShipping);
        String actualTax= driver.findElement(By.id("total_product_price_2_7_103282")).getText();
        Assert.assertEquals(expectedTax, actualTax);
        String actualTotalFinal= driver.findElement(By.id("total_product_price_2_7_103282")).getText();
        Assert.assertEquals(expectedTotalFinal, actualTotalFinal);
    }
    private void deleteProductsFromCart(){
        driver.findElement(By.xpath("//*[@title='Delete']")).click();
        }
}
