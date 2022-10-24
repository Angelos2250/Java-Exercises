package swe4.ui;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class addAnkündigungDialog implements Initializable {
    public TextField regionTextField;
    public TextField zTextField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void addToList(ActionEvent event) {
        SpendenankündigungController.hilfsgüters.add(new Hilfsgüter("Random",regionTextField.getText(),LocalDate.parse(zTextField.getText())));
        //AnnahmestelleController.handle
    }
}
