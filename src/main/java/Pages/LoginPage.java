package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    private WebDriver driver;
    public LoginPage(WebDriver driver){this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "passwd")
    private WebElement password;
    @FindBy(id = "SubmitLogin")
    private WebElement submitloginButton;
    @FindBy (className = "login")
    private WebElement sinIn;


    public void openSignInPage(){
        sinIn.click();
    }


    public LoginPage typeEmail(String mail){
        email.sendKeys(mail);
        return this;
    }
    public LoginPage typePassword(String pass){
        password.sendKeys(pass);
        return this;
    }
    public MyAccauntPage  clickSubmitLogin(){
        submitloginButton.click();
        return new MyAccauntPage(driver);
    }



}
