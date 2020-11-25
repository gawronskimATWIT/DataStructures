package DictionaryProject;

public class BusinessName {
private String location;
private String restaurantName;
    public BusinessName(String name, String town){
        location = town;
        restaurantName = name;

    }

    public BusinessName(String name) {
    restaurantName = name;

    }

    public String getLocation() {
        return location;
    }

    public String getRestaurantName() {
        return restaurantName;
    }


    public boolean equals(Object obj){
        BusinessName name = (BusinessName) obj;
        if(location.equals(name.getLocation())&& name.getRestaurantName().equals(restaurantName)) {
            return true;
        }

            return false;

    }

     public int compareTo(BusinessName name){
        int answerRestaurantName = name.getRestaurantName().compareTo(restaurantName);
        int answerLocation = name.getLocation().compareTo(location);
        return answerLocation+answerRestaurantName;
     }


    public String toString() {
        return restaurantName + ", " + location;
    }
}
