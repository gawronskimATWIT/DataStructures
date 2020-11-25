package DLListProject;

import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polygon {

    private DoublyLinkedList<Line> polyList = new DoublyLinkedList<>();

    public Polygon(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scan = new Scanner(file);
        String parse;
        while(scan.hasNext()){
            parse = scan.nextLine();
            Line temp = parseString(parse);
            polyList.add(temp);
        }


    }

    /**
     * Uses regex to filter out digits from the strings.
     * took me a good amount of time to figure this out
     * tried
     *
     * @param string Line of ordered pairs requires 2 points
     * @return Line object from Double values from the given string
     */
    private Line parseString(String string){
        Matcher m = Pattern.compile("[+-]?((\\d+\\.?\\d*)|(\\.\\d+))").matcher(string);
        List<String> stringArray = new ArrayList<String>();
       while(m.find()){
           stringArray.add(m.group());
       }
        double[] doubleArray = new double[stringArray.size()];
       for (int i=0; i<doubleArray.length;i++) {
            doubleArray[i] =Double.parseDouble(stringArray.get(i));
        }
        return new Line(doubleArray[0],doubleArray[1],doubleArray[2],doubleArray[3]);



    }




// Old parseString method that didnt work

//there are probably better ways of doing this.
//    private Line parseString(String string) {
   //     Splits string along white space in between ordered pairs(took spaces out between , in polygon.dat)
//        String[] stringArray = string.split("\\s+");
//        String startPoint = stringArray[0];
//        String endPoint = stringArray[1];
 //       gets rid of parathenses.
//        startPoint = startPoint.substring(startPoint.indexOf("(") + 1, startPoint.indexOf(")"));
//        endPoint = endPoint.substring(endPoint.indexOf("(") + 1, endPoint.indexOf(")"));
 //       removes comma from ordered pair
//        String[] startPointArray, endPointArray;
//        startPointArray = startPoint.split(",");
//        endPointArray = endPoint.split(",");
  //      creates new Line object with each x and y value from each point
//        return new Line(Double.parseDouble(startPointArray[0]),Double.parseDouble(startPointArray[1]),Double.parseDouble(endPointArray[0]),Double.parseDouble(endPointArray[1]));
//    }

    public void display(){
       ListIterator<Line> listIterator = polyList.getIterator();
       int i = 1;
       while(listIterator.hasNext()){
        System.out.println("Line " + i + ": " + listIterator.next().toString());
        i++;
    }}


    public ListIterator<Line> getLineIterator() {
    return polyList.getIterator();
    }

    public void reverse() {
        polyList.reverse();
    }
}
