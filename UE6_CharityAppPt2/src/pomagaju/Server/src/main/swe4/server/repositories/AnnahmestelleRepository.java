package swe4.server.repositories;

import javafx.collections.ObservableList;
import swe4.ui.Annahmestelle;

import java.util.List;
import java.util.Map;

public interface AnnahmestelleRepository {
    List<Annahmestelle> findAllAnnahmestellen();

    Annahmestelle findByName(String name);

    void insertAnnahmestelle(Annahmestelle annahmestelle);

    void deleteAnnahmestelle(Annahmestelle annahmestelle);
    void updateAnnahmestelle(Annahmestelle annahmestelle);
}
