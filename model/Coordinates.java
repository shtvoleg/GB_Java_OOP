package model;

/*
Класс Координаты
*/

public class Coordinates {
    int x, y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // рассчитать расстояние между двумя координатами
    public int countDistance(Coordinates coordinates) {
        int dx = Math.abs(coordinates.x - x);
        int dy = Math.abs(coordinates.y - y);
        return Math.max(dx, dy);
    }

    // сравнение координат на равенство
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        if (x != that.x) return false;
        return y == that.y;
    }

    @Override
    public String toString() {
        return "(" + x + ";" + y + ")";
    }

}