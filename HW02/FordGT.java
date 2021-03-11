/**
 * @author Andrew Friedman.
 * @version 1.00.
 */
public class FordGT extends Car {
    private double weight;
    private String driverName;

    /**
     * [FordGT description].
     * @param name            [description].
     * @param make            [description].
     * @param fuelLevel       [description].
     * @param horsepower      [description].
     * @param previousUpgrade [description].
     * @param weight          [description].
     * @param driverName      [description].
     */
    public FordGT(String name, String make, double fuelLevel, int horsepower,
        boolean previousUpgrade, double weight, String driverName) {
        super(name, make, fuelLevel, horsepower, previousUpgrade);
        this.weight = weight;
        this.driverName = driverName;
    }

    /**
     * [FordGT description].
     */
    public FordGT() {
        super("Pony", "Ford", 100, 450, false);
        weight = 3300;
        driverName = "Ken Miles";
    }

    /**
     * Overrides toString shit.
     * @return a fucking description.
     */
    public String toString() {
        return super.toString() + ", Weight: " + weight + ", Driver: " + driverName;
    }

    /**
     * Overrides equals shit.
     * @param  inputO the comparitive.
     * @return        a fucking decision.
     */
    public boolean equals(Object inputO) {
        if (inputO == null || !(inputO instanceof FordGT)) {
            return false;
        }
        FordGT input = (FordGT) inputO;
        return super.equals(inputO) && this.weight == input.getWeight();
    }

    /**
     * this baby is going to look brand new and then some.
     */
    public void upgrade() {
        if (!this.getPreviousUpgrade()) {
            this.setHorsepower(this.getHorsepower() + ((this.getHorsepower() < 200) ? 100 : 50));
            this.setFuelLevel((this.getFuelLevel() + 50 > this.MAX_FUEL_LEVEL) ? this.MAX_FUEL_LEVEL
                : this.getFuelLevel() + 50);
            this.setPreviousUpgrade(true);
        }
    }

    /**
     * might not be legal lmao.
     * @param inputC vroom vroom driver.
     */
    public void race(Car inputC) {
        if (!(inputC instanceof FordGT) || this.getFuelLevel() <= 50 || inputC.getFuelLevel() <= 50
            || this.getMake() != inputC.getMake()) {
            System.out.println(inputC.getName() + " could not race " + this.getName());
        } else {
            FordGT input = (FordGT) inputC;
            this.setFuelLevel(this.getFuelLevel() - 25);
            input.setFuelLevel(input.getFuelLevel() - 25);
            if (this.getHorsepower() > input.getHorsepower()) {
                System.out.println(this.getName() + " with " + driverName
                    + " as the driver won against " + input.getName()
                    + " with " + input.getDriverName() + " as the driver");
            } else if (this.getHorsepower() < input.getHorsepower()) {
                System.out.println(input.getName() + " with " + input.getDriverName()
                    + " as the driver won against " + this.getName()
                    + " with " + driverName + " as the driver");
            } else if (this.weight > input.getWeight()) {
                System.out.println(this.getName() + " with " + driverName
                    + " as the driver won against " + input.getName()
                    + " with " + input.getDriverName() + " as the driver");
            } else if (this.weight < input.getWeight()) {
                System.out.println(input.getName() + " with " + input.getDriverName()
                    + " as the driver won against " + this.getName()
                    + " with " + driverName + " as the driver");
            } else {
                System.out.println(input.getName() + " tied with " + this.getName());
            }
        }
    }

    /**
     * [getWeight description].
     * @return [description].
     */
    public double getWeight() {
        return weight;
    }

    /**
     * [setWeight description].
     * @param weight [description].
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * [getDriverName description].
     * @return [description].
     */
    public String getDriverName() {
        return driverName;
    }

    /**
     * [setDriverName description].
     * @param driverName [description].
     */
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
}
