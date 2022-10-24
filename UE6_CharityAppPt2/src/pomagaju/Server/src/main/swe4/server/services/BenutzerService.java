package swe4.server.services;

import swe4.server.repositories.RepositoryFactory;
import swe4.server.repositories.UserRepository;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface BenutzerService extends Remote {
    Map<String,String> findAllUsers() throws RemoteException;

    String findUserByUsername(final String username) throws RemoteException;
    void insertUser(String username, String password) throws RemoteException;

    void deleteUser(String user) throws RemoteException;

    boolean containsKey(String key) throws RemoteException;

    boolean containsValue(String val) throws RemoteException;
}
