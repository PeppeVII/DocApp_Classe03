package it.unisa.progettois.docapp.data;

import java.io.Serializable;

public class Feedback implements Serializable {
    private int id;
    private String email;

    public Feedback(){}

    public Feedback(int id, String email){
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
