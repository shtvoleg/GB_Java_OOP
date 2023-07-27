package model;

/*
Статус персонажа
*/
public enum Status {
    Idle("простаивает"),
    Busy("занят"),
    Frozen("заморожен"),
    Moving("ходит"),
    Healing("лечит"),
    Dead("убит");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
}
