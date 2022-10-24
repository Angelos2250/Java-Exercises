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
import swe4.client.services.client.BenutzerClientService;
import swe4.server.services.BenutzerService;
import swe4.server.services.SpendenankündigungService;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class LoginController implements Initializable {
    public TextField benutzernameTxtFld;
    public PasswordField passwortTxtFld;
    public Button loginBtn;
    public Label wrongLogIn;
    public Button registerBtn;
    private final DataService dataService = ServiceFactory.dataServiceInstance();
    public static BenutzerService users = ServiceFactory.benutzerServiceInstance();
    public static BenutzerClientService benutzerClientService = ServiceFactory.benutzerClientServiceInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            users.insertUser("Rickroll","123");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void handleLoginBtn(ActionEvent event) throws IOException {
        if(users.containsKey(benutzernameTxtFld.getText().toString()) && users.containsValue(passwortTxtFld.getText().toString())) {
            wrongLogIn.setText("Success!");
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("ABC");
            stage.setMinHeight(490);
            stage.setMinWidth(240);
            stage.setMaxHeight(490);
            stage.setMaxWidth(240);
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
    public void handleRegisterBtn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Register.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("ABC");
        stage.setMinHeight(490);
        stage.setMinWidth(240);
        stage.setMaxHeight(490);
        stage.setMaxWidth(240);
        stage.setScene(new Scene(root1));
        stage.show();
    }
}
