package swe4.server.services;

import javafx.collections.ObservableList;
import swe4.ui.Annahmestelle;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface AnnahmestelleService extends Remote {
    List<Annahmestelle> findAllAnnahmestellen() throws RemoteException;

    Annahmestelle findByName(String name) throws RemoteException;

    void insertAnnahmestelle(Annahmestelle annahmestelle) throws RemoteException;

    void deleteAnnahmestelle(Annahmestelle annahmestelle) throws RemoteException;
    void updateAnnahmestelle(Annahmestelle annahmestelle) throws RemoteException;
}
