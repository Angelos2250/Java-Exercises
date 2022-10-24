package swe4.server.repositories;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import swe4.ui.Hilfsgüter;

import java.util.ArrayList;
import java.util.List;

public class FakeBedarfRepository implements BedarfRepository{
    public static List<Hilfsgüter> bedarfs = new ArrayList<>();
    @Override
    public List<Hilfsgüter> findAllBedarf() {
        return bedarfs;
    }

    @Override
    public void insertBedarf(Hilfsgüter bedarf) {
        bedarfs.add(bedarf);
    }

    @Override
    public void deleteBedarf(Hilfsgüter bedarf) {
        bedarfs.remove(bedarf);
    }
}
