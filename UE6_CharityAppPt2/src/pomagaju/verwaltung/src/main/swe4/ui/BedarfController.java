package swe4.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import swe4.client.services.DataService;
import swe4.client.services.ServiceFactory;
import swe4.server.repositories.BedarfRepository;
import swe4.server.repositories.RepositoryFactory;
import swe4.server.services.BedarfService;

import java.net.URL;
import java.util.ResourceBundle;

public class BedarfController implements Initializable {
    public TableColumn regColumn;
    @FXML
    private TableView<Hilfsgüter> tableView;

    @FXML
    public TableColumn<Hilfsgüter,String> bezColumn;

    @FXML
    public TableColumn<Hilfsgüter,String> beschColumn;

    @FXML
    public TableColumn<Hilfsgüter,String> zuColumn;

    @FXML
    public TableColumn<Hilfsgüter,String> menColumn;

    @FXML
    public TableColumn<Hilfsgüter,String> katColumn;

    @FXML
    public TableColumn<Hilfsgüter,String> bedColumn;

    private final DataService dataService = ServiceFactory.dataServiceInstance();
    public BedarfService hilfsgüter = ServiceFactory.bedarfServiceInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bezColumn.setCellValueFactory(new PropertyValueFactory<Hilfsgüter,String>("Bezeichnung"));
        beschColumn.setCellValueFactory(new PropertyValueFactory<Hilfsgüter,String>("Beschreibung"));
        zuColumn.setCellValueFactory(new PropertyValueFactory<Hilfsgüter,String>("Zustand"));
        menColumn.setCellValueFactory(new PropertyValueFactory<Hilfsgüter,String>("Menge"));
        katColumn.setCellValueFactory(new PropertyValueFactory<Hilfsgüter,String>("Kategorie"));
        bedColumn.setCellValueFactory(new PropertyValueFactory<Hilfsgüter,String>("Bedarf"));
        tableView.setItems(dataService.getBedarf());
    }
}
