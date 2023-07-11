/*
Класс Координаты

Обучающийся: ШИТОВ Олег Владимирович, "Разработчик Python", поток 4544, будни, утро.  11.07.2023.
*/

public class Coordinates {
    int x, y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double countDistance(Coordinates coordinates) { // метод рассчитывает расстояние между двумя персонажами
        int dx = coordinates.x - x;
        int dy = coordinates.y - y;
        return (Math.sqrt(dx * dx + dy * dy));
    }
}