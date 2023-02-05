package it.unisa.progettois.docapp.data;

import java.sql.Timestamp;

public class Messaggio {
    private Conversazione c;
    private Studente s;
    private String testo, id_messaggio;
    private Timestamp tms;

    public Messaggio(){}

    public Messaggio(Conversazione c, Studente s, String testo, Timestamp tms){
        this.c = c;
        this.s = s;
        this.testo = testo;
        this.tms = tms;
    }

    public String getId_messaggio() {
        return id_messaggio;
    }

    public void setId_messaggio(String id_messaggio) {
        this.id_messaggio = id_messaggio;
    }

    public Timestamp getTms() {
        return tms;
    }

    public void setTms(Timestamp tms) {
        this.tms = tms;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public Studente getS() {
        return s;
    }

    public void setS(Studente s) {
        this.s = s;
    }

    public Conversazione getC() {
        return c;
    }

    public void setC(Conversazione c) {
        this.c = c;
    }
}
