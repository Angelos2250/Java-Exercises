package swe4.server.services;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import swe4.server.repositories.AnnahmestelleRepository;
import swe4.server.repositories.BedarfRepository;
import swe4.server.repositories.RepositoryFactory;
import swe4.server.repositories.SpendenankündigungRepository;
import swe4.ui.Annahmestelle;
import swe4.ui.Hilfsgüter;

import java.time.LocalDate;

public class InitFakeDataService {
    private final BenutzerServiceImpl benutzerService = new BenutzerServiceImpl();
    private final AnnahmestelleRepository annahmestelleRepository = RepositoryFactory.annahmestelleRepositoryInstance();
    private final BedarfRepository bedarfRepository = RepositoryFactory.BedarfRepositoryInstance();
    private final SpendenankündigungRepository spendenankündigungRepository = RepositoryFactory.spendenankündigungRepositoryInstance();

    public void load(){
        //user
        benutzerService.insertUser("Rickroll","123");

        //Annahmestellen
        annahmestelleRepository.insertAnnahmestelle(new Annahmestelle("A1","OÖ","Softwarepark 69","Kiev","Aktiv"));
        annahmestelleRepository.insertAnnahmestelle(new Annahmestelle("A2","OÖ","Softwarepark 69","Kiev","Aktiv"));

        //Bedarf
        ObservableList<String> kategorien = FXCollections.observableArrayList();
        kategorien.add("1");
        kategorien.add("2");
        kategorien.add("3");
        ObservableList<String> bedarf = FXCollections.observableArrayList();
        bedarf.add("niedrig");
        bedarf.add("mittel");
        bedarf.add("hoch");
        bedarfRepository.insertBedarf(new Hilfsgüter("100% Wolle", "T SHirt","Sehr gut","10","1","niedrig"));
        bedarfRepository.insertBedarf(new Hilfsgüter("100% Wolle", "T SHirt","gut","5","1","niedrig"));
        bedarfRepository.insertBedarf(new Hilfsgüter("100% Wolle", "T SHirt","Schlecht","10","1","niedrig"));
        bedarfRepository.insertBedarf(new Hilfsgüter("100% Wolle", "T SHirt","Sehr gut","10","1","niedrig"));

        //Spendenankündigung
        //spendenankündigungRepository.insertSpendenankündigung(new Hilfsgüter("Random Token","100% Wolle", "Hose","Sehr gut","10", LocalDate.now(), "NÖ"));
        spendenankündigungRepository.insertSpendenankündigung(new Hilfsgüter("Random Token","100% Wolle", "T SHirt","gut","5", LocalDate.of(2022,5,2), "NÖ"));
        spendenankündigungRepository.insertSpendenankündigung(new Hilfsgüter("Random Token","100% Wolle", "T SHirt","Schlecht","10", LocalDate.of(2022,5,2), "NÖ"));
        spendenankündigungRepository.insertSpendenankündigung(new Hilfsgüter("Random Token","100% Wolle", "T SHirt","Sehr gut","10", LocalDate.of(2022,5,2), "NÖ"));
    }

}
