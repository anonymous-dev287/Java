package lsp;

public class LSPMain {
    public static void main(String[] args) {
        Cricketer cricketer = new Batsman();
        cricketer.play();

        cricketer = new Bowler();
        cricketer.play();
    }
}
