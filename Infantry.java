/*
Абстрактный класс пехота. Имеет предка: класс юнит. Имеет наследников: копейщик и разбойник. Имеет доп. поле: количество шагов.

Обучающийся: ШИТОВ Олег Владимирович, "Разработчик Python", поток 4544, будни, утро.  08.07.2023.
*/
abstract class Infantry extends Unit {
    private int step;

    public Infantry(String name, int health, int damage, int step) { // конструктор с 4-мя параметрами
        super(name, health, damage);
        if (step < 0) {
            this.step = 0;
        } else if (step > 100) {
            this.step = 10;
        } else {
            this.step = step;
        }
    }

    public Infantry() { // конструктор без параметров
        this("", 100, 0, 10);
    }

    public abstract void move();
    // @Override
    // public String getInfo() {
    // return super.getInfo();
    // }
}
