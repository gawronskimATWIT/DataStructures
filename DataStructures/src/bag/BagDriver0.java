//Michael Gawronski
package bag;

public class BagDriver0 {

    public static void main(String[] args) {
        ResizableArrayBag <String> words = new ResizableArrayBag<> ();

        words.add("home");
        words.add("sea");
        words.add("home");
        words.add("dog");

        ResizableArrayBag<String> names = new ResizableArrayBag<> ();

        names.add ("sea");
        names.add ("home");
        names.add ("dog");
        names.add ("home");

        System.out.println ("The bags words and names are equal? " + words.equals (names));
        System.out.println ("The bags names and words are equal? " + names.equals (words));

        names.add ("dog");
        words.add ("sea");
        System.out.println ("++++++++++++++++++++++++++++++++");
        System.out.println ("The bags words and names are equal? " + words.equals (names));
        System.out.println ("The bags names and words are equal? " + names.equals (words));


        ResizableArrayBag<String> ww = words.copy();

        ResizableArrayBag <String> unionbag = ww.union (names);
        Object[] content = unionbag.toArray();


        int len = unionbag.getCurrentSize();

        for (int idx = 0; idx < len; idx++)
            System.out.println(content[idx]);

    }
}