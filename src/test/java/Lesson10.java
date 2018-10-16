import Pages.ContactUsPage;
import Pages.MainProductsPage;
import Pages.NavigationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Lesson10 {

    private static WebDriver driver;


    @BeforeMethod
    public void getWebDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\Train\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
               driver = new ChromeDriver();
                driver.manage().window().maximize();
        driver.get("http://automationpractice.com");

    }
    @Test (groups = "positiye1")
    public void test1(){
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        NavigationPage navigationPage = new NavigationPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        navigationPage.goToContuctUsPage();
        contactUsPage.attachFile();
    }

}
