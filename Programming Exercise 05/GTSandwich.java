public class GTSandwich {
    private String bread;
    private String meat;
    private String[] extras;
    private int numMeat;
    private double price;
    private boolean hasSauce;
    private boolean makeCombo;

    public GTSandwich(String ibread, String imeat, String[] iextras,
    int inumMeat, double iprice, boolean ihasSauce, boolean imakeCombo) {
        bread = ibread;
        meat = imeat;
        extras = iextras;
        numMeat = inumMeat;
        price = iprice;
        hasSauce = ihasSauce;
        makeCombo = imakeCombo;
    }

  public GTSandwich(String ibread, String imeat, boolean imakeCombo) {
    this(ibread, imeat, new String[0], 4, 8.75, true, imakeCombo);
  }

  public GTSandwich() {
    this("Rye", "Turkey", true);
  }

  public String getBread() {
    return bread;
  }

  public void setBread(String ibread) {
    bread = ibread;
  }

  public String getMeat() {
    return meat;
  }

  public void setMeat(String imeat) {
    meat = imeat;
  }

  public String[] getExtras() {
    return extras;
  }

  public void setExtras(String[] iextras) {
    extras = iextras;
  }

  public int getNumMeat() {
    return numMeat;
  }

  public void setNumMeat(int inumMeat) {
    numMeat = inumMeat;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double iprice) {
    price = iprice;
  }

  public boolean getHasSauce() {
    return hasSauce;
  }

  public void setHasSauce(boolean ihasSauce) {
    hasSauce = ihasSauce;
  }

  public boolean getMakeCombo() {
    return makeCombo;
  }

  public void setMakeCombo(boolean imakeCombo) {
    if(imakeCombo && !makeCombo) {
      price += 2;
    }else if(!imakeCombo && makeCombo) {
      price -= 2;
    }
    makeCombo = imakeCombo;
  }

  public void applyCoupon(String coupon) {
    if (coupon == "CS1331" && makeCombo) {
      price /= 2;
      numMeat *= 2;
      System.out.println("Coupon Applied");
    }else {
      System.out.println("Coupon Not Applied");
    }
  }

  public void applyCoupon() {
    if (price >= 20) {
      price -= 5;
      makeCombo = true;
      System.out.println("Discount Applied");
    }else{
      System.out.println("Discount Not Applied");
    }
  }

  public void printExtras() {
    if (extras.length == 0) {
      System.out.println("The customer wants no extras.");
    }else {
      String message = "The customer wants these extras: ";
      for (int i = 0; i < extras.length; i++) {
        message += extras[i];
        if (i + 1 != extras.length) {
          message += ", ";
        }else {
          message += ".";
        }
      }
      System.out.println(message);
    }
  }

  public String toString() {
    String output = "GT Sandwich that costs " + price + " with " + bread + ", " + meat + ", ";
    for (int i = 0; i < extras.length; i++) {
      output += extras[i] + ", ";
    }
    output += numMeat + " slices of meat, Sauce: " + hasSauce + ", Combo: " + makeCombo;
    return output;
  }

  public static void main(String[] args) {
    GTSandwich houseSpecial = new GTSandwich("French", "Turkey", new String[]{"Banana Peppers", "Spinach", "Chipotle Mayo"}, 4, 10.75, true, true);
    GTSandwich javaSandwich = new GTSandwich();
    houseSpecial.applyCoupon("CS1331");
    javaSandwich.applyCoupon();
    houseSpecial.printExtras();

    System.out.println(houseSpecial);
    System.out.println(javaSandwich);
  }
}
