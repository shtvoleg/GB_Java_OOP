package model;

/*
Класс Интерфейс
*/

import java.util.ArrayList;

abstract interface Game_interface {
    void step(ArrayList<Unit> unit1, ArrayList<Unit> unit2);

    String getInfo();
}
