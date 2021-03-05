public class ShopDriver {
    public static void main(String[] args) {
        double[] tireVals = {
            0.70,
            0.32,
            0.45,
            0.50
        };
        Car c1 = new Car("SUV", 15000, 14600, tireVals);
        Mechanic m1 = new Mechanic("Raul");
        m1.service(c1);
        System.out.println(m1);
        System.out.println(c1);
        // Testing neg values
        double[] tireVals2 = {-0.70,
            -0.32,
            -0.45,
            -0.50
        };
        Car c2 = new Car("SUV", 15000, 14600, tireVals2);
        System.out.println(c2);
    }
}
