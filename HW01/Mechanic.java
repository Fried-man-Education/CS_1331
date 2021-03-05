public class Mechanic {

    private final String name;
    private double revenue;
    private double oilChangePrice;
    private double newTirePrice;


    public Mechanic(String name) {
        this(name, 0.00, 44.99, 59.99);

    }

    public Mechanic(String name, double oilChangePrice, double newTirePrice) {
        this(name, 0.00, oilChangePrice, newTirePrice);
    }

    public Mechanic(String name, double revenue, double oilChangePrice, double newTirePrice) {
        this.name = name;
        if (revenue < 0) {
            revenue = 0.00;
        }
        this.revenue = revenue;
        if (oilChangePrice < 0.99) {
            oilChangePrice = 44.99;
        }
        this.oilChangePrice = oilChangePrice;
        if (newTirePrice < 0.99) {
            newTirePrice = 59.99;
        }
        this.newTirePrice = newTirePrice;
    }

    @Override
    public String toString() {
        return "This is a mechanic named " + name + ". I charge"
            + " $" + String.format("%.2f", oilChangePrice) + " for an oil change, and  I charge "
            + "$" + String.format("%.2f", newTirePrice) + " for a new tire. I\'ve made $"
            + String.format("%.2f", revenue) + " in revenue.";
    }
    public void service(Car c) {
        if (c.getMileage() >= c.getNextOilChange()) {
            c.setNextOilChange(c.getMileage() + 3000);
            this.revenue += this.oilChangePrice;
        }
        double[] temp = new double[4];
        for (int i = 0; i < c.getTireLife().length; i++) {
            temp[i] = c.getTireLife()[i];
            if (c.getTireLife()[i] <= 0.50) {
                this.revenue += this.newTirePrice;
                temp[i] = 1.00;
            }
        }
        c.setTireLife(temp);
    }


}
