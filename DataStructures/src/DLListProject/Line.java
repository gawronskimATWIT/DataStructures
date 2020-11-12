package DLListProject;

import java.awt.geom.Point2D;

public class Line {
private Point2D start;
private Point2D end;





public Line(double x1, double y1, double x2,double y2){
start.setLocation(x1,y1);
end.setLocation(x2,y2);
}

public Line(Point2D start1, Point2D end1){
    start = start1;
    end = end1;

}


public Point2D getStart(){
    return start;
}
public Point2D getEnd() {
        return end;
}

public boolean equals(Line testLine){
    boolean Xtest=false;
    boolean Ytest=false;
    //tests if x values of the start and end are the same.
    if(testLine.getEnd().getX() == getEnd().getX() && testLine.getStart().getX() == getStart().getX()){
        Xtest = true;
    }
    if(testLine.getEnd().getY() == getEnd().getY() && testLine.getStart().getY() == getStart().getY()){
        Ytest = true;
    }
    return (Xtest && Ytest);
}


public String toString(){
    StringBuilder output = new StringBuilder();
    output.append("("  + getStart().getX() + ", " + getStart().getY()+")"+ "-> ");
    output.append("(" + getEnd().getX()+ ", " + getEnd().getY() + ")");
return output.toString();

}




}
