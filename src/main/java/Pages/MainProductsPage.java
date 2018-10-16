package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainProductsPage {

    private WebDriver driver;

    public MainProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy (xpath = "//*[@title='Faded Short Sleeve T-shirts']")
    private WebElement  product1;
    public void mooveToProduct(){
        Actions actions = new Actions(driver);
        actions.moveToElement(product1).build().perform();
        // actions.dragAndDropBy(productItem,30,0);
        //actions.moveByOffset(40,0);
    }

}
