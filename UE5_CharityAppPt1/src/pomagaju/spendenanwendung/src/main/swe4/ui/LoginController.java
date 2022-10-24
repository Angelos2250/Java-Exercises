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

import java.io.IOException;
import java.net.URL;
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
    public static Map<String,String> users = new TreeMap<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        users.put("Rickroll","123");
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
