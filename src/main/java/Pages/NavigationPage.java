package Pages;
import Utils.Log;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationPage {

    private WebDriver driver;

    public NavigationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "login")
    private WebElement sinIn;
    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]/a")
    private WebElement dressesButton;
    @FindBy(xpath = "//a[@title ='Women']")
    private WebElement womenButton;
    @FindBy(xpath = "//*[@title='Contact Us']")
    private WebElement contactUsLink;
    @FindBy(xpath = "//*[@id=\"newsletter-input\"]")
    private WebElement newsLetterForEmailField;
    @FindBy(xpath = "//*[@id=\"newsletter_block_left\"]/div/form/div/button")
    private WebElement newsLetterForEmailButton;
    @FindBy(xpath = "//*[@id=\"columns\"]/p")
    private WebElement newsLetterErrorMessage;

 @Step
    public void openSignInPage() {
        sinIn.click();
    }

    public void fillInSearchField(String name) {
        WebElement searchField = driver.findElement(By.id("search_query_top"));
        searchField.sendKeys(name);
    }


    public void clickSearchButton() {
        Log.LOG.info("Click to search button");
        driver.findElement(By.name("submit_search")).click();
    }

    public void clickDressesButton() {
        dressesButton.click();
    }

    @Step
    public void clickWomenButton() {
        Log.LOG.info("Click on Women category button");
        womenButton.click();
    }

    private void addMoreOneItemToProductsInTheCart() {
        new WebDriverWait(driver, 10);
        driver.findElement(By.xpath("c//*[@class='icon-plus']")).click();
    }

    public void fillInNewsLetterFieldWithEmail() {
        newsLetterForEmailField.sendKeys("asdwerfdedcfrt.com");
        newsLetterForEmailButton.click();
    }

    public void goToContuctUsPage() {
        contactUsLink.click();
    }

    public String getNewsLetterErrorMessage() {
        String erMass = newsLetterErrorMessage.getText();
        return erMass;
    }
}

