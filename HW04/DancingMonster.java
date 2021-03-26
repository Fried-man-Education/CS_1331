/**
 * @author Andrew Friedman.
 * @version 1.00.
 */
public class DancingMonster extends Monster implements Danceable {
    private String danceMove;
    private int dancesWon;

    /**
     * [DancingMonster description].
     * @param name       [description].
     * @param spookiness [description].
     * @param danceMove  [description].
     */
    public DancingMonster(String name, int spookiness, String danceMove) {
        super(name, spookiness);
        this.danceMove = danceMove;
        this.dancesWon = 0;
    }

    /**
     * [dance description].
     * @return [description].
     */
    public int dance() {
        System.out.println(this.getName() + " does the " + danceMove);
        return (int) Math.random() * this.getSpookiness();
    }

    /**
     * [wonDance description].
     */
    public void wonDance() {
        dancesWon += 1;
    }

    /**
     * [toString description].
     * @return [description].
     */
    public String toString() {
        return this.getName() + " has a spook rating of " + this.getSpookiness()
            + " and has won " + dancesWon + " dances thus far";
    }

    /**
     * [getDanceMove description].
     * @return [description].
     */
    public String getDanceMove() {
        return danceMove;
    }

    /**
     * [setDanceMove description].
     * @param danceMove [description].
     */
    public void setDanceMove(String danceMove) {
        this.danceMove = danceMove;
    }

    /**
     * [getDancesWon description].
     * @return [description].
     */
    public int getDancesWon() {
        return dancesWon;
    }

    /**
     * [setDancesWon description].
     * @param dancesWon [description].
     */
    public void setDancesWon(int dancesWon) {
        this.dancesWon = dancesWon;
    }
}
