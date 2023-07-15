/*
Обучающийся: ШИТОВ Олег Владимирович, "Разработчик Python", поток 4544, будни, утро.  15.07.2023.

Абстрактный класс пехота. Имеет предка: класс юнит. Имеет наследников: копейщик и разбойник. Имеет доп. поле: количество шагов.
*/

import java.util.ArrayList;

abstract class Infantry extends Unit {
    private int step;

    public Infantry(String name, int health, int damage, int speed, int step, int x, int y) { // конструктор с 7-ю
                                                                                              // параметрами
        super(name, health, damage, speed, x, y);
        if (step < 0) {
            this.step = 0;
        } else if (step > 100) {
            this.step = 10;
        } else {
            this.step = step;
        }
    }

    public Infantry() { // конструктор без параметров
        this("", 100, 0, 1, 10, 0, 0);
    }

    public abstract void move();

    @Override
    public void step(ArrayList<Unit> unit1, ArrayList<Unit> unit2) { // метод выводит ближайший персонаж с его
                                                                     // координатами
        Unit tmp = nearest(unit1);
        System.out.println(tmp.name + " " + coordinates.countDistance(tmp.coordinates));
    };
}