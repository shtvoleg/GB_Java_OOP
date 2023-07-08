/*
Класс копейщик. Имеет предка: класс пехота. Имеет доп. поле: сила.

Обучающийся: ШИТОВ Олег Владимирович, "Разработчик Python", поток 4544, будни, утро.  08.07.2023.
*/

class Spearman extends Infantry {
    private int power;

    public Spearman(String name, int health, int damage, int power) { // конструктор с 4-мя параметрами
        super(name, health, damage, power);
        if (power < 0) {
            this.power = 0;
        } else if (power > 10) {
            this.power = 10;
        } else {
            this.power = power;
        }
    }

    public Spearman() { // конструктор с 4-мя параметрами
        this("", 100, 0, 10); // конструктор без параметров
    }

    public void move() {
        System.out.println("Spearman " + name + " moves.");
    }
    // @Override
    // public String getInfo() {
    // return super.getInfo();
    // }
}