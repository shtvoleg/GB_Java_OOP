/*
Обучающийся: ШИТОВ Олег Владимирович, "Разработчик Python", поток 4544, будни, утро.  08  15.07.2023.

Абстрактный класс заклинатель. Имеет предка: класс юнит. Имеет наследников: класс маг и класс священник (монах). Имеет метод: влияние.
*/
abstract class Spirit extends Unit {
    public Spirit(String name, int health, int energy, int speed, int x, int y) { // конструктор с 6-ю параметрами
        super(name, health, energy, speed, x, y);
    }

    public Spirit() { // конструктор без параметров
        this("", 100, 10, 0, 0, 0);
    } // конструктор без параметров

    public abstract void influence();
}