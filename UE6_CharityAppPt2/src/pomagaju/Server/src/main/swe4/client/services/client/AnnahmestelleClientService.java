package swe4.client.services.client;

import swe4.client.services.DataService;
import swe4.client.services.ServiceFactory;
import swe4.server.services.AnnahmestelleService;
import swe4.ui.Annahmestelle;

import java.rmi.RemoteException;

public class AnnahmestelleClientService {
    private final DataService dataService = ServiceFactory.dataServiceInstance();
    private final AnnahmestelleService annahmestelleService = ServiceFactory.annahmestelleServiceInstance();

    public void insertAnnahmestelle(Annahmestelle annahmestelle){
        new Thread(() -> {
            try {
                annahmestelleService.insertAnnahmestelle(annahmestelle);
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

    public void deleteAnnahmestelle(Annahmestelle annahmestelle){
        new Thread(() -> {
            try {
                annahmestelleService.deleteAnnahmestelle(annahmestelle);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }).start();
    }
    public void updateAnnahmestelle(Annahmestelle annahmestelle){
        new Thread(() -> {
            try {
                annahmestelleService.updateAnnahmestelle(annahmestelle);
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
