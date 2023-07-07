/*
Абстрактный класс Пехота. Имеет поле "Количество шагов".
 
Обучающийся: ШИТОВ Олег Владимирович, "Разработчик Python", поток 4544, будни, утро.  07.07.2023.
*/
abstract class Infantry extends Unit {
    private int step;

    public Infantry(String name, int health, int damage, int step) {
        super(name, health, damage);
        if (step < 0) {
            this.step = 0;
        } else if (step > 100) {
            this.step = 10;
        } else {
            this.step = step;
        }
    }

    public abstract void move();
}
