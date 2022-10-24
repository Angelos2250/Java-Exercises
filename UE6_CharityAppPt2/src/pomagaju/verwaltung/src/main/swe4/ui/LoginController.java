package swe4.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import swe4.client.services.DataService;
import swe4.client.services.ServiceFactory;
import swe4.server.services.AnnahmestelleService;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public TextField benutzernameTxtFld;
    public PasswordField passwortTxtFld;
    public ComboBox annahmestelleComboBox;
    public Button loginBtn;
    public Label wrongLogIn;

    private final DataService dataService = ServiceFactory.dataServiceInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        annahmestelleComboBox.setItems(dataService.getAnnahmestellen());
    }

    public void handleLoginBtn(ActionEvent event) throws IOException {
        if(benutzernameTxtFld.getText().toString().equals("Rickroll") && passwortTxtFld.getText().toString().equals("123")) {
            wrongLogIn.setText("Success!");

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Dashboard");
            stage.setMinHeight(400);
            stage.setMinWidth(600);
            stage.setScene(new Scene(root1));
            stage.show();
        }

        else if(benutzernameTxtFld.getText().isEmpty() && passwortTxtFld.getText().isEmpty()) {
            wrongLogIn.setText("Please enter your data.");
        }


        else {
            wrongLogIn.setText("Wrong username or password!");
        }

    }


}
