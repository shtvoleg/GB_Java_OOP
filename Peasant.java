/*
Обучающийся: ШИТОВ Олег Владимирович, "Разработчик Python", поток 4544, будни, утро.  15.07.2023.

Класс крестьянин. Имеет предка: класс юнит. Имеет метод: приносить стрелу.
*/

class Peasant extends Unit {
    public Peasant(String name, int health, int damage, int speed, int x, int y) { // конструктор с 6-ю параметрами

        super(name, health, damage, speed, x, y);
    }

    public Peasant() { // конструктор без параметров
        this("", 100, 0, 0, 0, 0);
    }

    public void bring_Arrow() {
        System.out.println("Крестьянин " + name + " принёс стрелу.");
    } // метод находится в работе
}