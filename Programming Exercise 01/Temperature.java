public class Temperature {
  public static void main(String[] args) {
    float fahrenheit = 450.0f;
    double celsius = (fahrenheit - 32) / 1.8;
    double kelvin = celsius;
    kelvin += 273.15;
    System.out.print(fahrenheit + "\n" + celsius + "\n" + kelvin);
    // Im excited to relearn java! :)
  }
}
