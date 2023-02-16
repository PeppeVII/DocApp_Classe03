package it.unisa.progettois.docapp.models;



import java.util.HashMap;

public class Interazione_Post implements IEntity {
    public static final String TABLE_NAME ="InterazionePost";
    private int id_documento;
    private String email_studente;

    public Interazione_Post(){}

    public Interazione_Post(int id_documento, String email_studente){
        this.id_documento = id_documento;
        this.email_studente = email_studente;
    }

    public int getId_documento() {
        return id_documento;
    }

    public void setId_documento(int id_documento) {
        this.id_documento = id_documento;
    }

    public String getEmail_studente() {
        return email_studente;
    }

    public void setEmail_studente(String email_studente) {
        this.email_studente = email_studente;
    }

    @Override
    public HashMap<String, ?> toHashMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id_documento", id_documento);
        map.put("email_studente", email_studente);
        return map;
    }
}
