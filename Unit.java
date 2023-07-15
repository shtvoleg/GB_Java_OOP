/*
Обучающийся: ШИТОВ Олег Владимирович, "Разработчик Python", поток 4544, будни, утро. 15.07.2023.

Абстрактный класс юнит. Имеет наследников:
- абстрактный класс Shooter (Стрелок);
- абстрактный класс Infantry (Пехота);
- абстрактный класс Spirit (Заклинатели);
- класс Peasant (Крестьянин);
*/

import java.util.ArrayList;
import java.util.Random;

public abstract class Unit {
    protected String name; // имя юнита
    protected int health; // запас здоровья
    protected int damage; // сумма повреждений
    protected int speed; // скорость передвижения

    Coordinates coordinates;

    public Unit(String name, int health, int damage, int speed, int x, int y) { // конструктор с 6-ю параметрами
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.speed = speed;
        coordinates = new Coordinates(x, y);
        if (health < 0) {
            this.health = 0;
        } else if (health > 100) {
            this.health = 100;
        } else {
            this.health = health;
        }
        if (damage < 0) {
            this.damage = 0;
        } else if (damage > 100) {
            this.damage = 100;
        } else {
            this.damage = damage;
        }
    }

    public Unit() { // конструктор без параметров
        this("", 100, 0, 1, 0, 0);
    } // конструктор без параметров

    public String getInfo() {
        return String.format("%s: скорость=%d, x= %d, y= %d", this.name, this.speed, coordinates.x, coordinates.y);
    }

    public String getName() {
        return name;
    }

    public String getRandomName() {
        return String.valueOf(Name.values()[new Random().nextInt(Name.values().length)]);
    }

    public int getHealth() {
        return this.health;
    }

    public void step(ArrayList<Unit> unit1, ArrayList<Unit> unit2) {
        return;
    }

    public Unit nearest(ArrayList<Unit> unit) { // метод определяет ближайшего персонажа из команды соперника
        double nearestDistance = Double.MAX_VALUE;
        Unit nearestEnemy = null;
        for (int i = 0; i < unit.size(); i++) {
            if (coordinates.countDistance(unit.get(i).coordinates) < nearestDistance) {
                nearestDistance = coordinates.countDistance(unit.get(i).coordinates);
                nearestEnemy = unit.get(i);
            }
        }
        return nearestEnemy;
    }

    public void getDamage(int Damage) {
        if (this.health - damage > 0) {
            this.health -= damage;
        } else {
            this.health = 0; // здоровья нет -> нежизнеспособен
        }
    }

    public void attack(Unit target, int damage) { // метод описывает атаку персонажа target
        target.getDamage(damage);
        System.out.printf("\n%s был атакован с ущербом %d.", target.name, damage);
    }

    public int getSpeed() { // метод возвращает скорость
        return speed;
    }
}