package bag;

public class BagDriver {

    public static void main(String[] args) {
        LinkedBag<String> words = new LinkedBag<> ();

        words.add("home");
        words.add("sea");
        words.add("home");
        words.add("dog");

        LinkedBag<String> names = new LinkedBag<> ();

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


        LinkedBag <String> unionbag = words.union (names);
        Object[] content = unionbag.toArray();


        int len = unionbag.getCurrentSize();

        for (int idx = 0; idx < len; idx++)
            System.out.println(content[idx]);


        LinkedBag <String> intersect = names.intersection (words);
        content = intersect.toArray();
        len = intersect.getCurrentSize();
        System.out.println ("=======Intersection========");
        for (int idx = 0; idx < len; idx++)
            System.out.println(content[idx]);

    }
}