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

import java.net.URL;
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

    public ObservableList<Hilfsgüter> hilfsgüter = FXCollections.observableArrayList();

    public void initHilfsgüter(){
        ObservableList<String> kategorien = FXCollections.observableArrayList();
        kategorien.add("1");
        kategorien.add("2");
        kategorien.add("3");
        ObservableList<String> bedarf = FXCollections.observableArrayList();
        bedarf.add("niedrig");
        bedarf.add("mittel");
        bedarf.add("hoch");
        hilfsgüter.add(new Hilfsgüter("100% Wolle", "Hose","Sehr gut","10",kategorien,bedarf,new Annahmestelle("A1","OÖ","Softwarepark 69","Kiev","Aktiv").getBundesland()));
        hilfsgüter.add(new Hilfsgüter("100% Wolle", "T SHirt","gut","5",kategorien,bedarf,new Annahmestelle("A1","NÖ","Softwarepark 69","Volyn","Aktiv").getBundesland()));
        hilfsgüter.add(new Hilfsgüter("100% Wolle", "T SHirt","Schlecht","10",kategorien,bedarf,new Annahmestelle("A1","OÖ","Softwarepark 69","Kiev","Aktiv").getBundesland()));
        hilfsgüter.add(new Hilfsgüter("100% Wolle", "T SHirt","Sehr gut","10",kategorien,bedarf,new Annahmestelle("A1","NÖ","Softwarepark 69","Volyn","Aktiv").getBundesland()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bezColumn.setCellValueFactory(new PropertyValueFactory<Hilfsgüter,String>("Bezeichnung"));
        beschColumn.setCellValueFactory(new PropertyValueFactory<Hilfsgüter,String>("Beschreibung"));
        zuColumn.setCellValueFactory(new PropertyValueFactory<Hilfsgüter,String>("Zustand"));
        menColumn.setCellValueFactory(new PropertyValueFactory<Hilfsgüter,String>("Menge"));
        katColumn.setCellValueFactory(new PropertyValueFactory<Hilfsgüter,String>("Kategorie"));
        bedColumn.setCellValueFactory(new PropertyValueFactory<Hilfsgüter,String>("Bedarf"));
        regColumn.setCellValueFactory(new PropertyValueFactory<Hilfsgüter,String>("Region"));
        initHilfsgüter();
        FilteredList<Hilfsgüter> filteredList = new FilteredList<>(hilfsgüter, b -> true);
        filterTxtBox.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(hilfsgüter -> {
                // If filter text is empty, display all hilfsgüter.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (hilfsgüter.getKategorie().getSelectionModel().getSelectedItem().toString().toLowerCase().indexOf(lowerCaseFilter) != -1 )
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
