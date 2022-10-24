package swe4.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Annahmestelle implements Serializable {
    private String name;
    private String bundesland;
    private String Adresse;
    private String Region;
    private String Status;


    public Annahmestelle(String name, String bundesland, String adresse, String region, String status) {
        this.name = name;
        this.bundesland = bundesland;
        Adresse = adresse;
        Region = region;
        Status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBundesland() {
        return bundesland;
    }

    public void setBundesland(String bundesland) {
        this.bundesland = bundesland;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
