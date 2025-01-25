package dip;

public class Cricketer {
    private Equipment equipment;

    public Cricketer(Equipment equipment) {
        this.equipment = equipment;
    }

    public void play() {
        equipment.use();
    }
}
