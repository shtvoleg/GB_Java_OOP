package model;

/*
Класс разбойник. Имеет предка: класс пехота.
*/
public class Robber extends Infantry {

    private int power;

    public Robber(String name, int maxHealth, int speed, int power, int x, int y) {
        super(Role.Robber, name, maxHealth, speed, x, y);
        this.power = power;
    }

    @Override
    public String description() {
        return "R";
    }

    @Override
    protected void attack(Unit target) {
        int dmg = 15;
        if (power > 0) {
            // если есть энергия, то урон утраивается
            dmg *= 3;
            --power;
        }
        target.changeHealth(-dmg);
    }

}
