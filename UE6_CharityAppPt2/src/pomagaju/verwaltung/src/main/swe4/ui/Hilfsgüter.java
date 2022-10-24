package swe4.ui;

import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

import java.io.Serializable;
import java.time.LocalDate;

public class Hilfsgüter implements Serializable {
    private String token;
    private String beschreibung;
    private String bezeichnung;
    private String zustand;
    private String menge;
    private String kategorie;
    private String bedarf;
    private LocalDate zeitpunkt;
    private String region;

    public Hilfsgüter(String token, String ort, LocalDate zeitpunkt){
        this.token = token;
        this.region = ort;
        this.zeitpunkt = zeitpunkt;
    }

    public Hilfsgüter(String beschreibung, String bezeichnung, String zustand, String menge, String kategorie, String bedarf) {
        this.beschreibung = beschreibung;
        this.bezeichnung = bezeichnung;
        this.zustand = zustand;
        this.menge = menge;
        this.kategorie = kategorie;
        this.bedarf = bedarf;
    }

    public Hilfsgüter(String token ,String beschreibung, String bezeichnung, String zustand, String menge, LocalDate zeitpunkt, String region) {
        this.beschreibung = beschreibung;
        this.bezeichnung = bezeichnung;
        this.zustand = zustand;
        this.menge = menge;
        this.zeitpunkt = zeitpunkt;
        this.token = token;
        this.region = region;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getZustand() {
        return zustand;
    }

    public void setZustand(String zustand) {
        this.zustand = zustand;
    }

    public String getMenge() {
        return menge;
    }

    public void setMenge(String menge) {
        this.menge = menge;
    }

    public String getKategorie() {
        return kategorie;
    }

    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }

    public String getBedarf() {
        return bedarf;
    }

    public void setBedarf(String bedarf) {
        this.bedarf = bedarf;
    }

    public LocalDate getZeitpunkt() {
        return zeitpunkt;
    }

    public String getRegion() {
        return region;
    }

    public String getToken() {
        return token;
    }
}
