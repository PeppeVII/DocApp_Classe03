package it.unisa.progettois.docapp.data;

public class Caricamento {
    private Documento d;
    private Studente s;

    public Caricamento(){}

    public Caricamento(Documento d, Studente s){
        this.d = d;
        this.s = s;
    }

    public Studente getS() {
        return s;
    }

    public void setS(Studente s) {
        this.s = s;
    }

    public Documento getD() {
        return d;
    }

    public void setD(Documento d) {
        this.d = d;
    }
}
