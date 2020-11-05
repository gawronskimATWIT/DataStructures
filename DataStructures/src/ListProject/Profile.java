package ListProject;
//Michael Gawronski

import org.w3c.dom.ls.LSOutput;

public class Profile {

private Name profileName;
private String imageLocation;
private AList<String> status;
private AList<Name> friends;

public Profile(Name name){
friends = new AList<>();
status = new AList<>();
profileName = name;
}

    /**
     * gets profile name
     *
     * @return profileName
     */
    public Name getProfileName(){
    return profileName;
}
    public void bulkChangeName(Name targetName){
        profileName.changeFirstName(targetName.getFirstName());
        profileName.changeMiddleName(targetName.getMiddleName());
        profileName.changeLastName(targetName.getLastName());
    }

    /**
     * tests if the Profile's name matches given Profile's name
     *
     * @param otherProfile to be compared to
     * @return true if name are equal; else false
     */
    public boolean equals(Profile otherProfile) {
    if(otherProfile.getProfileName().equals(otherProfile.getProfileName()))
        return true;
    return false;

}

    /**
     * changes location to Name Class
     * allows other classes to change location
     * @param newLocation
     */
    public void changeLocation(String newLocation){
profileName.changeLocation(newLocation);
    }

 public void changeYearOfBirth(int yearOfBirth){
    profileName.addYOB(yearOfBirth);
 }

    public void addStatusEntry(String statusString){
    status.add(statusString);
}

public void addFriend(Name newFriend){
    friends.add(newFriend);
}

public void changeImage(String newLocation){
    imageLocation=newLocation;
}

    /**
     * Prints Profile overview.
     *
     */
    public void viewProfile() {
    System.out.println(profileName.getFirstName()+", " +profileName.getMiddleName()+", "+ profileName.getLastName());
    System.out.println("Location: ");
    System.out.println(profileName.getLocation());
    System.out.println("Status: ");
    String[] statusArray = (String[]) status.toArray();
    for (int i = 0; i < statusArray.length; i++) {
        System.out.println(i);
    }

    System.out.println("Friends: ");
    Name[] friendArray = (Name[]) friends.toArray();
    for (int i = 0; i < friendArray.length ; i++) {
        System.out.println(i);
    }


}



}
