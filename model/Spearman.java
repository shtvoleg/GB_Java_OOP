package model;

/*
Класс копейщик. Имеет предка: класс пехота. Имеет доп. поле: сила.
*/
public class Spearman extends Infantry {

    public Spearman(String name, int speed, int x, int y) {
        super(Role.Spearman, name, 100, speed, x, y);
    }

    @Override
    public String description() {
        return "S";
    }

    public void attack(Unit target) {
        int dmg = (int) (target.getMaxHealth() * 0.3);
        target.changeHealth(-dmg);
    }

}
