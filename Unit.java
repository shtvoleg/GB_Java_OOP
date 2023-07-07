/*
Абстрактный класс Юнит. Имеет наследников:
- абстрактный класс Shooter (Стрелок);
- абстрактный класс Infantry (Пехота);
- абстрактный класс Spirit (Заклинатели);
- класс Peasant (Крестьянин);
 
Обучающийся: ШИТОВ Олег Владимирович, "Разработчик Python", поток 4544, будни, утро.  07.07.2023.
*/

public class Unit {
    protected String name; // имя юнита
    protected int health; // запас здоровья
    protected int damage; // сумма повреждений

    public Unit(String name, int health, int damage) { // конструктор
        this.name = name;
        if (health < 0) {
            this.health = 0;
        } else if (health > 100) {
            this.health = 100;
        } else {
            this.health = health;
        }
        if (damage < 0) {
            this.damage = 0;
        } else if (damage > 100) {
            this.damage = 100;
        } else {
            this.damage = damage;
        }
    }
}
