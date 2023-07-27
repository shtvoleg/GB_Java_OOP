package model;

/*
Абстрактный класс заклинатель. Имеет предка: класс юнит. Имеет наследников: класс маг и класс священник (монах). Имеет метод: влияние.
*/
public abstract class Spirit extends Unit{
    protected int mana; // количество маны

    protected Spirit(Role role, String name, int maxHealth, int speed, int range, int x, int y) {
        super(role, name, maxHealth, speed, range, x, y);
        this.mana = 10;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " MP:" + mana + "/10";
    }

}
