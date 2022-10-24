package swe4.server.repositories;

import javafx.collections.ObservableList;
import swe4.ui.Hilfsgüter;

import java.util.List;

public interface BedarfRepository {
    List<Hilfsgüter> findAllBedarf();

    void insertBedarf(Hilfsgüter bedarf);

    void deleteBedarf(Hilfsgüter bedarf);
}
