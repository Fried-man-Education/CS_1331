/**
 * @author Andrew Friedman.
 * @version 1.00.
 */
public class ShelbyMustang extends Car {
    private int racesWon;

    /**
     * [ShelbyMustang description].
     */
    public ShelbyMustang() {
        super("Carroll", "Shelby Automotives", 100, 350, false);
        this.racesWon = 0;
    }

    /**
     * [ShelbyMustang description].
     * @param name            [description].
     * @param make            [description].
     * @param fuelLevel       [description].
     * @param horsepower      [description].
     * @param previousUpgrade [description].
     * @param racesWon        [description].
     */
    public ShelbyMustang(String name, String make, double fuelLevel, int horsepower,
        boolean previousUpgrade, int racesWon) {
        super(name, make, fuelLevel, horsepower, previousUpgrade);
        this.racesWon = racesWon;
    }

    /**
     * [getRacesWon description].
     * @return [description].
     */
    public int getRacesWon() {
        return this.racesWon;
    }

    /**
     * [setRacesWon description].
     * @param racesWon [description].
     */
    public void setRacesWon(int racesWon) {
        this.racesWon = racesWon;
    }

    /**
     * [toString description].
     * @return [description].
     */
    public String toString() {
        return (super.toString() + ",  racesWon: " + this.racesWon);
    }

    /**
     * [equals description].
     * @param  objc [description].
     * @return      [description].
     */
    public boolean equals(Object objc) {
        if (objc == null || !(objc instanceof ShelbyMustang)) {
            return false;
        }
        ShelbyMustang obj = (ShelbyMustang) objc;
        return super.equals(obj) && this.racesWon == obj.getRacesWon();
    }

    /**
     * [race description].
     * @param objc [description].
     */
    public void race(Car objc) {
        if (!(objc instanceof ShelbyMustang) || this.getFuelLevel() <= 50 || objc.getFuelLevel() <= 50) {
            System.out.println(objc.getName() + " could not race " + this.getName());
        } else {
            ShelbyMustang obj = (ShelbyMustang) objc;
            this.setFuelLevel(this.getFuelLevel() - 25);
            obj.setFuelLevel(obj.getFuelLevel() - 25);
            if (this.getHorsepower() > obj.getHorsepower()) {
                System.out.println(this.getName() + " won against " + obj.getName());
                this.setRacesWon(this.getRacesWon() + 1);
            } else if (this.getHorsepower() < obj.getHorsepower()) {
                System.out.println(obj.getName() + " won against " + this.getName());
                obj.setRacesWon(obj.getRacesWon() + 1);

            } else if (this.racesWon > obj.racesWon) {
                System.out.println(this.getName() + " won against " + obj.getName());
                this.setRacesWon(this.getRacesWon() + 1);

            } else if (this.racesWon < obj.racesWon) {
                System.out.println(obj.getName() + " won against " + this.getName());
                obj.setRacesWon(obj.getRacesWon() + 1);

            } else {
                System.out.println(obj.getName() + " tied with " + this.getName());
            }
        }
    }
}
