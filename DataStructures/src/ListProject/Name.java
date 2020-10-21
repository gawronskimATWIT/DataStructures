package ListProject;
//Michael Gawronski
import java.awt.desktop.PreferencesEvent;

public class Name {
    private String firstName;
    private String middleName;
    private String lastName;
    private String location;
    private int yearOfBirth;
    private String suffix = null;

    public Name(String fName, String mName, String lName) {
        firstName=fName;
        middleName=mName;
        lastName=lName;
    }


    public void addYOB(int YOB){
        yearOfBirth=YOB;
    }

    /**
     * adds a suffix to name determined by the iteration of
     * the given name.
     *
     * @param iteration how many iterations of the name exist
     */
    public void addSuffix(int iteration){
        if(iteration>3){
            suffix = iteration +"rd";
        }
        if(iteration==2){
            suffix = "II";
        }
        if(iteration==3){
            suffix="III";
        }
    }
    public String getFirstName(){
        return firstName;
    }
    public String getMiddleName(){
        return middleName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getLocation(){
        return location;
    }
    public int getYearOfBirth(){
        return yearOfBirth;
    }
    public void changeFirstName(String fInput){
        firstName=fInput;

    }
    public void changeMiddleName(String middleInput){

        middleName=middleInput;
    }

    public void changeLastName(String lastInput){
        lastName=lastInput;
    }

    public void changeLocation(String inputLocation){
        location=inputLocation;
    }


    /**
     * compares each name field to see if they are equal
     *
     * @param otherName other Name to be compared against
     * @return true if names are equal; else false
     */
    public boolean equals(Name otherName){
        return ((otherName.getFirstName().equals(firstName))&&(otherName.getMiddleName().equals(middleName))&&(otherName.getLastName().equals(lastName)));
    }
    public String toString(){
        StringBuilder output = new StringBuilder();
        output.append(firstName+", ");
        output.append(lastName+", ");
        output.append(yearOfBirth);
        output.append(location);
        output.append(suffix);
        return output.toString();
    }



}
