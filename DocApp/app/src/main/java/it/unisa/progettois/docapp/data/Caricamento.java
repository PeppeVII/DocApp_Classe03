package it.unisa.progettois.docapp.data;

public class Caricamento {
    private int id;
    private String email;

    public Caricamento(){}

    public Caricamento(int id, String email){
        this.id = id;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
