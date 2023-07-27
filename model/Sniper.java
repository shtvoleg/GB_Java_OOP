package model;

/*
Класс снайпер. Имеет предка: класс стрелок. Имеет доп. поле: число патронов.
*/
public class Sniper extends Shooter {
    public Sniper(String name, int shots, int range, int x, int y) {
        super(Role.Sniper, name, 100, 1, shots, range, x, y);
    }

    @Override
    public String description() {
        return "N";
    }

}
