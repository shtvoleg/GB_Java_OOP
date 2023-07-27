package ui;

import model.Status;
import model.Unit;
import ui.AnsiColors;

import java.util.ArrayList;
import java.util.Arrays;

/*
Игровая доска.
Отображает поле битвы и информацию о командах.
 */
public class Board {
    private final String[][] board; // ячейки доски
    private int step; // текущий шаг игры

    public Board() {
        board = new String[10][10];
        step = 0;
        reset();
    }

    // "обнуление" доски
    private void reset() {
        for (String[] row: board)
            Arrays.fill(row, " ");
    }

    // установка на доску персонажей из units с цветом color
    private void setUnits(ArrayList<Unit> units, String color) {
        for (Unit unit : units) {
            if (!unit.getStatus().equals(Status.Dead)) {
                int x = unit.getCoordinates().getX();
                int y = unit.getCoordinates().getY();
                board[y][x] = color + unit.description() + AnsiColors.ANSI_RESET;
            }
        }
    }

    // Отображение доски и информации о командах
    public void show(ArrayList<Unit> team1, ArrayList<Unit> team2, ArrayList<Unit> robbers) {
        // расстановка всех персонажей
        reset();
        setUnits(team1, AnsiColors.ANSI_GREEN);
        setUnits(team2, AnsiColors.ANSI_BLUE);
        setUnits(robbers, AnsiColors.ANSI_RED);

        // ширина левого столбца в описании команд
        int width = team1.stream().map(Unit::getInfo).map(String::length).max(Integer::compareTo).get();

        // вывод доски в псевдографике и двух колонок с инфой о командах
        System.out.printf("  %-21s", "Шаг " + step);
        System.out.print(AnsiColors.ANSI_GREEN + "  Зеленые" + AnsiColors.ANSI_RESET);
        System.out.print(" ".repeat(width - 9) + "    ");
        System.out.println(AnsiColors.ANSI_BLUE + "  Синие" + AnsiColors.ANSI_RESET);
        System.out.println('┌' + "─┬".repeat(9) + "─┐");
        for (int i = 0; i < 9; i++) {
            for (String elem : board[i])
                System.out.print("│" + elem);
            System.out.print("│  ");
            System.out.printf("%-" + width + "s    " + team2.get(i).getInfo(), team1.get(i).getInfo());
            System.out.println("\n├" + "─┼".repeat(9) + "─┥");
        }
        for (String elem : board[9])
            System.out.print("│" + elem);
        System.out.print("│  ");
        System.out.printf("%-" + width + "s    " + team2.get(9).getInfo(), team1.get(9).getInfo());
        System.out.println("\n└" + "─┴".repeat(9) + "─┘");

        step++;
    }
}
