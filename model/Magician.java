package model;

import java.util.ArrayList;

/*
Класс Мог - наследник класса Заклинатель
*/

public class Magician extends Spirit {

    public Magician(String name, int range, int x, int y) {
        super(Role.Magician, name, 70, 1, range, x, y);
    }

    // Заморозить противника
    private void freeze(ArrayList<Unit> units) {
        if (mana > 0 && !status.equals(Status.Frozen)) {
            Unit target = null;

            int targetSpeed = Integer.MIN_VALUE;
            int targetHp = Integer.MIN_VALUE;
            for (Unit unit : units) {
                if (!unit.status.equals(Status.Dead) && !unit.role.equals(Role.Robber) &&
                        unit.coordinates.countDistance(coordinates) <= range) {
                    // выбираем самого шустрого или с наибольшим количеством здоровья для заморозки
                    int speed = unit.getSpeed();
                    int hp = unit.getHealth();
                    if (targetSpeed < speed) {
                        targetSpeed = speed;
                        targetHp = hp;
                        target = unit;
                    } else if (speed == targetSpeed && targetHp < hp) {
                        targetHp = hp;
                        target = unit;
                    }
                }
            }

            if (target != null) {
                target.status = Status.Frozen;
                mana -= 1;
                status = Status.Busy;
            } else {
                status = Status.Idle;
            }
        } else {
            status = Status.Idle;
        }
    }

    @Override
    public String description() {
        return "M";
    }

    @Override
    public void step(ArrayList<Unit> enemies, ArrayList<Unit> unused) {
        if (status.equals(Status.Dead))
            return;

        freeze(enemies);
    }

}
