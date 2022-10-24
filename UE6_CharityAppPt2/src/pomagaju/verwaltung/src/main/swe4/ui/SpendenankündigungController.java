package swe4.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import swe4.client.services.DataService;
import swe4.client.services.ServiceFactory;
import swe4.server.repositories.RepositoryFactory;
import swe4.server.repositories.SpendenankündigungRepository;
import swe4.server.services.SpendenankündigungService;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class SpendenankündigungController implements Initializable {
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
    public TableColumn<Hilfsgüter,String> zeitColumn;

    private final DataService dataService = ServiceFactory.dataServiceInstance();
    public SpendenankündigungService hilfsgüter = ServiceFactory.spendenankündigungServiceInstance();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bezColumn.setCellValueFactory(new PropertyValueFactory<Hilfsgüter,String>("Bezeichnung"));
        beschColumn.setCellValueFactory(new PropertyValueFactory<Hilfsgüter,String>("Beschreibung"));
        zuColumn.setCellValueFactory(new PropertyValueFactory<Hilfsgüter,String>("Zustand"));
        menColumn.setCellValueFactory(new PropertyValueFactory<Hilfsgüter,String>("Menge"));
        zeitColumn.setCellValueFactory(new PropertyValueFactory<Hilfsgüter,String>("Zeitpunkt"));
        FilteredList<Hilfsgüter> filteredList = new FilteredList<>(dataService.getSpendenankündigungen(), b -> true);
        filterTxtBox.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(hilfsgüter -> {
                // If filter text is empty, display all hilfsgüter.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (hilfsgüter.getBeschreibung().toLowerCase().indexOf(lowerCaseFilter) != -1 )
                    return true;
                else if (hilfsgüter.getBezeichnung().toLowerCase().indexOf(lowerCaseFilter) != -1)
                    return true;
                else if (hilfsgüter.getMenge().toLowerCase().indexOf(lowerCaseFilter) != -1)
                    return true;
                else if (hilfsgüter.getZustand().toLowerCase().indexOf(lowerCaseFilter) != -1)
                    return true;
                else if (hilfsgüter.getZeitpunkt().toString().toLowerCase().indexOf(lowerCaseFilter) != -1)
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
