import java.util.ArrayList;

public class GrandSlam {
  private String name;
  private ArrayList<ProfessionalPlayer> leaderboard;

  public GrandSlam (String name, ArrayList<ProfessionalPlayer> leaderboard) {
    this.name = name;
    this.leaderboard = leaderboard;
    createLeaderboard();
  }

  public void createLeaderboard() {
    // N! speed
    for (int i = 0; i < leaderboard.size(); i++) {
      int minI = i;
      for (int j = i; j < leaderboard.size(); j++) {
        if (leaderboard.get(j).calculateSkillLevel() > leaderboard.get(minI).calculateSkillLevel()) {
          minI = j;
        }else if (leaderboard.get(j).calculateSkillLevel() == leaderboard.get(minI).calculateSkillLevel() && leaderboard.get(j).compareTo(leaderboard.get(minI)) == 1) {
          minI = j;
        }
      }
      ProfessionalPlayer temp = leaderboard.get(i);
      leaderboard.set(i, leaderboard.get(minI));
      leaderboard.set(minI, temp);
    }
  }

  public int findPlayer (ProfessionalPlayer input) {
    int begin = 0;
    int last = leaderboard.size() - 1;
    int mid = 0;
    while (begin <= last) {
      mid = (begin + last) / 2;
      if (leaderboard.get(mid).calculateSkillLevel() > input.calculateSkillLevel()) {
        begin = mid + 1;
      }else if (leaderboard.get(mid).calculateSkillLevel() < input.calculateSkillLevel()) {
        last = mid - 1;
      }else {
        return mid;
      }
    }
    return -1;
  }

  public String toString() {
    return "Welcome to the " + name + " tournament! The current leaderboard is: " + leaderboard.toString();
  }
}
