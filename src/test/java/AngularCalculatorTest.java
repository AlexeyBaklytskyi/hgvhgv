import Data.CalculatorDataProvider;
import Pages.AngularCalculatorPage;
import Utils.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AngularCalculatorTest  {
    private static WebDriver driver;
    @BeforeMethod
    public void getWebDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\Train\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.way2automation.com/angularjs-protractor/calc/");
    }
    @Test(groups = "AngularCalculatorTests", dataProvider = "FunctionalTestsForCalc", dataProviderClass = CalculatorDataProvider.class)
    public void functionalTests(String firstNumber, String action, String secondNumber, String expectedResalt) {

        AngularCalculatorPage angularCalculatorPage = new AngularCalculatorPage(driver);
       String actualResalt = angularCalculatorPage.makeSomeCalculations(firstNumber, action, secondNumber);

        Log.LOG.info("Checking the correctness of counting");
        Assert.assertEquals(expectedResalt,actualResalt);

    }
    @AfterMethod
    public void finish() {
        driver.close();
    }


}
