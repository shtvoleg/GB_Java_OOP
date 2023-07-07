/*
Класс Крестьянин - наследник класса Юнит
 
Обучающийся: ШИТОВ Олег Владимирович, "Разработчик Python", поток 4544, будни, утро.  07.07.2023.
*/

class Peasant extends Unit {
    public Peasant(String name, int health, int damage) {
        super(name, health, damage);
    }

    public void bring_Arrow() {
        System.out.println("Peasant " + name + " brings an arrow.");
    }
}