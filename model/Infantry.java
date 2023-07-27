package model;

import java.util.ArrayList;

/*
Абстрактный класс пехота. Имеет предка: класс юнит. Имеет наследников: копейщик и разбойник. Имеет доп. поле: количество шагов.
*/

public abstract class Infantry extends Unit {

    protected Infantry(Role role, String name, int maxHealth, int speed, int x, int y) {
        super(role, name, maxHealth, speed, 1, x, y);
    }

    // сделать ход
    @Override
    public void step(ArrayList<Unit> enemies, ArrayList<Unit> allies) {
        if (status.equals(Status.Dead)) // если убит, то
            return; // выходим

        if (!status.equals(Status.Frozen)) { // если не заморожен
            Unit target = nearest(enemies); // ближайший противник
            if (target != null) {
                if (target.coordinates.countDistance(coordinates) <= range) {
                    // бьем, если можем дотянуться
                    status = Status.Busy;
                    attack(target);
                } else {
                    // если не можем, идем в его сторону
                    ArrayList<Unit> allUnits = new ArrayList<>();
                    allUnits.addAll(allies);
                    allUnits.addAll(enemies);
                    status = Status.Moving;
                    moveTo(target, allUnits);
                }
            } else {
                status = Status.Idle;
            }
        } else {
            status = Status.Idle;
        }
    }

    // атаковать
    protected abstract void attack(Unit target);

}
