/*
Обучающийся: ШИТОВ Олег Владимирович, "Разработчик Python", поток 4544, будни, утро.  15.07.2023.

Класс Священник - наследник класса Заклинатель
*/

class Priest extends Spirit {
    private int energy;

    public Priest(String name, int health, int energy, int speed, int x, int y) { // конструктор с 7-ю параметрами

        super(name, health, energy, speed, x, y);
        if (energy < 0) {
            this.energy = 0;
        } else if (energy > 10) {
            this.energy = 10;
        } else {
            this.energy = energy;
        }
    }

    public Priest() {
        super("Монах", 100, 10, 0, 0, 0);
    } // конструктор без параметров

    public void influence() {
        System.out.println("Монах " + name + " применил заклинание.");
    } // метод находится в работе
}
