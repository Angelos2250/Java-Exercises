package swe4.ui;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import swe4.client.services.DataService;
import swe4.client.services.ServiceFactory;
import swe4.client.services.client.SpendenAnkündigungClientService;
import swe4.server.services.SpendenankündigungService;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class SpendenankündigungController implements Initializable {
    public Button ankBtn;
    @FXML
    private TableView<Hilfsgüter> tableView;

    @FXML
    public TableColumn<Hilfsgüter,String> tokColumn;

    @FXML
    public TableColumn<Hilfsgüter,String> ortColumn;

    @FXML
    public TableColumn<Hilfsgüter,String> zeitColumn;

    private final DataService dataService = ServiceFactory.dataServiceInstance();
    public static SpendenankündigungService hilfsgüter = ServiceFactory.spendenankündigungServiceInstance();
    public static SpendenAnkündigungClientService spendenAnkündigungClientService = ServiceFactory.spendenAnkündigungClientServiceInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tokColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getToken()));
        ortColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getRegion()));
        zeitColumn.setCellValueFactory(new PropertyValueFactory<Hilfsgüter,String>("Zeitpunkt"));
        tableView.setItems(dataService.getSpendenankündigungen());
    }

    public void handleAnkBtn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addAnkündigungDialog.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("ABC");
        stage.setScene(new Scene(root1));
        stage.show();
        tableView.setItems(dataService.getSpendenankündigungen());
    }
}
