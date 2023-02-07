package it.unisa.progettois.docapp.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import it.unisa.progettois.docapp.facade.Facade;

public class CaricamentoDAO implements Facade {
    private SQLiteDatabase db;
    private DatabasePopulator dp;

    public CaricamentoDAO(Context context){
        dp = new DatabasePopulator(context);
        open();
    }

    public void open(){
        db = dp.getWritableDatabase();
    }

    public void close(){
        db.close();
    }

    @Override
    public boolean inserisci(int id, String email) {
        String[] selectionArgs = {String.valueOf(id), email};
        db.execSQL("INSERT INTO Caricamento(documento, studente) VALUES (?,?)", selectionArgs);
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
