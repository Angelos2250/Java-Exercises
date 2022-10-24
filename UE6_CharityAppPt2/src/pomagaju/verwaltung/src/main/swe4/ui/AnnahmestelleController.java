package swe4.ui;

import javafx.beans.Observable;
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
import swe4.client.services.DataService;
import swe4.client.services.ServiceFactory;
import swe4.client.services.client.AnnahmestelleClientService;
import swe4.server.repositories.AnnahmestelleRepository;
import swe4.server.repositories.RepositoryFactory;
import swe4.server.services.AnnahmestelleService;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;

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

    private final DataService dataService = ServiceFactory.dataServiceInstance();
    public static AnnahmestelleService annahmestellen = ServiceFactory.annahmestelleServiceInstance();
    public static AnnahmestelleClientService annahmestelleClientService = ServiceFactory.annahmestelleClientServiceInstance();
    public Button reloadBtn;


    public void handleAddBtn(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addAnnahmestelleDialog.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Dashboard");
        stage.setScene(new Scene(root1));
        stage.show();
        tableView.setItems(dataService.getAnnahmestellen());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            dataService.refresh();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        tableView.setEditable(true);
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        bundeslandColumn.setCellValueFactory(new PropertyValueFactory<>("Bundesland"));
        bundeslandColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        adresseColumn.setCellValueFactory(new PropertyValueFactory<>("Adresse"));
        adresseColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        regionColumn.setCellValueFactory(new PropertyValueFactory<>("Region"));
        regionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("Status"));
        statusColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        nameColumn.setOnEditCommit(event -> {
            final String val = getEventValue(event);
            final Annahmestelle annahmestelle = getAnnahmestelleOfEvent(event);
            annahmestelle.setName(val);
            annahmestelleClientService.updateAnnahmestelle(annahmestelle);
        });

        bundeslandColumn.setOnEditCommit(event -> {
            final String val = getEventValue(event);
            final Annahmestelle annahmestelle = getAnnahmestelleOfEvent(event);
            annahmestelle.setName(val);
            annahmestelleClientService.updateAnnahmestelle(annahmestelle);
        });

        adresseColumn.setOnEditCommit(event -> {
            final String val = getEventValue(event);
            final Annahmestelle annahmestelle = getAnnahmestelleOfEvent(event);
            annahmestelle.setName(val);
            annahmestelleClientService.updateAnnahmestelle(annahmestelle);
        });

        regionColumn.setOnEditCommit(event -> {
            final String val = getEventValue(event);
            final Annahmestelle annahmestelle = getAnnahmestelleOfEvent(event);
            annahmestelle.setName(val);
            annahmestelleClientService.updateAnnahmestelle(annahmestelle);
        });

        statusColumn.setOnEditCommit(event -> {
            final String val = getEventValue(event);
            final Annahmestelle annahmestelle = getAnnahmestelleOfEvent(event);
            annahmestelle.setName(val);
            annahmestelleClientService.updateAnnahmestelle(annahmestelle);
        });

        tableView.setItems(dataService.getAnnahmestellen());
    }


    public void handleDeleteBtn(ActionEvent event) {
        tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItems());
    }

    private static String getEventValue(TableColumn.CellEditEvent<Annahmestelle, String> event) {
        return emptyString(event.getNewValue()).orElse(event.getOldValue());
    }

    private static Annahmestelle getAnnahmestelleOfEvent(TableColumn.CellEditEvent<Annahmestelle, String> event) {
        return event.getTableView().getItems().get(event.getTablePosition().getRow());
    }

    private static Optional<String> emptyString(String string) {
        return Optional.ofNullable(string).filter(Predicate.not(String::isEmpty));
    }
}
