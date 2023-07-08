/*
Класс крестьянин. Имеет предка: класс юнит. Имеет метод: приносить стрелу.

Обучающийся: ШИТОВ Олег Владимирович, "Разработчик Python", поток 4544, будни, утро.  08.07.2023.
*/

class Peasant extends Unit {
    public Peasant(String name, int health, int damage) { // конструктор с 3-мя параметрами
        super(name, health, damage);
    }

    public Peasant() { // конструктор без параметров
        this("", 100, 0);
    }

    public void bring_Arrow() {
        System.out.println("Peasant " + name + " brings an arrow.");
    }
    // @Override
    // public String getInfo() {
    // return super.getInfo();
    // }
}