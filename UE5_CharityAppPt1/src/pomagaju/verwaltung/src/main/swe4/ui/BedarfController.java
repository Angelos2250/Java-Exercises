package swe4.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
        hilfsgüter.add(new Hilfsgüter("100% Wolle", "T SHirt","Sehr gut","10",kategorien,bedarf));
        hilfsgüter.add(new Hilfsgüter("100% Wolle", "T SHirt","gut","5",kategorien,bedarf));
        hilfsgüter.add(new Hilfsgüter("100% Wolle", "T SHirt","Schlecht","10",kategorien,bedarf));
        hilfsgüter.add(new Hilfsgüter("100% Wolle", "T SHirt","Sehr gut","10",kategorien,bedarf));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bezColumn.setCellValueFactory(new PropertyValueFactory<Hilfsgüter,String>("Bezeichnung"));
        beschColumn.setCellValueFactory(new PropertyValueFactory<Hilfsgüter,String>("Beschreibung"));
        zuColumn.setCellValueFactory(new PropertyValueFactory<Hilfsgüter,String>("Zustand"));
        menColumn.setCellValueFactory(new PropertyValueFactory<Hilfsgüter,String>("Menge"));
        katColumn.setCellValueFactory(new PropertyValueFactory<Hilfsgüter,String>("Kategorie"));
        bedColumn.setCellValueFactory(new PropertyValueFactory<Hilfsgüter,String>("Bedarf"));
        initHilfsgüter();
        tableView.setItems(hilfsgüter);
    }
}
