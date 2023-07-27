package model;

/*
Класс Лучник (Арбалетчик). Имеет предка: класс Стрелок.  Имеет доп. поле: число стрел.
*/

public class Archer extends Shooter {

    public Archer(String name, int shots, int range, int x, int y) {
        super(Role.Archer, name, 100, 2, shots, range, x, y);
    }

    // получить стрелу
    public void getArrow() {
        this.shots += 1;
    }

    @Override
    public String description() {
        return "A";
    }

}
