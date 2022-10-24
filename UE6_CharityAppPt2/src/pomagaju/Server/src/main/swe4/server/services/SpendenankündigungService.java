package swe4.server.services;

import javafx.collections.ObservableList;
import swe4.ui.Hilfsgüter;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface SpendenankündigungService extends Remote {
    List<Hilfsgüter> findAllSpendenankündigung() throws RemoteException;

    void insertSpendenankündigung(Hilfsgüter spendenankündigung) throws RemoteException;

    void deleteSpendenankündigung(Hilfsgüter spendenankündigung) throws RemoteException;
}
