/*
Абстрактный класс заклинатель. Имеет предка: класс юнит. Имеет наследников: класс маг и класс священник (монах). Имеет метод: влияние.

Обучающийся: ШИТОВ Олег Владимирович, "Разработчик Python", поток 4544, будни, утро.  08.07.2023.
*/
abstract class Spirit extends Unit {
    public Spirit(String name, int health, int energy) { // конструктор с 4-мя параметрами
        super(name, health, energy);
    }

    public Spirit() { // конструктор без параметров
        this("", 100, 10);
    } // конструктор без параметров

    public abstract void influence();

    // @Override
    // public String getInfo() {
    // return super.getInfo();
    // }
}