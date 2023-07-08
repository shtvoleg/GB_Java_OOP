/*
Абстрактный класс стрелок. Имеет предка: класс юнит. Имеет наследников: снайпер и лучник (арбалетчик). Имеет доп. поле: дистанция стрельбы.

Обучающийся: ШИТОВ Олег Владимирович, "Разработчик Python", поток 4544, будни, утро.  08.07.2023.
*/
abstract class Shooter extends Unit {
    protected int distance; // дистанция стрельбы

    public Shooter(String name, int health, int damage, int distance) { // конструктор с 4-мя параметрами
        super(name, health, damage);
        if (distance < 0) {
            this.distance = 0;
        } else if (distance > 100) {
            this.distance = 100;
        } else {
            this.distance = distance;
        }
    }

    public Shooter() { // конструктор без параметров
        this("", 100, 0, 1);
    } // конструктор без параметров

    public abstract void attack();
    // @Override
    // public String getInfo() {
    // return super.getInfo();
    // }
}