import Pages.LoginPage;
import Pages.MainProductsPage;
import Pages.MyAccauntPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;

public class Lesson8 {


    private static WebDriver driver;
    MainProductsPage mainProductsPage;

    @BeforeMethod
    public void getWebDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\Train\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com");

    }
    @Test
    public void verifyCart(){
        mainProductsPage = new MainProductsPage(driver);

        mainProductsPage.mooveToProduct();

    }
}
