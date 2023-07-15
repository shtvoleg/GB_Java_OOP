/*
Обучающийся: ШИТОВ Олег Владимирович, "Разработчик Python", поток 4544, будни, утро.  15.07.2023.

Абстрактный класс стрелок. Имеет предка: класс юнит. Имеет наследников: снайпер и лучник (арбалетчик). Имеет доп. поле: дистанция стрельбы.
*/

import java.util.ArrayList;
import java.util.Random;

abstract class Shooter extends Unit {
    protected int distance; // дистанция стрельбы
    protected int arrow; // количество стрел/выстрелов

    public Shooter(String name, int health, int damage, int speed, int x, int y) { // конструктор с 7-ю параметрами
        super(name, health, damage, speed, x, y);
        if (distance < 0) {
            this.distance = 0;
        } else if (distance > 10) {
            this.distance = 10;
        } else {
            this.distance = distance;
        }
    }

    public Shooter() { // конструктор без параметров
        this("", 100, 0, 0, 0, 0);
    } // конструктор без параметров

    public int getArrow() {
        return this.arrow;
    }

    @Override
    public void step(ArrayList<Unit> unit1, ArrayList<Unit> unit2) {
        if (getHealth() == 0 || getArrow() == 0) { // если здоровье=0 или стрелы=0, то вернуть управление
            return;
        }
        Unit currentEnemy = nearest(unit1); // это бизлежащий противник
        attack(currentEnemy, new Random().nextInt(10)); // он пподвергается атаке со случайной величиной ущерба
        if (unit2.contains(Peasant.class)) {
            return;
        }
        arrow--;
    }
}
