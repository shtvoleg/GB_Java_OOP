/*
Обучающийся: ШИТОВ Олег Владимирович, "Разработчик Python", поток 4544, будни, утро.  15.07.2023.

Класс снайпер. Имеет предка: класс стрелок. Имеет доп. поле: число патронов.
*/
class Sniper extends Shooter {
    private int shot;

    public Sniper(String name, int health, int damage, int speed, int x, int y) { // конструктор с 7-ю параметрами
        super(name, health, damage, speed, x, y);
        if (shot < 0) {
            this.shot = 0;
        } else if (shot > 10) {
            this.shot = 10;
        } else {
            this.shot = shot;
        }
    }

    public Sniper() { // конструктор без параметров
        this("", 100, 0, 0, 0, 0);
    }

    public void attack() { // метод на ходится в работе
        System.out.println("Снайпер " + name + " выстрелил.");
        shot--;
    }
}
