package swe4.client.services;

import swe4.client.services.client.AnnahmestelleClientService;
import swe4.client.services.client.BenutzerClientService;
import swe4.client.services.client.SpendenAnkündigungClientService;
import swe4.server.config.ServiceConfig;
import swe4.server.services.AnnahmestelleService;
import swe4.server.services.BedarfService;
import swe4.server.services.BenutzerService;
import swe4.server.services.SpendenankündigungService;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServiceFactory {
    private static BenutzerService benutzerService = null;
    private static AnnahmestelleService annahmestelleService = null;
    private static BedarfService bedarfService = null;
    private static SpendenankündigungService spendenankündigungService = null;
    private static RefreshService refreshService = null;
    private static Registry registry = null;
    private static DataService dataService = null;

    private static AnnahmestelleClientService annahmestelleClientService = null;
    private static BenutzerClientService benutzerClientService = null;
    private static SpendenAnkündigungClientService spendenAnkündigungClientService = null;

    private ServiceFactory() {
        throw new AssertionError("No ServiceFactory Instances for you!");
    }

    public static AnnahmestelleClientService annahmestelleClientServiceInstance() {
        if(annahmestelleClientService == null){
            annahmestelleClientService = new AnnahmestelleClientService();
        }
        return annahmestelleClientService;
    }

    public static SpendenAnkündigungClientService spendenAnkündigungClientServiceInstance() {
        if(spendenAnkündigungClientService == null){
            spendenAnkündigungClientService = new SpendenAnkündigungClientService();
        }
        return spendenAnkündigungClientService;
    }

    public static BenutzerClientService benutzerClientServiceInstance() {
        if(benutzerClientService == null){
            benutzerClientService = new BenutzerClientService();
        }
        return benutzerClientService;
    }

    public static BenutzerService benutzerServiceInstance() {
        if (benutzerService == null) {
            benutzerService = (BenutzerService) findRmiObject(ServiceConfig.benutzerServiceName());
        }
        return benutzerService;
    }

    public static DataService dataServiceInstance() {
        if (dataService == null) {
            dataService = new DataService();
        }
        return dataService;
    }

    public static AnnahmestelleService annahmestelleServiceInstance() {
        if (annahmestelleService == null) {
            annahmestelleService = (AnnahmestelleService) findRmiObject(ServiceConfig.annahmestelleServiceName());
        }
        return annahmestelleService;
    }

    public static BedarfService bedarfServiceInstance() {
        if (bedarfService == null) {
            bedarfService = (BedarfService) findRmiObject(ServiceConfig.bedarfServiceName());
        }
        return bedarfService;
    }

    public static SpendenankündigungService spendenankündigungServiceInstance() {
        if (spendenankündigungService == null) {
            spendenankündigungService = (SpendenankündigungService) findRmiObject(ServiceConfig.spendenankündigungServiceName());
        }
        return spendenankündigungService;
    }

    private static Remote findRmiObject(String name) {
        Registry registry = initializeOrGetRegistry();
        try {
            return registry.lookup(name);
        } catch (RemoteException | NotBoundException e) {
            handleRemoteException(e);
        }
        return null;
    }

    private static Registry initializeOrGetRegistry() {
        if (registry == null) {
            try {
                registry = LocateRegistry.getRegistry(ServiceConfig.port());
            } catch (RemoteException e) {
                handleRemoteException(e);
            }
        }
        return registry;
    }

    public static void startRefreshService() {
        if (refreshService == null || !refreshService.isAlive()) {
            refreshService = new RefreshService();
        }
        refreshService.start();
    }

    public static void stopRefreshService() {
        if (refreshService != null) {
            refreshService.stopRefreshing();
        }
    }

    private static void handleRemoteException(Exception e) {
        throw new RuntimeException(e);
    }

}
