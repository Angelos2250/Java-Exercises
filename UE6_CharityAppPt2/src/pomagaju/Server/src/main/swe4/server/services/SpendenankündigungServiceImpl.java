package swe4.server.services;

import javafx.collections.ObservableList;
import swe4.server.repositories.RepositoryFactory;
import swe4.server.repositories.SpendenankündigungRepository;
import swe4.ui.Hilfsgüter;

import java.util.List;

public class SpendenankündigungServiceImpl implements SpendenankündigungService {
    private final SpendenankündigungRepository spendenankündigungRepository = RepositoryFactory.spendenankündigungRepositoryInstance();
    @Override
    public List<Hilfsgüter> findAllSpendenankündigung() {
        return spendenankündigungRepository.findAllSpendenankündigung();
    }

    @Override
    public void insertSpendenankündigung(Hilfsgüter spendenankündigung) {
        spendenankündigungRepository.insertSpendenankündigung(spendenankündigung);
    }

    @Override
    public void deleteSpendenankündigung(Hilfsgüter spendenankündigung) {
        spendenankündigungRepository.deleteSpendenankündigung(spendenankündigung);
    }
}
