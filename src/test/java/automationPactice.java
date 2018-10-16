import Pages.AuthentacationPage;
import Pages.CreateAccauntPage;
import Pages.NavigationPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class automationPactice {
    private static WebDriver driver;
    @BeforeMethod
    public void getWebDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\Train\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
       driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com");

    }
    @Test(groups = "positiye1")
    public void verifySignUpErrorMassage() {
        NavigationPage navigationPage = new NavigationPage(driver);
        AuthentacationPage authentacationPage = new AuthentacationPage(driver);
        CreateAccauntPage createAccauntPage = new CreateAccauntPage(driver);
        navigationPage.openSignInPage();
        authentacationPage.emailCreateFealdFiilIn("BaklllTestmai1111l@gmaill.com");
        authentacationPage.clickSubmitButton();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        createAccauntPage.createAccaunt();
        verifyThetAccauntCreatedComplete("Alex Bakl");
    }
    @AfterMethod
    public void finish() {
        driver.close();
    }


    private void verifyThetAccauntCreatedComplete(String expectedUser){
        String actualUser = driver.findElement(By.xpath("//a[@class='account']/span")).getText();
        Assert.assertEquals(expectedUser, actualUser);
    }

}


