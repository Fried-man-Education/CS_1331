import java.util.ArrayList;
/**
 * @author Andrew Friedman.
 * @version 1.00.
 */
public class GuestList {
    private ArrayList<Monster> guests;
    private DancingMonster bestDancer;

    /**
     * [GuestList description].
     * @param monsters [description].
     */
    public GuestList(ArrayList<Monster> monsters) {
        guests = monsters;
        bestDancer = null;
        for (Monster x: monsters) {
            if (x instanceof DancingMonster) {
                if (bestDancer == null || x.compareTo(bestDancer) == 1) {
                    bestDancer = (DancingMonster) x;
                }
            }
        }
    }

    /**
     * [GuestList description].
     */
    public GuestList() {
        guests = new ArrayList<Monster>();
        bestDancer = null;
    }

    /**
     * [addGuest description].
     * @param input [description].
     */
    public void addGuest(Monster input) {
        guests.add(input);
        if (input instanceof DancingMonster) {
            if (bestDancer == null || input.compareTo(bestDancer) == 1) {
                bestDancer = (DancingMonster) input;
            }
        }
    }

    /**
     * [toString description].
     * @return [description].
     */
    public String toString() {
        String temp = "";
        for (Monster x: guests) {
            temp += x.getName() + ", ";
        }
        return temp; // minus last comma
    }

    /**
     * [danceBattle description].
     * @param in1 [description].
     * @param in2 [description].
     */
    public void danceBattle(Monster in1, Monster in2) {
        System.out.println(in1.toString());
        System.out.println(in2.toString());

        if (in1 instanceof DancingMonster && in2 instanceof DancingMonster) {
            DancingMonster input1 = (DancingMonster) in1;
            DancingMonster input2 = (DancingMonster) in2;
            int dance1 = input1.dance();
            int dance2 = input2.dance();
            if (dance1 > dance2) {
                System.out.println(input1.getName() + "won the dance battle!");
                input1.wonDance();
            } else if (dance1 < dance2) {
                System.out.println(input2.getName() + "won the dance battle!");
                input2.wonDance();
            } else {
                System.out.println("And this dance battle is a tie!");
            }
        } else if (in1 instanceof DancingMonster && !(in2 instanceof DancingMonster)) {
            System.out.println(in1.getName() + "won the dance battle!");
            ((DancingMonster) in1).wonDance();
        } else if (in2 instanceof DancingMonster && !(in1 instanceof DancingMonster)) {
            System.out.println(in2.getName() + "won the dance battle!");
            ((DancingMonster) in2).wonDance();
        } else {
            System.out.println("And this dance battle is a tie!");
        }
    }
}
