public class ProfessionalPlayer extends Player {
  private boolean isSeeded;

  public ProfessionalPlayer(String name, double points, int trophies, boolean isSeeded) {
    super(name, points, trophies);
    this.isSeeded = isSeeded;
  }

  public double calculateSkillLevel() {
    if (isSeeded) {
      return (this.getPoints() + 1.5 * this.getTrophies()) * 2;
    }
    return this.getPoints() + 1.5 * this.getTrophies();
  }

  public boolean equals(Object inp) {
    if (!(inp instanceof ProfessionalPlayer)) {return false;}
    ProfessionalPlayer input = (ProfessionalPlayer)inp;
    if (this.getName() != input.getName()) {
      return false;
    }else if (this.getPoints() != input.getPoints()) {
      return false;
    }else if (this.getTrophies() != input.getTrophies()) {
      return false;
    }else if (isSeeded != input.getIsSeeded()) {
      return false;
    }
    return true;
  }

  public boolean getIsSeeded() {
    return isSeeded;
  }

  public void setIsSeeded(boolean isSeeded) {
    this.isSeeded = isSeeded;
  }
}
