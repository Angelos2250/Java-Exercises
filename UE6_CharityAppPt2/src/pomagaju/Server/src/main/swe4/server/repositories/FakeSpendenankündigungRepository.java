package swe4.server.repositories;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import swe4.ui.Annahmestelle;
import swe4.ui.Hilfsgüter;

import java.util.ArrayList;
import java.util.List;

public class FakeSpendenankündigungRepository implements SpendenankündigungRepository{
    public static List<Hilfsgüter> spendenankündigungen = new ArrayList<>();
    @Override
    public List<Hilfsgüter> findAllSpendenankündigung() {
        return spendenankündigungen;
    }

    @Override
    public void insertSpendenankündigung(Hilfsgüter spendenankündigung) {
        spendenankündigungen.add(spendenankündigung);
    }

    @Override
    public void deleteSpendenankündigung(Hilfsgüter spendenankündigung) {
        spendenankündigungen.remove(spendenankündigung);
    }
}
