package it.unisa.progettois.docapp.data;

import java.io.Serializable;

public class Documento implements Serializable {
    private String nome, descrizione, universita, facolta, corso_di_studio, path;
    private int dimensione, id_documento;

    public Documento(){}

    public Documento(String nome, String descrizione, String universita, String facolta, String corso_di_studio, String path, int dimensione){
        this.nome = nome;
        this.descrizione = descrizione;
        this.universita = universita;
        this.facolta = facolta;
        this.corso_di_studio = corso_di_studio;
        this.path = path;
        this.dimensione = dimensione;
    }

    public void setDimensione(int dimensione) {
        this.dimensione = dimensione;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

    public int getId_documento() {
        return id_documento;
    }

    public void setId_documento(int id_documento) {
        this.id_documento = id_documento;
    }
}
