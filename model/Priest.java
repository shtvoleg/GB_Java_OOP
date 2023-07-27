package model;

import java.util.ArrayList;

/*
Класс Священник - наследник класса Заклинатель
*/

public class Priest extends Spirit {
    public Priest(String name, int x, int y) {
        super(Role.Priest, name, 70, 0, 0, x, y);
    }

    private void heal(ArrayList<Unit> units) {
        if (mana > 0 && !status.equals(Status.Frozen)) {
            Unit target = null;

            double minHpRatio = 1;
            for (Unit unit : units) {
                // ищем наиболее раненого (но живого)
                if (!unit.status.equals(Status.Dead) && !unit.role.equals(Role.Magician) && !unit.role.equals(Role.Priest)) {
                    double hpRatio = (double) unit.getHealth() / unit.getMaxHealth();
                    if (hpRatio < minHpRatio) {
                        minHpRatio = hpRatio;
                        target = unit;
                    }
                }
            }

            if (target != null) {
                // лечим раненого, если есть такой
                target.changeHealth((int) (target.getMaxHealth() * 0.3));
                mana -= 1;
                status = Status.Healing;
            } else {
                status = Status.Idle;
            }
        } else {
            status = Status.Idle;
        }
    }

    @Override
    public String description() {
        return "P";
    }

    @Override
    public void step(ArrayList<Unit> unused, ArrayList<Unit> allies) {
        if (status.equals(Status.Dead))
            return;

        heal(allies);
    }

}
