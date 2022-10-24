package swe4.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddAnnahmestelleController implements Initializable {

    public TextField nameTextField;
    public TextField bundeslandTextField;
    public TextField adresseTextField;
    public TextField regionTextField;
    public TextField statusTextField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void addToList(ActionEvent event) {
        AnnahmestelleController.annahmestellen.add(new Annahmestelle(nameTextField.getText(),bundeslandTextField.getText(),adresseTextField.getText(),regionTextField.getText(),statusTextField.getText()));
        //AnnahmestelleController.handle
    }
}
