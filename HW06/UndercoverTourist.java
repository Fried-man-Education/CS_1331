import java.util.ArrayList;
/**
 * @author Andrew Friedman.
 * @version 1.00.
 */
public class UndercoverTourist {
    /**
     * [calculateNumActivities description].
     * @param  inpA [description].
     * @param  inpb [description].
     * @param  inpa [description].
     * @return      [description].
     */
    public static int calculateNumActivities(ArrayList<TravelActivity> inpA, double inpb, int inpa) {
        int temp = 0; // min
        for (int i = 0; i < inpA.size(); i++) { // find cheapest one
            if (inpA.get(i).getPrice() < inpA.get(temp).getPrice()) {
                temp = i;
            }
        }
        double price = inpA.get(temp).getPrice(); // store cheapest price
        if (price > inpb) { // if overbudget return to top
            return inpa;
        }
        inpA.remove(temp); // remove repeats
        return calculateNumActivities(inpA, inpb - price, inpa + 1); // go deeper
    }
}
