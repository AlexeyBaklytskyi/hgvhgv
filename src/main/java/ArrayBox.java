import java.util.Arrays;
import java.util.Random;

public class ArrayBox {

    int counter=0;
    int [] array;
    public void setArray( int [] array) {
        this.array = array;
    }

    public int arrayPars(int [] arrey){

        for(int i=0;i<arrey.length;i++) {
            if (arrey[i] > 0 && arrey[i] % 2 == 0) {
                counter++;
            }
        }
         System.out.println("Всего в массиве "+counter+" четных");
        return counter;
    }

}
