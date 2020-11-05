package ListProject;
//Michael Gawronski
import java.util.Scanner;


public class Network {
    private AList<Profile> profileList;

    public Network(){
        profileList = new AList<>();
    }

    /**
     * adds new Profile to the network and adds a suffix if there is more
     * than 1 of the same profile in the network
     *
     * @param newProfile  Profile that is to be added to network
     */
    public void addProfile(Profile newProfile){
        if(searchCount(newProfile)>1){
            newProfile.getProfileName().addSuffix(searchCount(newProfile));
        }
        profileList.add(newProfile);

    }

    /**
     * returns if network is empty
     *
     * @return true if network is empty; else false.
     */
    public boolean isEmpty(){
        return profileList.isEmpty();
    }

    /**
     * Gets amount of profile(s) match with given Profile in the network
     *
     *
     * @param profile target
     * @return int of amount of profiles that match requested Profile
     */
    public int searchCount(Profile profile){
Profile[] profileArray = (Profile[]) profileList.toArray();
int answer=0;
    for (Profile value : profileArray) {
        if (value.getProfileName().equals(profile.getProfileName()))
            answer++;
    }
    return answer;
}

    /**
     * Gets the index in the profile list for the targeted
     * profile
     *
     * @param profile
     * @return index of requested profile
     */
    public int getIndex(Profile profile){
        Profile[] profileArray = (Profile[]) profileList.toArray();
        int answer=0;
        for (int i = 0; i <profileArray.length ;i++) {
            if(profileArray[i].getProfileName().equals(profile.getProfileName()))
                answer = i;
        }
        return answer;
    }

    public Profile getEntry(int givenPosition){
        return profileList.getEntry(givenPosition);
    }


    /**
     * Main Menu for WIT Social Network
     * with 5 options to explore the network
     *
     * @param input Scanner for userinput
     * @param network Profile list
     */
    private static void menu(Scanner input, Network network) {
    System.out.println("Welcome to the WIT network");
    System.out.println("What would you like to do?");
    System.out.println("------------------------");
    System.out.println("1-Create new Profile");
    System.out.println("2-Add a new Status");
    System.out.println("3-Change Name");
    System.out.println("4-Search Profiles");
    System.out.println("5-Add new Friend");
    System.out.println("6-Exit");
    System.out.println("------------------------");
    int userInput = 0;
    try {
        userInput = input.nextInt();
    } catch (IllegalArgumentException e) {
        System.out.println("Please enter a correct entry.");
        System.exit(0);
    }
    if (userInput > 5 || userInput <= 0) {
        System.out.println("Please enter a correct entry.");
        System.exit(0);
    }
    switch (userInput) {
        case 1:
            createNewProfile(input,network);
            break;
        case 2:
            System.out.println("Which Profile would you like to add a status too?");
            Profile targetProfile = new Profile(getName(input));
            addNewStatus(input,network,targetProfile);
            break;
        case 3:
            System.out.println("Which Profile would you like to change the name to?");
            Profile targetProfile2 = new Profile(getName(input));
            modifyProfile(input,network,targetProfile2);
        case 4:
            System.out.println("Enter Profile name to search: ");
            Profile targetProfile3 = new Profile(getName(input));
            if(network.searchCount(targetProfile3)<=0) {
                System.out.println("Profile doesnt exist.");
                menu(input,network);
            }
            network.getEntry(network.getIndex(targetProfile3)).viewProfile();
            System.out.println("Return to menu?");
            if(input.nextLine().equals("Y"))
                menu(input, network);
            if(input.nextLine().equals("N"));
            System.exit(0);
            break;
        case 5:
            System.out.println("Please enter Profile name to add friend too:");
            Profile targetProfile4 = new Profile(getName(input));
            System.out.println("Please enter name of your new friend: ");
            network.getEntry(network.getIndex(targetProfile4)).addFriend(getName(input));
             menu(input,network);
            break;
        case 6:
            System.out.println("Exiting.......");
            System.exit(0);
            break;
    }


}

    /**
     * Method that prompts the user for Strings
     * to create a new Name object
     * @param input Scanner for userInput
     * @return Name with firstName,middleName,lastName
     */
    private static Name getName(Scanner input){
    String fName,mName,lName;
    System.out.println("Please enter first name:");
    fName = input.nextLine();
    System.out.println("Please enter middle name:");
    mName = input.nextLine();
    System.out.println("Please enter last name:");
    lName = input.nextLine();
    Name testName = new Name(fName,mName,lName);
    return testName;
}

    /**
     * Creates a new Profile for the network
     *
     * @param input Scanner for userInput
     * @param network Profile List
     */
    private static void createNewProfile(Scanner input, Network network){
 Profile newProfile = new Profile(getName(input));
        network.addProfile(newProfile);
        menu(input,network);
    }

    /**
     * adds a new status entry for the selected Profile
     *
     * @param input Scanner for userInput
     * @param network Profile List
     * @param targetProfile profile that needs to be changed
     */
    private static void addNewStatus(Scanner input, Network network,Profile targetProfile){
        if(network.searchCount(targetProfile)<1){
            System.out.println("Profile doesn't exist");
            menu(input,network);
        }
        System.out.println("Please enter your new status: ");
        network.getEntry(network.getIndex(targetProfile)).addStatusEntry(input.nextLine());
        System.out.println("Status added.");
        menu(input,network);
    }


    /**
     * static method for modifying profile
     *
     * @param input scanner input
     * @param network target network
     * @param targetProfile profile in which to modify
     */
    private static void modifyProfile(Scanner input, Network network,Profile targetProfile){
        System.out.println("What would you like to edit?");
        System.out.println("----------------------------");
        System.out.println("1-Name");
        System.out.println("2-Location");
        System.out.println("3-Year of Birth");
        System.out.println("-----------------------------");
        int userInput = input.nextInt();
        switch (userInput){
            case 1:
                network.getEntry(network.getIndex(targetProfile)).bulkChangeName(getName(input));
                break;
            case 2:
                System.out.println("Enter new location: ");
                network.getEntry(network.getIndex(targetProfile)).changeLocation(input.nextLine());
                break;
            case 3:
                System.out.println("Enter new Year of Birth: ");
                network.getEntry(network.getIndex(targetProfile)).changeYearOfBirth(input.nextInt());
                break;
        }
menu(input,network);
    }


    /**
     * main method
     * @param args
     */
    public static void main(String[] args) {
        Network network = new Network();
        Scanner input = new Scanner(System.in);
       menu(input,network);
    }





}
