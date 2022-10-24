package swe4.server.services;

import javafx.collections.ObservableList;
import swe4.ui.Hilfsgüter;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface BedarfService extends Remote {
    List<Hilfsgüter> findAllBedarf() throws RemoteException;

    void insertBedarf(Hilfsgüter bedarf) throws RemoteException;

    void deleteBedarf(Hilfsgüter bedarf) throws RemoteException;
}
