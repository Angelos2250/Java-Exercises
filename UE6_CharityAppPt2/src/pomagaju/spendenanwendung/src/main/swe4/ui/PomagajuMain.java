package swe4.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import swe4.client.services.ServiceFactory;

import java.io.IOException;

public class PomagajuMain extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ServiceFactory.startRefreshService();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage.setTitle("Hello!");
        stage.setScene(new Scene(root,300,275));
        stage.setMinHeight(490);
        stage.setMinWidth(240);
        stage.setMaxHeight(490);
        stage.setMaxWidth(240);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
