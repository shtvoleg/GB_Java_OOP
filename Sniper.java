/*
Класс Снайпер - наследник абстрактного класса Стрелок. Имеет дополнительное поле "Число патронов".
 
Обучающийся: ШИТОВ Олег Владимирович, "Разработчик Python", поток 4544, будни, утро.  07.07.2023.
*/
class Sniper extends Shooter {
    private int shot;

    public Sniper(String name, int health, int damage, int distance, int shot) {
        super(name, health, damage, distance);
        if (shot < 0) {
            this.shot = 0;
        } else if (shot > 10) {
            this.shot = 10;
        } else {
            this.shot = shot;
        }
    }

    public void attack() {
        System.out.println("Sniper " + name + " attacks with a shot.");
        shot--;
    }
}
