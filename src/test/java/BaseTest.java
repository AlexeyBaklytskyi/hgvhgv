import Pages.AngularCalculatorPage;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;


public class BaseTest {
    private static WebDriver driver;
    AngularCalculatorPage angularCalculatorPage;
    @Parameters("browser")
    @BeforeMethod (alwaysRun = true)
    public void getWebDriver(@Optional("chrome") String browser) {
        /*if (browser.equals("chrome")) {

            ChromeDriverManager.chromedriver().setup();
            *//*   System.setProperty("webdriver.chrome.driver", "D:\\Train\\ChromeDriver\\chromedriver_win32\\chromedriver.exe")*//*
            driver = new ChromeDriver();
        } else if(browser.equals("firefox")) {
            FirefoxDriverManager.firefoxdriver().setup();
             driver = new FirefoxDriver();
        }*/
        System.setProperty("webdriver.chrome.driver", "D:\\Train\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.way2automation.com/angularjs-protractor/calc/");
        angularCalculatorPage = new AngularCalculatorPage(driver);

    }

    public void getScreenShot() throws IOException {
        File screenshot = ((TakesScreenshot) driver).
                getScreenshotAs(OutputType.FILE);
        String path = "./target/screenshots/" + screenshot.getName();
        FileUtils.copyFile(screenshot, new File(path));
    }

            @AfterMethod(alwaysRun = true)
            public void close(ITestResult testResult) throws IOException {
                driver.manage().deleteAllCookies();
                if (testResult.getStatus() == ITestResult.FAILURE) {
                    getScreenShot();}
                driver.close();}

    }




