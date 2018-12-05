package Ficheros.ejercicio10;

import Ficheros.Ejercicio8.Agenda;

import java.util.ArrayList;
import java.util.List;

public class ListOfAgenda {
    public List<Agenda> list = new ArrayList<>();

    public ListOfAgenda() {
    }

    public void add(Agenda ag) {
        list.add(ag);
    }

    public List<Agenda> getList() {
        return list;
    }
}
