/*
Класс Мог - наследник класса Заклинатель
 
Обучающийся: ШИТОВ Олег Владимирович, "Разработчик Python", поток 4544, будни, утро.  07.07.2023.
*/

class Magician extends Spirit {
    private int mana;

    public Magician(String name, int health, int damage, int mana) {
        super(name, health, damage);
        if (mana < 0) {
            this.mana = 0;
        } else if (mana > 10) {
            this.mana = 10;
        } else {
            this.mana = mana;
        }
    }

    public void influence() {
        System.out.println("Magician " + name + " influences with magic.");
    }
}
