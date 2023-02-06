package it.unisa.progettois.docapp.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import it.unisa.progettois.docapp.facade.Facade;

public class DocumentoDAO implements Facade {
    private SQLiteDatabase db;
    private DatabasePopulator dp;

    public DocumentoDAO(Context context){
        dp = new DatabasePopulator(context);
        open();
    }

    public void open(){
        db = dp.getWritableDatabase();
    }

    public void close(){
        db.close();
    }


    @SuppressLint("Range")
    public List<Documento> retreiveByFiltraggio(String universita_scelta, String facolta_scelta, String insegnamento_scelto){
        List<Documento> documenti = new ArrayList<>();
        String[] selectionArgs = {universita_scelta, facolta_scelta, insegnamento_scelto};
        String query = "SELECT * FROM Documento d WHERE d.universita = ? AND d.facolta = ? AND d.corso_di_studio = ?";
        Cursor cursor = db.rawQuery(query, selectionArgs);

        if(cursor.moveToFirst()){
            do {
                documenti.add(new Documento(cursor.getString(cursor.getColumnIndex("nome")), cursor.getString(cursor.getColumnIndex("descrizione")), cursor.getString(cursor.getColumnIndex("universita")), cursor.getString(cursor.getColumnIndex("facolta")), cursor.getString(cursor.getColumnIndex("corso_di_studio")), cursor.getInt(cursor.getColumnIndex("dimensione"))));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return documenti;
    }


    @Override
    public boolean inserisci(int id, String email) {
        String[] selectionArgs = {String.valueOf(id), email};
        db.execSQL("INSERT INTO Caricamento(documento, studente) VALUES (?,?)");
        return true;
    }

    @SuppressLint("Range")
    @Override
    public Object ottieni(int id, String email) {
        Caricamento caricamento = new Caricamento();
        String[] selectionArgs = {String.valueOf(id), email};
        String query = "SELECT * FROM Caricamento c WHERE c.id = ? AND c.email = ?";
        Cursor cursor = db.rawQuery(query, selectionArgs);

        if(cursor.moveToFirst()) {
            caricamento = new Caricamento(cursor.getInt(cursor.getColumnIndex("id")), cursor.getString(cursor.getColumnIndex("email")));
            return caricamento;
        }
        return null;
    }
}
