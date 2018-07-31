package com.example.suhayb.h3ko.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Dokumentation implements Serializable {

    @SerializedName("@id")
    private String id;

//    Personendaten
    private String name;
    private String gewicht;
    private String groesse;
    private String geschlecht;

//    Generelle Dokumentaiton
    private String vorerkrankungen;
    private String aktuelle_behandlungen;
    private String aktuelle_mediaktion;
    private String aktuelle_vergangene_symptomen;
    private String andere;

//    visuelle Dokumentaiton
    private String roentgentbilder;
    private String mrt_bilder;
    private String ultrashall;

//    akustische Dokumentaiton
    private String herztoene;

    public Dokumentation() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGewicht() {
        return gewicht;
    }

    public void setGewicht(String gewicht) {
        this.gewicht = gewicht;
    }

    public String getGroesse() {
        return groesse;
    }

    public void setGroesse(String groesse) {
        this.groesse = groesse;
    }

    public String getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
    }

    public String getVorerkrankungen() {
        return vorerkrankungen;
    }

    public void setVorerkrankungen(String vorerkrankungen) {
        this.vorerkrankungen = vorerkrankungen;
    }

    public String getAktuelle_behandlungen() {
        return aktuelle_behandlungen;
    }

    public void setAktuelle_behandlungen(String aktuelle_behandlungen) {
        this.aktuelle_behandlungen = aktuelle_behandlungen;
    }

    public String getAktuelle_mediaktion() {
        return aktuelle_mediaktion;
    }

    public void setAktuelle_mediaktion(String aktuelle_mediaktion) {
        this.aktuelle_mediaktion = aktuelle_mediaktion;
    }

    public String getAktuelle_vergangene_symptomen() {
        return aktuelle_vergangene_symptomen;
    }

    public void setAktuelle_vergangene_symptomen(String aktuelle_vergangene_symptomen) {
        this.aktuelle_vergangene_symptomen = aktuelle_vergangene_symptomen;
    }

    public String getAndere() {
        return andere;
    }

    public void setAndere(String andere) {
        this.andere = andere;
    }

    public String getRoentgentbilder() {
        return roentgentbilder;
    }

    public void setRoentgentbilder(String roentgentbilder) {
        this.roentgentbilder = roentgentbilder;
    }

    public String getMrt_bilder() {
        return mrt_bilder;
    }

    public void setMrt_bilder(String mrt_bilder) {
        this.mrt_bilder = mrt_bilder;
    }

    public String getUltrashall() {
        return ultrashall;
    }

    public void setUltrashall(String ultrashall) {
        this.ultrashall = ultrashall;
    }

    public String getHerztoene() {
        return herztoene;
    }

    public void setHerztoene(String herztoene) {
        this.herztoene = herztoene;
    }
}
