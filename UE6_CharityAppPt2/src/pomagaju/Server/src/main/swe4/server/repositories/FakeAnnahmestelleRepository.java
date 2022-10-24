package swe4.server.repositories;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import swe4.ui.Annahmestelle;

import java.util.ArrayList;
import java.util.List;

public class FakeAnnahmestelleRepository implements AnnahmestelleRepository{
    public static List<Annahmestelle> annahmestellen = new ArrayList<>();

    @Override
    public List<Annahmestelle> findAllAnnahmestellen() {
        return annahmestellen;
    }

    @Override
    public Annahmestelle findByName(String name) {
        for (Annahmestelle a:annahmestellen){
            if (a.getName()==name){
                return a;
            }
        }
        return null;
    }

    @Override
    public void insertAnnahmestelle(Annahmestelle annahmestelle) {
        annahmestellen.add(annahmestelle);
    }

    @Override
    public void deleteAnnahmestelle(Annahmestelle annahmestelle) {
        annahmestellen.remove(annahmestelle);
    }

    @Override
    public void updateAnnahmestelle(Annahmestelle annahmestelle) {
        int index = annahmestellen.indexOf(annahmestelle);
        if (index < 0) return;
        annahmestellen.set(index,annahmestelle);
    }
}
