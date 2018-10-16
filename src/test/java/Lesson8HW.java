import Pages.NavigationPage;
import Pages.ShopingCatrSummaryPage;
import Pages.WomanPage;
import Utils.Config;
import Utils.Log;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.acl.Group;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Lesson8HW {

    private static WebDriver driver;
 private final Properties config = Config.loadProperties("config.properties");
    @BeforeMethod
    public void getWebDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\Train\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(config.getProperty("baseurl"));
     //вместо   driver.get("http://automationpractice.com");

    }

    @Test (groups = "positiye1")
    public void verifySortingByPrice() {

        NavigationPage navigationPage = new NavigationPage(driver);
        WomanPage womanPage = new WomanPage(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        navigationPage.clickWomenButton();
        womanPage.filterByPrice();
        womanPage.addProductsToCart();
        deleteMoreExpensiveProduct();


    }
    @AfterMethod
    public void finish() {
        driver.close();
    }


    private void deleteMoreExpensiveProduct() {
        Log.LOG.info("Deleting More Expensive product from cart");
        ShopingCatrSummaryPage shopingCatrSummaryPage = new ShopingCatrSummaryPage(driver);
        String price1 = driver.findElement(By.xpath("//*[contains(@class,'cart_item first_item')]//*[@data-title='Unit price']/span"))
                .getText();
        String price2 = driver.findElement(By.xpath("//*[contains(@class,'cart_item last_item')]//*[@data-title='Unit price']/span/span[1]"))
                .getText();
        price1 = price1.replaceAll("[^0-9&!\\.]", "");
        double valuePrice1 = Double.parseDouble(price1);
        price2 = price2.replaceAll("[^0-9&!\\.]", "");
        double valuePrice2 = Double.parseDouble(price2);
        if (valuePrice1 > valuePrice2) {
            shopingCatrSummaryPage.deleteProduct1();
        }else {
            shopingCatrSummaryPage.deleteProduct2();

        }
    }
}

