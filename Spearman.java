/*
Класс Копейщик - наследник класса Пехота
 
Обучающийся: ШИТОВ Олег Владимирович, "Разработчик Python", поток 4544, будни, утро.  07.07.2023.
*/

class Spearman extends Infantry {
    private int power;

    public Spearman(String name, int health, int damage, int power) {
        super(name, health, damage, power);
        if (power < 0) {
            this.power = 0;
        } else if (power > 10) {
            this.power = 10;
        } else {
            this.power = power;
        }
    }

    public void move() {
        System.out.println("Spearman " + name + " moves.");
    }
}
