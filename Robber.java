/*
Класс разбойник. Имеет предка: класс пехота.

Обучающийся: ШИТОВ Олег Владимирович, "Разработчик Python", поток 4544, будни, утро.  08.07.2023.
*/

class Robber extends Infantry {
    private int power;

    public Robber(String name, int health, int damage, int power) { // конструктор с 4-мя параметрами
        super(name, health, damage, power);
        if (power < 0) {
            this.power = 0;
        } else if (power > 10) {
            this.power = 10;
        } else {
            this.power = power;
        }
    }

    public Robber() { // конструктор без параметров
        this("", 100, 0, 10);
    }

    public void move() {
        System.out.println("Robber " + name + " moves.");
    }
    // @Override
    // public String getInfo() {
    // return super.getInfo();
    // }
}