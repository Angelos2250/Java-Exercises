package swe4.server;

import javafx.embed.swing.JFXPanel;
import swe4.server.config.ServiceConfig;
import swe4.server.services.*;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    private static BenutzerService benutzerService = new BenutzerServiceImpl();
    private static AnnahmestelleService annahmestelleService = new AnnahmestelleServiceImpl();
    private static BedarfService bedarfService = new BedarfServiceImpl();
    private static SpendenankündigungService spendenankündigungService = new SpendenankündigungServiceImpl();

    public static void main(String... args) {
        //TODO: Fix Edits
        new InitFakeDataService().load();

        try {
            BenutzerService benutzerServiceStub = (BenutzerService) UnicastRemoteObject
                    .exportObject(benutzerService, 0);

            AnnahmestelleService annahmestelleServiceStub = (AnnahmestelleService) UnicastRemoteObject
                    .exportObject(annahmestelleService, 0);

            BedarfService bedarfServiceStub = (BedarfService) UnicastRemoteObject
                    .exportObject(bedarfService, 0);

            SpendenankündigungService spendenankündigungServiceStub = (SpendenankündigungService) UnicastRemoteObject
                    .exportObject(spendenankündigungService, 0);

            Registry registry = LocateRegistry.createRegistry(ServiceConfig.port());

            registry.rebind(ServiceConfig.benutzerServiceName(), benutzerServiceStub);
            registry.rebind(ServiceConfig.annahmestelleServiceName(), annahmestelleServiceStub);
            registry.rebind(ServiceConfig.bedarfServiceName(), bedarfServiceStub);
            registry.rebind(ServiceConfig.spendenankündigungServiceName(), spendenankündigungServiceStub);

            System.out.println("Server Running...");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}