/*
Класс снайпер. Имеет предка: класс стрелок. Имеет доп. поле: число патронов.

Обучающийся: ШИТОВ Олег Владимирович, "Разработчик Python", поток 4544, будни, утро.  08.07.2023.
*/
class Sniper extends Shooter {
    private int shot;

    public Sniper(String name, int health, int damage, int distance, int shot) { // конструктор с 5-ю параметрами
        super(name, health, damage, distance);
        if (shot < 0) {
            this.shot = 0;
        } else if (shot > 10) {
            this.shot = 10;
        } else {
            this.shot = shot;
        }
    }

    public Sniper() { // конструктор без параметров
        this("", 100, 0, 10, 10);
    }

    public void attack() {
        System.out.println("Sniper " + name + " attacks with a shot.");
        shot--;
    }
    // @Override
    // public String getInfo() {
    // return super.getInfo();
    // }
}