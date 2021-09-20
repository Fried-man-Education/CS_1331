/**
 * @author Andrew Friedman.
 * @version 1.00.
 */
public abstract class Car {
    private String name;
    private String make;
    private double fuelLevel;
    private int horsepower;
    private boolean previousUpgrade;
    protected static final double MAX_FUEL_LEVEL = 100;

    /**
     * the creator.
     * @param name            Every car person has a name for their prized car.
     * @param make            This represents the makeof the car (i.e.Ford, Shelby).
     * @param fuelLevel       his represents the fuel level of the car.
     * @param horsepower      This represents how much horsepowerthe car has.
     * @param previousUpgrade Shelby always wants to know if a car has been brought back to him for an upgrade before.
     */
    public Car(String name, String make, double fuelLevel, int horsepower, boolean previousUpgrade) {
        this.name = name;
        this.make = make;
        this.fuelLevel = (fuelLevel > MAX_FUEL_LEVEL) ? MAX_FUEL_LEVEL : fuelLevel;
        this.horsepower = horsepower;
        this.previousUpgrade = previousUpgrade;
    }

    /**
     * Overrides toString shit.
     * @return a fucking description.
     */
    public String toString() {
        return "Car named: " + name + ", Make: " + make + ", Fuel Amount: "
            + String.format("%.1f", fuelLevel) + ", HP: " + horsepower;
    }

    /**
     * Overrides equals shit.
     * @param  inputO the comparitive.
     * @return        a fucking decision.
     */
    public boolean equals(Object inputO) {
        if (inputO == null || !(inputO instanceof Car)) {
            return false;
        }
        Car input = (Car) inputO;
        return this.name == input.name && this.make == input.make && this.horsepower == input.horsepower;
    }

    /**
     * this baby is going to look brand new and then some.
     */
    public void upgrade() {
        if (!this.previousUpgrade) {
            this.horsepower += (this.horsepower < 200) ? 100 : 50;
            this.previousUpgrade = true;
        }
    }

    /**
     * might not be legal lmao.
     * @param input vroom vroom driver.
     */
    public abstract void race(Car input);

    /**
     * [getName description].
     * @return [description].
     */
    public String getName() {
        return name;
    }

    /**
     * [setName description].
     * @param name [description].
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * [getMake description].
     * @return [description].
     */
    public String getMake() {
        return make;
    }

    /**
     * [setMake description].
     * @param make [description].
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * [getFuelLevel description].
     * @return [description].
     */
    public double getFuelLevel() {
        return fuelLevel;
    }

    /**
     * [setFuelLevel description].
     * @param fuelLevel [description].
     */
    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    /**
     * [getHorsepower description].
     * @return [description].
     */
    public int getHorsepower() {
        return horsepower;
    }

    /**
     * [setHorsepower description].
     * @param horsepower [description].
     */
    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    /**
     * [getPreviousUpgrade description].
     * @return [description].
     */
    public boolean getPreviousUpgrade() {
        return previousUpgrade;
    }

    /**
     * [setPreviousUpgrade description].
     * @param previousUpgrade [description].
     */
    public void setPreviousUpgrade(boolean previousUpgrade) {
        this.previousUpgrade = previousUpgrade;
    }
}
