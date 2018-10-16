import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public class Lesson2HWp1 {

    public static void main(String[] args) {
        int b=0;
        int[] arrey = new int[15];
        for(int i=0;i<arrey.length;i++){
            Random rnd=new Random();
            arrey[i]=rnd.nextInt(10);}
        System.out.println(Arrays.toString(arrey));
        for(int i=0;i<arrey.length;i++){
            if(arrey[i]>0&arrey[i]%2==0)
                b++;}


        sortArray (arrey);
     /*   int per1;
        String str = "$20.50";
        str = str.replaceAll("[^0-9&!\\.]","");
        double value = Double.parseDouble(str);
         value = value*0.8;*/
        System.out.println("Всего в массиве "+b+" четных");
       /* DecimalFormat dec = new DecimalFormat("#0.00");
        System.out.println(dec.format(value));*/

    }
    public static void sortArray (int[]arr){
        for (int i=arr.length- 1;i >= 0;i--) {

            for (int j=0;j<i;j++) {
                if (arr[j]<arr[j+1]) {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            System.out.print (arr[i]+", ");
                   }
        System.out.println (" ");
    }
}

