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

public class Lesson6 {
    WebDriver driver;

    @Before
    public void getWebDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\Train\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
@Test
    public void demoTest() {

        WebElement searchField = driver.findElement(By.id("search_query_top"));
        searchField.sendKeys("Blouse");
        WebElement submitButton = driver.findElement(By.name("submit_search"));
        submitButton.click();
        driver.findElement(By.className("icon-th-list")).click();
        driver.findElement(By.xpath("//*[@title='Add to cart']")).click();
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Proceed to checkout']")));
         driver.findElement(By.xpath("//*[@title='Proceed to checkout']")).click();

    }

    @After
    public void stop() {
        driver.close();
    }
}