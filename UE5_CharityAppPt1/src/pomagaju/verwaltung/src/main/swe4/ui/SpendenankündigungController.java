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

    public ObservableList<Hilfsgüter> hilfsgüter = FXCollections.observableArrayList();

    private void initHilfsgüter(){
        hilfsgüter.add(new Hilfsgüter("100% Wolle", "Hose","Sehr gut","10", LocalDate.now()));
        hilfsgüter.add(new Hilfsgüter("100% Wolle", "T SHirt","gut","5", LocalDate.of(2022,5,2)));
        hilfsgüter.add(new Hilfsgüter("100% Wolle", "T SHirt","Schlecht","10", LocalDate.of(2022,5,2)));
        hilfsgüter.add(new Hilfsgüter("100% Wolle", "T SHirt","Sehr gut","10", LocalDate.of(2022,5,2)));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bezColumn.setCellValueFactory(new PropertyValueFactory<Hilfsgüter,String>("Bezeichnung"));
        beschColumn.setCellValueFactory(new PropertyValueFactory<Hilfsgüter,String>("Beschreibung"));
        zuColumn.setCellValueFactory(new PropertyValueFactory<Hilfsgüter,String>("Zustand"));
        menColumn.setCellValueFactory(new PropertyValueFactory<Hilfsgüter,String>("Menge"));
        zeitColumn.setCellValueFactory(new PropertyValueFactory<Hilfsgüter,String>("Zeitpunkt"));
        initHilfsgüter();
        FilteredList<Hilfsgüter> filteredList = new FilteredList<>(hilfsgüter, b -> true);
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
