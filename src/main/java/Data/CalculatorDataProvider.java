package Data;

import org.testng.annotations.DataProvider;

public class CalculatorDataProvider {

    @DataProvider
    public Object[][] FunctionalTestsForCalc() {
        return new Object[][]{
                {"2", "ADDITION","2","4"},
                {"2","DIVISION", "2","1"},
                {"2","MODULO","2","0"},
                {"2","MULTIPLICATION","2","4"},
                {"2","SUBTRACTION","2","0"}
        };
    }
}
