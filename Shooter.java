/*
Абстрактный класс Стрелок - наследник класса Юнит. Имеет поле "Дистанция стрельбы".
  
Обучающийся: ШИТОВ Олег Владимирович, "Разработчик Python", поток 4544, будни, утро.  07.07.2023.
*/
abstract class Shooter extends Unit {
    protected int distance; // дистанция стрельбы

    public Shooter(String name, int health, int damage, int distance) {
        super(name, health, damage);
        if (distance < 0) {
            this.distance = 0;
        } else if (distance > 100) {
            this.distance = 100;
        } else {
            this.distance = distance;
        }
    }

    public abstract void attack();
}
