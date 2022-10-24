package swe4.ui;

import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

import java.time.LocalDate;

public class Hilfsgüter {
    private String beschreibung;
    private String bezeichnung;
    private String zustand;
    private String menge;
    private ComboBox kategorie;
    private ComboBox bedarf;
    private LocalDate zeitpunkt;

    public Hilfsgüter(String beschreibung, String bezeichnung, String zustand, String menge, ObservableList kategorie, ObservableList bedarf) {
        this.beschreibung = beschreibung;
        this.bezeichnung = bezeichnung;
        this.zustand = zustand;
        this.menge = menge;
        this.kategorie = new ComboBox(kategorie);
        this.bedarf = new ComboBox(bedarf);
        this.kategorie.getSelectionModel().selectFirst();
        this.bedarf.getSelectionModel().selectFirst();
    }

    public Hilfsgüter(String beschreibung, String bezeichnung, String zustand, String menge, LocalDate zeitpunkt) {
        this.beschreibung = beschreibung;
        this.bezeichnung = bezeichnung;
        this.zustand = zustand;
        this.menge = menge;
        this.zeitpunkt = zeitpunkt;
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

    public ComboBox getKategorie() {
        return kategorie;
    }

    public void setKategorie(ComboBox kategorie) {
        this.kategorie = kategorie;
    }

    public ComboBox getBedarf() {
        return bedarf;
    }

    public void setBedarf(ComboBox bedarf) {
        this.bedarf = bedarf;
    }

    public LocalDate getZeitpunkt() {
        return zeitpunkt;
    }

}
