package swe4.server.services;

import javafx.collections.ObservableList;
import swe4.server.repositories.AnnahmestelleRepository;
import swe4.server.repositories.RepositoryFactory;
import swe4.ui.Annahmestelle;

import java.rmi.RemoteException;
import java.util.List;

public class AnnahmestelleServiceImpl implements AnnahmestelleService {
    private final AnnahmestelleRepository annahmestelleRepository = RepositoryFactory.annahmestelleRepositoryInstance();

    @Override
    public List<Annahmestelle> findAllAnnahmestellen() throws RemoteException {
        return annahmestelleRepository.findAllAnnahmestellen();
    }

    @Override
    public Annahmestelle findByName(String name) throws RemoteException {
        for (Annahmestelle a:annahmestelleRepository.findAllAnnahmestellen()){
            if (a.getName()== name){
                return a;
            }
        }
        return null;
    }

    @Override
    public void insertAnnahmestelle(Annahmestelle annahmestelle) throws RemoteException {
        annahmestelleRepository.insertAnnahmestelle(annahmestelle);
    }

    @Override
    public void deleteAnnahmestelle(Annahmestelle annahmestelle) throws RemoteException {
        annahmestelleRepository.deleteAnnahmestelle(annahmestelle);
    }

    @Override
    public void updateAnnahmestelle(Annahmestelle annahmestelle) throws RemoteException {
        annahmestelleRepository.updateAnnahmestelle(annahmestelle);
    }
}
