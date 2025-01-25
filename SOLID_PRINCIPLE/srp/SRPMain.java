package srp;

public class SRPMain {
    public static void main(String[] args) {
        TeamSelection teamSelection = new TeamSelection();
        teamSelection.selectPlayers();

        MatchScheduler matchScheduler = new MatchScheduler();
        matchScheduler.scheduleMatch();
    }
}
