import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    public static final int FirstPosNumber = 10;
    public static final int SecondPosNumber = 5;
    private Calculator calculator;
    /* Все тестовые мутоды должны быть public, private это воспомагательные методы.
    * */
    @Before
    public void init(){
        calculator = new Calculator();
    }
    @Test
    public void verifyAddTwoPositivNumbers() {
        int expectedSuma = 15;
        calculator.setFirstNumber(FirstPosNumber);
        calculator.setSecondNumber(SecondPosNumber);
        int actualSumma = calculator.addNumbers();
        Assert.assertEquals(expectedSuma, calculator.addNumbers());
    }

    @Test
    public void verifyMultiplyTwoPositivNumbers() {
        int expectedMultiplication = 50;
        Calculator calculator = new Calculator();
        calculator.setFirstNumber(FirstPosNumber);
        calculator.setSecondNumber(SecondPosNumber);
        int actualMultiplication = calculator.multiplyNumbers();
        Assert.assertEquals(expectedMultiplication, calculator.multiplyNumbers());
    }

    @Test
    public void verifyDeductTwoPositivNumbers() {
        int expectedSuma = 5;
        Calculator calculator = new Calculator();
        calculator.setFirstNumber(FirstPosNumber);
        calculator.setSecondNumber(SecondPosNumber *-1);
        int actualSumma = calculator.addNumbers();
        Assert.assertEquals(expectedSuma, calculator.addNumbers());
    }
    @After
    public void deleteObject(){
        calculator = null;
    }


}

