/**
 * @author Andrew Friedman.
 * @version 1.00.
 */
public class Satellite {
    private String name;
    private int catalogNumber;
    private int launchYear;
    private int launchDay;
    private double inclination;
    private double meanMotion;

    /**
     * [Satellite description].
     * @param name          [description].
     * @param catalogNumber [description].
     * @param launchYear    [description].
     * @param launchDay     [description].
     * @param inclination   [description].
     * @param meanMotion    [description].
     */
    public Satellite(String name, int catalogNumber, int launchYear,
        int launchDay, double inclination, double meanMotion) {
        this.name = name;
        this.catalogNumber = catalogNumber;
        this.launchYear = launchYear;
        this.launchDay = launchDay;
        this.inclination = inclination;
        this.meanMotion = meanMotion;
    }

    /**
     * [orbitTime description].
     * @return [description].
     */
    public double orbitTime() {
        return (24 * 60) / meanMotion;
    }

    /**
     * [toString description].
     * @return [description].
     */
    public String toString() {
        return name + ": #" + catalogNumber + ". Launched on day " + launchDay + " of "
            + launchYear + ". Inclination: " + inclination + " degrees. " + meanMotion
            + " orbits per day - " + orbitTime() + " minutes per orbit.";
    }

    /**
     * [encodeCSV description].
     * @return [description].
     */
    public String encodeCSV() {
        return name + ", " + catalogNumber + ", " + launchYear + ", " + launchDay + ", "
            + inclination + ", " + meanMotion + ", " + orbitTime();
    }
}
