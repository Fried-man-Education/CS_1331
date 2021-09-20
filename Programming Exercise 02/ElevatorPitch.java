import java.util.Scanner;

public class ElevatorPitch {
  public static void main(String[] args) {
    String myPitch;
    String name;
    double gpa;
    int graduationYear;
    String hobby;
    String major;
    Scanner myScanner = new Scanner(System.in);
    System.out.println("Enter your full name: ");
    name = myScanner.nextLine();
    System.out.println("Enter your gpa: ");
    gpa = myScanner.nextDouble();
    System.out.println("Enter the year you will graduate: ");
    graduationYear = myScanner.nextInt();
    myScanner.nextLine();
    System.out.println("Enter your favorite hobby: ");
    hobby = myScanner.nextLine();
    System.out.println("Enter your major: ");
    major = myScanner.nextLine();
    myPitch = "Hello, my name is " + name + ". I’m a " + major + " major with a gpa of " + String.valueOf(gpa) + " graduating in " + String.valueOf(graduationYear) + ". In my free time, I like " + hobby + ".";
    System.out.println(myPitch);
  }
}
