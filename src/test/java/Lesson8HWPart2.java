import Data.RegistrationDataProvider;
import Pages.AuthentacationPage;
import Pages.NavigationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Lesson8HWPart2 {
    private static WebDriver driver;
    @BeforeMethod
    public void getWebDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\Train\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com");

    }


    @Test(dataProvider = "RegistrationNegative", dataProviderClass = RegistrationDataProvider.class)
    public void loginWithIncorrectCredentials(String email, String pass, String message) {

        NavigationPage navigationPage = new NavigationPage(driver);
        navigationPage.openSignInPage();
        AuthentacationPage authentacationPage = new AuthentacationPage(driver);
        authentacationPage.accRegistrate(email, pass);
        Assert.assertEquals(message,authentacationPage.getValidationMessage());

}
    @AfterMethod
    public void finish() {
        driver.close();
    }
}
