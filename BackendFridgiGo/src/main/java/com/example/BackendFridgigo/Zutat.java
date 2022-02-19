package com.example.BackendFridgigo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Zutat {

    private int Zutatid;
    private String Link;
    private String Name;
    private int rezeptid;
    private String menge;
    private String mengenangabe;

    public Zutat() {
    }

    @Id
    public int getZutatid() {
        return Zutatid;
    }

    public void setZutatid(int Zutatid) {
        this.Zutatid = Zutatid;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }


    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getrezeptid() {
        return rezeptid;
    }

    public void setrezeptid(int rezeptid) {
       this.rezeptid = rezeptid;
    }

    public String getmenge() {
        return menge;
    }

    public void setmenge(String menge) {
        this.menge = menge;
    }

    public String mengenangabe() {
        return mengenangabe;
    }

    public void setmengenangabe(String mengenangabe) {
        this.mengenangabe = mengenangabe;
    }
}
