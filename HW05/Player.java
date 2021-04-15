public abstract class Player implements Comparable<Player> {
  private String name;
  private double points;
  private int trophies;

  public Player (String name, double points, int trophies) {
    this.name = name;
    this.points = points;
    this.trophies = trophies;
  }

  public abstract double calculateSkillLevel();

  public int compareTo(Player input) {
    if (calculateSkillLevel() > input.calculateSkillLevel()) {
      return 1;
    }else if (calculateSkillLevel() < input.calculateSkillLevel()) {
      return -1;
    }
    return 0;
  }

  public boolean equals(Object inp) {
    if (!(inp instanceof Player)) {return false;}
    Player input = (Player)inp;
    if (name != input.getName()) {
      return false;
    }else if (points != input.getPoints()) {
      return false;
    }else if (trophies != input.getTrophies()) {
      return false;
    }
    return true;
  }

  public String toString() {
    return name + ": " + String.format("%.1f", points) + " points - " + trophies + " trophies";
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPoints() {
    return points;
  }

  public void setPoints(double points) {
    this.points = points;
  }

  public int getTrophies() {
    return trophies;
  }

  public void setTrophies(int trophies) {
    this.trophies = trophies;
  }
}
