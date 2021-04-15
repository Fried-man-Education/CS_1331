public class AmateurPlayer extends Player {
  public AmateurPlayer(String name, double points, int trophies) {
    super(name, points, trophies);
  }

  public double calculateSkillLevel() {
    return this.getPoints() + .5 * this.getTrophies();
  }
}
