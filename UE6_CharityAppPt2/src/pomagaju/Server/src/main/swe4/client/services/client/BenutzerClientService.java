package swe4.client.services.client;

import swe4.client.services.DataService;
import swe4.client.services.ServiceFactory;
import swe4.server.services.AnnahmestelleService;
import swe4.server.services.BenutzerService;
import swe4.ui.Annahmestelle;

import java.rmi.RemoteException;

public class BenutzerClientService {
    private final DataService dataService = ServiceFactory.dataServiceInstance();
    private final BenutzerService benutzerService = ServiceFactory.benutzerServiceInstance();

    public void insertBenutzer(String name, String password){
        new Thread(() -> {
            try {
                benutzerService.insertUser(name, password);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            try {
                dataService.refresh();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
