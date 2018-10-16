package Data;

import org.testng.annotations.DataProvider;

public class RegistrationDataProvider {
    @DataProvider
    public Object[][] RegistrationNegative() {
        return new Object[][]{
                {"BaklTestmail@gmail.com", "121323","Authentication failed."},
                {"email@gmail.com","", "Password is required."},
                {"","2312","An email address required."}
        };
    }
}
