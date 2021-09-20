import java.util.Random;

public class SquareRoot {
  public static void main(String[] args) {
    Random rand = new Random();
    long bigRandNum = 1000000000000000l + rand.nextInt(300);
    System.out.println("The value is: " + bigRandNum);
    int i = 0;
    while (bigRandNum != 1) {
      bigRandNum = (long)Math.sqrt((double)bigRandNum);
      i++;
    }
    System.out.println("Count: " + i);
  }
}
