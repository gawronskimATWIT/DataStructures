package DictionaryProject;

import javax.naming.OperationNotSupportedException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TelephoneDirectory {
    private DictionaryInterface <BusinessName, String> dictionary;

    public TelephoneDirectory (String filename) {
        dictionary = new ArrayDictionary();

        try {
            String line;
            String name = "";
            String town = "";
            String number = "";
            File f = new File(filename);
            Scanner read = new Scanner(f);
            while (read.hasNext()) {
                line = read.nextLine();
                /**
                 * Beacuse im bad a regex I had to split strings into 2 arrays because first
                 * regex splits given strings into 2 groups.
                 */
                Pattern pattern = Pattern.compile("[^,]+");
                String[] stringArray = line.("");
                name = stringArray[0];
                String[] townAndNumber = stringArray[1].split("[^\\s]+");
                /**
                 * townAndNumber[0] = town
                 * townAndNumber[1] = phone Number
                 **/
                town = townAndNumber[0];
                number = townAndNumber[1];
                BusinessName bname = new BusinessName(name, town);
                dictionary.add(bname, number);
            }
        }
        catch (FileNotFoundException ex) {
            System.out.print (ex.getMessage());
        }
    }

    public boolean isEmpty () {
        return dictionary.isEmpty();
    }
    public void printDirectory () {
        Iterator <BusinessName> nameIterator = dictionary.getKeyIterator();
        Iterator <String> numberIterator = dictionary.getValueIterator();
        while (nameIterator.hasNext()) {
            System.out.println (nameIterator.next() + ": " + numberIterator.next());
        }
    }

    public String add (String name, String number) {
        String[] nameArray = name.split("[^,]+");
        BusinessName bName = new BusinessName(nameArray[0],nameArray[1]);
        return dictionary.add (bName, number);

    }

    public String remove (String name) {
        String[] nameArray = name.split("[^,]+");
        BusinessName bName = new BusinessName(nameArray[0],nameArray[1]);
       return dictionary.remove(bName);
    }

    public String getPhoneNumber (BusinessName name) {
    return dictionary.getValue(name);
    }


    //extra credit
    public BusinessName getBusinessName (String phoneNumber) {
        return null;
    }


    public static void main ( String[] args) {
        TelephoneDirectory td = new TelephoneDirectory("DataStructures/src/DictionaryProject/resturants.txt");
        if (td.isEmpty())
            System.exit(0);
        td.add ("Chateau Restaurant, Waltham", "781-894-3339");
        td.printDirectory();

        System.out.println(" ========== After removal =========");
        td.remove("Real Italian Gusto, Medford");
        td.printDirectory();

    }
}