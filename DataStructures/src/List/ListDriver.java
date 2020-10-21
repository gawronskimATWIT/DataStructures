//michael Gawronski
package List;

import java.util.Scanner;

public class ListDriver<T> {
    public static void main (String [] args) {
        LList <String> al = new LList<> ();
        String sentence = "Look around and you will see ways that people organize things that are used in their everyday life";
        Scanner read = new Scanner (sentence);
        while (read.hasNext())
            al.add (read.next());
        // test the method contains
        System.out.println (al.getLength() + " entries");
        al.add (0, "Hey!");
        System.out.println(al.contains("Hey!"));
        System.out.println (al.getLength() + " entries after add");
        al.add (5, "guys");
        System.out.println (al.getLength() + " entries after add");
        al.remove (2);
        System.out.println (al.getLength() + " entries after remove at position");
        al.remove ("that");
        System.out.println (al.getLength() + " entries after remove entry");
        String old = al.replace (7,"in which");
        System.out.println (al.getLength() + " entries after replace");
        System.out.println (old + " was replaced");
        Object [] arr = al.toArray();
        int len = al.getLength();
        for (int idx = 0; idx < len; idx ++)
            System.out.print (arr[idx] + " ");
        System.out.println();
        al.clear();
        System.out.println ("Empty ? " + al.isEmpty());
    }







}
