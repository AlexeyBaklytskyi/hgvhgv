package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MyAccauntPage {

    private WebDriver driver;
    public MyAccauntPage (WebDriver driver){this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
