package com.example.BackendFridgigo;

// KData = Kategorien Data

public class KData {
    private String kid;
    private int rezeptid;


    public KData() {
    }

    public String getkid() {
        return kid;
    }

    public void setkid(String kid) {
        this.kid = kid;
    }

    public int getrezeptid() {
        return rezeptid;
    }

    public void setrezeptid(Integer rezeptid) {
        this.rezeptid = rezeptid;
    }

}
