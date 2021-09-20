/**
 * @author Andrew Friedman.
 * @version 1.00.
 */
public class Monster implements Comparable<Monster> {
    private String name;
    private int spookiness;

    /**
     * [Monster description].
     * @param name       [description].
     * @param spookiness [description].
     */
    public Monster(String name, int spookiness) {
        this.name = name;
        this.spookiness = spookiness;
    }

    /**
     * [compareTo description].
     * @param  input [description].
     * @return       [description].
     */
    public int compareTo(Monster input) {
        if (this.spookiness > input.getSpookiness()) {
            return 1;
        } else if (this.spookiness < input.getSpookiness()) {
            return -1;
        }
        return 0;
    }

    /**
     * [toString description].
     * @return [description].
     */
    public String toString() {
        return name + " has a spook rating of " + spookiness;
    }

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
     * [getSpookiness description].
     * @return [description].
     */
    public int getSpookiness() {
        return spookiness;
    }

    /**
     * [setSpookiness description].
     * @param spookiness [description].
     */
    public void setSpookiness(int spookiness) {
        this.spookiness = spookiness;
    }
}
