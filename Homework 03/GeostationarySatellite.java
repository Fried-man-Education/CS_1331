/**
 * @author Andrew Friedman.
 * @version 1.00.
 */
public class GeostationarySatellite extends Satellite {
    /**
     * [GeostationarySatellite description].
     * @param name          [description].
     * @param catalogNumber [description].
     * @param launchYear    [description].
     * @param launchDay     [description].
     * @param inclination   [description].
     */
    public GeostationarySatellite(String name, int catalogNumber, int launchYear, int launchDay, double inclination) {
        super(name, catalogNumber, launchYear, launchDay, inclination, 1.0);
    }
}
