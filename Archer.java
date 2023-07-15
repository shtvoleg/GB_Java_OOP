/*
Обучающийся: ШИТОВ Олег Владимирович, "Разработчик Python", поток 4544, будни, утро.  15.07.2023.

Класс Лучник (Арбалетчик). Имеет предка: класс Стрелок.  Имеет доп. поле: число стрел.
*/

import java.util.ArrayList;

class Archer extends Shooter {
    private int arrow; // количество стрел

    public Archer(String name, int health, int damage, int speed, int x, int y) { // конструктор с 8-ю параметрами
        super(name, health, damage, speed, x, y);
        if (arrow < 0) {
            this.arrow = 0;
        } else if (arrow > 10) {
            this.arrow = 10;
        } else {
            this.arrow = arrow;
        }
    }

    public Archer() { // конструктор без параметров
        this("", 100, 0, 0, 1, 0);
    } // конструктор без параметров

}
