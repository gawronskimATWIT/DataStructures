//michael Gawronski
package bag;

import java.util.Scanner;

public class BagTest {

    public static void main(String[] args) {
        ArrayBag <String> testbag = new ArrayBag <>();
        Object [] testarray;
        String aString;
        Scanner input = new Scanner(System.in);
        for (int idx = 0; idx < 4; idx ++){
            System.out.println("New string:");
            aString = input.nextLine();
            testbag.add(aString);
        }
        testarray = testbag.toArray();
        for (Object s : testarray)
            System.out.println( (String) s);

        int n = testbag.getCurrentSize();
        System.out.println ("The size is " + n);

       // System.out.println(testbag.remove("AAA"));
        //System.out.println(testbag.remove ("TTT"));

        testarray = testbag.toArray();
        for (Object s : testarray)
            System.out.println( (String) s);


        //tests contains(T anEntry)
        boolean contains;
        System.out.println("Please enter String to search:");
      String testString= input.nextLine();
        System.out.println(testString +" is in the bag "+testbag.contains(testString));
        //Tests getFrequencyOf(T anEntry)
        System.out.println("Please enter String to count:");
        testString = input.nextLine();
        System.out.println( "There are "+testbag.getFrequencyOf(testString)+testString + "in the bag ");


        testbag.clear();
        n = testbag.getCurrentSize();
        System.out.println ("The size now is " + n);


        input.close();
    }

}