package it.unisa.progettois.docapp.models;



import java.util.HashMap;

public class Caricamento implements IEntity {
    public static final String TABLE_NAME = "Caricamento";
    private int id;
    private String email;

    public Caricamento() {
    }

    public Caricamento(int id, String email) {
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

    @Override
    public HashMap<String, ?> toHashMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("email", email);
        return map;
    }




}
