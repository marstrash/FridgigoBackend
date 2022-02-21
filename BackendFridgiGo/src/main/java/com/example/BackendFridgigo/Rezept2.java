package com.example.BackendFridgigo;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Rezept2 {

    private Integer Rezeptid;
    private String Name;
    private String Beschreibung;
    private String AnzahlPortionen;
    private String Kid;
    private String Zeit;
    private String Picture;
    private String EnName;


    public Rezept2() {
    }

    @Id
    public static Integer getrezeptid() {
        return getrezeptid();
    }

    public void setrezeptid(Integer rezeptid) {
        this.Rezeptid = rezeptid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

   

    public String getBeschreibung() {
        return Beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        Beschreibung = beschreibung;
    }

    public String getAnzahlPortionen() {
        return AnzahlPortionen;
    }

    public void setAnzahlPortionen(String AnzahlPortionen) {
        AnzahlPortionen = AnzahlPortionen;
    }

    public String getKid() {
        return Kid;
    }

    public void setKid(String kid) {
       Kid = kid;
    }

    public String getZeit() {
        return Zeit;
    }

    public void setZeit(String zeit) {
       Zeit = zeit;
    }


    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }

    public String getEnName() {
        return EnName;
    }

    public void setEnName(String enName) {
        EnName = enName;
    }
}

