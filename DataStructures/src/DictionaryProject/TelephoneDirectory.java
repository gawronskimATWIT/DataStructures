package DictionaryProject;

import javax.naming.OperationNotSupportedException;
import javax.print.DocFlavor;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TelephoneDirectory {
    private DictionaryInterface <BusinessName, String> dictionary;

    public TelephoneDirectory (String filename) {
        dictionary = new SortedLinkedDictionary();
        //dictionary = new ArrayDictionary();
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
                Matcher m = Pattern.compile("[^,]+").matcher(line);
                List<String> nameList = new ArrayList<String>();
                while (m.find()){
                    nameList.add(m.group());
                }
                name = nameList.get(0);
               m = Pattern.compile("[^\\s]+").matcher(nameList.get(1));
               List<String> townAndNumber = new ArrayList<String>();
               while(m.find()){
                   townAndNumber.add(m.group());
               }
                /**
                 * townAndNumber[0] = town
                 * townAndNumber[1] = phone Number
                 **/
                town = townAndNumber.get(0);
                number = townAndNumber.get(1);
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
        Matcher m = Pattern.compile("[^,]+").matcher(name);
        List<String> nameList = new ArrayList<String>();
        while (m.find()){
            nameList.add(m.group());
        }
        BusinessName bName = new BusinessName(nameList.get(0),nameList.get(1));
        return dictionary.add (bName, number);

    }

    public String remove (String name) {
        Matcher m = Pattern.compile("[^,]+").matcher(name);
        String[] nameList = new String[256];
        int index=0;
        while (m.find()){
           nameList[index]= m.group();
            index++;
        }
        //gets rid of white space that would mess up .equals()
        nameList[1]= nameList[1].replaceAll(" ","");
        BusinessName bName = new BusinessName(nameList[0],nameList[1]);
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
        TelephoneDirectory td = new TelephoneDirectory("src/DictionaryProject/restaurants.txt");
        if (td.isEmpty())
            System.exit(0);
        td.add ("Chateau Restaurant, Waltham", "781-894-3339");
        td.printDirectory();

        System.out.println(" ========== After removal =========");
        td.remove("Real Italian Gusto, Medford");
        td.printDirectory();

    }
}