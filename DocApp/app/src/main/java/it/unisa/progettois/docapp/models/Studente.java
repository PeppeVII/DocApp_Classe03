package it.unisa.progettois.docapp.models;



import java.io.Serializable;
import java.util.HashMap;

public class Studente implements Serializable, IEntity {
    public static final String TABLE_NAME = "Studente";

    private String email, nickname, password;

    public Studente() {
    }

    public Studente(String email, String nickname, String password) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    @Override
    public HashMap<String, ?> toHashMap() {

        HashMap<String, Object> map = new HashMap<>();
        map.put("email", email);
        map.put("nickname", nickname);
        map.put("password", password);
        return map;
    }

}
