package swe4.server.services;

import javafx.collections.ObservableList;
import swe4.server.repositories.BedarfRepository;
import swe4.server.repositories.RepositoryFactory;
import swe4.ui.Hilfsgüter;

import java.util.List;

public class BedarfServiceImpl implements BedarfService {
    private final BedarfRepository bedarfRepository = RepositoryFactory.BedarfRepositoryInstance();
    @Override
    public List<Hilfsgüter> findAllBedarf() {
        return bedarfRepository.findAllBedarf();
    }

    @Override
    public void insertBedarf(Hilfsgüter bedarf) {
        bedarfRepository.insertBedarf(bedarf);
    }

    @Override
    public void deleteBedarf(Hilfsgüter bedarf) {
        bedarfRepository.deleteBedarf(bedarf);
    }
}
