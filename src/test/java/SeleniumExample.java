import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeleniumExample {
/*  @Test
    public void initBrowser(){
      System.setProperty("webdriver.chrome.driver","D:\\Train\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
      WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.close();
    }*/
   WebDriver driver;
     @Before
     public void getWebDriver() {
       System.setProperty("webdriver.chrome.driver", "D:\\Train\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
      driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("http://automationpractice.com/index.php");

     }

      @Test
    public void verifyThatPrudactPriceDisplaydInDemoSection (){
        inputIntoSearchFielfAndClickToSambit("Blouse");
        String expectedPrice = "$27.00";
        swichToListView();
        openProdactView();
        WebElement actualPrice = driver.findElement(By.id("our_price_display"));
        Assert.assertEquals(expectedPrice,actualPrice.getText());
         }

        private void swichToListView(){
       driver.findElement(By.className("icon-th-list")).click();
         }
        private void  openProdactView(){
       driver.findElement(By.xpath("//*[@title='View']")).click();
          }
  @Test
  public void verifyThatSectionsNameSMassegeDisplaydInEmptyCart () {

    WebElement cartButton = driver.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?controller=order']"));
    cartButton.click();
    WebElement firstStep = driver.findElement(By.xpath("//li[@class='step_current  first']"));
    Assert.assertEquals("01. Summary", firstStep.getText());
    WebElement secondStep = driver.findElement(By.xpath("//li[@class='step_todo second']"));
    Assert.assertEquals("02. Sign in", secondStep.getText());
    WebElement thirdStep = driver.findElement(By.xpath("//li[@class='step_todo third']"));
    Assert.assertEquals("03. Address", thirdStep.getText());
    WebElement fourStep = driver.findElement(By.xpath("//li[@class='step_todo four']"));
    Assert.assertEquals("04. Shipping", fourStep.getText());
    WebElement fiveStep = driver.findElement(By.xpath("//li[@class='step_todo last']"));
    Assert.assertEquals("05. Payment", fiveStep.getText());
    WebElement emptyCartMessege = driver.findElement(By.xpath("//p[@class='alert alert-warning']"));
    Assert.assertEquals("Your shopping cart is empty.", emptyCartMessege.getText());

    List<WebElement> shopingCartSteps = driver.findElements(By.xpath("//ul[@class='step clearfix']"));
    List <String> actualOrders = new ArrayList<String>();
    for (WebElement shopingCartSep : shopingCartSteps ) {
      actualOrders.add(shopingCartSep.getText());
    }
      List <String> expectedOrders = Arrays.asList("01. Summary","02. Sign in","03. Address","04. Shipping","05. Payment");
      Assert.assertTrue(expectedOrders.equals(actualOrders));


  }

    private void inputIntoSearchFielfAndClickToSambit(String name){
        WebElement searchField = driver.findElement(By.id("search_query_top"));
        searchField.sendKeys(name);
        WebElement submitButton = driver.findElement(By.name("submit_search"));
        submitButton.click();
    }
@After
public void stop(){
    driver.close();
  }
}
