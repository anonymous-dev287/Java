package ocp;

public class OCPMain {
    public static void main(String[] args) {
        Player batsman = new Batsman();
        batsman.play();

        Player bowler = new Bowler();
        bowler.play();

        // Player wicketKeeper = new WicketKeeper();
        // wicketKeeper.play();
    }
}
