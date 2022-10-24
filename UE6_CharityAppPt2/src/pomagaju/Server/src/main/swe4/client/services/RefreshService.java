package swe4.client.services;

import java.rmi.RemoteException;

public class RefreshService extends Thread {

    private static final int WAIT_TIME = 1000;
    public static final int WAIT_TIME_MULT = 10;
    private final DataService dataService = ServiceFactory.dataServiceInstance();
    private boolean stop = false;
    private int ticker = 0;

    @Override
    public synchronized void run() {
        while(!stop) {
            try {
                wait(WAIT_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ticker++;
            if(ticker == WAIT_TIME_MULT) {
                try {
                    dataService.refresh();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                System.out.println("Refreshing!");
            }
            ticker = ticker % WAIT_TIME_MULT;
        }
    }

    public synchronized void stopRefreshing() {
        stop = true;
    }
}