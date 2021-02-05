import java.util.Scanner;

public class Calculator {
  public static void main(String[] args) {
    int firstNumber;
    int secondNumber;
    Scanner myScanner = new Scanner(System.in);
    System.out.println("Enter your first number: ");
    firstNumber = myScanner.nextInt();
    System.out.println("Enter your second number: ");
    secondNumber = myScanner.nextInt();
    System.out.println("Sum is " + String.valueOf(firstNumber + secondNumber));
    System.out.println("Difference is " + String.valueOf(firstNumber - secondNumber));
    System.out.println("Product is " + String.valueOf(firstNumber * secondNumber));
    System.out.println("Quotient is " + String.valueOf((float) firstNumber / secondNumber));
  }
}
