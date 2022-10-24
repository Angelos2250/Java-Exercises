package swe4.ui;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import swe4.client.services.client.SpendenAnkündigungClientService;

import java.net.URL;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class addAnkündigungDialog implements Initializable {
    public TextField regionTextField;
    public TextField zTextField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void addToList(ActionEvent event) throws RemoteException {
        SpendenankündigungController.spendenAnkündigungClientService.insertSpendenankündigung(new Hilfsgüter("Random Token","100% Wolle", "T SHirt","gut","5", LocalDate.parse(zTextField.getText()), regionTextField.getText()));
    }
}
