/*
Обучающийся: ШИТОВ Олег Владимирович, "Разработчик Python", поток 4544, будни, утро.  15.07.2023.

Класс копейщик. Имеет предка: класс пехота. Имеет доп. поле: сила.
*/

import java.util.ArrayList;

class Spearman extends Infantry {
    private int power;

    public Spearman(String name, int health, int damage, int speed, int power, int x, int y) { // конструктор с 7-ю
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

    public Spearman() { // конструктор с 4-мя параметрами
        this("", 100, 0, 1, 10, 0, 0); // конструктор без параметров
    }

    public void move() {
        System.out.println("Копейщик  " + name + " переместился.");
    }

    @Override
    public void step(ArrayList<Unit> unit1, ArrayList<Unit> unit2) {
        Unit tmp = nearest(unit1);
        System.out.println(tmp.name + " " + coordinates.countDistance(tmp.coordinates));
    };
}
