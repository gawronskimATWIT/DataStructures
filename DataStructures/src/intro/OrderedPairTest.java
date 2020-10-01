//@author Mike Gawronski
package intro;
import java.util.Scanner;
public class OrderedPairTest {

    public static void main(String[] args) {
        OrderedPair<String> couple = new OrderedPair<>("James", "Kathrin");

        String head = couple.getFirst();
        String spouse = couple.getSecond();

        System.out.println(head);
        System.out.println ("Head of household: "+ couple.getFirst() + "; spouse: "+ couple.getSecond());

        couple.swap();
        System.out.println ("Head of household: "+ couple.getFirst() + "; spouse: "+ couple.getSecond());

        OrderedPair <String> other = new OrderedPair();
        Scanner input = new Scanner (System.in);
        System.out.print ("Who is head of household?");

        other.setFirst (input.nextLine());
        System.out.print ("Who is dependent?");

        other.setSecond (input.nextLine());
        System.out.println ("Same couple? " + couple.equals(other));
        other.swap();
        System.out.println ("Same couple after swap? " + couple.equals(other));

        OrderedPair <String> copied = couple.copy();

        System.out.println ("Is copied the same as original? " + copied.equals (couple));

        couple.setFirst("Peter");
        System.out.println ("Head of household for the copied is " + copied.getFirst());

    }
}