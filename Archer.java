/*
Класс Лучник (Арбалетчик) - наследник класса Стрелок.  Имеет дополнительное поле "Число стрел".
 
Обучающийся: ШИТОВ Олег Владимирович, "Разработчик Python", поток 4544, будни, утро.  07.07.2023.
*/

class Archer extends Shooter {
    private int arrow;

    public Archer(String name, int health, int damage, int distance, int arrow) {
        super(name, health, damage, distance);
        if (arrow < 0) {
            this.arrow = 0;
        } else if (arrow > 10) {
            this.arrow = 10;
        } else {
            this.arrow = arrow;
        }
    }

    public void attack() {
        System.out.println("Sniper " + name + " attacks with a shot.");
        arrow--;
    }
}
