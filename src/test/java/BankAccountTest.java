import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {
    private BankAccount bankAccount;
    @Before
    public void init() {
       bankAccount = new BankAccount();
        bankAccount.setAccountNumber(123);
        bankAccount.setBalance(100);
    }
    @Test
    public void verifyCredit(){
        double expectedBalance = 150;
        double actualBalance =  bankAccount.credit(50);
        Assert.assertEquals(expectedBalance, actualBalance, 0.00);
    }
    @Test
    public void verifyDebitPosiyive(){
        double expectedBalance = 50;
        double actualBalance =  bankAccount.debit(50);
        Assert.assertEquals(expectedBalance, actualBalance,0.00);
    }
    @Test
    public void verifyDebitNegative(){

        double actualBalance =  bankAccount.debit(150);

        Assert.assertFalse("Сумма снятия больше чем остаток на счету!", false);
    }

    @After
    public void deleteObject(){
        bankAccount.setBalance(100);
        bankAccount = null;
    }
}
