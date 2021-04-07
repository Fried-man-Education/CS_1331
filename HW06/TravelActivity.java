/**
* This is a class representing a TravelActivity
*/
public class TravelActivity {
    private String name;
    private double price;
    /**
    * Travel activity constructor with 2 parameters
    * @param name - The name of the activity
    * @param price - The price of the activity
    */
    public TravelActivity(String name, double price) {
        this.name = name;
        this.price = price;
    }
    /**
    * Getter method returning the name of the travel activity
    * @return the name of the activity
    */
    public String getName() {
        return name;
    }
    /**
    * Getter method returning the price of the travel activity
    * @return the price of the activity
    */
    public double getPrice() {
        return price;
    }
    /**
    * Setter method setting the name of the travel activity
    * @param name - new name of the activity
    */
    public void setName(String name) {
        this.name = name;
    }
    /**
    * Setter method setting the price of the travel activity
    * @param price - new price of the activity
    */
    public void setPrice(double price) {
        this.price = price;
    }
}
