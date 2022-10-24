package swe4.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import swe4.client.services.DataService;
import swe4.client.services.ServiceFactory;
import swe4.server.services.BedarfService;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

public class BedarfController implements Initializable {

    public TextField filterTxtBox;
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

    @FXML
    public TableColumn<Hilfsgüter,String> regColumn;

    private final DataService dataService = ServiceFactory.dataServiceInstance();
    public BedarfService hilfsgüter = ServiceFactory.bedarfServiceInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            dataService.refresh();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        bezColumn.setCellValueFactory(new PropertyValueFactory<Hilfsgüter,String>("Bezeichnung"));
        beschColumn.setCellValueFactory(new PropertyValueFactory<Hilfsgüter,String>("Beschreibung"));
        zuColumn.setCellValueFactory(new PropertyValueFactory<Hilfsgüter,String>("Zustand"));
        menColumn.setCellValueFactory(new PropertyValueFactory<Hilfsgüter,String>("Menge"));
        katColumn.setCellValueFactory(new PropertyValueFactory<Hilfsgüter,String>("Kategorie"));
        bedColumn.setCellValueFactory(new PropertyValueFactory<Hilfsgüter,String>("Bedarf"));
        regColumn.setCellValueFactory(new PropertyValueFactory<Hilfsgüter,String>("Region"));
        FilteredList<Hilfsgüter> filteredList = new FilteredList<>(dataService.getBedarf(), b -> true);
        filterTxtBox.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(hilfsgüter -> {
                // If filter text is empty, display all hilfsgüter.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (hilfsgüter.getKategorie().toLowerCase().indexOf(lowerCaseFilter) != -1 )
                    return true;
                else if (hilfsgüter.getRegion().toLowerCase().indexOf(lowerCaseFilter) != -1)
                    return true;
                else
                    return false;
            });
        });
        SortedList<Hilfsgüter> sortedData = new SortedList<>(filteredList);
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sortedData);
    }
}
