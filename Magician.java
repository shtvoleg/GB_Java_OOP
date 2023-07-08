/*
Класс Мог - наследник класса Заклинатель

Обучающийся: ШИТОВ Олег Владимирович, "Разработчик Python", поток 4544, будни, утро.  08.07.2023.
*/

class Magician extends Spirit {
    private int energy;

    public Magician(String name, int health, int energy) { // конструктор с 4-мя параметорами
        super(name, health, energy);
        if (energy < 0) {
            this.energy = 0;
        } else if (energy > 10) {
            this.energy = 10;
        } else {
            this.energy = energy;
        }
    }

    public Magician() { // конструктор без параметоров
        super("", 100, 10);
    }

    // @Override
    // public String getInfo() {
    // return super.getInfo();
    // }
    public void influence() {
        System.out.println("Magician " + name + " influences with magic.");
    }
}