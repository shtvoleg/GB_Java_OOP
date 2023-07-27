package model;

import java.util.ArrayList;

/*
Абстрактный класс стрелок. Имеет предка: класс юнит. Имеет наследников: снайпер и лучник (арбалетчик). Имеет доп. поле: дистанция стрельбы.
*/
public abstract class Shooter extends Unit {
    protected int shots; // количество выстрелов

    protected Shooter(Role role, String name, int maxHealth, int speed, int shots, int range, int x, int y) {
        super(role, name, maxHealth, speed, range, x, y);
        this.shots = shots;
    }

    public int getShots() {
        return shots;
    }

    @Override
    public void step(ArrayList<Unit> enemies, ArrayList<Unit> allies) {
        if (status.equals(Status.Dead))
            return;

        if (!status.equals(Status.Frozen)) {
            Unit target = nearest(enemies); // ближайший противник
            if (target != null) {
                if (target.coordinates.countDistance(coordinates) <= range) {
                    // атакуем, если достаем
                    status = Status.Busy;
                    attack(target);
                } else {
                    // иначе двигаемся ближе
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

    protected void attack(Unit target) {
        int dmg = (int) (target.getMaxHealth() * 0.3);
        target.changeHealth(-dmg);
        shots -= 1;
    }

}
