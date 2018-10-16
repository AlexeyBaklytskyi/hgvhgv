import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayBoxTest {
    public static final int [] array = {4,3,4,6,7,9};
    private ArrayBox arraybox;
    @Before
    public void init(){
       arraybox = new ArrayBox();
    }
    @Test
    public void verifyCountEvenNumbers(){
        int expectedCount = 3;
        arraybox.setArray(array);
        int actualCount = arraybox.arrayPars(array);
        Assert.assertEquals(expectedCount, actualCount);
           }
    @After
    public void deleteObject(){
        arraybox = null;
    }

}
