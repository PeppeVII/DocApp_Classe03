package it.unisa.progettois.docapp.data;

public class Conversazione {
    private String nome_conversazione, id_conversazione;
    private Studente s;

    public Conversazione(){}

    public Conversazione(String nome_conversazione, Studente s){
        this.s = s;
        this.nome_conversazione = nome_conversazione;
    }

    public String getId_conversazione() {
        return id_conversazione;
    }

    public void setId_conversazione(String id_conversazione) {
        this.id_conversazione = id_conversazione;
    }

    public Studente getS() {
        return s;
    }

    public void setS(Studente s) {
        this.s = s;
    }

    public String getNome_conversazione() {
        return nome_conversazione;
    }

    public void setNome_conversazione(String nome_conversazione) {
        this.nome_conversazione = nome_conversazione;
    }
}
