package Pages;


import Utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.ref.WeakReference;

public class AngularCalculatorPage {
    private WebDriver driver;

    public AngularCalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "/html/body/div[3]/div/form/input[1]")
    private WebElement fealdForFirstNumber;
    @FindBy(xpath = "/html/body/div[3]/div/form/input[2]")
    private WebElement fealdForSecondNumber;
    @FindBy(xpath = "/html/body/div[3]/div/form/select")
    private WebElement actionDropBOX;
    @FindBy (xpath = "//*[@id=\"gobutton\"]")
    private WebElement goButton;
    @FindBy(xpath = "/html/body/div[3]/div/form/h2")
    private WebElement resalt;

    public String makeSomeCalculations(String firstNumber, String action, String secondNumber){
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/form/input[1]")));
        Log.LOG.info("Filling first number");
        fealdForFirstNumber.sendKeys(firstNumber);
        Log.LOG.info("Choosing action");
        chooseAction(action);
        Log.LOG.info("Filling second number");
        fealdForSecondNumber.sendKeys(secondNumber);
        goButton.click();
       /* new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/form/h2")));*/
        try {
            Thread.sleep( 4000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.LOG.info("Getting resalt number");
        String r =  resalt.getText();
      return r;
    }

    public void chooseAction(String action) {
        Select value = new Select(actionDropBOX);
        value.selectByValue(action);
        /*ADDITION +
        *DIVISION /
        *MODULO %
        *MULTIPLICATION *
        * SUBTRACTION -
        * */


    }
}