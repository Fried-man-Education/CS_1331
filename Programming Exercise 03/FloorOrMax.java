public class FloorOrMax {
  public static void main(String[] args) {
    float myRand = 4.00f + (float)Math.random() * (54.00f - 4.00f);
    System.out.println("The value is: " + String.format("%.02f", (Math.round(myRand * 100.0f) / 100.0f)));
    int temp = (int)Math.floor(myRand);
    if (temp % 2 == 0 && temp > 15) {
      System.out.println(temp);
    }else if (temp % 2 == 1) {
      System.out.println(Math.max(myRand, 32));
    }else {
      System.out.println(myRand);
    }
  }
}
