package DLListProject;

import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Polygon {

    private DoublyLinkedList<Line> polyList;

    public Polygon(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scan = new Scanner(file);
        String parse;
        while(scan.hasNext()){
            parse = scan.nextLine();
            polyList.add(parseString(parse));
        }


    }
//there are probably better ways of doing this.
    private Line parseString(String string) {
        //Splits string along white space in between ordered pairs(took spaces out between , in polygon.dat)
        String[] stringArray = string.split("\\s+");
        String startPoint = stringArray[0];
        String endPoint = stringArray[1];
        //gets rid of parathenses.
        startPoint = startPoint.substring(startPoint.indexOf("(") + 1, startPoint.indexOf(")"));
        endPoint = endPoint.substring(endPoint.indexOf("(") + 1, endPoint.indexOf(")"));
        //removes comma from ordered pair
        String[] startPointArray, endPointArray;
        startPointArray = startPoint.split(",");
        endPointArray = endPoint.split(",");
        //creates new Line object with each x and y value from each point
        return new Line(Double.parseDouble(startPointArray[0]),Double.parseDouble(startPointArray[1]),Double.parseDouble(endPointArray[0]),Double.parseDouble(endPointArray[1]));
    }

    public void display(){
       Iterator<Line> listIterator = polyList.getIterator();
       int i = 1;
       while(listIterator.hasNext()){
        System.out.println("Line " + i + ": " + listIterator.next().toString());
        i++;
    }}


    public static void main(String[] args) throws FileNotFoundException {

        Polygon polygon = new Polygon("polygon.dat");

        polygon.display();
    }

}
