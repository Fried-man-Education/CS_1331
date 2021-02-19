import java.util.Scanner;

public class CoffeeShop {
    public static Order[] createOrderArray(String inputStr) {
        Order[] temp = new Order[inputStr.length()];
        for (int i = 0; i < inputStr.length(); i++) {
            if (inputStr.charAt(i) == 'L') {
                temp[i] = Order.LATTE;
            } else if (inputStr.charAt(i) == 'C') {
                temp[i] = Order.COFFEE;
            } else if (inputStr.charAt(i) == 'I') {
                temp[i] = Order.ICED_COFFEE;
            } else if (inputStr.charAt(i) == 'F') {
                temp[i] = Order.FRAPPE;
            } else if (inputStr.charAt(i) == 'P') {
                temp[i] = Order.PASTRY;
            }
        }
        return temp;
    }

    public static double lookupMakeTime(Order inputOrd) {
        switch (inputOrd) {
        case LATTE:
            return 3.0;
        case COFFEE:
            return 0.5;
        case ICED_COFFEE:
            return 2.0;
        case FRAPPE:
            return 6.0;
        case PASTRY:
            return 3.0;
        default:
            return 0;
        }
    }

    public static void computeOrderMakeTime(Order[] inputArr, int numBaristas) {
        double totalMakeTime = 0;
        int numOrders = inputArr.length;
        double min = 0;
        for (int i = 0; i < inputArr.length; i++) {
            min += lookupMakeTime(inputArr[i]);
        }
        min = (min / numBaristas) + (numOrders % numBaristas);
        System.out.println("It will take " + min + " minutes for " + numBaristas + " baristas to make these orders.");
    }

    public static void main(String[] args) {
        System.out.println("Welcome to your local coffee shop! What does the rush look like today?");
        Scanner myScanner = new Scanner(System.in);
        String order = myScanner.nextLine();
        for (int i = 1; i < 4; i++) {
            computeOrderMakeTime(createOrderArray(order), i);
        }
    }
}
