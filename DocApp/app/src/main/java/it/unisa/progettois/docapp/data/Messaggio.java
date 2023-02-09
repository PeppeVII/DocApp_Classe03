package it.unisa.progettois.docapp.data;

import java.sql.Timestamp;

public class Messaggio {
    private String  email_studente, testo, id_messaggio;
    private int id_conversazione;
    private Timestamp tms;

    public Messaggio(){}

    public Messaggio(int id_conversazione, String email_studente, String testo, Timestamp tms){
        this.email_studente = email_studente;
        this.id_conversazione = id_conversazione;
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

    public int getId_conversazione() {
        return id_conversazione;
    }

    public void setId_conversazione(int id_conversazione) {
        this.id_conversazione = id_conversazione;
    }

    public String getEmail_studente() {
        return email_studente;
    }

    public void setEmail_studente(String email_studente) {
        this.email_studente = email_studente;
    }
}
