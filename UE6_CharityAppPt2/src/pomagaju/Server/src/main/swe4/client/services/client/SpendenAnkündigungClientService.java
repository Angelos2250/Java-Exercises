package swe4.client.services.client;

import swe4.client.services.DataService;
import swe4.client.services.ServiceFactory;
import swe4.server.services.BenutzerService;
import swe4.server.services.SpendenankündigungService;
import swe4.ui.Hilfsgüter;

import java.rmi.RemoteException;

public class SpendenAnkündigungClientService {
    private final DataService dataService = ServiceFactory.dataServiceInstance();
    private final SpendenankündigungService spendenankündigungService = ServiceFactory.spendenankündigungServiceInstance();

    public void insertSpendenankündigung(Hilfsgüter hilfsgüter){
        new Thread(() -> {
            try {
                spendenankündigungService.insertSpendenankündigung(hilfsgüter);
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
