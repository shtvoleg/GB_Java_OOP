package model;

import java.util.ArrayList;

/*
Абстрактный класс юнит. Имеет наследников:
- абстрактный класс model.Shooter (Стрелок);
- абстрактный класс model.Infantry (Пехота);
- абстрактный класс model.Spirit (Заклинатели);
- класс model.Peasant (Крестьянин);
*/

public abstract class Unit implements Game_interface, Comparable<Unit> {
    protected final Role role; // роль
    private final String name; // имя
    private final int maxHealth; // максимальное здоровье
    private int health; // текущее здоровье
    private final int speed; // скорость
    protected Status status; // статус в зависимости от роли
    protected final int range; // дальность действия
    protected Coordinates coordinates; // текущие координаты на доске

    // конструктор
    protected Unit(Role role, String name, int maxHealth, int speed, int range, int x, int y) {
        this.role = role;
        this.name = name;
        this.maxHealth = this.health = maxHealth;
        this.speed = speed;
        this.range = range;
        this.status = Status.Idle;
        this.coordinates = new Coordinates(x, y);
    }

    public Role getRole() {
        return role;
    }

    public Status getStatus() {
        return status;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getHealth() {
        return health;
    }

    // изменить запас текущего здоровья
    public void changeHealth(int delta) {
        health += delta;
        if (health <= 0) {
            health = 0;
            status = Status.Dead; // убит
        } else if (health > maxHealth) {
            health = maxHealth;
        }
    }

    public int getSpeed() {
        return speed;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    // определить ближайшего персонажа из команды соперника
    public Unit nearest(ArrayList<Unit> units) {
        Unit result = null;
        int minDist = Integer.MAX_VALUE;
        for (Unit unit : units) {
            int dist = coordinates.countDistance(unit.coordinates);
            if (dist < minDist && !unit.status.equals(Status.Dead)) {
                minDist = dist;
                result = unit;
            }
        }
        return result;
    }

    // двигаться в сторону target, с учетом занятости клеток персонажами из units
    protected void moveTo(Unit target, ArrayList<Unit> units) {
        int thisX = coordinates.x;
        int thisY = coordinates.y;
        int tgtX = target.coordinates.x;
        int tgtY = target.coordinates.y;

        // на сколько нужно передвинуться
        int distance = Math.min(speed, target.coordinates.countDistance(coordinates) - 1);
        // передвигаемся
        for (int i = 0; i < distance; i++) {
            if (Math.abs(thisX - tgtX) >= Math.abs(thisY - tgtY)) {
                if (thisX - tgtX > 0)
                    thisX -= 1;
                else
                    thisX += 1;
            } else {
                if (thisY - tgtY > 0)
                    thisY -= 1;
                else
                    thisY += 1;
            }
        }

        Coordinates coords = new Coordinates(thisX, thisY);
        // проверяем, что в данную координату можем передвинуться (не занята)
        for (Unit unit : units) {
            if (unit.coordinates.equals(coords)) {
                status = Status.Idle;
                return;
            }
        }
        coordinates = coords;
    }

    public abstract String description();

    @Override
    public String getInfo() {
        return role + " " + name + " " + coordinates + " " + status + " HP:" + health + "/" + maxHealth;
    }

    // сравнение юнитов по их скорости, или запасу оставшегося здоровья, если
    // скорости равны
    @Override
    public int compareTo(Unit unit) {
        int cmp = Integer.compare(speed, unit.speed);
        if (cmp != 0)
            return cmp;
        return Integer.compare(health, unit.health);
    }
}
