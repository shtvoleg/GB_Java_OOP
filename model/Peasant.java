package model;

import java.util.ArrayList;

/*
Класс крестьянин. Имеет предка: класс юнит. Имеет метод: приносить стрелу.
*/

public class Peasant extends Unit {
    public Peasant(String name, int x, int y) {
        super(Role.Peasant, name, 50, 0, 0, x, y);
    }

    // принести стрелу лучнику
    public void bringArrow(Archer archer) {
        archer.getArrow();
    }

    @Override
    public String description() {
        return "E";
    }

    @Override
    public void step(ArrayList<Unit> unused, ArrayList<Unit> allies) {
        if (status.equals(Status.Dead))
            return;

        if (!status.equals(Status.Frozen)) {
            for (Unit unit : allies) {
                // ищем лучника, которому нужна стрела
                if (!unit.status.equals(Status.Frozen) && unit.role.equals(Role.Archer) && ((Archer) unit).getShots() == 0) {
                    bringArrow((Archer) unit);
                    status = Status.Busy;
                    return;
                }
            }
        }
        status = Status.Idle;
    }

    @Override
    public String getInfo() {
        return super.getInfo();
    }
}
