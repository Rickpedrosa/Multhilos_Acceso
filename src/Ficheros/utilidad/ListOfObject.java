package Ficheros.utilidad;

import java.util.ArrayList;
import java.util.List;

public class ListOfObject<M> {
    private List<M> list = new ArrayList<>();

    public ListOfObject() {
    }

    public void add(M object) {
        list.add(object);
    }

    public List<M> getList() {
        return list;
    }
}
