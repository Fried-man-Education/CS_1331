import java.util.ArrayList;
public class UndercoverTourist {
  public static int calculateNumActivities (ArrayList<TravelActivity> inpA, double inpb, int inpa) {
    int temp = 0;
    for (int i = 0; i < inpA.size(); i++) {
      if (inpA.get(i).getPrice() < inpA.get(temp).getPrice()) {
        temp = i;
      }
    }
    double price = inpA.get(temp).getPrice();
    if (price > inpb) {
      return inpa;
    }
    inpA.remove(temp);
    return calculateNumActivities(inpA, inpb-price, inpa+1);
  }
}
