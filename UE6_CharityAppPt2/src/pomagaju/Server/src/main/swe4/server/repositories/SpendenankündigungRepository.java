package swe4.server.repositories;

import javafx.collections.ObservableList;
import swe4.ui.Annahmestelle;
import swe4.ui.Hilfsgüter;

import java.util.List;

public interface SpendenankündigungRepository {
    List<Hilfsgüter> findAllSpendenankündigung();

    void insertSpendenankündigung(Hilfsgüter spendenankündigung);

    void deleteSpendenankündigung(Hilfsgüter spendenankündigung);
}
