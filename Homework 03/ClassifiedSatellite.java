import java.util.Scanner;

/**
 * @author Andrew Friedman.
 * @version 1.00.
 */
public class ClassifiedSatellite extends Satellite {
    /**
     * [ClassifiedSatellite description].
     * @param name          [description].
     * @param catalogNumber [description].
     * @param launchYear    [description].
     * @param launchDay     [description].
     * @param inclination   [description].
     * @param meanMotion    [description].
     */
    public ClassifiedSatellite(String name, int catalogNumber, int launchYear,
        int launchDay, double inclination, double meanMotion) {
        super(name, catalogNumber, launchYear, launchDay, inclination, meanMotion);
    }

    /**
     * [toString description].
     * @return [description].
     */
    public String toString() {
        return checker() ? super.toString() : "INCORRECT PASSWORD";
    }

    /**
     * [encodeCSV description].
     * @return [description].
     */
    public String encodeCSV() {
        return checker() ? super.encodeCSV() : "INCORRECT PASSWORD";
    }

    /**
     * [checker description].
     * @return [description].
     */
    boolean checker() {
        System.out.println("Password:");
        return "f8ee89496da476b3849f4de45a4528b4".equals(new Scanner(System.in).nextLine());
    }
}
