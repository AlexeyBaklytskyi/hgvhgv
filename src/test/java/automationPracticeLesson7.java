import Pages.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

public class automationPracticeLesson7 {

    private static WebDriver driver;
    @Before
    public void getWebDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\Train\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com");

    }
    @Test
    public void verifyPaymentSection () {
       /* Зарегистрировать нового пользователя - проверить что пользователь зарегистрирован
        Открыть Dresses
        Переключится в List View
        Отфильтровать товары по размеру L
        Отсортировать товары по возрастанию цены
        Добавить первые два товара в корзину
        Перейти в корзину
        Проверить что оба товара в корзине
        Проверить что Total товаров равно Total Products
        Проверить что скидка на цену корректная
        Перейти в Adress - проверить Billing Adress
        Перейти в Shipping
        Активировать “I agree ...”
        Перейти на страницу Payment
        Сравнить что значения в блоке Payment соответствуют значениям на Cart  Summary*/

        NavigationPage navigationPage = new NavigationPage(driver);
        AuthentacationPage authentacationPage = new AuthentacationPage(driver);
        CreateAccauntPage createAccauntPage = new CreateAccauntPage(driver);
        DressesPage dressesPage = new DressesPage(driver);
        ShopingCatrSummaryPage shopingCatrSummaryPage = new ShopingCatrSummaryPage(driver);
        CartAdressPage cartAdressPage = new CartAdressPage(driver);
        CartShippingPage cartShippingPage = new CartShippingPage(driver);
        CartPaymentPage cartPaymentPage = new CartPaymentPage(driver);
        navigationPage.openSignInPage();
        authentacationPage.emailCreateFealdFiilIn("BakllTestmail995@gmail2.com");
        authentacationPage.clickSubmitButton();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
       createAccauntPage.createAccaunt();
        verifyThetAccauntCreatedComplete("Alex Bakl");
        navigationPage.clickDressesButton();
        dressesPage.swichToListView();
        dressesPage.filterBySizeL();
        dressesPage.chooseSelectorBySort();
        dressesPage.waitTillRefreshProducts();
         dressesPage.addProductToCart();
        char expectedProductsQntty = shopingCatrSummaryPage.GetsummaryProductsQuantity();
        verifySummaryProductsQuantity(expectedProductsQntty);
        verifyThatDiscountCorrect();
        String firstPriceInSummary = shopingCatrSummaryPage.GetPriceFirst();
        String secondPriceInSummary = shopingCatrSummaryPage.GetPriceSecond();
        String sumOfPricesInSummary = shopingCatrSummaryPage.getSumOfProductPrices();
        String totalPrceInSummary = shopingCatrSummaryPage.getTotalPrice();
        shopingCatrSummaryPage.clickProceedToCheckOutButton();
        String billingFirstLastName = cartAdressPage.getFirstLastNameBillin();
        String billingAdress = cartAdressPage.getAdressBillin();
        String billingCity =  cartAdressPage.getCityBillin();
        String billingState = cartAdressPage.getStateBillin();
        String billingMobileNumber = cartAdressPage.getMobileNumberBillin();

        String deliveryFirstLastName = cartAdressPage.getFirstLastNameDelivery();
        String deliveryAdress = cartAdressPage.getAdressDelivery();
        String deliveryCity = cartAdressPage.getCityDelivery();
        String deliveryState = cartAdressPage.getStateDelivery();
        String deliveryMobileNumber = cartAdressPage.getMobileNumberDelivery();
        verifyBillingAdress(deliveryFirstLastName,billingFirstLastName);
        verifyBillingAdress(deliveryCity,billingCity);
        verifyBillingAdress(deliveryState,billingState);
        verifyBillingAdress(deliveryAdress,billingAdress);
        verifyBillingAdress(deliveryMobileNumber,billingMobileNumber);
        cartAdressPage.clickProceedToCheckOutButton();
        cartShippingPage.checkAgreementCheckBox();
        cartShippingPage.clickProceedToCheckOutButton();

        cartPaymentPage.waitTillRefreshProducts();
        String firstPriceInPayment = cartPaymentPage.GetPriceFirst();
        String secondPriceInPayment = cartPaymentPage.GetPriceSecond();
        String sumOfPricesInPayment = cartPaymentPage.getSumOfProductPrices();
        String totalPrceInPayment = cartPaymentPage.getTotalPrice();
        verifyPrices(firstPriceInSummary,firstPriceInPayment);
        verifyPrices(secondPriceInSummary,secondPriceInPayment);
        verifyPrices(sumOfPricesInSummary,sumOfPricesInPayment);
        verifyPrices(totalPrceInSummary,totalPrceInPayment);

    }
    @After
    public void finish() {
        driver.close();
    }

         private void verifyThetAccauntCreatedComplete(String expectedUser){
             String actualUser = driver.findElement(By.xpath("//a[@class='account']/span")).getText();
             Assert.assertEquals(expectedUser, actualUser);
         }
         private void verifySummaryProductsQuantity(char expectedProductsQntty){
            char ExpectedProductsQntty = '2';
             Assert.assertEquals(ExpectedProductsQntty,expectedProductsQntty );
         }
         private void verifyThatDiscountCorrect(){
             DecimalFormat dec = new DecimalFormat("#0.00");
             String oldPrice = driver.findElement(By.xpath("//*[contains(@class,'cart_item first_item')]//span[3]")).getText();
             String newPrice = driver.findElement(By.xpath("//*[contains(@class,'cart_item first_item')]//span[@class='price']/span[1]")).getText();
             oldPrice = oldPrice.replaceAll("[^0-9&!\\.]","");
             double value = Double.parseDouble(oldPrice);
             double expectedNewPrice = value*0.8;
             newPrice = newPrice.replaceAll("[^0-9&!\\.]","");
             double actualNewPrice = Double.parseDouble(newPrice);
             Assert.assertEquals(dec.format(expectedNewPrice),dec.format(actualNewPrice));
    }
            private void verifyBillingAdress(String expectedDelivery,String actualBilling){

            Assert.assertEquals(expectedDelivery,actualBilling);
            }
            private void verifyPrices(String expectedPrise,String actualPrice){
                Assert.assertEquals(expectedPrise,actualPrice);
    }

}