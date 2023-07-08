/*Объектно-ориентированное программирование (семинары)

*Урок 1. Принципы ООП: Инкапсуляция, наследование, полиморфизм

Проанализировать и описать персонажей: Маг, Священник (или Монах), Разбойник, Копейщик, Снайпер, Лучник (или Арбалетчик), Крестьянин.
На базе описания персонажей описать простейшую иерархию классов.
В основной программе создать по одному экземпляру каждого класса.

*Урок 2. Принципы ООП Абстракция и интерфейсы. Пример проектирования

Добавить файл с описанием интерфейса. В котором описать два метода, void step(); и String getInfo();
Реализовать интерфейс в абстрактном классе и в наследниках так, чтобы getInfo возвращал тип персонажа.
Создать два списка в классе main. В каждый из списков добавить по десять случайных экземнляров наследников BaseHero.
Удалить ненужные методы из абстрактного класса, если такие есть.
В main пройти по спискам и вызвать у всех персонажей getInfo.

Обучающийся: ШИТОВ Олег Владимирович, "Разработчик Python", поток 4544, будни, утро.  08.07.2023.
 */

import java.util.ArrayList;
import java.util.Random;

public class Role_game { // основной модуль

    public static void main(String[] args) {

        final int TEAM_SIZE = 10; // в обеих командах будет по 10 персонажей

        System.out.println("**** Команда1: ****");
        ArrayList<Unit> team1 = team(TEAM_SIZE); // создаём команду1

        System.out.println("\n**** Команда2: ****");
        ArrayList<Unit> team2 = team(TEAM_SIZE); // создаём команду2
    }

    public static ArrayList<Unit> team(int teamSize) { // метод создаёт команду из teamSize случайно выбранных
                                                       // персонажей
        ArrayList<Unit> team = new ArrayList<>();
        for (int i = 0; i < teamSize; i++) {
            int val = new Random().nextInt(7);
            switch (val) {
                case (0):
                    team.add(new Magician("Magician", 100, 0));
                    break;
                case (1):
                    team.add(new Priest("Priest", 100, 0, 0));
                    break;
                case (2):
                    team.add(new Robber("Robber", 100, 0, 0));
                    break;
                case (3):
                    team.add(new Spearman("Spearman", 100, 0, 0));
                    break;
                case (4):
                    team.add(new Sniper("Sniper", 100, 0, 0, 10));
                    break;
                case (5):
                    team.add(new Archer("Archer", 100, 0, 0, 0));
                    break;
                default:
                    team.add(new Peasant("Peasant", 100, 0));
                    break;
            }
            System.out.printf("%d) %s\n", i, team.get(i).getInfo());
        }
        return team;
    }
}