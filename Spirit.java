/*
Абстрактный класс Заклинатель - наследник класса Юнит
 
Обучающийся: ШИТОВ Олег Владимирович, "Разработчик Python", поток 4544, будни, утро.  07.07.2023.
*/
abstract class Spirit extends Unit {
    public Spirit(String name, int health, int damage) {
        super(name, health, damage);
    }

    public abstract void influence();
}