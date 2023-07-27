/*
Обучающийся: ШИТОВ Олег Владимирович, "Разработчик Python", поток 4544, будни, утро.  27.07.2023.

Объектно-ориентированное программирование (семинары)
Реализовать игру на Java с ООП. В игре участвуют 2 команды, в каждой по 10 участников,
каждый участник имеет случайную роль из числа семи установленных.

Основной модуль (Role_game.java)
*/

import model.*;
import ui.Board;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Role_game { // основной модуль
    private static final Random rnd = new Random();
    private static final int TEAM_SIZE = 10; // в обеих командах будет по 10 персонажей

    public static void main(String[] args) {

        ArrayList<Unit> team1 = createTeam(0); // Создаем команду 1
        ArrayList<Unit> team2 = createTeam(9); // Создаем команду 2
        ArrayList<Unit> robbers = spawnRobbers(2); // Создаем разбойников

        // Упорядочиваем команды
        team1.sort(Comparator.reverseOrder());
        team2.sort(Comparator.reverseOrder());

        // противники для команды 1 = команда 2 + разбойники
        ArrayList<Unit> team1Enemies = new ArrayList<>();
        team1Enemies.addAll(team2);
        team1Enemies.addAll(robbers);

        // противники для команды 2 = команда 1 + разбойники
        ArrayList<Unit> team2Enemies = new ArrayList<>();
        team2Enemies.addAll(team1);
        team2Enemies.addAll(robbers);

        // противники для разбойников = команда 1 + команда 2
        ArrayList<Unit> robbersEnemies = new ArrayList<>();
        robbersEnemies.addAll(team1);
        robbersEnemies.addAll(team2);

        Board board = new Board(); // Доска
        board.show(team1, team2, robbers); // отображаем первоначальное расположение

        System.out.println("Ход - по нажатию <Enter>...");
        Scanner in = new Scanner(System.in);
        int winTeam = 0;
        while (winTeam == 0) { // пока выигравший не определен

            in.nextLine();

            for (int i = 0; i < 10; i++) { // для всех членов каждой из команд
                if (isTeamDead(team1)) { // если все члены команды 1 убиты
                    winTeam = 2; // то команда 2 выиграла
                    break;
                } else if (isTeamDead(team2)) { // и наоборот
                    winTeam = 1;
                    break;
                } else { // команды живы, делаем поочереди ходы
                    team1.get(i).step(team1Enemies, team1);
                    team2.get(i).step(team2Enemies, team2);
                }
            }

            // ход разбойников
            for (Unit unit : robbers)
                unit.step(robbersEnemies, robbers);

            board.show(team1, team2, robbers); // отобразить доску
        }

        System.out.printf("Команда %s выиграла\n", winTeam == 1 ? "зеленых" : "синих");
    }

    // создание команды
    private static ArrayList<Unit> createTeam(int num) { // метод создаёт команду из числа <teamSize> случайно
                                                         // выбранных персонажей, num = координата y
        ArrayList<Unit> team = new ArrayList<>();

        for (int i = 0; i < TEAM_SIZE; i++) {
            int val = rnd.nextInt(6); // персонаж - случайный
            switch (val) {
                case (0):
                    team.add(new Magician(getRandomName(), 5, i, num));
                    break;
                case (1):
                    team.add(new Priest(getRandomName(), i, num));
                    break;
                case (2):
                    team.add(new Spearman(getRandomName(), 2, i, num));
                    break;
                case (3):
                    team.add(new Sniper(getRandomName(), 0, 8, i, num));
                    break;
                case (4):
                    team.add(new Archer(getRandomName(), 5, 5, i, num));
                    break;
                default:
                    team.add(new Peasant(getRandomName(), i, num));
                    break;
            }
        }
        return team;
    }

    // создание разбойников
    private static ArrayList<Unit> spawnRobbers(int count) {
        ArrayList<Unit> result = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            while (true) {
                // выбираем случайные координаты на оставшихся ячейках доски
                int x = rnd.nextInt(10);
                int y = rnd.nextInt(8) + 1;
                Coordinates coordinates = new Coordinates(x, y);

                boolean duplicate = false;
                // проверяем, что координата не занята другим разбойником
                for (Unit unit : result) {
                    if (unit.getCoordinates().equals(coordinates)) {
                        duplicate = true;
                        break;
                    }
                }

                if (!duplicate) {
                    // создаем нового разбойника
                    result.add(new Robber(getRandomName(), 100, 1, 10, x, y));
                    break;
                }
            }
        }
        return result;
    }

    // все ли члены команды мертвы?
    public static boolean isTeamDead(ArrayList<Unit> team) {
        for (Unit avengers : team) {
            if (!avengers.getStatus().equals(Status.Dead))
                return false;
        }
        return true;
    }

    // выбор случайного имени
    private static String getRandomName() {
        var names = Name.values();
        return String.valueOf(names[rnd.nextInt(names.length)]);
    }
}
