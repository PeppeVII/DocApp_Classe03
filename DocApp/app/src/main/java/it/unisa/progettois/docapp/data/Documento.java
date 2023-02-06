package it.unisa.progettois.docapp.data;

import java.io.Serializable;

public class Documento implements Serializable {
    private String id_documento, nome, descrizione, universita, facolta, corso_di_studio;
    private int dimensione;

    public Documento(){}

    public Documento(String nome, String descrizione, String universita, String facolta, String corso_di_studio, int dimensione){
        this.nome = nome;
        this.descrizione = descrizione;
        this.universita = universita;
        this.facolta = facolta;
        this.corso_di_studio = corso_di_studio;
        this.dimensione = dimensione;
    }

    public int getDimensione() {
        return dimensione;
    }

    public String getCorso_di_studio() {
        return corso_di_studio;
    }

    public void setCorso_di_studio(String corso_di_studio) {
        this.corso_di_studio = corso_di_studio;
    }

    public String getFacolta() {
        return facolta;
    }

    public void setFacolta(String facolta) {
        this.facolta = facolta;
    }

    public String getUniversita() {
        return universita;
    }

    public void setUniversita(String universita) {
        this.universita = universita;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId_documento() {
        return id_documento;
    }

    public void setId_documento(String id_documento) {
        this.id_documento = id_documento;
    }
}
