package it.unisa.progettois.docapp.facade;

public interface Facade {
    boolean inserisci(int id, String email);
    Object ottieni(int id, String email);
}