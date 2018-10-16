package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthentacationPage {
    private WebDriver driver;

    public AuthentacationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email_create")
    private WebElement emailField;
    @FindBy (xpath = "//*[@id = 'email']")
    private WebElement email;
    @FindBy (xpath = "//*[@id = 'passwd']")
    private WebElement passwd;
    @FindBy(xpath = "//*[@id = 'SubmitLogin']")
    private WebElement submitButton;
@FindBy (xpath = "//*[@id=\"center_column\"]/div[1]/ol")
private WebElement errorMassege;


    @FindBy(id = "SubmitCreate")
    private WebElement SubmitButton;

    public void accRegistrate(String emaill, String password){
        email.sendKeys(emaill);
        passwd.sendKeys(password);
        submitButton.click();
    }
    public String getValidationMessage(){
        String msssage = errorMassege.getText();
        return msssage;
    }
    public void emailCreateFealdFiilIn(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void clickSubmitButton() {
        SubmitButton.click();
    }
}
