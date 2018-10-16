import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lesson2 {
    public static void main(String[] args) {

        Animal animal = new Animal();
        animal.setName("Barsik");
        animal.setAge(12);
        animal.setColor("Broun");
        /*Animal.showNameSAge(animal.name, 12);
        int[] numbers = {3, 5, 1, 8};
        int sum = 0;
        for (int i=0; i<4; i++){
            sum += numbers[i];
        }
        System.out.println (sum);
        */
//       Колекция
        List <Integer> numbers = new ArrayList();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        System.out.println (numbers);
        Set<Integer>ListSet = new HashSet<Integer>();
        ListSet.add (1);
        ListSet.add (2);
        ListSet.add (3);
        ListSet.add (4);
        for (Integer value :ListSet){
            System.out.println (value);
        }


    }
   public static void calculate (int a, int b){
     int sum = a+b;
       System.out.println(sum);
    }
    public static void calculate2 (int a, int b){
        int sum = a-b;
        System.out.println(sum);
    }
    public static int calculateNumbers (int a, int b){
        int sum = a+b;
        return sum;
    }
}

