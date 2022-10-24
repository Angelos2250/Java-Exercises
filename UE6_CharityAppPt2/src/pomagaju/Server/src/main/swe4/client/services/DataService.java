package swe4.client.services;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import swe4.server.services.AnnahmestelleService;
import swe4.server.services.BedarfService;
import swe4.server.services.BenutzerService;
import swe4.server.services.SpendenankündigungService;
import swe4.ui.Annahmestelle;
import swe4.ui.Hilfsgüter;

import java.rmi.RemoteException;

public class DataService {
    private final AnnahmestelleService annahmestelleService = ServiceFactory.annahmestelleServiceInstance();
    private final BenutzerService benutzerService = ServiceFactory.benutzerServiceInstance();
    private final BedarfService bedarfService = ServiceFactory.bedarfServiceInstance();
    private final SpendenankündigungService spendenankündigungService = ServiceFactory.spendenankündigungServiceInstance();

    private final ObservableList<Annahmestelle> annahmestellen = FXCollections.observableArrayList();
    private final ObservableList<Hilfsgüter> bedarf = FXCollections.observableArrayList();
    private final ObservableList<Hilfsgüter> spendenankündigungen = FXCollections.observableArrayList();

    public void refresh() throws RemoteException {
        annahmestellen.setAll(annahmestelleService.findAllAnnahmestellen());
        bedarf.setAll((bedarfService.findAllBedarf()));
        spendenankündigungen.setAll(spendenankündigungService.findAllSpendenankündigung());
    }

    public ObservableList<Annahmestelle> getAnnahmestellen(){
        return annahmestellen;
    }

    public ObservableList<Hilfsgüter> getBedarf(){
        return bedarf;
    }

    public ObservableList<Hilfsgüter> getSpendenankündigungen(){
        return spendenankündigungen;
    }
}
