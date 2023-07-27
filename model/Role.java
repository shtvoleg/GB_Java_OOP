package model;

/*
Роль персонажа
*/
public enum Role {
    Archer("Лучник"),
    Magician("Маг"),
    Peasant("Крестьянин"),
    Priest("Монах"),
    Robber("Разбойник"),
    Sniper("Снайпер"),
    Spearman("Копейщик");

    private final String name;

    Role(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
