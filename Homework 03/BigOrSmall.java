public class BigOrSmall {
  public static void main(String[] args) {
    int smallRandNum = 2 + (int)(Math.random() * ((5 - 2) + 1));
    System.out.println("We will run " + smallRandNum + " times!");
    for (int i = 0; i < smallRandNum; i++) {
      int temp = 2 + (int)(Math.random() * ((20 - 2) + 1));
      System.out.println("The value is: " + temp);
      if (temp > 10) {
        System.out.println("Yay!");
      }else {
        System.out.println("Nay!");
      }
    }
  }
}
