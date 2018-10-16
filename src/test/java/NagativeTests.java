import Pages.NavigationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NagativeTests {
    private static WebDriver driver;
    @BeforeMethod
    public void getWebDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\Train\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com");

    }

@Test (groups = "negative1")
public void newsletterValidation(){
    NavigationPage navigationPage = new NavigationPage(driver);
    navigationPage.fillInNewsLetterFieldWithEmail();
    String expectiveMessage = "Newsletter : Invalid email address.";
    String actualMessage   = navigationPage.getNewsLetterErrorMessage();

}


    @AfterMethod
    public void finish() {
        driver.close();
    }



}
