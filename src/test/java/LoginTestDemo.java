import Model.Accaunt;
import Pages.LoginPage;
import Pages.MyAccauntPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestDemo {

    private static WebDriver driver;
    LoginPage loginPage;
    MyAccauntPage myAccauntPage;

    @Before
    public void getWebDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\Train\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com");

    }
    @Test
    public void verifyLoginWithCorrectData(){
        Accaunt accaunt = new Accaunt();
        accaunt.setEmail("BakllTestmail@gmail.com");
        accaunt.setPassword("123456789");

        loginPage = new LoginPage(driver);
        myAccauntPage = new MyAccauntPage (driver);
        loginPage.openSignInPage();
        loginPage.typeEmail(accaunt.getEmail()).
                typePassword(accaunt.getPassword()).
                        clickSubmitLogin();
    }
}
