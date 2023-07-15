/*
Обучающийся: ШИТОВ Олег Владимирович, "Разработчик Python", поток 4544, будни, утро.  15.07.2023.

Класс Мог - наследник класса Заклинатель
*/

class Magician extends Spirit {
    private int energy;

    public Magician(String name, int health, int energy, int speed, int x, int y) { // конструктор с 6-ю параметрами
        super(name, health, energy, speed, x, y);
        if (energy < 0) {
            this.energy = 0;
        } else if (energy > 10) {
            this.energy = 10;
        } else {
            this.energy = energy;
        }
    }

    public Magician() { // конструктор без параметоров
        super("Маг", 100, 10, 0, 1, 0);
    } // конструктор без параметров

    public void influence() {
        System.out.println("Маг " + name + " применил магию.");
    } // метод находится в работе
}
