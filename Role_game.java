/*Объектно-ориентированное программирование (семинары)
Урок 1. Принципы ООП: Инкапсуляция, наследование, полиморфизм

Проанализировать и описать персонажей: Маг, Священник (или Монах), Разбойник, Копейщик, Снайпер, Лучник (или Арбалетчик), Крестьянин.
На базе описания персонажей описать простейшую иерархию классов.
В основной программе создать по одному экземпляру каждого класса.
 
Обучающийся: ШИТОВ Олег Владимирович, "Разработчик Python", поток 4544, будни, утро.  07.07.2023.
 */

public class Role_game {
    public static void main(String[] args) {

        System.out.println("**** Начало ****");
        // создание 1 мага; 1 священника; 1 разбойника; 1 копейщика, 1 снайпера, 1
        // лучника и 1 крестьянина соответственно
        Magician Magician1 = new Magician("Маг-1", 100, 0, 100);
        System.out.println("Инициализирован " + Magician1.name + ".");
        Priest Priest1 = new Priest("Священник-1", 100, 0, 100);
        System.out.println("Инициализирован " + Priest1.name + ".");
        Robber Robber1 = new Robber("Разбойник-1", 100, 0, 10);
        System.out.println("Инициализирован " + Robber1.name + ".");
        Spearman Spearman1 = new Spearman("Копейщик-1", 100, 0, 10);
        System.out.println("Инициализирован " + Spearman1.name + ".");
        Sniper Sniper1 = new Sniper("Снайпер-1", 100, 0, 5, 10);
        System.out.println("Инициализирован " + Sniper1.name + ".");
        Archer Archer1 = new Archer("Лучник-1", 100, 0, 1, 10);
        System.out.println("Инициализирован " + Archer1.name + ".");
        Peasant Peasant1 = new Peasant("Крестьянин-1", 100, 0);
        System.out.println("Инициализирован " + Peasant1.name + ".");

    }
}