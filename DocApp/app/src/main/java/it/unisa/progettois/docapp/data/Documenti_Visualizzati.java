package it.unisa.progettois.docapp.data;

public class Documenti_Visualizzati {
    private int id_documento;
    private String email_studente;

    public Documenti_Visualizzati(){}

    public Documenti_Visualizzati(int id_documento, String email_studente){
        this.id_documento = id_documento;
        this.email_studente = email_studente;
    }

    public String getEmail_studente() {
        return email_studente;
    }

    public void setEmail_studente(String email_studente) {
        this.email_studente = email_studente;
    }

    public int getId_documento() {
        return id_documento;
    }

    public void setId_documento(int id_documento) {
        this.id_documento = id_documento;
    }
}
