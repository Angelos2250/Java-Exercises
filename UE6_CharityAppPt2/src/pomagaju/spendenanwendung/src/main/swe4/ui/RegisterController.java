package swe4.ui;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    public Button registerBtn;
    public TextField benutzernameTxtFld;
    public PasswordField passwortTxtFld;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void handleRegisterBtn(ActionEvent event) throws RemoteException {
        LoginController.benutzerClientService.insertBenutzer(benutzernameTxtFld.getText(),passwortTxtFld.getText());
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);

        VBox vbox = new VBox(new Text("Register Succesfull"));
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(15));
        dialogStage.setScene(new Scene(vbox));
        dialogStage.show();
        Stage stage = (Stage) registerBtn.getScene().getWindow();
        stage.close();
    }
}
