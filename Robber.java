/*
Обучающийся: ШИТОВ Олег Владимирович, "Разработчик Python", поток 4544, будни, утро.  15.07.2023.

Класс разбойник. Имеет предка: класс пехота.
*/

import java.util.ArrayList;

class Robber extends Infantry {
    private int power;

    public Robber(String name, int health, int damage, int speed, int power, int x, int y) { // конструктор с 7-ю
                                                                                             // параметрами
        super(name, health, damage, speed, power, x, y);
        if (power < 0) {
            this.power = 0;
        } else if (power > 10) {
            this.power = 10;
        } else {
            this.power = power;
        }
    }

    public Robber() { // конструктор без параметров
        this("", 100, 0, 1, 10, 0, 0);
    } // констрактор без параметров

    public void move() {
        System.out.println("Robber " + name + " moves.");
    } // метода находится в работе

    @Override
    public void step(ArrayList<Unit> unit1, ArrayList<Unit> unit2) {
        Unit tmp = nearest(unit1);
        System.out.println(tmp.name + " " + coordinates.countDistance(tmp.coordinates));
    }
}