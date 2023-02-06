package it.unisa.progettois.docapp.data;

import java.io.Serializable;

public class Studente implements Serializable {
    private String email, nickname, password;
    private boolean is_admin;

    public Studente(){}

    public Studente(String email, String nickname, String password, boolean is_admin){
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.is_admin = is_admin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
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
}
