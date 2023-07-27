package model;

/*
Обучающийся: ШИТОВ Олег Владимирович, "Разработчик Python", поток 4544, будни, утро.  27.07.2023.
Класс Интерфейс
*/

import java.util.ArrayList;

abstract interface Game_interface {
    void step(ArrayList<Unit> unit1, ArrayList<Unit> unit2);

    String getInfo();
}
