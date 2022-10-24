package swe4.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AnnahmestelleController implements Initializable {
    public Button deleteBtn;
    @FXML
    private TableView<Annahmestelle> tableView;

    @FXML
    public TableColumn<Annahmestelle,String> nameColumn;

    @FXML
    public TableColumn<Annahmestelle,String> bundeslandColumn;

    @FXML
    public TableColumn<Annahmestelle,String> adresseColumn;

    @FXML
    public TableColumn<Annahmestelle,String> regionColumn;

    @FXML
    public TableColumn<Annahmestelle,String> statusColumn;

    public static ObservableList<Annahmestelle> annahmestellen = FXCollections.observableArrayList();
    public Button reloadBtn;


    public void handleAddBtn(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addAnnahmestelleDialog.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Dashboard");
        stage.setScene(new Scene(root1));
        stage.show();
        tableView.setItems(annahmestellen);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        bundeslandColumn.setCellValueFactory(new PropertyValueFactory<>("Bundesland"));
        bundeslandColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        adresseColumn.setCellValueFactory(new PropertyValueFactory<>("Adresse"));
        adresseColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        regionColumn.setCellValueFactory(new PropertyValueFactory<>("Region"));
        regionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("Status"));
        statusColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        tableView.setItems(annahmestellen);
        tableView.setEditable(true);
    }

    public static void initAnnahmestellen() {
        ObservableList<Annahmestelle> a = FXCollections.observableArrayList();
        annahmestellen.add(new Annahmestelle("A1","OÖ","Softwarepark 69","Kiev","Aktiv"));
        annahmestellen.add(new Annahmestelle("A2","OÖ","Softwarepark 69","Kiev","Aktiv"));
    }

    public void handleDeleteBtn(ActionEvent event) {
        tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItems());
    }
}
