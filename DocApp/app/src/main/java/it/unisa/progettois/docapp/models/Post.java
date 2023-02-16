package it.unisa.progettois.docapp.models;

import java.util.HashMap;

public class Post implements IEntity {
    public static final String TABLE_NAME = "Post";
    private String titolo, testo, id_post;
    private boolean is_domanda;

    public Post() {

    }

    public Post(String titolo, String testo, boolean is_domanda) {
        this.titolo = titolo;
        this.testo = testo;
        this.is_domanda = is_domanda;
    }

    public String getId_post() {
        return id_post;
    }

    public void setId_post(String id_post) {
        this.id_post = id_post;
    }

    public boolean isIs_domanda() {
        return is_domanda;
    }

    public void setIs_domanda(boolean is_domanda) {
        this.is_domanda = is_domanda;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    @Override
    public HashMap<String, ?> toHashMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("titolo", titolo);
        map.put("testo", testo);
        map.put("is_domanda", is_domanda);
        return map;

    }
}
