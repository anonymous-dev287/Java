package dip;

public class DIPMain {
    public static void main(String[] args) {
        Equipment cricketBat = new CricketBat();
        Cricketer cricketer = new Cricketer(cricketBat);
        cricketer.play();
    }
}
 