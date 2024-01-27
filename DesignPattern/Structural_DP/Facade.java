package DesignPattern.StructuralDP;

//Subsystem - Player Management
class PlayerManagement {
 public void addPlayer(String playerName) {
     System.out.println("Adding player: " + playerName);
     // Implementation logic to add a player
 }

 public void removePlayer(String playerName) {
     System.out.println("Removing player: " + playerName);
     // Implementation logic to remove a player
 }
}

//Subsystem - Scorekeeping
class Scorekeeping {
 public void recordRun(String player, int runs) {
     System.out.println("Recording " + runs + " run(s) for player: " + player);
     // Implementation logic to record runs
 }

 public void recordWicket(String player) {
     System.out.println("Recording wicket for player: " + player);
     // Implementation logic to record wickets
 }
}

//Subsystem - Match Scheduling
class MatchScheduling {
 public void scheduleMatch(String date, String venue) {
     System.out.println("Scheduling match on " + date + " at " + venue);
     // Implementation logic to schedule a match
 }
}

//Facade - CricketMatchFacade
class CricketMatchFacade {
 private PlayerManagement playerManagement;
 private Scorekeeping scorekeeping;
 private MatchScheduling matchScheduling;

 public CricketMatchFacade(PlayerManagement playerManagement, Scorekeeping scorekeeping, MatchScheduling matchScheduling) {
     this.playerManagement = playerManagement;
     this.scorekeeping = scorekeeping;
     this.matchScheduling = matchScheduling;
 }

 public void organizeCricketMatch(String date, String venue, String player1, String player2) {
     matchScheduling.scheduleMatch(date, venue);
     playerManagement.addPlayer(player1);
     playerManagement.addPlayer(player2);
     System.out.println("Match is ready to start!");

     // Simulate the match
     scorekeeping.recordRun(player1, 30);
     scorekeeping.recordRun(player2, 20);
     scorekeeping.recordWicket(player1);

     System.out.println("Match completed successfully!");
 }
}

//Client Code
public class Facade {
 public static void main(String[] args) {
     PlayerManagement playerManagement = new PlayerManagement();
     Scorekeeping scorekeeping = new Scorekeeping();
     MatchScheduling matchScheduling = new MatchScheduling();

     CricketMatchFacade cricketMatchFacade = new CricketMatchFacade(playerManagement, scorekeeping, matchScheduling);

     // Client organizes a cricket match
     cricketMatchFacade.organizeCricketMatch("2024-03-10", "Wankhede Stadium", "Rohit Sharama", "Ms Dhoni");
 }
}





/*     PlayerManagement, Scorekeeping, and MatchScheduling are subsystems that handle player management, scorekeeping, and match scheduling, respectively.
CricketMatchFacade provides a simplified interface for clients to organize a cricket match seamlessly.
The client code demonstrates organizing a cricket match using the facade.

In this example, the Facade Pattern simplifies the process of organizing a cricket match, allowing clients to perform actions related to the match without dealing with the complexities of individual subsystems.
*/