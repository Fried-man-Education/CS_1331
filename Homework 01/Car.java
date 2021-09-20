public class Car {
    private String type;
    private int mileage; // defaults to 0
    private int nextOilChange; // defaults to mileage + 3000
    private double[] tireLife; // defaults to 4 values of 1.00
    private static int numCars = 0;

    public Car(String itype, int imileage, int inextOilChange, double[] itireLife) {
        type = itype;
        if (imileage < 0) {
            imileage = 0;
        }
        mileage = imileage;
        if (inextOilChange < 0) {
            inextOilChange = imileage + 3000;
        }
        nextOilChange = inextOilChange;
        for (int i = 0; i < itireLife.length; i++) {
            if (itireLife[i] < 0 || itireLife[i] > 1) {
                itireLife[i] = 1.00;
            }
        }
        tireLife = itireLife;
        numCars += 1;
    }

    public Car(String itype, int imileage, double[] itireLife) {
        this(itype, imileage, (imileage + 3000), itireLife);
    }

    public Car(String itype, double[] itireLife) {
        this(itype, 0, 3000, itireLife);
    }

    public Car(Car icar) {
        type = icar.type;
        mileage = icar.mileage;
        nextOilChange = icar.nextOilChange;
        tireLife = new double[4];
        for (int i = 0; i < icar.tireLife.length; i++) {
            tireLife[i] = icar.tireLife[i];
        }
        numCars += 1;
    }

    private int averageTireLife() {
        double sum = 0;
        for (double i: this.tireLife) {
            sum += i;
        }
        return (int) (sum / 4 * 100);
    }

    public String toString() {
        return "This is a car of type " + this.type + " with a mileage of "
            + this.mileage + "miles. I’m due for a checkup in " + (this.nextOilChange - this.mileage)
            + " miles, and my average tire life is " + this.averageTireLife() + "%.";
    }

    public String getType() {
        return type;
    }

    public void setType(String itype) {
        type = itype;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int imileage) {
        mileage = imileage;
    }

    public int getNextOilChange() {
        return nextOilChange;
    }

    public void setNextOilChange(int inextOilChange) {
        nextOilChange = inextOilChange;
    }

    public double[] getTireLife() {
        return tireLife;
    }

    public void setTireLife(double[] itireLife) {
        tireLife = itireLife;
    }

    public int getNumCars() {
        return numCars;
    }

    public void setNumCars(int inumCars) {
        numCars = inumCars;
    }
}
